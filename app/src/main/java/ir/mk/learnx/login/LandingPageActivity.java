package ir.mk.learnx.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import ir.mk.learnx.Home;
import ir.mk.learnx.R;

public class LandingPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        Button login = findViewById(R.id.login_loading2);
        login.setOnClickListener(v -> {
            Intent i = new Intent(LandingPageActivity.this, LoginActivity.class);
            startActivity(i);
            finish();
        });

        Button signUp = findViewById(R.id.landing_sign_up);
        signUp.setOnClickListener(v -> {
            Intent i = new Intent(LandingPageActivity.this, SignUpActivity.class);
            startActivity(i);
        });

        Button guest = findViewById(R.id.login_loading2_guest);
        guest.setOnClickListener(v -> {
            Intent i = new Intent(LandingPageActivity.this, Home.class);
            startActivity(i);
        });
    }
}