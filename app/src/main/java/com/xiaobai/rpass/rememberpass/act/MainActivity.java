package com.xiaobai.rpass.rememberpass.act;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.xiaobai.rpass.rememberpass.R;


public class MainActivity extends BaseActivity {

    private Button btn_add;
    private Button btn_see_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setBankVisibity(false);
        setOkVisibity(false);
        setTitleText("记记");
        init();
    }

    private void init() {
        btn_add = this.findViewById(R.id.btn_add_new);
        btn_see_info = this.findViewById(R.id.btn_into_see);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),AddLogActivity.class));
            }
        });
        btn_see_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),ViewLogActivity.class));
            }
        });
    }


}
