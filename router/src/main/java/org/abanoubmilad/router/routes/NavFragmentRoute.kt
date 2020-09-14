package org.abanoubmilad.router.routes

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import org.abanoubmilad.labyrinth.INavHolder

class NavFragmentRoute<T : Fragment>(
    private val navTabIndex: Int? = null,
    fragmentClass: Class<T>,
    bundleSetter: ((Bundle) -> Unit)? = null
) : FragmentRoute<T>(fragmentClass, bundleSetter) {

    override fun runOn(runner: FragmentActivity) {
        if (navTabIndex == null) {
            (runner as? INavHolder)?.getINav()?.navigate(buildFragment(), buildBundle())
        } else {
            (runner as? INavHolder)?.getINav()?.navigate(
                navTabIndex,
                fragmentToPush = buildFragment(),
                bundle = buildBundle()
            )
        }
    }
}