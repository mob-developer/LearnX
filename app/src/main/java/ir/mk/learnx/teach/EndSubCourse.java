package ir.mk.learnx.teach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import ir.mk.learnx.R;
import ir.mk.learnx.quiz.QuestionActivity;

public class EndSubCourse extends AppCompatActivity {
    private int thisStep;
    private int allStep;
    private int lesson;
    private int courseId;
    private int subCourseId;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_sub_course);
        lesson = getIntent().getIntExtra("lesson", -1);
        courseId = getIntent().getIntExtra("courseId", -1);
        subCourseId = getIntent().getIntExtra("subCourseId", -1);
        thisStep = getIntent().getIntExtra("step", 1);
        allStep = getIntent().getIntExtra("allStep", 1);
        Button button = findViewById(R.id.button5);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(EndSubCourse.this, SubCourseListActivity.class);
            intent.putExtra("lesson",lesson);
            intent.putExtra("courseId",courseId);
            startActivity(intent);
        });
    }
}