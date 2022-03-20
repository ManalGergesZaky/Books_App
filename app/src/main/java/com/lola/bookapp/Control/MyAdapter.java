package com.lola.bookapp.Control;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lola.bookapp.Model.MyBooks;
import com.lola.bookapp.R;
import com.lola.bookapp.View.Book_details;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    private ArrayList<MyBooks> booksArrayList ;
    private Context context ;

    public MyAdapter(ArrayList<MyBooks> booksArrayList, Context context) {
        this.booksArrayList = booksArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder
            (@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_items , parent,false) ;

        return new MyViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder
            (@NonNull MyAdapter.MyViewHolder holder, int position) {
        MyBooks myBooks = booksArrayList.get(position) ;

        holder.name_book.setText( myBooks.getName_book() + ".");
        holder.auth.setText(myBooks.getAuthor()+ ".");
        holder.pup.setText(myBooks.getPublisher()+ ".");
        holder.dat.setText(myBooks.getPublishedDate());
       // holder.description.setText(myBooks.getDes());


        Picasso.with(context)
                .load(myBooks.getImg_link())
                .into(holder.imageView_lis);



    }

    @Override
    public int getItemCount() {
        return booksArrayList.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView name_book , auth , pup , dat, description , page;

        private ImageView imageView_lis , image_fa ;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            imageView_lis = itemView.findViewById(R.id.img_list);
            name_book = itemView.findViewById(R.id.naList);
            auth = itemView.findViewById(R.id.auth_list);
            pup = itemView.findViewById(R.id.pup_list);
            dat = itemView.findViewById(R.id.pupDate_list);

            image_fa = itemView.findViewById(R.id.img_Favor) ;

            image_fa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    MyBooks myBooks = booksArrayList.get(position) ;
                    Sql sql = new Sql(context) ;
                    boolean inn = sql.insert( myBooks.getName_book() ,myBooks.getAuthor() ) ;
                    String tex = "You are Add this Book To Favorite" ;
                    Toast tost = Toast.makeText(context, tex, Toast.LENGTH_SHORT);
                    View bg = tost.getView();
                    bg.setBackgroundColor(Color.parseColor("#CB55F3DF"));
                    //bg.setBackgroundColor(Color.RED);
                     tost.setGravity(Gravity.TOP , 0,0);
                    tost.show();
                }
            });
        }

        @Override
        public void onClick(View v) {

            int position = getAdapterPosition();
            MyBooks myBooks = booksArrayList.get(position) ;

            Intent intent = new Intent(context , Book_details.class) ;
            intent.putExtra("img",myBooks.getImg_link());
            intent.putExtra("name" ,myBooks.getName_book() );
            intent.putExtra("page" ,myBooks.getPage() );
            intent.putExtra("description" , myBooks.getDes());
            intent.putExtra("web" ,myBooks.getWeb_link());

            System.out.println("ok");
            context.startActivity(intent);
        }
    }
}
