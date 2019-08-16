package by.egorgutko.myproject.Retrofit;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Api {

//вынести константами в отдельный класс
    @GET("users/{id}")
    Observable<User> getPostWithID(@Path("id") int id);

    @POST("posts")
    Observable<User> postData(@Body User mData);

}

