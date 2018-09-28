package com.billy.leetcode;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private IMyAidlInterface iMyAidlInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindService();
    }

    class BasicTypesServiceConnection implements ServiceConnection{

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iMyAidlInterface = IMyAidlInterface.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }

    /**
     * 绑定服务
     */
    private void bindService(){
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.billy.leetcode"
                , "com.billy.leetcode.service.BasicTypesService"));
        boolean isBind = bindService(intent, new BasicTypesServiceConnection(), Context.BIND_AUTO_CREATE);
    }

    public void onClick (View view) throws RemoteException {
        Toast.makeText(this,iMyAidlInterface.getName(),Toast.LENGTH_SHORT).show();
    }
}
