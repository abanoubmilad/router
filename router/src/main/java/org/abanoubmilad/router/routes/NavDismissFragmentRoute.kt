package org.abanoubmilad.router.routes

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import org.abanoubmilad.labyrinth.INavHolder

class NavDismissFragmentRoute<T : Fragment>(
    fragmentClass: Class<T>,
    bundleSetter: ((Bundle) -> Unit)? = null
) : FragmentRoute<T>(fragmentClass, bundleSetter) {
    override fun runOn(runner: FragmentActivity) {
        (runner as? INavHolder)?.getINav()?.dismissThenNavigate(buildFragment(), buildBundle())
    }
}