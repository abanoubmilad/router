package org.abanoubmilad.router.routes

import androidx.fragment.app.FragmentActivity
import org.abanoubmilad.router.startChromeTab

class ChromeTabRoute(
    private val url: String?
) : Route() {
    override fun runOn(runner: FragmentActivity) {
        runner.startChromeTab(url)
    }
}