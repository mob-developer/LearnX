package ir.mk.learnx.teach;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import ir.mk.learnx.R;
import ir.mk.learnx.model.CourseListAdapter;
import ir.mk.learnx.model.CourseList;

public class CourseListActivity extends AppCompatActivity {

    int lesson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);

        lesson = getIntent().getIntExtra("lesson",-1);


        ArrayList<CourseList> coursesList = new ArrayList<>();

        switch (lesson){
            case 1:
                coursesList.add(new CourseList(1,"مخلوط و جداسازی مواد","50%",-1));
                coursesList.add(new CourseList(2,"تغییرهای شیمیایی در خدمت زندگی","20%",0));
                coursesList.add(new CourseList(3,"از درون اتم چه خبر","%80",-1));
                coursesList.add(new CourseList(4,"تنظیم عصبی","100%",0));
                break;
            case 2:

                break;

        }



        CourseListAdapter courseListAdapter = new CourseListAdapter(coursesList);
        RecyclerView recyclerView = findViewById(R.id.course_list_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(courseListAdapter);

    }
}