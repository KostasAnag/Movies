package com.example.movies;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

    public class SQLiteHelper extends SQLiteOpenHelper {

        private static final String DATABASE_NAME = "movies.db";
        private static final int DATABASE_VERSION = 1;

        public static final String TABLE_MOVIES = "movies";
        public static final String[] COLUMNS_MOVIES = {"id", "title", "notes", "ratings","category"};

        public SQLiteHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL("CREATE TABLE movies (id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT NOT NULL, notes TEXT NOT NULL, ratings INTEGER ,category TEXT NOT NULL)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
}

