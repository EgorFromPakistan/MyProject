package by.egorgutko.myproject.Retrofit;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Api {

    //вынести константами в отдельный класс
    @GET(StaticValue.forGetUser)
    Observable<User> getPostWithID(@Path("id") int id);

    @POST(StaticValue.forPost)
    Observable<User> postData(@Body User mData);

}

