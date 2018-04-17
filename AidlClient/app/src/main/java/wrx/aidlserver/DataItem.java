package wrx.aidlserver;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by wuruixiong on 4/17/18.
 */

public class DataItem implements Parcelable {

    private int id;
    private String name;

    public DataItem(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private DataItem(Parcel parcel) {
        id = parcel.readInt();
        name = parcel.readString();
    }

    @Override
    public String toString() {
        return id + name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
    }

    public static final Creator<DataItem> CREATOR
            = new Creator<DataItem>() {
        public DataItem createFromParcel(Parcel in) {
            return new DataItem(in);
        }
        public DataItem[] newArray(int size) {
            return new DataItem[size];
        }
    };

}
