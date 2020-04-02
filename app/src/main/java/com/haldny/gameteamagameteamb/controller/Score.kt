package com.haldny.gameteamagameteamb.controller

data class Score(val notification: INotification, var teamA: Int = 0, var teamB: Int = 0) {

    fun incrementTeamA() {
        teamA += 1
        notifyView()
    }

    fun incrementTeamB() {
        teamB += 1
        notifyView()
    }

    fun reset() {
        teamA = 0
        teamB = 0
        notifyView()
    }

    private fun notifyView() {
        notification.notify(teamA.toString(), teamB.toString())
    }
}