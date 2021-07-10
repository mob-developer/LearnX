package ir.mk.learnx.loading;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import ir.mk.learnx.Home;
import ir.mk.learnx.R;

public class Loading2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading2);

        Button login = findViewById(R.id.login_loading2);
        login.setOnClickListener(v -> {
            Intent i = new Intent(Loading2.this, Home.class);
            startActivity(i);
            finish();
        });
    }
}