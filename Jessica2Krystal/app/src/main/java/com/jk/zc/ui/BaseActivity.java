package com.jk.zc.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.jk.zc.R;

import butterknife.ButterKnife;

/**
 * Created by ZhangCheng on 2016/9/13.
 */
public abstract class BaseActivity extends AppCompatActivity {


    public abstract int getLayoutId();

    public abstract void initViews();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initViews();
        initToolBar();
    }

    private void initToolBar() {
        Toolbar mToolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);
    }

//
//    // TODO:适配4.4的透明状态栏
//    @TargetApi(Build.VERSION_CODES.KITKAT)
//    protected void setStatusBarTranslucent() {
//        if ((Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT&&
//                !(this instanceof NewsDetailActivity || this instanceof PhotoActivity
//                        || this instanceof PhotoDetailActivity))
//                || (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT
//                && this instanceof NewsDetailActivity)) {
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            SystemBarTintManager tintManager = new SystemBarTintManager(this);
//            tintManager.setStatusBarTintEnabled(true);
//            tintManager.setStatusBarTintResource(R.color.colorPrimary);
//        }
//    }

}
