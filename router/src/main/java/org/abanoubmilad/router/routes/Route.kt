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

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

abstract class Route {
    open fun runOn(runner: Fragment) {
        runner.activity?.let { activity ->
            runOn(activity)
        }

    }

    abstract fun runOn(runner: FragmentActivity)
}