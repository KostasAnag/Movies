package com.example.movies;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class Movie {
    private int id;
    private String title;
    private String notes;
    private String category;
    private int ratings;


    public Movie() {
    }

    public Movie(Context context, int id){
        SQLiteOpenHelper helper = new SQLiteHelper(context);
        SQLiteDatabase database = helper.getWritableDatabase();

//      SELECT * FROM movies WHERE id = ?
        Cursor cursor = database.query(SQLiteHelper.TABLE_MOVIES, SQLiteHelper.COLUMNS_MOVIES, "id = ?", new String[]{String.valueOf(id)}, null, null, null);

        cursor.moveToFirst();
        this.id = cursor.getInt(0);
        this.title = cursor.getString(1);
        this.notes = cursor.getString(2);
        this.category = cursor.getString(3);
        this.ratings = cursor.getInt(4);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings =ratings;
    }

    public void save(Context context){
        SQLiteOpenHelper helper = new SQLiteHelper(context);
        SQLiteDatabase database = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.COLUMNS_MOVIES[1], this.title);
        values.put(SQLiteHelper.COLUMNS_MOVIES[2], this.notes);
        values.put(SQLiteHelper.COLUMNS_MOVIES[3], this.category);
        values.put(SQLiteHelper.COLUMNS_MOVIES[4], this.ratings);

//        INSERT INTO movies (title,notes,category,ratings) VALUES ('"+this.title+"', '"+this.description+"', "+this.price+")
        long new_id=database.insert(SQLiteHelper.TABLE_MOVIES, null, values);

        Log.d("save_id", "save: "+new_id );

    }

    public void update(Context context){
        SQLiteOpenHelper helper = new SQLiteHelper(context);
        SQLiteDatabase database = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.COLUMNS_MOVIES[1], this.title);
        values.put(SQLiteHelper.COLUMNS_MOVIES[2], this.notes);
        values.put(SQLiteHelper.COLUMNS_MOVIES[3], this.category);
        values.put(SQLiteHelper.COLUMNS_MOVIES[4], this.ratings);

//        database.rawQuery("UPDATE TABLE products SET (title='new title', description='new description', price=500) WHERE id = ?", new String[] {"1"});

        database.update(SQLiteHelper.TABLE_MOVIES, values, "id = ?", new String[]{String.valueOf(this.id)});
    }

    public void delete(Context context){
        SQLiteOpenHelper helper = new SQLiteHelper(context);
        SQLiteDatabase database = helper.getWritableDatabase();

//        database.rawQuery("DELETE FROM products WHERE id = ?", new String[] {"1"});
        database.delete(SQLiteHelper.TABLE_MOVIES, "id = ?", new String[]{String.valueOf(this.id)});

    }

    public static ArrayList<Movie> selectByCategory(Context context, int category){
        ArrayList<Movie> movies = new ArrayList<>();

        SQLiteOpenHelper helper = new SQLiteHelper(context);
        SQLiteDatabase database = helper.getWritableDatabase();

//      SELECT * FROM products
        Cursor cursor = database.query(SQLiteHelper.TABLE_MOVIES, SQLiteHelper.COLUMNS_MOVIES, "category = ?", new String[]{String.valueOf(category)}, null, null, null);
//        Cursor cursor = database.rawQuery("SELECT * FROM movies WHERE category = '"+category+"'", null);
        Log.d("CATEGORY", cursor.getCount()+"");

        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Movie movie= new Movie();
            movie.id = cursor.getInt(0);
            movie.title = cursor.getString(1);
            movie.notes = cursor.getString(2);
            movie.category = cursor.getString(3);
            movie.ratings = cursor.getInt(4);

            movies.add(movie);
            cursor.moveToNext();
        }
        return movies;
    }

    public static ArrayList<Movie> getAllMovies(Context context){
        ArrayList<Movie> movies = new ArrayList<>();

        SQLiteOpenHelper helper = new SQLiteHelper(context);
        SQLiteDatabase database = helper.getWritableDatabase();

//      SELECT * FROM products
        Cursor cursor = database.query(SQLiteHelper.TABLE_MOVIES, SQLiteHelper.COLUMNS_MOVIES, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Movie movie= new Movie();
            movie.id = cursor.getInt(0);
            movie.title = cursor.getString(1);
            movie.notes = cursor.getString(2);
            movie.category = cursor.getString(3);
            movie.ratings = cursor.getInt(4);

            movies.add(movie);
            cursor.moveToNext();
        }
        return movies;
    }

}
