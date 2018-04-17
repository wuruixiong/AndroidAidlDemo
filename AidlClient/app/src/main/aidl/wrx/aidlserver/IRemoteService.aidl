// IRemoteService.aidl
package wrx.aidlserver;
import wrx.aidlserver.DataItem;

// Declare any non-default types here with import statements
interface IRemoteService {


    void addDataItem(in DataItem data);
    List<DataItem> getDateItemList();

    /** Request the process ID of this service, to do evil things with it. */
    int getPid();

    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

}
