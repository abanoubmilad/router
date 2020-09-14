package org.abanoubmilad.router.routes

import androidx.fragment.app.FragmentActivity
import org.abanoubmilad.labyrinth.INavHolder

// bottom nav tab
class NavTabRoute(
    private val navTabIndex: Int,
    private val clearAllTop: Boolean? = null
) : Route() {
    override fun runOn(runner: FragmentActivity) {
        if (clearAllTop == null) {
            (runner as? INavHolder)?.getINav()?.navigate(navTabIndex)
        } else {
            (runner as? INavHolder)?.getINav()?.navigate(navTabIndex, clearAllTop = clearAllTop)
        }
    }
}