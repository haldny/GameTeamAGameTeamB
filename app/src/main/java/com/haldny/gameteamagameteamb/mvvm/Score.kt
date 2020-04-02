package com.haldny.gameteamagameteamb.mvvm

data class Score(var teamA: Int = 0, var teamB: Int = 0) {

    fun incrementTeamA() {
        teamA += 1
    }

    fun incrementTeamB() {
        teamB += 1
    }

    fun reset() {
        teamA = 0
        teamB = 0
    }

}