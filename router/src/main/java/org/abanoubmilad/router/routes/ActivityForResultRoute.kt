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

