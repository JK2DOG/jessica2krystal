package com.jk.zc.ui.activity;

import android.os.Build;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

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
                Toast.makeText(AboutActivity.this,"喜欢",Toast.LENGTH_SHORT).show();
                break;
            case R.id.bb_friends:
                Toast.makeText(AboutActivity.this,"朋友",Toast.LENGTH_SHORT).show();
                break;
            case R.id.bb_nearby:
                Toast.makeText(AboutActivity.this,"附近",Toast.LENGTH_SHORT).show();
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
