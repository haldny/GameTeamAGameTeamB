package com.haldny.gameteamagameteamb.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel() : ViewModel() {

    private val livedata: MutableLiveData<Score> = MutableLiveData()

    fun getScore() : MutableLiveData<Score> {
        return livedata
    }

    fun teamAClick() {
        var score = livedata.value
        if (score == null) {
            score = Score()
        }

        score.incrementTeamA()
        livedata.value = score
    }

    fun teamBClick() {
        var score = livedata.value
        if (score == null) {
            score = Score()
        }

        score.incrementTeamB()
        livedata.value = score
    }

    fun resetClick() {
        var score = livedata.value
        if (score == null) {
            score = Score()
        }

        score.reset()
        livedata.value = score
    }

}