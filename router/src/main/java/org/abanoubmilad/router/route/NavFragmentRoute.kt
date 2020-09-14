package org.abanoubmilad.router.route

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import org.abanoubmilad.labyrinth.INav

class NavFragmentRoute<T : Fragment>(
    private val navTabIndex: Int? = null,
    fragmentClass: Class<T>,
    bundleSetter: ((Bundle) -> Unit)? = null
) : FragmentRoute<T>(fragmentClass, bundleSetter) {
    override fun runOn(runner: Fragment) {
        runner.activity?.let { activity ->
            runOn(activity)
        }
    }

    override fun runOn(runner: FragmentActivity) {
        val fragment = buildFragment()
        if (navTabIndex == null)
            (runner as? INav)?.navigate(fragment, buildBundle())
        else
            (runner as? INav)?.navigate(
                navTabIndex,
                fragmentToPush = fragment,
                bundle = buildBundle()
            )
    }
}