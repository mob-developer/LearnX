package ir.mk.learnx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import ir.mk.learnx.adapters.HomeCourseListAdapter;
import ir.mk.learnx.adapters.QuizListAdapter;
import ir.mk.learnx.model.CourseList;
import ir.mk.learnx.quiz.QuizListActivity;
import ir.mk.learnx.teach.CourseListActivity;

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
        quizButton.setOnClickListener(v->{
            Intent i = new Intent(Home.this, QuizListActivity.class);
            startActivity(i);
        });
    }


    boolean doubleBackToExitPressedOnce = false;

}