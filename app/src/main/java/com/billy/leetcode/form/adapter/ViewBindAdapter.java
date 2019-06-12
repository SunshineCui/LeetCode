package com.billy.leetcode.form.adapter;

import android.databinding.BindingAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.billy.leetcode.form.model.FormModel;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.ArrayList;

/**
 * Created by Billy_Cui on 2018/10/18.
 * Describe:
 */

public class ViewBindAdapter {

    @BindingAdapter(value = {"formAdapter", "listener"},requireAll = false)
    public static void setFormAdapter(RecyclerView rv, ArrayList<FormModel> items, View.OnClickListener listener) {
        FormAdapter adapter = (FormAdapter) rv.getAdapter();
        if (adapter == null) {
            adapter = new FormAdapter(items == null ? new ArrayList<FormModel>() : items,rv.getContext());
            LinearLayoutManager layoutManager = new LinearLayoutManager(rv.getContext(),LinearLayoutManager.VERTICAL,false);
            rv.setLayoutManager(layoutManager);

//            FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(rv.getContext());
//            flexboxLayoutManager.setFlexWrap(FlexWrap.NOWRAP);
//            flexboxLayoutManager.setFlexDirection(FlexDirection.COLUMN);
//            flexboxLayoutManager.setJustifyContent(JustifyContent.FLEX_START);
//            rv.setLayoutManager(flexboxLayoutManager);
            rv.setAdapter(adapter);
        }else {
            adapter.refreshData(items);
        }
    }
}
