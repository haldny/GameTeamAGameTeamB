package com.haldny.gameteamagameteamb.controller

class Controller(private val notification: INotification) {

    private val score: Score = Score(notification)

    fun teamAClick() {
        score.incrementTeamA()
    }

    fun teamBClick() {
        score.incrementTeamB()
    }

    fun resetClick() {
        score.reset()
    }

}