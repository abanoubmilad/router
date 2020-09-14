package org.abanoubmilad.router.routes

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import org.abanoubmilad.labyrinth.INav

class NavFragmentRoute<T : Fragment>(
    private val navTabIndex: Int? = null,
    fragmentClass: Class<T>,
    bundleSetter: ((Bundle) -> Unit)? = null
) : FragmentRoute<T>(fragmentClass, bundleSetter) {

    override fun runOn(runner: FragmentActivity) {
        if (navTabIndex == null) {
            (runner as? INav)?.navigate(buildFragment(), buildBundle())
        } else {
            (runner as? INav)?.navigate(
                navTabIndex,
                fragmentToPush = buildFragment(),
                bundle = buildBundle()
            )
        }
    }
}