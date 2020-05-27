package com.example.android.charactercreator.room

import androidx.room.*

@Dao
interface CharacterDao {
    @Insert
    fun addCharacter(character: Character)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateCharacter(character: Character)

    @Delete
    fun removeCharacter(character: Character)
}