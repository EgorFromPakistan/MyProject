package by.egorgutko.myproject.Data;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import by.egorgutko.myproject.R;

public class DetailsOfFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, null);
        TextView tView = (TextView) view.findViewById(R.id.tText);
        ImageView iView =(ImageView) view.findViewById(R.id.itemImage);
        tView.setText(getArguments().getString("1"));
        iView.setImageResource( getArguments().getInt("2"));
        return view;
    }
}