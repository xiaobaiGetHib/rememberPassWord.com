package com.xiaobai.rpass.rememberpass.utils;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xiaobai.rpass.rememberpass.R;
import com.xiaobai.rpass.rememberpass.model.Remember;

import java.util.List;

/**
 * 通用的 RecyclerView Adapter。
 *
 */
public class QDRecyclerViewAdapter extends RecyclerView.Adapter<QDRecyclerViewAdapter.ViewHolder> {
    private List<Remember> mItems;
    private final LayoutInflater mLayoutInflater;
    private final Context mContext;

    public QDRecyclerViewAdapter(List<Remember> remembers,Context mContext ) {
        this.mItems = remembers;
       this.mLayoutInflater=LayoutInflater.from(mContext);
        this.mContext=mContext;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
       /* LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View root = inflater.inflate(R.layout.recycle_view_see_user, viewGroup, false);*/
       return new ViewHolder(mLayoutInflater.inflate(R.layout.recycle_view_see_user, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setText(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }




    public static class ViewHolder extends RecyclerView.ViewHolder  {

        private TextView mEt_use,mEt_account,mEt_password;
        private QDRecyclerViewAdapter mAdapter;

        public ViewHolder(View itemView) {
            super(itemView);

            mEt_use = (TextView) itemView.findViewById(R.id.tv_use);
            mEt_account = (TextView) itemView.findViewById(R.id.tv_account);
            mEt_password = (TextView) itemView.findViewById(R.id.tv_password);
        }

        public void setText(Remember data) {
            mEt_use  .setText(data.getUsername().length()>25? data.getUsername().substring(0,22)+"...":data.getUsername());
            mEt_password.setText("计入时间："+data.getRememberTime());
            mEt_account  .setText(data.getUseThis().length()>25? data.getUseThis().substring(0,22)+"...":data.getUseThis());
        }
    }
}
