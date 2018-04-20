package com.xiaobai.rpass.rememberpass.act;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.xiaobai.rpass.rememberpass.R;
import com.ycuwq.datepicker.date.DatePicker;
import com.ycuwq.datepicker.date.DatePickerDialogFragment;

import java.text.SimpleDateFormat;

public class RememberTimeActivity extends BaseActivity {

    DatePicker datePicker;
    private TextView tv_time_re;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remember_time);
        tv_time_re=(TextView)this.findViewById(R.id.tv_time_re);
        datePicker=(DatePicker)this.findViewById(R.id.datePicker);
        init();
    }
    private void init() {
        datePicker.setVisibility(View.GONE);
        setOKText("选择时间");
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy年MM月dd日");
        String rememberTime= dateFormat.format(System.currentTimeMillis());

        tv_time_re.setText(rememberTime);
        getTvBasetitleOK().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               switch (getTvBasetitleOK().getText().toString()){
                   case "选择时间":
                       setOKText("完成");
                       datePicker.setVisibility(View.VISIBLE);
                       break;
                   case "完成":
                       datePicker.setVisibility(View.GONE);
                       setOKText("选择时间");
                        break;
               }
            }
        });

        datePicker.setOnDateSelectedListener(new DatePicker.OnDateSelectedListener() {
            @Override
            public void onDateSelected(int year, int month, int day) {
              tv_time_re.setText(year+"年"+month+"月"+day+"日");
            }
        });
        //datePickerDialogFragment.show(getSupportFragmentManager(), "DatePickerDialogFragment");
    }
}
