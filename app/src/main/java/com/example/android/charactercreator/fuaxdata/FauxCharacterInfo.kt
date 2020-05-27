package com.example.android.charactercreator.fuaxdata

enum class FauxCharacterInfo(
    val characterName: String,
    val mainClass: String,
    val characterLevel: String,
    val subClass: String? = null,
    val isMultiClassed: Boolean? = false,
    val additionalClasses: List<String>? = emptyList()
) {
    ROGUE(
        characterName = "Newbie",
        mainClass = "Rogue",
        characterLevel = "3",
        subClass = "Inquisitor"
    )
}