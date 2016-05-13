package com.my.nullpointerplayer.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.my.nullpointerplayer.R;
import com.my.nullpointerplayer.activity.MainActivity;

/**
 * 所有Fragment都继承该Fragment
 * Fragment跳转方法
 * Fragment返回方法
 * Created by dllo on 16/1/26.
 */
public class BaseFragment extends Fragment {

    private MainActivity mainActivity;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    /**
     * Fragment跳转(替换)Fragment的方法
     *
     * @param fragment
     */
    public void goNextFragment(Fragment fragment) {
        fragmentManager = mainActivity.getSupportFragmentManager();
        //fragmentManager=getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.addToBackStack("00");
        fragmentTransaction.commit();
    }

    /**
     * Fragment返回Fragment的方法
     */
    public void goBack() {
        if (null == fragmentTransaction) {
            fragmentManager = mainActivity.getSupportFragmentManager();
        }
        fragmentManager.popBackStack();
        fragmentManager.popBackStackImmediate("", 1);
    }
}
