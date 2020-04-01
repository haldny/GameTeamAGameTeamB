package com.haldny.gameteamagameteamb

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class PresenterTest {

    private lateinit var presenter: Presenter
    private lateinit var activity: IMainActivity
    private var result: Boolean = false

    @Before
    fun setUp() {
        activity = object: IMainActivity {
            override fun updateTeamScore(scoreTeamA: String, scoreTeamB: String) {
                result = true
            }
        }
        presenter = Presenter(activity)
    }

    @Test
    fun testClickTeamA() {
        presenter.teamAClick()
        Assert.assertEquals(1, presenter.score.teamA)
        Assert.assertEquals(0, presenter.score.teamB)
        Assert.assertTrue(result)
    }

    @Test
    fun testClickTeamB() {
        presenter.teamBClick()
        Assert.assertEquals(0, presenter.score.teamA)
        Assert.assertEquals(1, presenter.score.teamB)
        Assert.assertTrue(result)
    }

    @Test
    fun testTwoClickTeamBOneClickTeamA() {
        presenter.teamBClick()
        presenter.teamBClick()
        presenter.teamAClick()
        Assert.assertEquals(1, presenter.score.teamA)
        Assert.assertEquals(2, presenter.score.teamB)
        Assert.assertTrue(result)
    }
}