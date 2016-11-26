package com.example.termproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class ManagerDB extends SQLiteOpenHelper {

    private static ArrayList<Integer> mArrayList;

    public ManagerDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void onCreate(SQLiteDatabase db) {
        // 새로운 테이블 생성
        /* 이름은 MyLogger2, 자동으로 값이 증가하는 _id 정수형 기본키 컬럼과
        position 문자형 컬럼, content 문자열 컬럼, 위도, 경도 컬럼으로 구성된 테이블을 생성. */
        db.execSQL("CREATE TABLE MyLogger2 (_id INTEGER PRIMARY KEY AUTOINCREMENT, position TEXT, content TEXT,latitude DOUBLE,longitude DOUBLE,pNumber INTEGER);");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(String position, String content,double latitude,double longitude,int pNumber) {
        //DB에 쓸 수 있도록 Open
        SQLiteDatabase db = getWritableDatabase();
        //DB Insert 쿼리 실행
        String s="INSERT INTO MyLogger2 VALUES(null, '" + position + "','" + content + "','" + latitude + "','" + longitude + "','" + pNumber + "');";
        db.execSQL(s);
        db.close();
    }

    public String getResult() {

        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        Cursor cursor = db.rawQuery("SELECT * FROM MyLogger2", null);
        while (cursor.moveToNext()) {
            result += cursor.getInt(0)
                    + " : "
                    + cursor.getString(1)
                    + " | "
                    + cursor.getString(2)
                    + " | "
                    + cursor.getDouble(3)
                    + " | "
                    + cursor.getDouble(4)
                    + " | "
                    + cursor.getInt(5)
                    + "\n";
        }

        return result;
    }

    public ArrayList<Integer> getPosition(){

        SQLiteDatabase db = getReadableDatabase();

        mArrayList=new ArrayList<Integer>();

        // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
        Cursor cursor = db.rawQuery("SELECT pNumber FROM MyLogger2", null);
        while(cursor.moveToNext()){
            mArrayList.add(cursor.getInt(0));

        }
        return mArrayList;
    }

    public String getContent(){

        SQLiteDatabase db = getReadableDatabase();
        String content="";
        Cursor cursor = db.rawQuery("SELECT content FROM MyLogger2", null);

        return content;
    }
}