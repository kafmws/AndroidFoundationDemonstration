package com.example.hp.activitylifetest;

import android.app.Dialog;
import android.content.Intent;
import android.nfc.Tag;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String log = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        Log.d(log,"on Create");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(log,"on Start");
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
