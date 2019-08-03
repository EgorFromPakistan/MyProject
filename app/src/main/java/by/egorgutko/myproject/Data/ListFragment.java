package by.egorgutko.myproject.Data;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import javax.inject.Inject;

import butterknife.BindView;
import by.egorgutko.myproject.AppComponent;
import by.egorgutko.myproject.DaggerAppComponent;
import by.egorgutko.myproject.ListActivity;
import by.egorgutko.myproject.R;

public class ListFragment extends Fragment {
   // ListAdapter listAdapter = new ListAdapter();

    @SuppressLint("ValidFragment")
    @Inject
    ListFragment(){}

    private AppComponent mAppComponent;
    @Inject
    ListAdapter listAdapter;


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup containre, Bundle saveInstanceState) {
        mAppComponent = DaggerAppComponent.builder().build();
        View view = inflater.inflate(R.layout.fragment_list, containre, false);
        mAppComponent.inject(this);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.listRecyclerView);
        //recyclerView.setOnClickListener(this);

        listAdapter.setmOnItemClickListener(new ListAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                ListFragment.this.onClick(listAdapter.getItem(position));
            }
        });
        recyclerView.setAdapter(listAdapter);
        //просто показываем, что список вертикальный
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }


    public void onClick(Pair pPair) {
        if (getActivity() != null) {

            ((ListActivity) getActivity()).newFragment(pPair);
        }
    }


}