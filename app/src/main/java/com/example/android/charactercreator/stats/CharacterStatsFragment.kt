package com.example.android.charactercreator.stats

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.charactercreator.R
import com.example.android.charactercreator.fuaxdata.FauxAbilitySkillStats
import com.example.android.charactercreator.room.Character
import com.example.android.charactercreator.stats.epoxy.CharacterStatsController
import kotlinx.android.synthetic.main.fragment_character_stats.*

typealias ClickActionHandler = (action: CharacterStatsClickAction) -> Unit

private const val PROFICIENCY = 2

class CharacterStatsFragment : Fragment() {

    lateinit var controller: CharacterStatsController
    private lateinit var viewModel: CharacterStatsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = CharacterStatsViewModel()
        return inflater.inflate(R.layout.fragment_character_stats, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        controller = CharacterStatsController()
        renderView()
    }

    private fun renderView() {
        stat_recyclerview.layoutManager = LinearLayoutManager(context)
        stat_recyclerview.adapter = controller.adapter
        controller.setData(viewModel.fetchViewState(), callBack)
    }

    private val callBack: ClickActionHandler = { action ->
        when(action) {
            CharacterStatsClickAction.StatsAction -> {
                val statBottomSheet = StatEditorBottomSheet()
                statBottomSheet.show(fragmentManager!!, StatEditorBottomSheet::class.simpleName)
            }
        }
    }
}

sealed class CharacterStatsClickAction {
    object StatsAction : CharacterStatsClickAction()
}