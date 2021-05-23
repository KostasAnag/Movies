package com.example.movies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;

public class NewMovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_movie);

        Spinner spinView=findViewById(R.id.spinView);
        String[] categories = {"Drama", "Adventure", "Comedy", "Thriller"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(NewMovieActivity.this, R.layout.spinner_item, R.id.txtView_item, categories);
        spinView.setAdapter(adapter);

        EditText edTxt_title = findViewById(R.id.edTxt_title);
        EditText edTxt_notes = findViewById(R.id.edTxt_notes);
       // EditText edTxt_category = findViewById(R.id.edTxt_category);
        RatingBar edTxt_rating = findViewById(R.id.edTxt_ratings);
        //edTxt_rating.setRating(5);
        Button btn_save = findViewById(R.id.btn_save);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Movie movie = new Movie();
                movie.setTitle(edTxt_title.getText().toString());
                movie.setNotes(edTxt_notes.getText().toString());
                movie.setCategory(spinView.getSelectedItem().toString());
                movie.setRatings((int) edTxt_rating.getRating());
               // movie.setRatings(Integer.valueOf(edTxt_rating.getNumStars()));

                movie.save(NewMovieActivity.this);

           NewMovieActivity.this.finish();
            }
        });

    }

    }
