package ir.mk.learnx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import ir.mk.learnx.adapters.HomeCourseListAdapter;
import ir.mk.learnx.model.Account;
import ir.mk.learnx.model.CourseList;
import ir.mk.learnx.model.Server;
import ir.mk.learnx.quiz.QuizListActivity;


public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ArrayList<CourseList> coursesList = new ArrayList<>();

        coursesList.add(new CourseList(1, "علوم", "lesson", -1));
        coursesList.add(new CourseList(2, "ریاضی", "lesson", -1));
        coursesList.add(new CourseList(3, "ادبیات", "lesson", -1));
        coursesList.add(new CourseList(4, "عربی", "lesson", -1));
        coursesList.add(new CourseList(5, "دینی", "lesson", -1));
        coursesList.add(new CourseList(6, "زبان", "lesson", -1));
        coursesList.add(new CourseList(7, "اجتماعی", "lesson", -1));


        HomeCourseListAdapter homeCourseListAdapter = new HomeCourseListAdapter(coursesList);
        RecyclerView recyclerView = findViewById(R.id.lesson_list_home);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(homeCourseListAdapter);


        Button quizButton = findViewById(R.id.button_quiz);
        quizButton.setOnClickListener(v -> {
            Intent i = new Intent(Home.this, QuizListActivity.class);
            startActivity(i);
        });

        SharedPreferences sharedPreferences = getSharedPreferences(Server.MY_PREFS_NAME, MODE_PRIVATE);
        int iq = sharedPreferences.getInt("iq", 0);
        if (iq == 0) {
            SharedPreferences.Editor editor = getSharedPreferences(Server.MY_PREFS_NAME, MODE_PRIVATE).edit();
            editor.putInt("iq", 100);
            editor.apply();
            iq = 100;
        }
        Account.getLoggedInAccount().setScore(iq);
        TextView textView = findViewById(R.id.score);
        textView.setText(iq);
    }


    boolean doubleBackToExitPressedOnce = false;

}