package ir.mk.learnx.teach;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.util.Util;

import ir.mk.learnx.R;
import ir.mk.learnx.model.Server;
import ir.mk.learnx.quiz.QuestionActivity;

public class LearnMovieActivity extends AppCompatActivity {


    private PlayerView player;
    private SimpleExoPlayer simpleExoPlayer;
    private boolean playWhenReady = true;
    private int currentWindow = 0;
    private long playbackPosition = 0;

    private int thisStep;
    private int allStep;
    private int lesson;
    private int courseId;
    private int subCourseId;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_movie);

        lesson = getIntent().getIntExtra("lesson", -1);
        courseId = getIntent().getIntExtra("courseId", -1);
        subCourseId = getIntent().getIntExtra("subCourseId", -1);
        thisStep = getIntent().getIntExtra("step", 1);
        allStep = getIntent().getIntExtra("allStep", 1);
        int nextStepType;
        if (thisStep<allStep) {
            nextStepType = getStepType(lesson, courseId, subCourseId, thisStep + 1);
        }else{
            nextStepType = -1;
        }

        Button goNext = findViewById(R.id.learn_movie_go_next);
        goNext.setOnClickListener(v -> {
            switch (nextStepType){
                case -1:
                    Intent intent_1 = new Intent(this, EndSubCourse.class);
                    intent_1.putExtra("lesson",lesson);
                    intent_1.putExtra("courseId",courseId);
                    intent_1.putExtra("subCourseId",subCourseId);
                    intent_1.putExtra("allStep",allStep);
                    startActivity(intent_1);
                    break;
                case 0:
                    Intent intent0 = new Intent(this, LearnMovieActivity.class);
                    intent0.putExtra("lesson",lesson);
                    intent0.putExtra("courseId",courseId);
                    intent0.putExtra("subCourseId",subCourseId);
                    intent0.putExtra("step",thisStep+1);
                    intent0.putExtra("allStep",allStep);
                    startActivity(intent0);
                    break;
                case 1:
                    Intent intent1 = new Intent(this, QuestionActivity.class);
                    intent1.putExtra("lesson",lesson);
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


//        Toast.makeText(this, "course id:" + courseId + " ,subcourse-step:" + subCourseId+"-"+thisStep, Toast.LENGTH_SHORT).show();

    }
    private int getStepType(int lesson, int course,int subCourse,int step){
        return 1;
    }


    private void initializePlayer() {
        player = findViewById(R.id.learn_movie_video_view);

        simpleExoPlayer = new SimpleExoPlayer.Builder(this).build();
        player.setPlayer(simpleExoPlayer);

        //Server.serverUrl + courseId + "/" + subCourseId + "/" + thisStep + ".mp4"
        MediaItem mediaItem = MediaItem.fromUri(Server.serverUrlLearnMovie + lesson + "/" + courseId + "/" + subCourseId + "/" + thisStep + ".mp4");
        simpleExoPlayer.setMediaItem(mediaItem);

        simpleExoPlayer.seekTo(currentWindow, playbackPosition);
        simpleExoPlayer.setPlayWhenReady(playWhenReady);
        simpleExoPlayer.prepare();

    }

    @Override
    public void onStart() {
        super.onStart();
        if (Util.SDK_INT >= 24) {
            initializePlayer();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
//        hideSystemUi();
        if ((Util.SDK_INT < 24 || player == null)) {
            initializePlayer();
        }
    }

//    @SuppressLint("InlinedApi")
//    private void hideSystemUi() {
//        player.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
//                | View.SYSTEM_UI_FLAG_FULLSCREEN
//                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
//                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
//    }

    @Override
    public void onPause() {
        super.onPause();
        if (Util.SDK_INT < 24) {
            releasePlayer();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (Util.SDK_INT >= 24) {
            releasePlayer();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        Toast.makeText(this, "a: "+playbackPosition, Toast.LENGTH_SHORT).show();
    }

    private void releasePlayer() {
        if (simpleExoPlayer != null) {
            playWhenReady = simpleExoPlayer.getPlayWhenReady();
            playbackPosition = simpleExoPlayer.getCurrentPosition();
            currentWindow = simpleExoPlayer.getCurrentWindowIndex();
            simpleExoPlayer.release();
            simpleExoPlayer = null;
        }
    }













//    @Override
//    protected void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//
//        outState.putInt("MyVideoPosition", myVideoView.getCurrentPosition());
//        myVideoView.pause();
//
//    }
//
//    @Override
//    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//
//        videoPosition = savedInstanceState.getInt("MyVideoPosition");
//        myVideoView.seekTo(videoPosition);
//
//    }
}