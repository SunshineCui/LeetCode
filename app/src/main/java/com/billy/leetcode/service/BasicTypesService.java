package com.billy.leetcode.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import com.billy.leetcode.IMyAidlInterface;

/**
 * Created by Billy_Cui on 2018/8/8
 * Describe:
 */

public class BasicTypesService extends Service{
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new IMyAidlInterface.Stub() {

            @Override
            public String getName() throws RemoteException {
                return "hello world!";
            }
        };
    }
}
