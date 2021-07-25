package ir.mk.learnx.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.util.ArrayList;

import ir.mk.learnx.R;
import ir.mk.learnx.model.Server;
import ir.mk.learnx.teach.EndSubCourse;
import ir.mk.learnx.teach.LearnMovieActivity;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class QuestionActivity extends AppCompatActivity {


    private int thisStep;
    private String allStep;
    private int lesson;
    private int courseId;
    private int subCourseId;

    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private final Integer correctOption = 1;
    private boolean ended = false;
    private boolean ended2 = false;

    private Handler handler;
    private static final int GET_QUESTIONS = 1;
    OkHttpClient client = new OkHttpClient();
    private ImageView loadingImageView;
    private TextView loadingTextView;


    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        lesson = getIntent().getIntExtra("lesson", -1);
        courseId = getIntent().getIntExtra("courseId", -1);
        subCourseId = getIntent().getIntExtra("subCourseId", -1);
        thisStep = getIntent().getIntExtra("step", 1);
        allStep = getIntent().getStringExtra("allStep");
        int nextStepType;
        if (thisStep < allStep.length()) {
            nextStepType = getStepType(allStep, thisStep);
        } else {
            nextStepType = -1;
        }


        loadingImageView = findViewById(R.id.learn_quiz_loading);
        Glide.with(this).load(R.mipmap.loading_gif).into(loadingImageView);






        handler = new Handler() {
            @SuppressLint("HandlerLeak")
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


        Button goNext = findViewById(R.id.learn_quiz_go_next);
        goNext.setOnClickListener(v -> {
            switch (nextStepType) {
                case -1:
                    Intent intent_1 = new Intent(this, EndSubCourse.class);
                    intent_1.putExtra("lesson", lesson);
                    intent_1.putExtra("courseId", courseId);
                    intent_1.putExtra("subCourseId", subCourseId);
                    intent_1.putExtra("allStep", allStep);
                    startActivity(intent_1);
                    break;
                case 0:
                    Intent intent0 = new Intent(this, LearnMovieActivity.class);
                    intent0.putExtra("lesson", lesson);
                    intent0.putExtra("courseId", courseId);
                    intent0.putExtra("subCourseId", subCourseId);
                    intent0.putExtra("step", thisStep + 1);
                    intent0.putExtra("allStep", allStep);
                    startActivity(intent0);
                    break;
                case 1:
                    Intent intent1 = new Intent(this, QuestionActivity.class);
                    intent1.putExtra("lesson", lesson);
                    intent1.putExtra("courseId", courseId);
                    intent1.putExtra("subCourseId", subCourseId);
                    intent1.putExtra("step", thisStep + 1);
                    intent1.putExtra("allStep", allStep);
                    startActivity(intent1);
                    break;
                default:

                    break;
            }
        });


        Thread threadGetQuestion = new Thread(new Runnable() {
            @Override
            public void run() {
                Message message = new Message();
                message.what = GET_QUESTIONS;
                try {
                    question = QuestionActivity.this.run(Server.serverUrlQuiz + lesson + "" + courseId + "" + subCourseId + "" + thisStep + "1"); // 1 for easy - 2 for normal - 3 for hard
                } catch (IOException e) {
                    e.printStackTrace();
                }
                message.arg1 = 1;
                handler.sendMessage(message);
            }
        });
        threadGetQuestion.start();
    }

    private int getStepType(String allStep, int thisStep){
        return Integer.parseInt(allStep.substring(thisStep,thisStep+1));
    }

    private void showQuestion() {
        String[] temp = question.split("==@@");
        question = temp[1];
        option1 = temp[2];
        option2 = temp[3];
        option3 = temp[4];
        option4 = temp[5];


        TextView QTextView = findViewById(R.id.learn_quiz_Question);
        QTextView.setText(question);

        Button button1 = findViewById(R.id.btn_quiz_ans1);
        Button button2 = findViewById(R.id.btn_quiz_ans2);
        Button button3 = findViewById(R.id.btn_quiz_ans3);
        Button button4 = findViewById(R.id.btn_quiz_ans4);

        ArrayList<Button> questionArrayList = new ArrayList<>();
        questionArrayList.add(button1);
        questionArrayList.add(button2);
        questionArrayList.add(button3);
        questionArrayList.add(button4);
        ArrayList<Button> questionArrayList2 = new ArrayList<>();
        questionArrayList2.add(button1);
        questionArrayList2.add(button2);
        questionArrayList2.add(button3);
        questionArrayList2.add(button4);


        ConstraintLayout constraintLayout = findViewById(R.id.activity_question);
        for (Button button : questionArrayList) {
            button.setOnClickListener(v -> {
                if (!ended && button.getTag() == correctOption) {
                    button.setBackgroundColor(Color.rgb(0, 255, 0));
                } else if (!ended) {
                    button.setBackgroundColor(Color.rgb(255, 0, 0));
                    for (Button b : questionArrayList2) {
                        if (b.getTag() == correctOption) {
                            b.setBackgroundColor(Color.rgb(0, 255, 0));
                        }
                    }
                }
                ended = true;
                if (ended && !ended2) {
                    ConstraintLayout constraintLayout1 = findViewById(R.id.quiz_end);
                    constraintLayout1.setVisibility(View.VISIBLE);
                    ended2 = true;
                }
            });
        }

        int random = (int) (Math.random() * 4);
        questionArrayList.get(random).setText(option1);
        questionArrayList.get(random).setTag(correctOption);
        questionArrayList.remove(random);

        random = (int) (Math.random() * 3);
        questionArrayList.get(random).setText(option2);
        questionArrayList.remove(random);

        random = (int) (Math.random() * 2);
        questionArrayList.get(random).setText(option3);
        questionArrayList.remove(random);

        random = 0;
        questionArrayList.get(random).setText(option4);
        questionArrayList.remove(random);


        ImageView imageView = findViewById(R.id.learn_quiz_loading);
        imageView.setVisibility(View.GONE);
        TextView textView = findViewById(R.id.learn_quiz_loading_text);
        textView.setVisibility(View.GONE);
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