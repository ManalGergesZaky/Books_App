package com.lola.bookapp.Ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.lola.bookapp.Control.MyAdapter;
import com.lola.bookapp.Model.MyBooks;
import com.lola.bookapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Recycler_Sport extends AppCompatActivity {

    private RequestQueue requestQueue ;
    private  String name ,author , pup ,pupDate , description , pages ,web_link;


    private ArrayList<MyBooks> booksArrayList = new ArrayList<MyBooks>() ;
    private RecyclerView recyclerView ;
    private MyAdapter myAdapter = new MyAdapter(booksArrayList , this) ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler__sport);


        recyclerView = findViewById(R.id.rec_sport);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this) ;
        recyclerView.setLayoutManager(layoutManager);
        //  recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myAdapter);
        requestQueue = Volley.newRequestQueue(this) ;

        ParseJson_Sport() ;
    }

    public void ParseJson_Sport() {


        String url_sport = "https://run.mocky.io/v3/f393cb45-4081-4e33-a45e-c2966a90f2f8";



        JsonObjectRequest request = new JsonObjectRequest
                (Request.Method.GET, url_sport, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {

                                try {
                                    JSONArray jsonArray = response.getJSONArray("items") ;

                                    for (int i = 0 ; i<jsonArray.length() ; i++)
                                    {
                                        JSONObject item = jsonArray.getJSONObject(i);

                                        JSONObject ti_item = item.getJSONObject("volumeInfo");
                                        name = ti_item.getString("title") ;
                                        pup = ti_item.getString("publisher");
                                        pupDate = ti_item.getString("publishedDate");

                                        pages = ti_item.getString("pageCount");
                                        System.out.println( i + "  page :  "+ pages );

                                        System.out.println( i + "   :  "+ name );

                                        System.out.println( i + "   :  "+ pup );
                                        System.out.println( i + "   :  "+ pupDate );


                                        JSONArray auth = ti_item.getJSONArray("authors");
                                        author = auth.getString(0) ;
                                        System.out.println( i + "  auther :  "+ author );

                                        JSONObject img_Link = ti_item.getJSONObject("imageLinks") ;
                                        String im = img_Link.getString("smallThumbnail");

                                        System.out.println( i + "  img :  "+ im );



                                        web_link = ti_item.getString("previewLink") ;

                                        System.out.println( i + "  web :  "+ web_link );





                                        description = ti_item.getString("description");


                                        System.out.println( i + "  des :  "+ description );


                                        booksArrayList.add(new MyBooks(name, author,pup,pupDate,im ,description ,pages ,web_link)) ;



                                    }


                                    myAdapter = new MyAdapter(booksArrayList, Recycler_Sport.this ) ;
                                    recyclerView.setAdapter(myAdapter);
                                } catch (JSONException e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        System.out.println(error.getMessage());
                    }
                }) ;
        requestQueue.add(request) ;
    }
}