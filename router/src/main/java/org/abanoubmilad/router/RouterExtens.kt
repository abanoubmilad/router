package org.abanoubmilad.router

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer

fun FragmentActivity.listenToRouter(router: Router) {
    router.route.observe(this, Observer {
        it.runOn(this)
    })
}

fun Fragment.listenToRouter(router: Router) {
    router.route.observe(viewLifecycleOwner, Observer {
        it.runOn(this)
    })
}

fun Context?.startChromeTab(url: String?) {
    if (this == null || url.isNullOrBlank())
        return
    try {
        CustomTabsIntent.Builder()
            .setToolbarColor(
                ContextCompat.getColor(
                    this,
                    R.color.colorAccent
                )
            )
            .addDefaultShareMenuItem().setShowTitle(true)
            .build().launchUrl(this, Uri.parse(url))
    } catch (e: ActivityNotFoundException) {
        startActivityOfUri(url)
    }
}

fun Fragment.startChromeTab(url: String?) {
    context?.startChromeTab(url)
}


fun Context.startActivityOfUri(url: String?, onActivityNotFound: (() -> Unit)? = null) {
    if (url.isNullOrBlank()) return
    try {
        startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse(url)
            )
        )
    } catch (_: ActivityNotFoundException) {
        onActivityNotFound?.invoke()
    }
}

fun Intent.addActivitiesPurgeFlags() {
    addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
    addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
}






