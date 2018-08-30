package com.example.rakapermanaputra.mynotesapp.db;

import android.provider.BaseColumns;

public class DatabaseContact {

    static String TABLE_NOTE = "note";

    static final class NoteColumns implements BaseColumns {

        //Note title
        static String TITLE = "title";
        //Note description
        static String DESCRIPTION = "description";
        //Note date
        static String DATE = "date";

    }

}
