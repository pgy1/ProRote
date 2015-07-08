package pgy.com.desire.Utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import pgy.com.desire.Models.assign;

/**
 * Created by pengguangyu on 2015/7/7.
 */
public class sqliteHelper extends SQLiteOpenHelper{
    //用来保存UserID、Access Token、Access Secret的表名
    public static final String TB_NAME= "assign";
    public sqliteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    //创建表
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( "CREATE TABLE IF NOT EXISTS "+
                        TB_NAME+ "("+
                        assign. ID+ " integer primary key,"+
                        assign. NAME+ " varchar,"+
                        assign. NUMBER+ " integer,"+
                        assign. PROCESS+ " integer,"+
                        assign. DEADLINE+ " date"+
                        ")"
        );
        Log. e("Database" ,"onCreate" );
    }
    //更新表
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL( "DROP TABLE IF EXISTS " + TB_NAME );
        onCreate(db);
        Log. e("Database", "onUpgrade");
    }
    //更新列
    public void updateColumn(SQLiteDatabase db, String oldColumn, String newColumn, String typeColumn){
        try{
            db.execSQL( "ALTER TABLE " +
                            TB_NAME + " CHANGE " +
                            oldColumn + " "+ newColumn +
                            " " + typeColumn
            );
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
