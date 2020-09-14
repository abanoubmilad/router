package org.abanoubmilad.router.route

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

class PlayStoreRoute(private val applicationId: String) : Route() {
    private fun createPlayStoreAppIntent(): Intent {
        return Intent(
            Intent.ACTION_VIEW,
            Uri.parse("market://details?id=${applicationId}")
        )

    }

    private fun createBrowserIntent(): Intent {
        return Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://play.google.com/store/apps/details?id=${applicationId}")
        )
    }

    override fun runOn(runner: Fragment) {
        runner.activity?.let { activity ->
            runOn(activity)
        }
    }

    override fun runOn(runner: FragmentActivity) {
        try {
            runner.startActivity(createPlayStoreAppIntent())
        } catch (e: ActivityNotFoundException) {
            runner.startActivity(createBrowserIntent())

        }
    }
}