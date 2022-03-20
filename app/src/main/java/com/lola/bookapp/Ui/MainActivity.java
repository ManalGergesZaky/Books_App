package com.lola.bookapp.Ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.lola.bookapp.R;

public class MainActivity extends AppCompatActivity {

    private ImageView sport , time , love , life , view_fav ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sport = findViewById(R.id.spo);
        time = findViewById(R.id.tim);
        love = findViewById(R.id.lov);
        life = findViewById(R.id.liv) ;
        view_fav = findViewById(R.id.img_Favoruit) ;

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Sport Book");

                OpenActivity_Recycler_Time() ;




            }
        });
        sport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                OpenActivity_Recycler_Sport();
            }
        });

        life.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                OpenActivity_Recycler_Live();
            }
        });

        love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenActivity_Recycler_Love();
            }
        });

        view_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenActivity_GetData() ;
            }
        });
    }


    public void OpenActivity_Recycler_Time()
    {
        //setContentView(R.layout.book_items);
        Intent intent = new Intent(this , Recycler_Tiem.class) ;
        startActivity(intent);

    }

    public void OpenActivity_Recycler_Sport()
    {

        Intent intent = new Intent(this , Recycler_Sport.class) ;
        startActivity(intent);

    }

    public void OpenActivity_Recycler_Love()
    {

        Intent intent = new Intent(this , Recycler_Love.class) ;
        startActivity(intent);

    }

    public void OpenActivity_Recycler_Live()
    {

        Intent intent = new Intent(this , Recycler_Life.class) ;
        startActivity(intent);

    }

    public void OpenActivity_GetData()
    {

        Intent intent = new Intent(this , GetFavouriteData.class) ;
        startActivity(intent);

    }


}