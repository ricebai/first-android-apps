package com.example.zhangk.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button login_ok = findViewById(R.id.login_ok);
        login_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText login_name = findViewById(R.id.login_name);
                EditText login_pwd = findViewById(R.id.login_pwd);


                AlertDialog dialog = new AlertDialog.Builder(LoginActivity.this).setTitle("提示")
                        .setMessage("点击确认！"+login_name.getText()+"/"+login_pwd.getText())
                        .setPositiveButton("退出", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
//                                finish();
                                dialog.dismiss();
                            }
                        })
                .show();
            }
        });
    }
}
