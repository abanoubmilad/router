package org.abanoubmilad.router.routes

import androidx.fragment.app.FragmentActivity
import org.abanoubmilad.router.startActivityOfUri

class UriRoute(private val uri: String?) : Route() {
    override fun runOn(runner: FragmentActivity) {
        runner.startActivityOfUri(uri)
    }
}