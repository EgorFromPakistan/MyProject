package by.egorgutko.myproject;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import by.egorgutko.myproject.Data.DetailsOfFragment;
import by.egorgutko.myproject.Data.ListFragment;
import by.egorgutko.myproject.Presenter.PresenterForRecycler;

public class ListActivity extends AppCompatActivity {


    int count;
    DetailsOfFragment frag1;
    ListFragment fragment;
    FragmentManager fragmetManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        fragment = new ListFragment();
        fragmetManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmetManager.beginTransaction();
        fragmentTransaction.add(R.id.placeholder, fragment);
        fragmentTransaction.commit();
        frag1 = new DetailsOfFragment();

    }

    public void newFragment(Pair<String, Integer> pPair) {
        Bundle bundle = new Bundle();
        bundle.putString("1",pPair.first);
        bundle.putInt("2",pPair.second);
        frag1.setArguments(bundle);
        FragmentTransaction fragmentTransaction = fragmetManager.beginTransaction();
        fragmentTransaction.replace(R.id.placeholder, frag1);
        fragmentTransaction.commit();
    }
}
