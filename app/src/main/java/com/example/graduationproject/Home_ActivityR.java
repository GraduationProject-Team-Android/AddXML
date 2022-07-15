package com.example.graduationproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.graduationproject.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class Home_ActivityR extends AppCompatActivity {
    Button btn_test1;
    Button btn_test2;
    Button btn_test3;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
  // easy , difficult
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels_degree);
        btn_test1 = findViewById(R.id.button2);
        btn_test2 = findViewById(R.id.button3);
        btn_test3 = findViewById(R.id.button4);
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail().build();
        gsc = GoogleSignIn.getClient(this,gso);
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if(account!= null){
         String name = account.getDisplayName();
         String mail = account.getEmail();
         btn_test1.setText(name);
         btn_test2.setText(mail);
         btn_test3.setText("logout");

         btn_test3.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 SignOut();
             }
         });

        }
    }

    private void SignOut() {

    }
}