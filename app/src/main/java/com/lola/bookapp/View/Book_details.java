package com.lola.bookapp.View;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.lola.bookapp.R;
import com.squareup.picasso.Picasso;

public class Book_details extends AppCompatActivity {

    private TextView name , des , page ;
    private ImageView image_book , image_fa ;
    private Bundle extras ;
    private WebView webView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        extras = getIntent().getExtras();
        name = findViewById(R.id.name_det);
        des = findViewById(R.id.descr_det);
        image_book = findViewById(R.id.img_de) ;
        page = findViewById(R.id.page) ;

        webView = findViewById(R.id.web_de) ;

        webView.setWebViewClient(new WebViewClient());

        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        if (extras != null)
        {
            name.setText(extras.getString("name"));
            des.setText(extras.getString("description"));
            page.setText("pageCount : " + extras.getString("page"));
            Picasso.with(this).load(extras.getString("img")).into(image_book);

            webView.loadUrl(extras.getString("web"));

        }
    }
}