package com.haldny.gameteamagameteamb

class Presenter(val activity: IMainActivity) : IPresenter {

    val score: Score = Score()

    override fun teamAClick() {
        score.incrementTeamA()
        notifyActivity()
    }

    override fun teamBClick() {
        score.incrementTeamB()
        notifyActivity()
    }

    override fun resetClick() {
        score.reset()
        notifyActivity()
    }

    override fun updateModel(teamA: String?, teamB: String?) {
        if (teamA != null) {
            score.teamA = teamA.toInt()
        }

        if (teamB != null) {
            score.teamB = teamB.toInt()
        }

        notifyActivity()
    }

    private fun notifyActivity() {
        activity.updateTeamScore(score.teamA.toString(), score.teamB.toString())
    }
}