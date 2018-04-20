package com.xiaobai.rpass.rememberpass.act;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.activeandroid.query.Select;
import com.xiaobai.rpass.rememberpass.R;
import com.xiaobai.rpass.rememberpass.model.Remember;

public class DateActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
        int num= Integer.parseInt((getIntent().getStringExtra("rememberId")));
        Log.i("进入", "onCreate: "+num);
        Select select=new Select();
             Remember remember=(Remember)select.from(Remember.class).where("ID="+num).execute();

        setTitleText(remember.getUseThis());
    }
}
