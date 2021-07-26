package ir.mk.learnx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.Toast;

import ir.mk.learnx.quiz.QuizListActivity;
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

        Button quizButton = findViewById(R.id.button_quiz);
        quizButton.setOnClickListener(v->{
            Intent i = new Intent(Home.this, QuizListActivity.class);
            startActivity(i);
        });
    }



}