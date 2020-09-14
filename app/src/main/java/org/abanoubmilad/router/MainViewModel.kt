package org.abanoubmilad.router

import android.app.Activity
import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import org.abanoubmilad.router.routes.*

class MainViewModel : ViewModel() {
    val router = Router()
    private val requestCode = 101

    private val _msg =
        SingleLiveEvent<String>()
    val msg: LiveData<String> = _msg

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

    fun onOpenActivityForResultClicked() {
        /*
        *   create a route to open activity for result
        */
        router.routeTo(ActivityForResultRoute(requestCode, SecondActivity::class.java))
    }

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == this.requestCode) {
            if (resultCode == Activity.RESULT_OK) {
                data?.getStringExtra("msg")?.let {
                    _msg.postValue(it)
                }
            } else {
                _msg.postValue("Result is canceled")
            }
        }

    }
}