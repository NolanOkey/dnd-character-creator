package com.example.android.charactercreator.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Character(
    @PrimaryKey private val id: Long,
    val name: String,
    @ColumnInfo(name = "primary_class") val primaryClass: String,
    @ColumnInfo(name = "sub_class") val subClass: String?
)