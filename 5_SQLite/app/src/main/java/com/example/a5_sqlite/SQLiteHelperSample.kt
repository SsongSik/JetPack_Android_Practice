package com.example.a5_sqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.util.*

class SQLiteHelperSample(context : Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){

    companion object {

        private const val DATABASE_VERSION = 1 //데이터베이스 버전
        private const val DATABASE_NAME = "myTestDB.db" //데이터베이스 이름
        private const val TBL_NAME = "my_table" //테이블이름

        private const val ID = "id"
        private const val TITLE = "title"

    }
    //테이블 만드는 구문
    override fun onCreate(db: SQLiteDatabase?) {

        val SQL_CREATE_ENTRIES =
            "CREATE TABLE $TBL_NAME (" +
                    "$ID INTEGER PRIMARY KEY," +
                    "$TITLE TEXT)"

        db?.execSQL(SQL_CREATE_ENTRIES)

    }

    //테이블의 행에 insert하는 구문
    fun insert(str : String) {

        val db = this.writableDatabase

        val values = ContentValues().apply {
            put(TITLE, str) //TITLE의 값에 str을 넣겠다.
        }

        db.insert(TBL_NAME, null, values)

    }

    //테이블 전체 행을 불러오는 구문
    fun getAllData() : ArrayList<String> {

        val db = this.readableDatabase
        val query = "SELECT * FROM $TBL_NAME"

        val cursor = db.rawQuery(query, null)

        val arr = ArrayList<String>()

        with(cursor) {
            while (moveToNext()) {
                arr.add(getString(1)) //값을 하나씩 넣어줌
                //이는 ID값은 아니고, TITLE값을 의미함
            }
        }

        return arr
    }

    //테이블의 행 전체를 삭제하는 구문
    fun deleteAll(){

        val db = this.writableDatabase
        db.execSQL("DELETE FROM $TBL_NAME")

    }


    // DATABASE VERSION 바뀔 때 기존 데이터베이스 버전에서 지워주는 작업을 함
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        db?.execSQL("DROP TABLE IF EXISTS $TBL_NAME")
        onCreate(db)

    }

}