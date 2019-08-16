package by.egorgutko.myproject;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import by.egorgutko.myproject.Retrofit.Data;
import by.egorgutko.myproject.Retrofit.NetworkService;
import by.egorgutko.myproject.Retrofit.Data;
import by.egorgutko.myproject.Retrofit.User;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RetofitActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retofit);
        //ButterKnife.bind(this);
        final TextView tView = findViewById(R.id.textView);
        NetworkService.getInstance()
                .getApi()
                .getPostWithID(2)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<User>() {
                               @Override
                               public void accept(User user) throws Exception {

                                   tView.append(user.mData.getId() + "\n");
                                   tView.append(user.mData.getEmail() + "\n");
                                   tView.append(user.mData.getFirst_name() + "\n");
                                   tView.append(user.mData.getLast_name() + "\n");
                                   tView.append(user.mData.getAvatar() + "\n");

                               }
                           },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                               throwable.printStackTrace();
                            }
                        });

    }


}
