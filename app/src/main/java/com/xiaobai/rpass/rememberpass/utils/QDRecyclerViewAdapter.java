package com.xiaobai.rpass.rememberpass.utils;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xiaobai.rpass.rememberpass.R;
import com.xiaobai.rpass.rememberpass.model.Remember;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * 通用的 RecyclerView Adapter。
 *
 */
public class QDRecyclerViewAdapter extends RecyclerView.Adapter<QDRecyclerViewAdapter.ViewHolder> {
    private List<Remember> mItems;
    private final LayoutInflater mLayoutInflater;
    private final Context mContext;


    public QDRecyclerViewAdapter(List<Remember> remembers, Context mContext) {
        this.mItems = remembers;
        this.mLayoutInflater = LayoutInflater.from(mContext);
        this.mContext = mContext;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
       /* LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View root = inflater.inflate(R.layout.recycle_view_see_user, viewGroup, false);*/
        return new ViewHolder(mLayoutInflater.inflate(R.layout.recycle_view_see_user, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.setText(mItems.get(position));
        holder.itemView.findViewById(R.id.tv_delete_item).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteById(mItems.get(position).getId());
                removeItem(position);
            }
        });
    }

    public void removeItem(int num) {
        mItems.remove(num);
        notifyItemRemoved(num);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void deleteById(Long id) {

        if (Remember.deleteById(id))
            Toast.makeText(mContext, "删除成功！", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(mContext, "删除失败！", Toast.LENGTH_SHORT).show();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mEt_use, mEt_account, mEt_password;

        private View itemView;
        private Remember remember;
        private LinearLayout ll_item;
        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;

            mEt_use = (TextView) itemView.findViewById(R.id.tv_use);
            mEt_account = (TextView) itemView.findViewById(R.id.tv_account);
            mEt_password = (TextView) itemView.findViewById(R.id.tv_password);
            ll_item=(LinearLayout)itemView.findViewById(R.id.ll_item);
        }





        public void setText(final Remember data) {
            remember=data;
            mEt_account.setText(data.getUsername().length() > 25 ? data.getUsername().substring(0, 22) + "..." : data.getUsername());
            mEt_password.setText("计入时间：" + data.getRememberTime());
            mEt_use.setText(data.getUseThis().length() > 25 ? data.getUseThis().substring(0, 22) + "..." : data.getUseThis());
            ll_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("进入", "onClick: ");
                    EventBus.getDefault().post(new MessageEvent(data));
                }
            });
        }


    }

}
