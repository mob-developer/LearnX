package ir.mk.learnx.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import ir.mk.learnx.Home;
import ir.mk.learnx.R;
import ir.mk.learnx.teach.SubCourseListActivity;

public class EndQuiz extends AppCompatActivity {
    private int thisStep;
    private int allStep;
    private int lesson;
    private int courseId;
    private int subCourseId;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_quiz);

        Button button = findViewById(R.id.button5);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(EndQuiz.this, Home.class);
            startActivity(intent);
            finish();
        });
    }
}