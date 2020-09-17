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

import android.app.Activity
import android.content.Intent
import androidx.fragment.app.FragmentActivity

class DismissActivityForResultRoute(
    private val resultCode: Int = Activity.RESULT_OK,
    private val intentSetter: ((Intent) -> Unit)? = null
) : Route() {
    override fun runOn(runner: FragmentActivity) {
        val intent = Intent()
        intentSetter?.invoke(intent)
        runner.setResult(resultCode, intent)
        runner.finish()
    }
}