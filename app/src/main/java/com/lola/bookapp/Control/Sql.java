package com.lola.bookapp.Control;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ImageView;

import java.util.ArrayList;

public class Sql extends SQLiteOpenHelper {

    static  final  String Data_name = "data.dp" ;

    public Sql(Context context) {
        super(context, Data_name, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE  mytable (id INTEGER PRIMARY KEY AUTOINCREMENT ,  name TEXT , auth_book TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS mytable ");
        onCreate(db);

    }




    public  boolean insert ( String name_d ,String au)
    {
        SQLiteDatabase db = this.getWritableDatabase() ;
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name_d);
        contentValues.put("auth_book",au);

        int r = (int) db.insert("mytable" ,null , contentValues);
        if(r== -1 )
        {
            return  false ;
        }
        else
            return  true ;

    }

    public ArrayList<String> get_data()
    {

        ArrayList <String> arrayList= new ArrayList() ;

        SQLiteDatabase db =this.getReadableDatabase();

        Cursor res = db.rawQuery("SELECT id,name , auth_book FROM mytable", null );

        res.moveToFirst() ;
        while ( ! res.isAfterLast())
        {   String id = res.getString(0);
            String name = res.getString(1);
            String aut = res.getString(2);

            arrayList.add( id +"  :  " + name + "\n" + "\t  Author Name : " + aut);

            res.moveToNext();
        }

        return  arrayList ;
    }

}
