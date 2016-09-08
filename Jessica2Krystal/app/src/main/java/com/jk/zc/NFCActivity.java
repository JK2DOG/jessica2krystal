package com.jk.zc;

import android.content.Context;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.socks.library.KLog;

import java.util.Arrays;

/**
 * Created by ZhangCheng on 2016/9/7.
 */
public class NFCActivity extends AppCompatActivity {

    private NfcAdapter mNfcAdapter;


    public static void start(Context context) {
        Intent intent = new Intent(context, NFCActivity.class);
        context.startActivity(intent);
    }


    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_nfc);
        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);
        handleIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent);
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (mNfcAdapter == null) {
            KLog.e("设备不支持NFC");
            return;
        }
        if (!mNfcAdapter.isEnabled()) {
            KLog.e("请在系统设置中先启用NFC功能");
            return;
        }
    }

    private void handleIntent(Intent intent) {
        //获取到Intent的Action，注意多打Log
        KLog.e("handleIntent: " + intent.getAction());
        if (!intent.getAction().equals(NfcAdapter.ACTION_TECH_DISCOVERED)) {
            KLog.e("handleIntent: no valid action");
            return;
        }
        //获取Tag对象
     Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
        //获取卡ID，这个ID一般没什么用，有可能是卡自动生成的
//        KLog.e("Id:" + Util.byteArraytoHexString(tag.getId()));
        //NFC卡片所支持的技术标准
        KLog.e("TechList:" + Arrays.toString(tag.getTechList()));
    }

}
