package com.xiaobai.rpass.rememberpass.act;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xiaobai.rpass.rememberpass.R;
import com.xiaobai.rpass.rememberpass.model.Remember;

import java.text.SimpleDateFormat;

public class AddLogActivity extends BaseActivity {
    EditText etUse,etAccount,etPassword,etRemake;
    Button btn_off,btn_reset;
    LinearLayout ll_edit_remake;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_log);
        etUse=(EditText)this.findViewById(R.id.et_use);
        etAccount= (EditText)this.findViewById(R.id.et_account);
        etPassword= (EditText) this.findViewById(R.id.et_password);
        etRemake= (EditText)this.findViewById(R.id.et_remake);
        btn_off=(Button)this.findViewById(R.id.btn_off);
        btn_reset=(Button)this.findViewById(R.id.btn_reset);
        ll_edit_remake=(LinearLayout)this.findViewById(R.id.ll_edit_remake);

        init();
}

    private void init() {
        setTitleText("新增记忆");
        setOKText("添加备注");
        ll_edit_remake.setVisibility(View.GONE);
        getLlBasetitleBack().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
        getTvBasetitleOK().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (getTvBasetitleOK().getText().toString()){
                    case "取消备注":
                        setOKText("添加备注");
                        ll_edit_remake.setVisibility(View.GONE);
                        break;
                    case "添加备注":
                        setOKText("取消备注");
                        ll_edit_remake.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });
        btn_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(verificationInfo()){
            /*    Remember remember=new Remember("46465","46465","46465",
                        "46465");*/
                    SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
                    String rememberTime= dateFormat.format(System.currentTimeMillis());
                    Remember remember=new Remember(etUse.getText().toString(),etAccount.getText().toString(),etPassword.getText().toString(),
                            TextUtils.isEmpty(etRemake.getText())==true?  null:etRemake.getText().toString(),rememberTime);
                    Long saveStatus= remember.save();
                    Log.i("saveStatus", ""+saveStatus);
                    if(saveStatus!=null){
                        Toast.makeText(AddLogActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
                        finish();
                    }else {
                        Toast.makeText(AddLogActivity.this, "添加失败", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etUse.setText("");
                etAccount.setText("");
                etPassword.setText("");
                etRemake.setText("");
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

