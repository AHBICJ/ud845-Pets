package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.pets.data.PetContract.PetEntry;

public final class PetDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "shelter.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + PetEntry.TABLE_NAME + "( " +
                    PetEntry._ID + " INTEGER PRIMARY KEY," +
                    PetEntry.COLUMN_PET_NAME + " TEXT," +
                    PetEntry.COLUMN_PET_BREED + " TEXT NOT NULL," +
                    PetEntry.COLUMN_PET_GENDER + " INTEGER NOT NULL," +
                    PetEntry.COLUMN_PET_WEIGHT + " INTEGER NOT NULL DEFAULT 0);";
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + PetEntry.TABLE_NAME;

    public PetDbHelper(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }
}
