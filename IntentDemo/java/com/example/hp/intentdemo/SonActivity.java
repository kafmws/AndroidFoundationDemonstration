package com.example.hp.intentdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SonActivity extends AppCompatActivity {
    private static final String tag = "SonActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module_activity_son);
        Intent intent = getIntent();
        Log.d(tag,intent.getStringExtra("test_String"));
        Button button = findViewById(R.id.button);
        button.setOnClickListener((View view)->{
            Intent intent1 = new Intent();
            intent1.putExtra("test_String","dataFromSonActivity");
            setResult(RESULT_OK,intent1);
            finish();
        });
    }
}
