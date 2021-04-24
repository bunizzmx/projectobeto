package com.bunizz.comida;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Stack;

public class MainActivity extends AppCompatActivity
implements change_instance {

    Stack <FragmentElement> A0;
    Stack <FragmentElement> A1;
    Stack <FragmentElement> A2;
    Stack <FragmentElement> A3;
    FragmentElement mCurrentFragment;
    FragmentElement mOldfragment;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        A0= new Stack<>();
        A1= new Stack<>();
        A2= new Stack<>();
        A3= new Stack<>();
        setupFirstFragment ();
    }

    private void setupFirstFragment() {

        mCurrentFragment = new FragmentElement<>(null, main_fragment.newInstance(), FragmentElement.A0, true);
        cambiar_vista_0 (mCurrentFragment);}


    private void cambiar_vista_0 (FragmentElement fragment) {

        if (fragment != null) {
            mCurrentFragment = fragment;
            if (A0.size() <= 0) {
                A0.push(mCurrentFragment);
            }
        }

        inflateFragment();
    }

    private void cambiar_vista (FragmentElement fragment) {

        if (fragment != null) {
            mCurrentFragment = fragment;
            if (A1.size() <= 0) {
                A1.push(mCurrentFragment);
            }
        }

        inflateFragment();

    }
    private void setupSecondFragment() {

        mCurrentFragment = new FragmentElement<>(null, second_fragment.newInstance(), FragmentElement.A2, true);
        cambiar_vista_2 (mCurrentFragment);}

    private void cambiar_vista_2 (FragmentElement fragment) {

        if (fragment != null) {
            mCurrentFragment = fragment;
            if (A2.size() <= 0) {
                A2.push(mCurrentFragment);
            }
        }

        inflateFragment();

    }

    private void setupthirdFragment() {

        mCurrentFragment = new FragmentElement<>(null, second_fragment.newInstance(), FragmentElement.A3, true);
        cambiar_vista_3 (mCurrentFragment);}

    private void cambiar_vista_3 (FragmentElement fragment) {

        if (fragment != null) {
            mCurrentFragment = fragment;
            if (A3.size() <= 0) {
                A3.push(mCurrentFragment);
            }
        }

        inflateFragment();

    }

    @SuppressLint("RestrictedApi")
    private synchronized void inflateFragment() {
        Log.e("tipo fragmento", "9"+mCurrentFragment.getInstanceType());
        try {

            FragmentManager fragmentManager = getSupportFragmentManager();
            if (mOldfragment != null)
            {
                Log.e("tipo fragmento", "8"+mOldfragment.getInstanceType());
                if (mCurrentFragment.getFragment().isAdded()) {
                    Log.e("tipo fragmento", "10");
                    fragmentManager
                            .beginTransaction()
                            .addToBackStack(null)
                            .hide(mOldfragment.getFragment())
                            .show(mCurrentFragment.getFragment()).commit();

                } else {
                    Log.e("tipo fragmento", "111");
                    fragmentManager
                            .beginTransaction()
                            .addToBackStack(null)
                            .hide(mOldfragment.getFragment())
                            .add(R.id.frame_1, mCurrentFragment.getFragment()).commit();

                }
            } else {
                Log.e("tipo fragmento", "12");
                fragmentManager
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.frame_1, mCurrentFragment.getFragment()).commit();

            }


        } catch (IllegalStateException ignored) {
        }
    }



        private void saveFragment() {
        mOldfragment = mCurrentFragment;
    }


    private synchronized void changeOfInstance(int intanceType) {
        saveFragment();

        if (intanceType == FragmentElement.A0) {
            if (A0.size() == 0) {
                cambiar_vista_0(new FragmentElement<>("", main_fragment.newInstance(), FragmentElement.A0));
            } else {
                cambiar_vista_0(A0.pop());
            }
        }
        if (intanceType == FragmentElement.A1) {
            if (A1.size() == 0) {
                cambiar_vista(new FragmentElement<>("", First_fragment.newInstance(), FragmentElement.A1));
            } else {
                cambiar_vista(A1.pop());
            }
        }
        else if (intanceType == FragmentElement.A2) {
            if (A2.size() == 0) {
                cambiar_vista_2(new FragmentElement<>("", second_fragment.newInstance(), FragmentElement.A2));
            } else {
                cambiar_vista_2(A2.pop());
            }
        }
        else if (intanceType == FragmentElement.A3) {
            if (A3.size() == 0) {
                cambiar_vista_3(new FragmentElement<>("", third_fragment.newInstance(), FragmentElement.A3));
            } else {
                cambiar_vista_3(A3.pop());
            }
        }
        }

    @Override
    public void onChange(int tipe_fragment) {
        changeOfInstance (tipe_fragment);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (mCurrentFragment.getInstanceType()!=0) {
            changeOfInstance (0);
        }
    }
}


