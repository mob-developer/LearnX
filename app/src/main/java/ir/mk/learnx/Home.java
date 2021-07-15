package ir.mk.learnx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import ir.mk.learnx.loading.Loading2;
import ir.mk.learnx.teach.CourseListActivity;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button testButton = findViewById(R.id.button_test);
        testButton.setOnClickListener(v -> {
            Intent i = new Intent(Home.this, CourseListActivity.class);
            i.putExtra("lesson",1); // 1 for oloom
            startActivity(i);
        });
    }
}