package com.haldny.gameteamagameteamb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), IMainActivity, View.OnClickListener {

    private lateinit var buttonTeamA: Button
    private lateinit var buttonTeamB: Button
    private lateinit var buttonReset: Button
    private lateinit var textViewTeamA: TextView
    private lateinit var textViewTeamB: TextView

    private lateinit var presenter: IPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initPresenter()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString("teamA", textViewTeamA.text.toString())
        outState.putString("teamB", textViewTeamB.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val teamA = savedInstanceState.getString("teamA")
        val teamB = savedInstanceState.getString("teamB")

        if (presenter == null) {
            initPresenter()
        }

        presenter.updateModel(teamA, teamB)
    }

    private fun initPresenter() {
        presenter = Presenter(this)
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

    override fun updateTeamScore(scoreTeamA: String, scoreTeamB: String) {
        textViewTeamA.text = scoreTeamA
        textViewTeamB.text = scoreTeamB
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.buttonTeamA -> {
                presenter.teamAClick()
            }
            R.id.buttonTeamB -> {
                presenter.teamBClick()
            }
            R.id.buttonReset -> {
                presenter.resetClick()
            }
        }
    }

}
