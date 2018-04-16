package com.xiaobai.rpass.rememberpass.act;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.activeandroid.query.Select;
import com.xiaobai.rpass.rememberpass.R;
import com.xiaobai.rpass.rememberpass.model.Remember;
import com.xiaobai.rpass.rememberpass.utils.QDRecyclerViewAdapter;

import java.util.List;


public class ViewLogActivity extends BaseActivity {

    private RecyclerView recycle_re_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_log);
        setTitleText("记记展示");
        recycle_re_list=this.findViewById(R.id.recycle_re_list);
        init();
    }

    private void init() {
        List<Remember> list_RememberList= new Select().from(Remember.class).execute();
        Log.i("Sql", "init: "+list_RememberList.size());
        recycle_re_list.setLayoutManager(new LinearLayoutManager(this));
        recycle_re_list.setAdapter(new QDRecyclerViewAdapter(list_RememberList,getBaseContext()));

    }


}
