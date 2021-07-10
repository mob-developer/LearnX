package ir.mk.learnx.loading;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import ir.mk.learnx.R;


public class Loading1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading1);

        Thread welcomeThread = new Thread() {

            @Override
            public void run() {
                try {
                    super.run();
                    sleep(500);
                } catch (Exception e) {

                } finally {

                    Intent i = new Intent(Loading1.this, Loading2.class);
                    startActivity(i);
                    finish();
                }
            }
        };
        welcomeThread.start();
    }
}