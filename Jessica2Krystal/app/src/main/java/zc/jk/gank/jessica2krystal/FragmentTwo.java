package zc.jk.gank.jessica2krystal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by ZhangCheng on 2016/6/8.
 */
public class FragmentTwo extends Fragment {

    @Bind(R.id.tv)
    TextView mTextView;

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
        View mRootView = inflater.inflate(R.layout.fragment_one, container, false);
        ButterKnife.bind(this, mRootView);
        return mRootView;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTextView.setText("第二个页面");
    }
}
