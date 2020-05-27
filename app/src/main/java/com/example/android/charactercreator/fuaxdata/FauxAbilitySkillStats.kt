package com.example.android.charactercreator.fuaxdata

import com.example.android.charactercreator.stats.Skills

// this is probably some server side stuff. Let's not make the client do maths.
// also the this is basically a complex enum which is gross.
sealed class FauxAbilitySkillStats(
    val attributeTotal: String,
    val skills: List<Skills>
) {
        fun modifier(): String {
            val total = attributeTotal.toInt() - 10
            val mod = if (total < 0) {
                (total - 1).div(2)
            } else {
                (total.div(2))
            }
            return mod.toString()
        }

    data class Strength(
        val statTotal: String,
        val proficiency: String = "+ 2",
        private val setSkills: List<Skills> =
            listOf(
                Skills.SAVE,
                Skills.ATHLETICS
            )
    ): FauxAbilitySkillStats(statTotal, setSkills)

    data class Dexterity(
        val statTotal: String,
        val proficiency: String = "+ 2",
        private val setSkills: List<Skills> =
            listOf(
                Skills.SAVE,
                Skills.ACROBATICS,
                Skills.SLEIGHT_OF_HAND,
                Skills.STEALTH
            )
    ): FauxAbilitySkillStats(statTotal, setSkills)

    data class Constitution(
        val statTotal: String,
        val proficiency: String = "+ 2",
        private val setSkills: List<Skills> =
            listOf(
                Skills.SAVE
            )
    ): FauxAbilitySkillStats(statTotal, setSkills)

    data class Intelligence(
        val statTotal: String,
        val proficiency: String = "+ 2",
        private val setSkills: List<Skills> =
            listOf(
                Skills.SAVE,
                Skills.ARCANA,
                Skills.HISTORY,
                Skills.INVESTIGATION,
                Skills.NATURE,
                Skills.RELIGION
            )
    ): FauxAbilitySkillStats(statTotal, setSkills)

    data class Wisdom(
        val statTotal: String,
        val proficiency: String = "+ 2",
        private val setSkills: List<Skills> =
            listOf(
                Skills.ANIMAL_HANDLING,
                Skills.INSIGHT,
                Skills.MEDICINE,
                Skills.PERCEPTION,
                Skills.SURVIVAL
            )
    ): FauxAbilitySkillStats(statTotal, setSkills)

    data class Charisma(
        val statTotal: String,
        val proficiency: String = "+ 2",
        private val setSkills: List<Skills> =
            listOf(
                Skills.DECEPTION,
                Skills.INTIMIDATION,
                Skills.PERFORMANCE,
                Skills.PERSUASION
            )
    ): FauxAbilitySkillStats(statTotal, setSkills)
}