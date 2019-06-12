package com.billy.leetcode.form.model;

import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.ObservableArrayList;
import android.databinding.PropertyChangeRegistry;

import com.billy.leetcode.BR;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Billy_Cui on 2018/10/18.
 * Describe:
 */

public class FormModel implements Observable {

    private String name;
    private int type;
    private ObservableArrayList<FormModel> list;
    private transient PropertyChangeRegistry propertyChangeRegistry = new PropertyChangeRegistry();


    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyChange(BR.name);
    }

    @Bindable
    public ObservableArrayList<FormModel> getList() {
        return list;
    }

    public void setList(ObservableArrayList<FormModel> list) {
        this.list = list;
        notifyChange(BR.list);
    }

    private synchronized void notifyChange(int propertyId) {
        if (propertyChangeRegistry == null) {
            propertyChangeRegistry = new PropertyChangeRegistry();
        }
        propertyChangeRegistry.notifyChange(this, propertyId);
    }

    @Override
    public synchronized void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        if (propertyChangeRegistry == null) {
            propertyChangeRegistry = new PropertyChangeRegistry();
        }
        propertyChangeRegistry.add(callback);

    }

    @Override
    public synchronized void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        if (propertyChangeRegistry != null) {
            propertyChangeRegistry.remove(callback);
        }
        new ReentrantLock();
        new ReentrantReadWriteLock();
    }

    @Bindable
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
        notifyChange(BR.type);
    }
}
