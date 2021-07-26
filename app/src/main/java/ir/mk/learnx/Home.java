package ir.mk.learnx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.Toast;

import ir.mk.learnx.model.Server;
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

        SharedPreferences sharedPreferences = getSharedPreferences(Server.MY_PREFS_NAME,MODE_PRIVATE);
        int iq = sharedPreferences.getInt("iq",0);
        if (iq == 0){
            SharedPreferences.Editor editor = getSharedPreferences(Server.MY_PREFS_NAME,MODE_PRIVATE).edit();
            editor.putInt("iq",100);
            editor.apply();
            iq = 100;
        }
        //TODO show iq

    }


    boolean doubleBackToExitPressedOnce = false;

}