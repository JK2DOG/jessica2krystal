package com.jk.zc.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.jk.zc.R;
import com.jk.zc.ui.activity.AboutActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ZhangCheng on 2016/6/8.
 */
public class FragmentThree extends Fragment {

    @BindView(R.id.tv)
    TextView mTextView;

    @BindView(R.id.btn_about)
    Button mBtnAbout;

    private static FragmentThree instance;

    public static FragmentThree newInstance() {
        if (instance == null) {
            instance = new FragmentThree();
        }
        return instance;
    }

    public FragmentThree() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mRootView = inflater.inflate(R.layout.fragment_three, container, false);
        ButterKnife.bind(this, mRootView);
        return mRootView;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTextView.setText("第三个页面");
    }

    @OnClick(R.id.btn_about)
    void clickAbout() {
        startActivity(new Intent(getContext(), AboutActivity.class));
    }
}
