package com.jk.zc.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jk.zc.R;
import com.socks.library.KLog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by ZhangCheng on 2016/6/8.
 */
public class FragmentTwo extends Fragment {

    @BindView(R.id.tv)
    TextView mTextView;


    private Observer<String> observer;


    private static FragmentTwo instance;

    public static FragmentTwo newInstance() {
        if (instance == null) {
            instance = new FragmentTwo();
        }
        return instance;
    }

    public FragmentTwo() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mRootView = inflater.inflate(R.layout.fragment_two, container, false);
        ButterKnife.bind(this, mRootView);
        return mRootView;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTextView.setText("第二个页面");
        observer = new Observer<String>() {
            @Override
            public void onCompleted() {
                KLog.e("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                KLog.e("onError");
            }

            @Override
            public void onNext(String s) {
                KLog.e("onNext:" + s);
            }
        };

    }

    @OnClick(R.id.tv_rx)
    void click() {
//        Observable<String> observable;
//        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                subscriber.onNext("哈哈哈哈");
//            }
//        });
//        observable.subscribe(observer);
        Observable.just("xxx").map(new Func1<String, String>() {
            @Override
            public String call(String s) {
                return s+"zczczc";
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                KLog.e("call:" + s);
            }
        });

    }
}
