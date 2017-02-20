package com.example.divya.notepal.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Divya on 20-02-2017.
 */

public class NoteDbHelper extends SQLiteOpenHelper {

    public NoteDbHelper(Context context) {
        super(context,NoteContract.DB_NAME, null, NoteContract.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + NoteContract.TaskEntry.TABLE + " ( " +
                NoteContract.TaskEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NoteContract.TaskEntry.COL_TASK_TITLE + " TEXT NOT NULL);";

        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + NoteContract.TaskEntry.TABLE);
        onCreate(db);
    }
}

