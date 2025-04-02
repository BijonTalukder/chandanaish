package com.prio.chandanaish;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public  static  final String Database_name="my_database";
    public  static  final  int Database_version=1;

    private static final String TABLE_SERVICE = "service";
    private static final String TABLE_SERVICE_LIST = "service_list";

    // Service Table Columns
    private static final String COL_ID = "id";
    private static final String COL_TITLE = "title";
    private static final String COL_STATUS = "status";
    private static final String COL_TYPE = "type";
    private static final String COL_IMAGE_URL = "imageUrl";
    private static final String COL_IS_LOTTIE = "isLottie";
    private static final String COL_IS_CLICKABLE_LINK = "isClikableLink";
    private static final String COL_URL = "url";

    // Service List Table Columns
    private static final String COL_SERVICE_ID = "serviceId";
    private static final String COL_SHORT_DESC = "shortDescription";
    private static final String COL_DESC = "description";
    private static final String COL_PHONE = "phoneNumber";
    private static final String COL_IS_INTERNAL_URL = "isInternalUrl";
    public DatabaseHelper(Context context) {
super(context,Database_name,null,Database_version);
//        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTableService="CREATE TABLE "+TABLE_SERVICE+"("+
                COL_ID+"TEXT PRIMARY KEY," +
                COL_TITLE+" TEXT,"+
                COL_STATUS+" TEXT,"+
                COL_TYPE+" TEXT,"+
                COL_IMAGE_URL+" TEXT,"+
                COL_IS_LOTTIE+" TEXT,"+
                COL_IS_CLICKABLE_LINK+" TEXT,"+
                COL_URL+" TEXT )";

        db.execSQL(createTableService);

        String createServiceListTable="CREATE TABLE " + TABLE_SERVICE_LIST + " (" +
                COL_ID + " TEXT PRIMARY KEY, " +
                COL_SERVICE_ID + " TEXT, " +
                COL_TITLE + " TEXT, " +
                COL_SHORT_DESC + " TEXT, " +
                COL_DESC + " TEXT, " +
                COL_PHONE + " TEXT, " +
                COL_IS_INTERNAL_URL + " INTEGER, " +
                "FOREIGN KEY(" + COL_SERVICE_ID + ") REFERENCES " + TABLE_SERVICE + "(" + COL_ID + "))";
        db.execSQL(createServiceListTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
