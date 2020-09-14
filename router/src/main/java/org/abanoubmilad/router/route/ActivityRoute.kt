package org.abanoubmilad.router.route

import android.content.Intent
import androidx.fragment.app.Fragment
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

    override fun runOn(runner: Fragment) {
        runner.activity?.let {
            // let the fragment start the activity
            runner.startActivity(createIntent(it))
            if (performFinish)
                it.finish()
        }
    }

    override fun runOn(runner: FragmentActivity) {
        runner.startActivity(createIntent(runner))
        if (performFinish)
            runner.finish()
    }
}