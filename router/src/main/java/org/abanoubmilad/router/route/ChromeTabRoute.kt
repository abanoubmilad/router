package org.abanoubmilad.router.route

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import org.abanoubmilad.router.startChromeTab

class ChromeTabRoute(
    private val url: String?
) : Route() {
    override fun runOn(runner: Fragment) {
        runner.startChromeTab(url)
    }

    override fun runOn(runner: FragmentActivity) {
        runner.startChromeTab(url)
    }
}