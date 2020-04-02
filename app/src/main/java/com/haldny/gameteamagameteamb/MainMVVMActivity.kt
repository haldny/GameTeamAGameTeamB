package com.haldny.gameteamagameteamb

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.haldny.gameteamagameteamb.controller.Controller
import com.haldny.gameteamagameteamb.controller.INotification
import com.haldny.gameteamagameteamb.mvvm.MyViewModel

class MainMVVMActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var buttonTeamA: Button
    private lateinit var buttonTeamB: Button
    private lateinit var buttonReset: Button
    private lateinit var textViewTeamA: TextView
    private lateinit var textViewTeamB: TextView
    private lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initViewModel()

        viewModel.getScore().observe(this, Observer {
            notify(it.teamA.toString(), it.teamB.toString())
        })
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

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.buttonTeamA -> {
                viewModel.teamAClick()
            }
            R.id.buttonTeamB -> {
                viewModel.teamBClick()
            }
            R.id.buttonReset -> {
                viewModel.resetClick()
            }
        }
    }

    fun notify(teamAScore: String, teamBScore: String) {
        textViewTeamA.text = teamAScore
        textViewTeamB.text = teamBScore
    }
}