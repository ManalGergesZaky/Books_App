package com.lola.bookapp.Ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.lola.bookapp.R;
import com.lola.bookapp.Ui.MainActivity;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3000);
                    Intent intent = new Intent(getApplicationContext() , MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        };
        thread.start();
    }
}