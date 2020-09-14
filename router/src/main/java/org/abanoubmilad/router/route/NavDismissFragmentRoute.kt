package org.abanoubmilad.router.route

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import org.abanoubmilad.labyrinth.INav

class NavDismissFragmentRoute<T : Fragment>(
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
        (runner as? INav)?.dismissThenNavigate(fragment, buildBundle())
    }
}