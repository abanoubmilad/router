package org.abanoubmilad.router.routes

import androidx.fragment.app.FragmentActivity

class DismissActivityRoute : Route() {
    override fun runOn(runner: FragmentActivity) {
        runner.finish()
    }
}