package com.example.android.charactercreator.stats

import androidx.lifecycle.ViewModel
import com.example.android.charactercreator.fuaxdata.FauxAbilitySkillStats
import com.example.android.charactercreator.fuaxdata.FauxCharacterInfo

class CharacterStatsViewModel: ViewModel() {

    fun fetchViewState(): List<CharacterViewState> {
        val elements: MutableList<CharacterViewState> = mutableListOf()

        fetchStats().forEach {
            elements.add(toCharacterAttributeViewState(it))
        }

        elements.add(fetchPlayerInfo())
        return elements
    }

    private fun fetchStats(): List<FauxAbilitySkillStats> {
        val statList: MutableList<FauxAbilitySkillStats> = mutableListOf()

        statList.add(FauxAbilitySkillStats.Strength("8"))
        statList.add(FauxAbilitySkillStats.Dexterity("10"))
        statList.add(FauxAbilitySkillStats.Constitution("15"))
        statList.add(FauxAbilitySkillStats.Intelligence("14"))
        statList.add(FauxAbilitySkillStats.Wisdom("14"))
        statList.add(FauxAbilitySkillStats.Charisma("17"))

        return statList
    }

    private fun fetchPlayerInfo(): CharacterViewState {
        val fakeCharacterData = FauxCharacterInfo.ROGUE

        return CharacterViewState.CharacterInfoHeaderElement(
            characterName = fakeCharacterData.characterName,
            mainClass = fakeCharacterData.mainClass,
            characterLevel = fakeCharacterData.characterLevel,
            subClass = fakeCharacterData.subClass,
            isMultiClassed = fakeCharacterData.isMultiClassed,
            additionalClasses = fakeCharacterData.additionalClasses
        )
    }

    private fun toCharacterAttributeViewState(skill: FauxAbilitySkillStats): CharacterViewState {
        return CharacterViewState.CharacterAttributesElement(skill)
    }
}

sealed class CharacterViewState {
    data class CharacterInfoHeaderElement(
        val characterName: String,
        val mainClass: String,
        val characterLevel: String,
        val subClass: String? = null,
        val isMultiClassed: Boolean? = false,
        val additionalClasses: List<String>? = emptyList()
    ): CharacterViewState()

    data class CharacterAttributesElement(
        val skill: FauxAbilitySkillStats
    ): CharacterViewState()
}