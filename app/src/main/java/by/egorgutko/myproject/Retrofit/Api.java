package by.egorgutko.myproject.Retrofit;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Api {

    @GET("/users/{id}")
    public Call<data> getPostWithID(@Path("id") int id);

    @POST("/posts")
    public Call<data> postData(@Body data mdata);

}
