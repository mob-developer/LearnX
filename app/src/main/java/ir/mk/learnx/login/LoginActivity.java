package ir.mk.learnx.login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ir.mk.learnx.Home;
import ir.mk.learnx.R;
import ir.mk.learnx.model.Account;

public class LoginActivity extends AppCompatActivity {
    private String username;
    private String password;

    @SuppressLint("ShowToast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button enter = findViewById(R.id.login_button);
        EditText usernameField = findViewById(R.id.sign_up_email_field);
        EditText passwordField = findViewById(R.id.sign_up_password_field);
enter.setEnabled(true);

        enter.setOnClickListener(v -> {
            username = usernameField.getText().toString();
            password = passwordField.getText().toString();
            System.out.println(username +"***"+ password);
            String result = Account.loginUser(username, password);
            switch (result){
                case "successful":
                    Toast.makeText(this, "با موفقیت وارد شدید!", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(LoginActivity.this, Home.class);
                    startActivity(i);
                    break;
                case "invalid username":
                    Toast.makeText(this, "نام کاربری وجود ندارد", Toast.LENGTH_LONG).show();

                    break;
                case "invalid password":
                    Toast.makeText(this, "رمز‌عبور اشتباه است", Toast.LENGTH_LONG).show();
                    break;
                default:
                    Toast.makeText(this, "خطایی رخ داده‌است", Toast.LENGTH_LONG).show();

            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent i = new Intent(LoginActivity.this, LandingPageActivity.class);
        startActivity(i);
    }
}