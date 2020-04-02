package com.haldny.gameteamagameteamb

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.haldny.gameteamagameteamb.controller.Controller
import com.haldny.gameteamagameteamb.controller.INotification

class MainMVCActivity : AppCompatActivity(), View.OnClickListener, INotification {

    private lateinit var buttonTeamA: Button
    private lateinit var buttonTeamB: Button
    private lateinit var buttonReset: Button
    private lateinit var textViewTeamA: TextView
    private lateinit var textViewTeamB: TextView
    private lateinit var controller: Controller

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initController()
    }

    private fun initViews() {
        buttonTeamA = findViewById(R.id.buttonTeamA)
        buttonTeamB = findViewById(R.id.buttonTeamB)
        buttonReset = findViewById(R.id.buttonReset)

        textViewTeamA = findViewById(R.id.textTeamA)
        textViewTeamB = findViewById(R.id.textTeamB)

        buttonReset.setOnClickListener(this)
        buttonTeamB.setOnClickListener(this)
        buttonTeamA.setOnClickListener(this)
    }

    private fun initController() {
        controller = Controller(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.buttonTeamA -> {
                controller.teamAClick()
            }
            R.id.buttonTeamB -> {
                controller.teamBClick()
            }
            R.id.buttonReset -> {
                controller.resetClick()
            }
        }
    }

    override fun notify(teamAScore: String, teamBScore: String) {
        textViewTeamA.text = teamAScore
        textViewTeamB.text = teamBScore
    }
}