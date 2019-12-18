package com.example.assignmentmobilecomp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.widget.Toolbar;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button buttonPI = (Button)findViewById(R.id.bPI);
        Button buttonMA = (Button)findViewById(R.id.bMovie);
        Button buttonFAQ = (Button)findViewById(R.id.bFAQ);
        Button buttonCinema = (Button) findViewById(R.id.bCinemas);
        Toolbar toolbar = (Toolbar)findViewById(R.id.TB);
        setSupportActionBar(toolbar);


        buttonPI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (HomeActivity.this,AccountInformation.class);
                startActivity(intent);
            }
        });

        buttonMA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,MovieActivity.class);
                startActivity(intent);
            }
        });

        buttonFAQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,FAQActivity.class);
                startActivity(intent);
            }
        });

        /*buttonShowtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,showtimeActivity.class);
                startActivity(intent);
            }
        });*/

        buttonCinema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,CinemasLocation.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.logOut:
                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent ( HomeActivity.this,MainActivity.class);
                startActivity(intToMain);
                finish();
                return true;
            default:
                onResume();
                return super.onOptionsItemSelected(item);
        }
    }

}
