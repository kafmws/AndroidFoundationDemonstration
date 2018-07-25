package com.example.hp.activitylifetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String log = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(log,"on Create");
        setContentView(R.layout.main_layout);

        Button button1 = findViewById(R.id.Button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,NormalActivity.class);
                startActivity(intent);
            }
        });

        Button button2 = findViewById(R.id.Button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(log,"on Start");
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(log,"on Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(log,"on Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(log,"on Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(log,"on Destroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(log,"on Restart");
    }
}
