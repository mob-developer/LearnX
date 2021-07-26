package ir.mk.learnx.teach;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

import ir.mk.learnx.R;
import ir.mk.learnx.model.SubCourseList;
import ir.mk.learnx.adapters.SubCourseListAdapter;

public class SubCourseListActivity extends AppCompatActivity {

    private int courseId;
    private int lesson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_course_list);

        ArrayList<SubCourseList> subCoursesList = new ArrayList<>();

        courseId = getIntent().getIntExtra("courseId",-1);
        lesson = getIntent().getIntExtra("lesson",-1);


        switch (lesson){
            case 1:  // oloom
                if (courseId == -1){
                    Intent intent = new Intent(SubCourseListActivity.this,CourseListActivity.class);
                    startActivity(intent);
                } else if(courseId==1){
                    subCoursesList.add(new SubCourseList(1 ,1,1,"خالص و مخلوط","50%",-1));
                    subCoursesList.add(new SubCourseList(2 ,1,1,"همگن و ناهمگن","20%",0));
                    subCoursesList.add(new SubCourseList(3 ,1,1,"اجزای محلول","%80",R.drawable.ic_baseline_circle_24));
                    subCoursesList.add(new SubCourseList(4 ,1,1,"حالت فیزیکی محلول ها","100%",-1));
                    subCoursesList.add(new SubCourseList(5 ,1,1,"حل شدن در آب","0%",0));
                    subCoursesList.add(new SubCourseList(6 ,1,1,"مخلوط ها در زندگی","0%",-1));
                    subCoursesList.add(new SubCourseList(7 ,1,1,"جداسازی اجزای مخلوط","0%",0));
                    subCoursesList.add(new SubCourseList(8 ,1,1,"بخش بعدی","0%",-1));
                    subCoursesList.add(new SubCourseList(9 ,1,1,"بخش بعدی تر","0%",0));
                    subCoursesList.add(new SubCourseList(10,1,1,"بخشی با ویژگی بعدی","0%",-1));
                    subCoursesList.add(new SubCourseList(11,1,1,"بعد بخش قبلی","0%",0));
                    subCoursesList.add(new SubCourseList(12,1,1,"بعد از بعدی بخش قبلی","0%",-1));
                    subCoursesList.add(new SubCourseList(13,1,1,"دیگه اسمی به ذهنم نمیرسه!","0%",0));
                }else if(courseId == 2){
                    subCoursesList.add(new SubCourseList(1 ,1,2,"خالص و مخلوط","50%",-1));
                    subCoursesList.add(new SubCourseList(2 ,1,2,"همگن و ناهمگن","20%",0));
                }else if(courseId == 3){
                    subCoursesList.add(new SubCourseList(1 ,1,3,"خالص و مخلوط","50%",-1));
                    subCoursesList.add(new SubCourseList(2 ,1,3,"همگن و ناهمگن","20%",0));
                    subCoursesList.add(new SubCourseList(3 ,1,3,"بخش بعدی تر","0%",0));
                    subCoursesList.add(new SubCourseList(4 ,1,3,"بخشی با ویژگی بعدی","0%",-1));
                    subCoursesList.add(new SubCourseList(5 ,1,3,"اجزای محلول","%80",R.drawable.ic_baseline_circle_24));
                }else if(courseId == 4){
                    subCoursesList.add(new SubCourseList(1 ,1,4,"خالص و مخلوط","50%",-1));
                    subCoursesList.add(new SubCourseList(2 ,1,4,"دیگه اسمی به ذهنم نمیرسه!","0%",0));
                    subCoursesList.add(new SubCourseList(3 ,1,4,"دیگه اسمی به ذهنم نمیرسه!","0%",0));
                    subCoursesList.add(new SubCourseList(4 ,1,4,"دیگه اسمی به ذهنم نمیرسه!","0%",0));
                    subCoursesList.add(new SubCourseList(5 ,1,4,"همگن و ناهمگن","20%",0));
                    subCoursesList.add(new SubCourseList(6 ,1,4,"اجزای محلول","%80",R.drawable.ic_baseline_circle_24));
                }
                break;
            case 2:

                break;
        }





        SubCourseListAdapter subCourseListAdapter = new SubCourseListAdapter(subCoursesList);
        RecyclerView recyclerView = findViewById(R.id.sub_course_list_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(subCourseListAdapter);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,CourseListActivity.class);
        intent.putExtra("lesson",lesson);
        startActivity(intent);
        finish();
    }
}