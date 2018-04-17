package wrx.aidlserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuruixiong on 4/17/18.
 */

public class RemoteService extends Service {

    List<DataItem> mDataItemList;

    @Override
    public void onCreate() {
        super.onCreate();
        mDataItemList = new ArrayList<>();
        mDataItemList.add(new DataItem(100, "banana"));
        mDataItemList.add(new DataItem(101, "apple"));
        mDataItemList.add(new DataItem(102, "orange"));
    }

    @Override
    public IBinder onBind(Intent intent) {
        // Return the interface
        return mBinder;
    }

    private final IRemoteService.Stub mBinder = new IRemoteService.Stub() {

        @Override
        public void addDataItem(DataItem dataItem) throws RemoteException {
            mDataItemList.add(dataItem);
        }

        @Override
        public List<DataItem> getDateItemList() throws RemoteException {
            return mDataItemList;
        }

        public int getPid(){
            return android.os.Process.myPid();
        }
        public void basicTypes(int anInt, long aLong, boolean aBoolean,
                               float aFloat, double aDouble, String aString) {
            // Does nothing
        }
    };
}
