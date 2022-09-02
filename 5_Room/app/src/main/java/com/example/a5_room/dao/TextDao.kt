package com.example.a5_room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.a5_room.entity.TextEntity


@Dao
interface TextDao {

    @Query("SELECT * FROM text_table")
    fun getAllData() : List<TextEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(text : TextEntity)

    @Query("DELETE FROM text_table")
    fun deleteAllData()

}