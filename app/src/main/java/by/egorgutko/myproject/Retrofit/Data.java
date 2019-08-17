package by.egorgutko.myproject.Retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName(StaticValue.forId)
    @Expose
    private long id;

    @SerializedName(StaticValue.forEmail)
    @Expose
    private String email;

    @SerializedName(StaticValue.forFirstName)
    @Expose
    private String first_name;

    @SerializedName(StaticValue.forLastName)
    @Expose
    private String last_name;

    @SerializedName(StaticValue.forAvatar)
    @Expose
    private String avatar;

    //public data (String email,String first_name,String last_name,String avatar){
    //  this.email=email;
    //  this.first_name = first_name;
    // this.last_name = last_name;
    //  this.avatar = avatar;
    // }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }


    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getAvatar() {
        return avatar;
    }
}
