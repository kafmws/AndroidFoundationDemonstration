package com.example.hp.intentdemo;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module_activity_main);
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                    Intent intent = new Intent(MainActivity.this,SonActivity.class);
                    intent.putExtra("test_String","dataFromMainActivity");
                    startActivityForResult(intent,3001);}
            });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode){
            case 3001:
                if(resultCode == RESULT_OK){
                    Log.d("FirstActivity",data.getStringExtra("test_String"));
                }break;
                default:
        }
    }
}
