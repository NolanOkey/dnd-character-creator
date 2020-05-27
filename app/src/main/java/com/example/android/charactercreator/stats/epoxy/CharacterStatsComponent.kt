package com.example.android.charactercreator.stats.epoxy

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.android.charactercreator.R
import com.example.android.charactercreator.epoxy.KotlinEpoxyHolder
import com.example.android.charactercreator.fuaxdata.FauxAbilitySkillStats
import com.example.android.charactercreator.stats.CharacterStatsClickAction
import com.example.android.charactercreator.stats.ClickActionHandler

@EpoxyModelClass(layout = R.layout.view_character_attribute)
abstract class CharacterStatsComponent : EpoxyModelWithHolder<CharacterStatsComponent.ViewHolder>() {

    private val controller = CharacterSkillsController()

    @EpoxyAttribute
    lateinit var characterAttribute: FauxAbilitySkillStats

    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    lateinit var clickAction: ClickActionHandler

    override fun bind(holder: ViewHolder) {
        super.bind(holder)

        holder.statsRecyclerView.adapter = controller.adapter
        controller.setData(characterAttribute.skills, characterAttribute.modifier())

        holder.statTitle.text = characterAttribute.javaClass.simpleName
        holder.statTotal.text = characterAttribute.attributeTotal
        holder.statModifier.text = characterAttribute.modifier()

        holder.container.setOnClickListener { clickAction(CharacterStatsClickAction.StatsAction) }
    }

    class ViewHolder : KotlinEpoxyHolder() {
        val statTitle by bind<TextView>(R.id.character_stat_title)
        val statTotal by bind<TextView>(R.id.character_stat_total)
        val statModifier by bind<TextView>(R.id.character_stat_modifier)
        val container by bind<View>(R.id.character_stat_container)
        val statsRecyclerView by bind<RecyclerView>(R.id.character_skill_cell)
    }
}