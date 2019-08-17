package by.egorgutko.myproject.Data;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import by.egorgutko.myproject.R;

public class DetailsOfFragment extends Fragment {


    private Unbinder unbinder;

    @BindView(R.id.tText)
    TextView tView;

    @BindView(R.id.itemImage)
    ImageView iView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, null);
        unbinder = ButterKnife.bind(this, view);
        tView.setText(getArguments().getString("1"));
        iView.setImageResource(getArguments().getInt("2"));
        return view;
    }
}