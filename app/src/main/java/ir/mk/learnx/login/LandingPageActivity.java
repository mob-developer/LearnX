package ir.mk.learnx.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.Toast;

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


    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            Intent a = new Intent(Intent.ACTION_MAIN);
            a.addCategory(Intent.CATEGORY_HOME);
            a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(a);
            finish();
        }else{

        Toast.makeText(this, "لطفا کلید بازگشت را مجددا فشار دهید", Toast.LENGTH_SHORT).show();
        }

        this.doubleBackToExitPressedOnce = true;

        new Handler(Looper.getMainLooper()).postDelayed(() -> doubleBackToExitPressedOnce=false, 3000);
    }

}