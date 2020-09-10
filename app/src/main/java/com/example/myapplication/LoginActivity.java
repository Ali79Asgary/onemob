package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
//    EditText fullName;
    EditText emailEditText;
    EditText passwordEditText;
    Button login;
    TextView lnkRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        setupUI();
        setupListeners();
    }

    private void setupListeners() {
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                boolean isValid = checkValid();

                if (isValid) {
                    String emailValue = emailEditText.getText().toString();
                    String passwordValue = passwordEditText.getText().toString();
                    login(emailValue, passwordValue);
                }
            }
        });

        lnkRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }


    private boolean login(String email, String password) {
        // todo: login to server
        try {
            boolean successLogin = true;
            if (successLogin) {
                goToSecondActivity(email, password);
            }
        } catch (Exception ex) {
            Log.d("", ex.getMessage());
        }
        return true;
    }

    private void goToSecondActivity(String email, String password) {
        String baseUrl = "www.google.com";
        Bundle bundle = new Bundle();
        bundle.putString("email", email);
        bundle.putString("password", password);

//        Intent intent = new Intent(this, MainPageActivity.class);
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private boolean checkValid() {
        boolean validEmail = checkEmail();
        boolean validPass= checkPassword();
        boolean valid = false;

        Log.d("", "yyyyyyyyyyyyyyyyyyyyyyy" + validEmail + validPass);
        if (validEmail && validPass) {
            valid = true;
        }
        return valid;
    }

    private boolean checkPassword() {
        boolean isValid = true;

        if (passwordEditText.getText().toString().matches("")) {
            passwordEditText.setError("لطفا رمز عبور خود را وارد کنید");
            isValid = false;
        }
//        else {
//            if (!isValidPassword((CharSequence) passwordEditText)) {
//                passwordEditText.setError("لطفا  رمز عبور معتبر وارد کنید!");
//                isValid = false;
//            }
//        }
        return isValid;
    }

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    private boolean checkEmail() {
        boolean isValid = true;
        if (emailEditText.getText().toString().matches("")) {
            emailEditText.setError("لطفا ایمیل خود را وارد کنید");
//            Toast.makeText(this, "You did not enter a username", Toast.LENGTH_SHORT).show();
            isValid = false;
        } else {
            if (!isValidEmail(emailEditText.getText().toString())) {
                emailEditText.setError("لطفا ایمیل معتبر وارد کنید!");
                isValid = false;
            }
        }
//        Log.d("", "hellloooooooooooooooooo");
        return isValid;
    }

    private void setupUI() {
        emailEditText = findViewById(R.id.txtEmail);
        passwordEditText = findViewById(R.id.txtPassword);
        login = findViewById(R.id.btnLogin);
        lnkRegister = (TextView) findViewById(R.id.lblSignUpPage);
        lnkRegister.setMovementMethod(LinkMovementMethod.getInstance());

    }

}
