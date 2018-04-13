package com.xiaobai.rpass.rememberpass.act;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xiaobai.rpass.rememberpass.R;

/**
 * Created by Administrator on 2018/4/13.
 */

public class BaseActivity extends AppCompatActivity {
    private RelativeLayout llRoot;
    private LinearLayout llBasetitleBack;
    private TextView tvBasetitleTitle;
    private TextView tvBasetitleOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setTheme(R.style.NoActionBarSen);
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_base);

        findView();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        }
    }
    private void findView() {
        llRoot = (RelativeLayout) findViewById(R.id.ll_basetitle_root);
        llBasetitleBack = (LinearLayout) findViewById(R.id.ll_basetitle_back);
        tvBasetitleTitle = (TextView) findViewById(R.id.tv_basetitle_title);
        tvBasetitleOK = (TextView) findViewById(R.id.tv_basetitle_ok);
    }

    /**
     重点是重写setContentView，让继承者可以继续设置setContentView
     * 重写setContentView
     * @param resId
     */
    @Override
    public void setContentView(int resId) {
        View view = getLayoutInflater().inflate(resId, null);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        lp.addRule(RelativeLayout.BELOW, R.id.ll_basetitle);
        if (null != llRoot)
            llRoot.addView(view, lp);
    }

    /**
     *
     * 设置中间标题文字
     * @param c
     */
    public void setTitleText(String c) {
        if (tvBasetitleTitle != null)
            tvBasetitleTitle.setText(c);
    }
    /**
     *
     * 设置中间标题文字
     * @param resId
     */
    public void setTitleText(int resId) {
        if (tvBasetitleTitle != null)
            tvBasetitleTitle.setText(resId);
    }

    /**
     * 设置右边标题
     * @param c
     */
    public void setOKText(String c) {
        if (tvBasetitleOK != null)
            tvBasetitleOK.setText(c);
    }

    /**
     * 设置右边按钮是否显示
     * @param visible
     */
    public void setOkVisibity(boolean visible) {
        if (tvBasetitleOK != null) {
            if (visible)
                tvBasetitleOK.setVisibility(View.VISIBLE);
            else
                tvBasetitleOK.setVisibility(View.GONE);
        }
    }

    /**
     * 设置左边按钮是否显示
     * @param visible
     */
    public void setBankVisibity(boolean visible) {
        if (llBasetitleBack != null) {
            if (visible)
                llBasetitleBack.setVisibility(View.VISIBLE);
            else
                llBasetitleBack.setVisibility(View.INVISIBLE);
        }
    }

    public LinearLayout getLlBasetitleBack() {
        return llBasetitleBack;
    }


    public TextView getTvBasetitleTitle() {
        return tvBasetitleTitle;
    }



    public TextView getTvBasetitleOK() {
        return tvBasetitleOK;
    }
}