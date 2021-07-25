package ir.mk.learnx.teach;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.IOException;

import ir.mk.learnx.R;
import ir.mk.learnx.model.Server;
import ir.mk.learnx.quiz.QuestionActivity;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LoadingLearn extends AppCompatActivity {

    private Handler handler;
    private static final int GET_STEPS = 1;
    private String steps;
    OkHttpClient client = new OkHttpClient();
    private static int lesson;
    private static int courseId;
    private static int subCourseId;


    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_learn);

        lesson = getIntent().getIntExtra("lesson", -1);
        courseId = getIntent().getIntExtra("courseId", -1);
        subCourseId = getIntent().getIntExtra("subCourseId", -1);

        getAllSteps(lesson, courseId, subCourseId);


        handler = new Handler() {
            @SuppressLint("HandlerLeak")
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == GET_STEPS) {
                    if (msg.arg1 == 1) {
                        goToFirstStep(steps);
                    } else {
                        Log.e("mylog", "error in handle msg");
                    }
                }
            }
        };


    }

    private void goToFirstStep(String steps) {
        int firstStepType = getFirstStepType(steps);
        switch (firstStepType) {
            case 0:
                Intent intent0 = new Intent(this, LearnMovieActivity.class);
                intent0.putExtra("lesson", lesson);
                intent0.putExtra("courseId", courseId);
                intent0.putExtra("subCourseId",subCourseId);
                intent0.putExtra("step", 1);
                intent0.putExtra("allStep", steps);
                startActivity(intent0);
                break;
            case 1:
                Intent intent1 = new Intent(this, QuestionActivity.class);
                intent1.putExtra("lesson", lesson);
                intent1.putExtra("courseId",courseId);
                intent1.putExtra("subCourseId", subCourseId);
                intent1.putExtra("step", 1);
                intent1.putExtra("allStep", steps);
                startActivity(intent1);
                break;
            default:

                break;
        }
    }

    private int getFirstStepType(String steps) {
        return Integer.parseInt(steps.substring(0, 1));
    }

    private void getAllSteps(int lesson, int courseId, int subCourseId) {
        Thread threadGetSteps = new Thread(new Runnable() {
            @Override
            public void run() {
                Message message = new Message();
                message.what = GET_STEPS;
                try {
                    steps = LoadingLearn.this.run(Server.serverUrlSteps + lesson + "" + courseId + "" + subCourseId);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                message.arg1 = 1;
                handler.sendMessage(message);
            }
        });
        threadGetSteps.start();
    }

    private String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}