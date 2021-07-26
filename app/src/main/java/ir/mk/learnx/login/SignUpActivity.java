package ir.mk.learnx.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ir.mk.learnx.R;
import ir.mk.learnx.model.Account;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Button button = findViewById(R.id.sign_up_button);
        EditText usernameField = findViewById(R.id.sign_up_username);
        EditText emailField = findViewById(R.id.sign_up_email_field);
        EditText passwordField = findViewById(R.id.sign_up_password_field);
        EditText firstNameField = findViewById(R.id.sign_up_first_name);
        EditText lastNameField = findViewById(R.id.sign_up_last_name);

        button.setOnClickListener(v -> {
            if (!usernameField.getText().toString().isEmpty() && !emailField.getText().toString().isEmpty() &&
                    !passwordField.getText().toString().isEmpty() && !firstNameField.getText().toString().isEmpty() &&
                    !lastNameField.getText().toString().isEmpty()) {
                new Account(firstNameField.getText().toString(), lastNameField.getText().toString(),
                        0, 0, usernameField.getText().toString(),
                        passwordField.getText().toString(), emailField.getText().toString(), 0);
                Toast.makeText(this, "حساب کاربری با موفقیت ساخته شد", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "خطایی رخ داده است دوباره تلاش کنید", Toast.LENGTH_LONG).show();
            }

        });


    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(SignUpActivity.this, LandingPageActivity.class);
        startActivity(i);
    }
}