package com.xiaobai.rpass.rememberpass.act;

import android.os.Bundle;
import android.view.View;

import com.xiaobai.rpass.rememberpass.R;

public class AddLogActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_log);
       init();
}

    private void init() {
        setTitleText("新增记忆");
        setOKText("完成");
        getLlBasetitleBack().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
        getTvBasetitleOK().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}

