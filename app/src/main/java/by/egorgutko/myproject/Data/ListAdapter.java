package by.egorgutko.myproject.Data;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import by.egorgutko.myproject.R;

public class ListAdapter extends RecyclerView.Adapter {
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ((ListViewHolder) holder).BindView(position);

    }

    @Override
    public int getItemCount() {
        return OurData.title.length;
    }


    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        private TextView mItemText;
        private ImageView mImageView;

        public ListViewHolder(View itemView){
            super(itemView);
            mItemText = (TextView) itemView.findViewById(R.id.itemText);
            mImageView = (ImageView) itemView.findViewById(R.id.itemImage);
            itemView.setOnClickListener(this);
        }

        public void BindView(int position){
            mItemText.setText(OurData.title[position]);
            mImageView.setImageResource(OurData.picturePart[position]);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
