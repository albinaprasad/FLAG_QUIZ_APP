package com.albin.flag_quiz.Database

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.albin.flag_quiz.model.flagmodel
import com.techmania.flagquizwithsqlitedemo.DatabaseCopyHelper

class flagDAO {

    fun getRandomTen(helper: DatabaseCopyHelper): ArrayList<flagmodel>
    {
        val database: SQLiteDatabase=helper.writableDatabase

        val cursor: Cursor=database.rawQuery("SELECT * FROM flags ORDER BY RANDOM() limit 10",null)

        val dataList= ArrayList<flagmodel>()

        val idIndx=cursor.getColumnIndex("flag_id")
        val countryname=cursor.getColumnIndex("countryName")
        val flagName=cursor.getColumnIndex("flagName")

        while (cursor.moveToNext())
        {
            val record= flagmodel(
                    cursor.getInt(idIndx),
                    cursor.getString(countryname),
                    cursor.getString(flagName)
                    )

            dataList.add(record)
        }
        cursor.close()
        return dataList


    }

    fun getRandomThree(helper: DatabaseCopyHelper,id:Int):ArrayList<flagmodel>
    {
        var dataList= ArrayList<flagmodel>()
        val database: SQLiteDatabase=helper.writableDatabase
        val cursor: Cursor=database.rawQuery("SELECT * FROM flags where flag_id != $id ORDER BY RANDOM() limit 3",null)


        var idIndx=cursor.getColumnIndex("flag_id")
        var countryName=cursor.getColumnIndex("countryName")
        var flagname=cursor.getColumnIndex("flagName")



        while (cursor.moveToNext())
        {
            var record= flagmodel(

                cursor.getInt(idIndx),
                cursor.getString(countryName),
                cursor.getString(flagname)
                )

            dataList.add(record)
        }
        cursor.close()
      return  dataList
    }

}