package com.example.hp.sharedpreferencespractice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private BroadcastReceiver receiver;

    @Override
    protected void onPause() {
        super.onPause();
        if (receiver != null)
            unregisterReceiver(receiver);
        receiver = null;
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.hp.sharedpreferencespratice.LOGIN_SUCCESS");
        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Toast.makeText(LoginActivity.this,"上线通知",Toast.LENGTH_SHORT).show();
            }
        };
        registerReceiver(receiver,intentFilter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module_activity_login);
        final CheckBox cb = findViewById(R.id.cb_rememberpw);
        sp = getPreferences(MODE_PRIVATE);
        editor = sp.edit();
        final EditText et_name = findViewById(R.id.et_name);
        final EditText et_password = findViewById(R.id.et_password);
        boolean isRemember;
        if(isRemember = sp.getBoolean("isRemember",false)){
            et_name.setText(sp.getString("account",""));
            et_password.setText(sp.getString("password",""));
            cb.setChecked(true);
        }
        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account =et_name.getText().toString();
                String password = et_password.getText().toString();
                if(account.equals("admin")&&password.equals("admin")){
                    if(cb.isChecked()){
                        editor.putBoolean("isRemember", true);
                        editor.putString("account",account);
                        editor.putString("password",password);
                    }else{
                        editor.clear();
                    }
                    Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    sendBroadcast(new Intent("com.example.hp.sharedpreferencespratice.LOGIN_SUCCESS"));
                    startActivity(intent);
                } else{
                    editor.clear();
                    Toast.makeText(LoginActivity.this,"用户名或密码错误",Toast.LENGTH_SHORT).show();
                }
                editor.apply();
            }
        });
    }


}