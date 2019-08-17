package by.egorgutko.myproject.Retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName(StaticValue.forUser)
    @Expose
    public Data mData;
}
