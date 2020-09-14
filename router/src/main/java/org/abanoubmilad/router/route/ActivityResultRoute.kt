package org.abanoubmilad.router.route

import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

class ActivityResultRoute(
    private val code: Int, activityClass: Class<*>,
    intentSetter: ((Intent) -> Unit)? = null
) : ActivityRoute(activityClass, intentSetter) {
    override fun runOn(runner: Fragment) {
        runner.activity?.let {
            // let the fragment start the activity for result (IMPORTANT)
            runner.startActivityForResult(createIntent(it), code)
        }
    }

    override fun runOn(runner: FragmentActivity) {
        runner.startActivityForResult(createIntent(runner), code)
    }
}

