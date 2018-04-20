package com.xiaobai.rpass.rememberpass.act;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.activeandroid.query.Select;
import com.loopeer.cardstack.AllMoveDownAnimatorAdapter;
import com.loopeer.cardstack.CardStackView;
import com.loopeer.cardstack.UpDownAnimatorAdapter;
import com.loopeer.cardstack.UpDownStackAnimatorAdapter;
import com.xiaobai.rpass.rememberpass.R;
import com.xiaobai.rpass.rememberpass.model.Remember;
import com.xiaobai.rpass.rememberpass.utils.MessageEvent;
import com.xiaobai.rpass.rememberpass.utils.QDRecyclerViewAdapter;
import com.xiaobai.rpass.rememberpass.utils.TestStackAdapter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Arrays;
import java.util.List;


public class ViewLogActivity  extends BaseActivity {

    private TestStackAdapter mTestStackAdapter;
    private CardStackView mStackView;
  /*  public static Integer[] TEST_DATAS = new Integer[]{
            R.color.color_1,
            R.color.color_2,
            R.color.color_3,
            R.color.color_4,
            R.color.color_5,
            R.color.color_6,
            R.color.color_7,
            R.color.color_8,
            R.color.color_9,
            R.color.color_10,
            R.color.color_11,
            R.color.color_12,
            R.color.color_13,
            R.color.color_14,
            R.color.color_15,
            R.color.color_16,
            R.color.color_17,
            R.color.color_18,
            R.color.color_19,
            R.color.color_20,
            R.color.color_21,
            R.color.color_22,
            R.color.color_23,
            R.color.color_24,
            R.color.color_25,
            R.color.color_26
    };*/
  private RecyclerView recyclerView;
    private QDRecyclerViewAdapter qdRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_log);
        EventBus.getDefault().register(this);
      setTitleText("查看记记");
      setOKText("选择");
        recyclerView= (RecyclerView) this.findViewById(R.id.rv_list_log);
        getLlBasetitleBack().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        init();
    }

    private void init() {
        List<Remember> list_RememberList= new Select().from(Remember.class).execute();
        Log.i("Sql", "init: "+list_RememberList.size());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        qdRecyclerViewAdapter = new QDRecyclerViewAdapter(list_RememberList, getBaseContext());
        recyclerView.setAdapter(qdRecyclerViewAdapter);

     /*   mStackView = (CardStackView) findViewById(R.id.stackview);
        mTestStackAdapter = new TestStackAdapter(this);
        mStackView.setItemExpendListener(this);
        mStackView.setAdapter(mTestStackAdapter);
        new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        mTestStackAdapter.updateData(Arrays.asList(TEST_DATAS));
                    }
                }
                , 200
        );*/
    }
   /* public void onPreClick(View view) {
        mStackView.pre();
    }

    public void onNextClick(View view) {
        mStackView.next();
    }

    @Override
    public void onItemExpend(boolean expend) {

    }*/

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);

    }
 @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMoonEvent(MessageEvent messageEvent){
        if(messageEvent!=null) {
            Toast.makeText(this, "ada", Toast.LENGTH_SHORT).show();
            Intent intent=   new Intent(getBaseContext(),DateActivity.class);
            intent.putExtra("rememberId",""+messageEvent.getMessage());
            startActivity(intent);
        }
    }

}
