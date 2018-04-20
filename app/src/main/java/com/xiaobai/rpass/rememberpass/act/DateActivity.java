package com.xiaobai.rpass.rememberpass.act;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.activeandroid.query.Select;
import com.xiaobai.rpass.rememberpass.R;
import com.xiaobai.rpass.rememberpass.model.Remember;

public class DateActivity extends BaseActivity {


    private TextView et_account_see,et_password_see,et_remake_see,et_use_see;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);

      init();
    }

    private void init() {
        String rememberThis =  getIntent().getStringExtra("rememberThis");
        String rememberUserName =  getIntent().getStringExtra("rememberUserName");
        String rememberRemake =  getIntent().getStringExtra("rememberRemake");
        String rememberPassword =  getIntent().getStringExtra("rememberPassword");

      /*  Log.i("进入", "onCreate: "+num);*/

        getLlBasetitleBack().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setOkVisibity(false);
        setTitleText(rememberThis);
        et_account_see = (TextView) this.findViewById(R.id.et_account_see);
        et_password_see= (TextView) this.findViewById(R.id.et_password_see);
        et_remake_see= (TextView) this.findViewById(R.id.et_remake_see);
        et_account_see.setText(rememberUserName);
        et_remake_see.setText(TextUtils.isEmpty(rememberRemake)? "无":rememberRemake);
        et_password_see.setText(rememberPassword);
    }
}
