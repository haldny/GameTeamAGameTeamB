package com.haldny.gameteamagameteamb

interface IPresenter {
    fun teamAClick()
    fun teamBClick()
    fun resetClick()
    fun updateModel(teamA: String?, teamB: String?)
}