package ir.mk.learnx.teach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import ir.mk.learnx.R;

public class LearnQuizActivity extends AppCompatActivity {


    private int thisStep;
    private int allStep;
    private int courseId;
    private int subCourseId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_quiz);

        courseId = getIntent().getIntExtra("courseId", -1);
        subCourseId = getIntent().getIntExtra("subCourseId", -1);
        thisStep = getIntent().getIntExtra("step", 1);
        allStep = getIntent().getIntExtra("allStep", 1);
        int nextStepType = getStepType(courseId, subCourseId,thisStep+1);

        Button goNext = findViewById(R.id.learn_movie_go_next);
        goNext.setOnClickListener(v -> {
            switch (nextStepType){
                case 0:
                    Intent intent0 = new Intent(this, LearnMovieActivity.class);
                    intent0.putExtra("courseId",courseId);
                    intent0.putExtra("subCourseId",subCourseId);
                    intent0.putExtra("step",thisStep+1);
                    intent0.putExtra("allStep",allStep);
                    startActivity(intent0);
                    break;
                case 1:
                    Intent intent1 = new Intent(this, LearnQuizActivity.class);
                    intent1.putExtra("courseId",courseId);
                    intent1.putExtra("subCourseId",subCourseId);
                    intent1.putExtra("step",thisStep+1);
                    intent1.putExtra("allStep",allStep);
                    startActivity(intent1);
                    break;
                default:

                    break;
            }
        });



    }
    private int getStepType(int course,int subCourse,int step){
        return 0;
    }


}