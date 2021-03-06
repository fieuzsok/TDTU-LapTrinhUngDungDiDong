package com.tdt.lab03.exercise01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.tdt.lab03.R;

/**
 * Created by thChung on 3/2/2019.
 */

public class MainActivity extends AppCompatActivity {
    public static final String USER_NAME_INTENT = "USER_NAME";
    public static final String USER_EMAIL_INTENT = "USER_EMAIL";
    public static final int SUCCESS_CODE = 200;

    private EditText edtUsername;
    private Button btnLogin;
    private TextView txtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        handleEvents();
    }

    private void handleEvents() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });
    }

    private void openNewActivity() {
        Intent intent = new Intent(this, WelcomeActivity.class);
        String userName = edtUsername.getText().toString();
        intent.putExtra(USER_NAME_INTENT, userName);
        startActivityForResult(intent, SUCCESS_CODE);
    }

    private void initView() {
        edtUsername = findViewById(R.id.edtUsername);
        btnLogin = findViewById(R.id.btnLogin);
        txtMessage = findViewById(R.id.txtMessage);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == SUCCESS_CODE){
            String studentName = data.getStringExtra(USER_EMAIL_INTENT);
            edtUsername.setText(studentName);
            txtMessage.setText("Hẹn gặp lại!");
            btnLogin.setVisibility(View.GONE);
        }
    }
}
