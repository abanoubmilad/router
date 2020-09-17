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
import androidx.fragment.app.FragmentActivity

open class ActivityRoute(
    private val activityClass: Class<*>,
    private val intentSetter: ((Intent) -> Unit)? = null,
    private val performFinish: Boolean = false
) : Route() {

    fun createIntent(runner: FragmentActivity): Intent {
        val intent = Intent(runner, activityClass)
        intentSetter?.invoke(intent)
        return intent
    }

    override fun runOn(runner: FragmentActivity) {
        runner.startActivity(createIntent(runner))
        if (performFinish)
            runner.finish()
    }
}