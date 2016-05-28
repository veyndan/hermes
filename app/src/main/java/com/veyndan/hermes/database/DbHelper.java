package com.veyndan.hermes.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.veyndan.hermes.home.model.Comic;

public final class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "Hermes.db";

    String CREATE_TABLE = ""
            + "CREATE TABLE " + Comic.TABLE
            + "("
            + Comic.NUM + " INTEGER PRIMARY KEY,"
            + Comic.ALT + " TEXT,"
            + Comic.IMG + " TEXT,"
            + Comic.TITLE + " TEXT"
            + ")";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Comic.TABLE);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}