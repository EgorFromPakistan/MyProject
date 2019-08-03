package by.egorgutko.myproject;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.egorgutko.myproject.Model.NetworkService;
import by.egorgutko.myproject.Model.Post;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetofitActivity extends AppCompatActivity {

    @BindView(R.id. textView)
    TextView tView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retofit);
        ButterKnife.bind(this);


        NetworkService.getInstance()
                .getJSONApi()
                .getPostWithID(1)
                .enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(@NonNull Call<Post> call, @NonNull Response<Post> response) {
                        Post post = response.body();// body, чтобы добраться до данных

                        tView.append(post.getId() + "\n");
                        tView.append(post.getUserId() + "\n");
                        tView.append(post.getTitle() + "\n");
                        tView.append(post.getBody() + "\n");
                    }

                    @Override
                    public void onFailure(@NonNull Call<Post> call, @NonNull Throwable t) {

                        tView.append("Error occurred while getting request!");
                        t.printStackTrace();
                    }
                });
    }
}
