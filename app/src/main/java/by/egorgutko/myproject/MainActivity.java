package by.egorgutko.myproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import by.egorgutko.myproject.Interface.MainActivityView;
import by.egorgutko.myproject.Presenter.PresenterForList;

public class MainActivity extends AppCompatActivity implements MainActivityView {


    @Inject
    PresenterForList presenterForList;


    @BindView(R.id.ListOfTraining)
    Button listOfTraining;

    private AppComponent mAppComponent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAppComponent = DaggerAppComponent.builder().build();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAppComponent.inject(this);
        ButterKnife.bind(this);
        presenterForList.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenterForList.detachView();
    }

    @OnClick(R.id.ExitOfApp)
    void exitApplication(){
        presenterForList.exitOfApp();
    }

    @OnClick(R.id.ListOfTraining)
    void transitionToList(View v){
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.Retr)
    void transitionRetorofit(View v){
        Intent intent = new Intent(this, RetofitActivity.class);
        startActivity(intent);
    }


    @Override
    public void exitOfApp() {
        finish();
    }
}
