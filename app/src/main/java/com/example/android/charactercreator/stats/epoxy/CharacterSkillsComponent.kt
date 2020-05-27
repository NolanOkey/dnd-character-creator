package com.example.android.charactercreator.stats.epoxy

import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.android.charactercreator.R
import com.example.android.charactercreator.epoxy.KotlinEpoxyHolder
import com.example.android.charactercreator.stats.Skills
import java.util.*

@EpoxyModelClass(layout = R.layout.view_character_skills)
abstract class CharacterSkillsComponent : EpoxyModelWithHolder<CharacterSkillsComponent.ViewHolder>() {

    @EpoxyAttribute
    lateinit var characterSkills: Skills

    @EpoxyAttribute
    lateinit var skillModifier: String

    override fun bind(holder: ViewHolder) {
        super.bind(holder)

        holder.skillTitle.text = characterSkills.title
        holder.skillTotal.text = skillModifier
    }

    class ViewHolder : KotlinEpoxyHolder() {
        val skillTitle by bind<TextView>(R.id.character_skill_title)
        val skillTotal by bind<TextView>(R.id.character_skill_total)
    }
}