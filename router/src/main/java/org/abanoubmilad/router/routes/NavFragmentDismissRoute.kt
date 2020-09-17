/*
 * *
 *  * Created by Abanoub Milad Nassief Hanna
 *  * on 8/15/20 5:24 PM
 *  * Last modified 8/14/20 5:51 PM
 *
 */
/*
 * *
 *  * Created by Abanoub Milad Nassief Hanna
 *  * on 8/15/20 5:24 PM
 *  * Last modified 8/14/20 5:51 PM
 *
 */
package org.abanoubmilad.router.routes

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import org.abanoubmilad.labyrinth.INavHolder

class NavFragmentDismissRoute<T : Fragment>(
    fragmentClass: Class<T>,
    bundleSetter: ((Bundle) -> Unit)? = null
) : FragmentRoute<T>(fragmentClass, bundleSetter) {
    override fun runOn(runner: FragmentActivity) {
        (runner as? INavHolder)?.getINav()?.dismissThenNavigate(buildFragment(), buildBundle())
    }
}