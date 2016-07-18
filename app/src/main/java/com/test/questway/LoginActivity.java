package com.test.questway;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    EditText etLogin;
    EditText etPass;

    LinearLayout llEnter;

    TextView tvEnter;
    TextView tvFb;
    TextView tvGoogle;

    boolean isEnteredEmail = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etLogin = (EditText) findViewById(R.id.etLogin);
        etPass = (EditText) findViewById(R.id.etPass);
        llEnter = (LinearLayout) findViewById(R.id.llEnter);
        tvEnter = (TextView) findViewById(R.id.tvEnter);
        tvFb = (TextView) findViewById(R.id.withFb);
        tvGoogle = (TextView) findViewById(R.id.withGoogle);

        etLogin.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus || isEnteredEmail) {
                    llEnter.setVisibility(View.VISIBLE);
                } else {
                    llEnter.setVisibility(View.GONE);
                }
            }
        });

        etLogin.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                    etPass.setVisibility(View.VISIBLE);
                    isEnteredEmail = true;
                    etPass.requestFocus();
                    tvEnter.setText("Login");
                }
                return false;
            }
        });

        etPass.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                    login();
                }
                return false;
            }
        });

        llEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isEnteredEmail) {
                    etPass.setVisibility(View.VISIBLE);
                    isEnteredEmail = true;
                    etPass.requestFocus();
                    tvEnter.setText("Login");
                } else {
                    login();
                }
            }
        });
    }

    private void login() {
        Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
        startActivity(intent);
    }
}
