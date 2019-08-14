package by.egorgutko.myproject;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.egorgutko.myproject.Retrofit.NetworkService;
import by.egorgutko.myproject.Retrofit.data;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RetofitActivity extends AppCompatActivity {

    final TextView tView = findViewById(R.id.textView);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retofit);
        //ButterKnife.bind(this);

        NetworkService.getInstance()
                .getApi()
                .getPostWithID(2)
                .enqueue(new Callback<data>() {
                    @Override
                    public void onResponse(@NonNull Call<data> call, @NonNull Response<data> response) {
                        data mdata = response.body();

                        tView.append(mdata.getId() + "\n");
                        tView.append(mdata.getEmail() + "\n");
                        tView.append(mdata.getFirst_name() + "\n");
                        tView.append(mdata.getLast_name() + "\n");
                        tView.append(mdata.getAvatar() + "\n");
                    }

                    @Override
                    public void onFailure(@NonNull Call<data> call, @NonNull Throwable t) {

                        tView.append("Error occurred while getting request!");
                        t.printStackTrace();
                    }
                });
    }


}
