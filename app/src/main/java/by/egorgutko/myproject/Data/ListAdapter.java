package by.egorgutko.myproject.Data;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import by.egorgutko.myproject.R;

import static android.media.CamcorderProfile.get;

public class ListAdapter extends RecyclerView.Adapter{

    // новый ViewHolder, который может переиспользоваться в дальнейшем
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate( R.layout.list_item, parent, false);
        return new ListViewHolder(view);
    }

    public interface OnItemClickListener {
        void onClick( int position);
    }

    protected OnItemClickListener mOnItemClickListener;

    public void setmOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }


    //заполняем данными
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder) holder).binView(position);
        ((ListViewHolder) holder).setListeners(position,mOnItemClickListener);
    }

        // возвращает общее количество элементов списка
    @Override
    public int getItemCount() {
        return OurData.title.length;
    }

    public Pair getItem(int position) {
        return new Pair<String,Integer>(OurData.title[position], OurData.picturePart[position]);
    }

    //реализация класса, хранящего ссылки на виджеты
    static class ListViewHolder extends RecyclerView.ViewHolder {
        private static final String TAG = "myLogs";

        private TextView mTextViev;
        private ImageView mItemView;


        public ListViewHolder(View itemView) {

            super(itemView);
            mTextViev = (TextView) itemView.findViewById(R.id.itemText);
            mItemView = (ImageView) itemView.findViewById(R.id.itemImage);


        }

        // присваиваем обработчик
        public void setListeners(final int position, final OnItemClickListener onItemClickListener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onClick( position);
                    }
                }
            });
        }


        // для заполнения, устанавливает необходимые данные для соответствующей строки во view-компоненте
        public void binView(int position) {
            mTextViev.setText(OurData.title[position]);
            mItemView.setImageResource(OurData.picturePart[position]);
        }



    }

}