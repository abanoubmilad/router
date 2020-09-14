package org.abanoubmilad.router.routes

import androidx.fragment.app.FragmentActivity
import org.abanoubmilad.labyrinth.INavHolder

class DismissRoute(
    private val clearAllTop: Boolean? = null
) : Route() {
    override fun runOn(runner: FragmentActivity) {
        if (clearAllTop == null)
            (runner as? INavHolder)?.getINav()?.dismiss()
        else
            (runner as? INavHolder)?.getINav()?.dismiss(clearAllTop = clearAllTop)
    }
}