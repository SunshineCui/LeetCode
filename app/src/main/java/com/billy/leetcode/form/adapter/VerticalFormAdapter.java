package com.billy.leetcode.form.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.billy.leetcode.R;
import com.billy.leetcode.databinding.ItemFormBinding;
import com.billy.leetcode.databinding.ItemFormEndBinding;
import com.billy.leetcode.form.model.FormModel;

import java.util.ArrayList;

/**
 * Created by Billy_Cui on 2018/10/18.
 * Describe:
 */

public class VerticalFormAdapter extends RecyclerView.Adapter<VerticalFormAdapter.BindingHolder> {

    public final static int TYPE_NORMAL = 1;
    public final static int TYPE_END = 2;
    private final Context context;
    private ArrayList<FormModel> items;

    public VerticalFormAdapter(ArrayList<FormModel> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding inflate;
        if (viewType == TYPE_NORMAL) {
            inflate = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_form, parent, false);
        } else {
            inflate = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_form_end, parent, false);
        }
        return new BindingHolder(inflate.getRoot(), viewType);
    }


    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        if (holder.getViewType() == TYPE_END) {
            ItemFormEndBinding binding = DataBindingUtil.bind(holder.itemView);
            binding.setModel(items.get(position));
        } else {
            ItemFormBinding binding = DataBindingUtil.bind(holder.itemView);
            binding.setModel(items.get(position));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (items.get(position) != null) {
            switch (items.get(position).getType()) {
                case TYPE_NORMAL:

                    return TYPE_NORMAL;
                case TYPE_END:

                    return TYPE_END;

            }
        }
        return -1;

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class BindingHolder extends RecyclerView.ViewHolder {

        private int viewType;

        public BindingHolder(View itemView, int viewType) {
            super(itemView);
            this.viewType = viewType;
        }

        public int getViewType() {
            return viewType;
        }
    }

    public void refreshData(ArrayList<FormModel> list) {
        this.items = list;
        notifyDataSetChanged();
    }
}
