package com.jk.zc.ui.activity;

import android.os.Build;
import android.view.Menu;
import android.view.MenuItem;

import com.jk.zc.R;
import com.jk.zc.ui.activity.base.BaseActivity;

/**
 * Created by ZhangCheng on 2016/9/13.
 */
public class AboutActivity extends BaseActivity {
    @Override
    public int getLayoutId() {
        return R.layout.activity_about;
    }

    @Override
    public void initViews() {
        initToolBar();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    finishAfterTransition();
                } else {
                    finish();
                }
                break;
            case R.id.bb_favorites:
                break;
            case R.id.bb_friends:
                break;
            case R.id.bb_nearby:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_about, menu);
        return true;
    }
}
