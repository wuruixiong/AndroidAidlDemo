package wrx.aidlclient;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

import wrx.aidlserver.IRemoteService;

public class MainActivity extends Activity {


    IRemoteService mIRemoteService;
    private ServiceConnection mConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className, IBinder service) {
            Log.e("aidlclient", "onService Connected");
            mIRemoteService = IRemoteService.Stub.asInterface(service);
            try {
                Log.e("aidlclient", "Service Process Pid: " + mIRemoteService.getPid());
            } catch (Exception e) {
            }
        }
        public void onServiceDisconnected(ComponentName className) {
            Log.e("aidlclient", "onService Disconnected");
            mIRemoteService = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent();
                intent1.setAction("wrx.aidlserver.service");
                intent1.setPackage("wrx.aidlserver");
                bindService(intent1, mConnection, BIND_AUTO_CREATE);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(mConnection);
    }
}
