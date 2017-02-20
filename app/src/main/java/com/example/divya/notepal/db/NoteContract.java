package com.example.divya.notepal.db;

import android.provider.BaseColumns;

/**
 * Created by Divya on 20-02-2017.
 */

public class NoteContract {
    public static final String DB_NAME = "notes_db.db";
    public static final int DB_VERSION = 1;

    public class TaskEntry implements BaseColumns {
        public static final String TABLE = "notes";

        public static final String COL_TASK_TITLE = "title";
    }
}
