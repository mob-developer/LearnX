package ir.mk.learnx.quiz;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ir.mk.learnx.R;
import ir.mk.learnx.adapters.QuizListAdapter;
import ir.mk.learnx.model.CourseList;


public class QuizListActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_list);


        ArrayList<CourseList> coursesList = new ArrayList<>();

        coursesList.add(new CourseList(1, "علوم", "lesson", -1));
        coursesList.add(new CourseList(2, "ریاضی", "lesson", -1));
        coursesList.add(new CourseList(3, "ادبیات", "lesson", -1));
        coursesList.add(new CourseList(4, "عربی", "lesson", -1));
        coursesList.add(new CourseList(5, "دینی", "lesson", -1));
        coursesList.add(new CourseList(6, "زبان", "lesson", -1));
        coursesList.add(new CourseList(7, "اجتماعی", "lesson", -1));


        QuizListAdapter quizListAdapter = new QuizListAdapter(coursesList);
        RecyclerView recyclerView = findViewById(R.id.lesson_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(quizListAdapter);


    }
}