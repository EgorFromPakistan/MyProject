package by.egorgutko.myproject;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import by.egorgutko.myproject.databinding.ActivityAutBinding;

public class AutActivity extends AppCompatActivity implements View.OnClickListener {


    private static final String TAG = "myLogs";
    private FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthStateListener;

    private EditText ETemail;
    private EditText ETpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_aut);
        ActivityAutBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_aut);

        mAuth = FirebaseAuth.getInstance();

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Intent intent = new Intent(AutActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Log.d(TAG, "signed_out");
                }
            }
        };
        ETemail = binding.etEmail; //(EditText) findViewById(R.id.et_email);
        ETpassword = binding.etPassword; //(EditText) findViewById(R.id.et_password);

        findViewById(R.id.btn_sign_in).setOnClickListener(this);
        findViewById(R.id.btn_registration).setOnClickListener(this);

        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            Intent intent = new Intent(AutActivity.this, DataBaseActivity.class);
            startActivity(intent);
        }
        // FirebaseUser user = mAuth.getCurrentUser();
        //  if(user != null){
        //    Intent intent = new Intent(this, MainActivity.class);
        //  startActivity(intent);
        //  }
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_sign_in) {
            signin(ETemail.getText().toString(), ETpassword.getText().toString());
        } else if (view.getId() == R.id.btn_registration) {
            registration(ETemail.getText().toString(), ETpassword.getText().toString());
        }

    }

    public void onMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void signin(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(AutActivity.this, "Aвторизация успешна", Toast.LENGTH_SHORT).show();
                    onMain();
                } else
                    Toast.makeText(AutActivity.this, "Aвторизация провалена", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void registration(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(AutActivity.this, "Регистрация успешна", Toast.LENGTH_SHORT).show();
                    //onMain();
                } else
                    Toast.makeText(AutActivity.this, "Регистрация провалена", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
