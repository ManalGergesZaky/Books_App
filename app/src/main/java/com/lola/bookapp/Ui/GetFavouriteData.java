package com.lola.bookapp.Ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.lola.bookapp.R;
import com.lola.bookapp.Control.Sql;

import java.util.ArrayList;

public class GetFavouriteData extends AppCompatActivity {

    Sql dp = new Sql(this) ;
    ListView listView ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_favourit_data);

        OnClickGet();
    }

    public void OnClickGet()
    {
        listView = findViewById(R.id.list_fav);

        ArrayList<String> arrayList = dp.get_data();
        ArrayAdapter arrayAdapter = new ArrayAdapter(this ,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);


    }
}