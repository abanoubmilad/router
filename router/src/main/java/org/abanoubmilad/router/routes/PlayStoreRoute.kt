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

import androidx.fragment.app.FragmentActivity
import org.abanoubmilad.router.startActivityOfUri

class PlayStoreRoute(private val applicationId: String) : Route() {
    override fun runOn(runner: FragmentActivity) {
        runner.startActivityOfUri("market://details?id=${applicationId}",
            onActivityNotFound = {
                runner.startActivityOfUri("https://play.google.com/store/apps/details?id=${applicationId}")
            }
        )
    }
}