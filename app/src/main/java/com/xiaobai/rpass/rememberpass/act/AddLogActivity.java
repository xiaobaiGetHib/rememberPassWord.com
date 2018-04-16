package com.xiaobai.rpass.rememberpass.act;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.xiaobai.rpass.rememberpass.R;
import com.xiaobai.rpass.rememberpass.model.Remember;

import java.text.SimpleDateFormat;

public class AddLogActivity extends BaseActivity {
    EditText etUse,etAccount,etPassword,etRemake;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_log);
        etUse=this.findViewById(R.id.et_use);
        etAccount= this.findViewById(R.id.et_account);
        etPassword=  this.findViewById(R.id.et_password);
        etRemake= this.findViewById(R.id.et_remake);
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

            if(verificationInfo()){
            /*    Remember remember=new Remember("46465","46465","46465",
                        "46465");*/
                SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
              String rememberTime= dateFormat.format(System.currentTimeMillis());
                Remember remember=new Remember(etUse.getText().toString(),etAccount.getText().toString(),etPassword.getText().toString(),
                        TextUtils.isEmpty(etRemake.getText())==true?  null:etRemake.getText().toString(),rememberTime);
                if(   remember.save()==1){
                    Toast.makeText(AddLogActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
                    finish();
                }else {
                    Toast.makeText(AddLogActivity.this, "添加失败", Toast.LENGTH_SHORT).show();
                }
                }
            }
        });

    }

    private Boolean verificationInfo() {
        if(TextUtils.isEmpty(etAccount.getText())||
                TextUtils.isEmpty(etUse.getText())||
                    TextUtils.isEmpty(etPassword.getText())){
            Toast.makeText(this, "信息不完整！", Toast.LENGTH_SHORT).show();
            return false;
        }else {
            return  true;
        }
    }
}

