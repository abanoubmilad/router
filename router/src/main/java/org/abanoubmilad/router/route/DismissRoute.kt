package org.abanoubmilad.router.route

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import org.abanoubmilad.labyrinth.INav

class DismissRoute(
    private val clearAllTop: Boolean? = null
) : Route() {
    override fun runOn(runner: Fragment) {
        runner.activity?.let { activity ->
            runOn(activity)
        }

    }

    override fun runOn(runner: FragmentActivity) {
        if (clearAllTop == null)
            (runner as? INav)?.dismiss()
        else
            (runner as? INav)?.dismiss(clearAllTop = clearAllTop)
    }
}