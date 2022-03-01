package com.example.reader.logic.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "LocalNovel")
data class NovelEntity (
@PrimaryKey
@ColumnInfo(name = "id") var num:Int,
@ColumnInfo(name="novelName") var name:String,
@ColumnInfo(name="content") var content:String
)