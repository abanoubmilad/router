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
/*
 * *
 *  * Created by Abanoub Milad Nassief Hanna
 *  * on 8/15/20 5:24 PM
 *  * Last modified 8/14/20 5:51 PM
 *
 */
package org.abanoubmilad.router.routes

import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

class ActivityForResultRoute(
    private val requestCode: Int, activityClass: Class<*>,
    intentSetter: ((Intent) -> Unit)? = null
) : ActivityRoute(activityClass, intentSetter) {

    // (IMPORTANT) let the fragment start the activity for result
    override fun runOn(runner: Fragment) {
        runner.activity?.let {
            runner.startActivityForResult(createIntent(it), requestCode)
        }
    }

    override fun runOn(runner: FragmentActivity) {
        runner.startActivityForResult(createIntent(runner), requestCode)
    }
}

