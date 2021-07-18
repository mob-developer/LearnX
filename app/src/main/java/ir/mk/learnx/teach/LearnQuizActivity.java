package ir.mk.learnx.teach;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.IOException;

import ir.mk.learnx.R;
import ir.mk.learnx.model.Server;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LearnQuizActivity extends AppCompatActivity {


    private int thisStep;
    private int allStep;
    private int lesson;
    private int courseId;
    private int subCourseId;

    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    private Handler handler;
    private static final int GET_QUESTIONS = 1;
    OkHttpClient client = new OkHttpClient();
    private ImageView loadingImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_quiz);

        lesson = getIntent().getIntExtra("lesson", -1);
        courseId = getIntent().getIntExtra("courseId", -1);
        subCourseId = getIntent().getIntExtra("subCourseId", -1);
        thisStep = getIntent().getIntExtra("step", 1);
        allStep = getIntent().getIntExtra("allStep", 1);
        int nextStepType;
        if (thisStep < allStep) {
            nextStepType = getStepType(lesson, courseId, subCourseId, thisStep + 1);
        } else {
            nextStepType = -1;
        }

        ConstraintLayout constraintLayout = findViewById(R.id.activity_learn_quiz_layout);
        constraintLayout.setOnClickListener(v -> {
            Toast.makeText(this, "aaa", Toast.LENGTH_SHORT).show();
        });

        loadingImageView = findViewById(R.id.learn_quiz_loading);
        Glide.with(this).load(R.mipmap.loading_gif).into(loadingImageView);



        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == GET_QUESTIONS) {
                    if (msg.arg1 == 1) {
                        showQuestion();
                    } else {
                        Log.e("mylog", "error in handle msg");
                    }
                }
            }
        };


//        Button goNext = findViewById(R.id.learn_movie_go_next);
//        goNext.setOnClickListener(v -> {
//            switch (nextStepType){
//                case -1:
//                    Intent intent_1 = new Intent(this, EndSubCourse.class);
//                    intent_1.putExtra("lesson",lesson);
//                    intent_1.putExtra("courseId",courseId);
//                    intent_1.putExtra("subCourseId",subCourseId);
//                    intent_1.putExtra("allStep",allStep);
//                    startActivity(intent_1);
//                    break;
//                case 0:
//                    Intent intent0 = new Intent(this, LearnMovieActivity.class);
//                    intent0.putExtra("lesson",lesson);
//                    intent0.putExtra("courseId",courseId);
//                    intent0.putExtra("subCourseId",subCourseId);
//                    intent0.putExtra("step",thisStep+1);
//                    intent0.putExtra("allStep",allStep);
//                    startActivity(intent0);
//                    break;
//                case 1:
//                    Intent intent1 = new Intent(this, LearnQuizActivity.class);
//                    intent1.putExtra("lesson",lesson);
//                    intent1.putExtra("courseId",courseId);
//                    intent1.putExtra("subCourseId",subCourseId);
//                    intent1.putExtra("step",thisStep+1);
//                    intent1.putExtra("allStep",allStep);
//                    startActivity(intent1);
//                    break;
//                default:
//
//                    break;
//            }
//        });
//
//
//        Toast.makeText(this, "course id:" + courseId + " ,subcourse-step:" + subCourseId+"-"+thisStep, Toast.LENGTH_SHORT).show();


        Thread threadGetQuestion = new Thread(new Runnable() {
            @Override
            public void run() {
                Message message = new Message();
                message.what = GET_QUESTIONS;
                try {
                    LearnQuizActivity.this.run(Server.serverUrlQuiz + "?q=911121");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                message.arg1 = 1;
                handler.sendMessage(message);
            }
        });
        threadGetQuestion.start();
    }

    private int getStepType(int lesson, int course, int subCourse, int step) {
        return 1;
    }

    private void showQuestion() {
        Toast.makeText(this, "->"+question, Toast.LENGTH_LONG).show();
//        Toast.makeText(this, Server.serverUrlQuiz + "?q=911121", Toast.LENGTH_LONG).show();
    }



    private String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            String result =  response.body().string();
            System.out.println(result);
            question = result;
            return result;
        }
    }


}