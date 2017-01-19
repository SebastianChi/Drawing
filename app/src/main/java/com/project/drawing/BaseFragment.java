package com.project.drawing;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by billy_chi on 2017/1/13.
 */

public class BaseFragment extends Fragment {
    private static final String TAG = "DrawBaseFragment";

    private MainActivity mActivity;

    protected int mNumberOfDraw = 0;
    protected static String bundleKey = "ARG";

    public BaseFragment() {
    }

    public static BaseFragment newInstance(){
        BaseFragment fragment = new BaseFragment();
//        Bundle bundle = new Bundle();
//        bundle.putInt(bundleKey, arg);
//        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        Log.d(TAG, "onAttach");
        super.onAttach(context);
        if (context instanceof Activity) {
            mActivity = (MainActivity) context;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
//        if(getArguments() != null) {
//            mNumberOfDraw = getArguments().getInt(bundleKey);
//        }
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d(TAG, "onDetach");
        super.onDetach();
    }

}
