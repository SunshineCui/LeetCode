package com.billy.leetcode.form.view;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.billy.leetcode.R;
import com.billy.leetcode.databinding.ActivityFormBinding;
import com.billy.leetcode.form.adapter.FormAdapter;
import com.billy.leetcode.form.model.FormModel;

import java.util.ArrayList;

/**
 * Created by Billy_Cui on 2018/10/18.
 * Describe:
 */

public class FormActivity extends Activity{

    private ActivityFormBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_form);
        setData();
    }


    private void setData(){
        FormModel model1 = new FormModel();
        ObservableArrayList<FormModel> list1 = new ObservableArrayList<>();
        model1.setList(list1);

        for (int i = 0; i < 4; i++) {
            FormModel model2 = new FormModel();
            model2.setName("1级目录");
            model2.setType(FormAdapter.TYPE_NORMAL);
            ObservableArrayList<FormModel> list2 = new ObservableArrayList<>();
            model2.setList(list2);
            for (int j = 0; j < 3; j++) {
                FormModel model3 = new FormModel();
                model3.setName("2级目录");
                model3.setType(FormAdapter.TYPE_NORMAL);
                ObservableArrayList<FormModel> list3 = new ObservableArrayList<>();
                model3.setList(list3);
                for (int k = 0; k < 2; k++) {
                    FormModel end = new FormModel();
                    end.setType(FormAdapter.TYPE_END);
                    list3.add(end);
                }
                list2.add(model3);
            }
           list1.add(model2);
        }
        binding.setModel(model1);

    }

}
