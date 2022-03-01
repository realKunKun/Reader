package com.example.reader.logic.dao

import androidx.room.*
import com.example.reader.logic.model.NovelDataModel
import com.example.reader.logic.model.NovelEntity

@Dao
interface DataDao {
    @Query("SELECT content from LOCALNOVEL where novelName=(:name)")
    fun getNovel(name:String):String

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNovel(novelEntity: NovelEntity)

    @Delete
    fun deleteNovel(novelEntity: NovelEntity)

    @Update
    fun updateNovel(novelEntity: NovelEntity)
}