package org.abanoubmilad.router

import androidx.lifecycle.ViewModel
import org.abanoubmilad.router.routes.ActivityRoute
import org.abanoubmilad.router.routes.ChromeTabRoute
import org.abanoubmilad.router.routes.PlayStoreRoute
import org.abanoubmilad.router.routes.UriRoute

class MainViewModel : ViewModel() {
    val router = Router()


    fun onGithubChromeTabClicked() {
        /*
        *   create a route to start a chrome tab
        */
        router.routeTo(ChromeTabRoute("https://github.com/abanoubmilad"))
    }

    fun onGithubUriClicked() {
        /*
        *   create a route to view uri
        */
        router.routeTo(UriRoute("https://github.com/abanoubmilad"))
    }

    fun onPlayStoreClicked() {
        /*
        *   create a route to view an app on play store
        */
        router.routeTo(PlayStoreRoute("abanoubm.dayra"))
    }

    fun onOpenActivityClicked() {
        /*
    *   create a route to open activity
    */
        router.routeTo(ActivityRoute(SecondActivity::class.java))
    }
}