package com.example.movies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;

public class MovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        int movie_id = getIntent().getExtras().getInt("movie_id");


        Spinner spinner3=findViewById(R.id.spinner3);
        String[] categories = {"Drama", "Adventure", "Comedy", "Thriller"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MovieActivity.this, R.layout.spinner_item, R.id.txtView_item, categories);
        spinner3.setAdapter(adapter);

        EditText edTxt_id = findViewById(R.id.edTxt_id);
        EditText edTxt_title = findViewById(R.id.edTxt_title);
        EditText edTxt_Notes = findViewById(R.id.edTxt_Notes);
        RatingBar ratingBar=findViewById(R.id.ratingBar);

        //EditText edTxt_Category = findViewById(R.id.edTxt_Category);
        //EditText edTxt_Ratings = findViewById(R.id.edTxt_Ratings);


        Button btn_update = findViewById(R.id.btn_update);
        Button btn_delete = findViewById(R.id.btn_delete);

        Movie movie = new Movie(MovieActivity.this, movie_id);

        edTxt_id.setText(String.valueOf(movie.getId()));
        edTxt_title.setText(movie.getTitle());
        edTxt_Notes.setText(movie.getNotes());
        ratingBar.setRating(movie.getRatings());

        //edTxt_Category.setText(movie.getCategory());
        //edTxt_Ratings.setText(String.valueOf(movie.getRatings()));
       // edTxt_rating.setRating(5);

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                movie.setTitle(edTxt_title.getText().toString());
                movie.setNotes(edTxt_Notes.getText().toString());
                movie.setCategory(spinner3.getSelectedItem().toString());
                movie.setRatings((int) ratingBar.getRating());

                movie.update(MovieActivity.this);

                MovieActivity.this.finish();
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                movie.delete(MovieActivity.this);

                MovieActivity.this.finish();

            }
        });
    }
}






