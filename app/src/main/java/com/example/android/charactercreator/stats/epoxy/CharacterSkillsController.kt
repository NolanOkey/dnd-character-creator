package com.example.android.charactercreator.stats.epoxy

import com.airbnb.epoxy.Typed2EpoxyController
import com.example.android.charactercreator.stats.Skills

class CharacterSkillsController: Typed2EpoxyController<List<Skills>, String>() {

    override fun buildModels(skills: List<Skills>, modifier: String) {
        skills.forEachIndexed { index, skill ->
            characterSkillsComponent {
                id(index)
                characterSkills(skill)
                skillModifier(modifier)
            }
        }
    }
}