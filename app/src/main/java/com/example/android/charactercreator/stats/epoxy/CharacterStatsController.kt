package com.example.android.charactercreator.stats.epoxy

import com.airbnb.epoxy.Typed2EpoxyController
import com.example.android.charactercreator.stats.CharacterViewState
import com.example.android.charactercreator.stats.ClickActionHandler

class CharacterStatsController: Typed2EpoxyController<List<CharacterViewState>, ClickActionHandler>() {

    override fun buildModels(elements: List<CharacterViewState>, action: ClickActionHandler) {
        elements.forEachIndexed { index, element ->
            when(element) {
                is CharacterViewState.CharacterAttributesElement -> {
                    characterStatsComponent {
                        id(index)
                        characterAttribute(element.skill)
                        clickAction(action)
                    }
                }
            }
        }
    }
}