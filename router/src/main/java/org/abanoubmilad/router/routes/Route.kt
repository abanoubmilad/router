package org.abanoubmilad.router.routes

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

abstract class Route {
    open fun runOn(runner: Fragment) {
        runner.activity?.let { activity ->
            runOn(activity)
        }

    }

    abstract fun runOn(runner: FragmentActivity)
}