package org.abanoubmilad.router.route

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

abstract class Route {
    abstract fun runOn(runner: Fragment)
    abstract fun runOn(runner: FragmentActivity)
}