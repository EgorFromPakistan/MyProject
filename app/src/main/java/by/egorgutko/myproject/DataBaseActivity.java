package by.egorgutko.myproject;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import by.egorgutko.myproject.databinding.ActivityDataBaseBinding;

public class DataBaseActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DatabaseReference myRef;

    FirebaseUser user = mAuth.getInstance().getCurrentUser();

    private EditText ET_new_task;
    private Button Btn_new_task;

    private static class TaskViewHolder extends RecyclerView.ViewHolder {

        TextView mTitleTask;
        Button mDel;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);

            mTitleTask = (TextView) itemView.findViewById(R.id.tv_title_task);
            mDel = (Button) itemView.findViewById(R.id.btn_del);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_data_base);

        ActivityDataBaseBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_data_base);


        myRef = FirebaseDatabase.getInstance().getReference();

        Btn_new_task = binding.btnAdd; //(Button) findViewById(R.id.btn_add);
        ET_new_task = binding.etNewTasks; //(EditText) findViewById(R.id.et_new_tasks);

        Btn_new_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRef.child(user.getUid()).child("Tasks").push().setValue(ET_new_task.getText().toString());
            }
        });


        RecyclerView recyclerView = binding.rvListTasks; //(RecyclerView) findViewById(R.id.rv_list_tasks);

        FirebaseRecyclerAdapter<String, TaskViewHolder> adapter;

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        adapter = new FirebaseRecyclerAdapter<String, TaskViewHolder>(
                String.class,
                R.layout.task_layout,
                TaskViewHolder.class,
                myRef.child(user.getUid()).child("Tasks")
        ) {
            @Override
            protected void populateViewHolder(TaskViewHolder viewHolder, String title, final int position) {

                viewHolder.mTitleTask.setText(title);
                viewHolder.mDel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DatabaseReference itemRef = getRef(position);
                        itemRef.removeValue();
                    }
                });

                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(DataBaseActivity.this, DetailTaskActivity.class);
                        intent.putExtra("Reference", getRef(position).getKey().toString());
                        startActivity(intent);
                    }
                });

            }
        };
        recyclerView.setAdapter(adapter);
    }


}
