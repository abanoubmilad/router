/*
 * *
 *  * Created by Abanoub Milad Nassief Hanna
 *  * on 8/15/20 5:24 PM
 *  * Last modified 8/14/20 5:51 PM
 *
 */
package org.abanoubmilad.router

import android.app.Activity
import androidx.lifecycle.ViewModel
import org.abanoubmilad.router.routes.DismissActivityForResultRoute
import org.abanoubmilad.router.routes.DismissActivityRoute

class SecondViewModel : ViewModel() {
    val router = Router()

    fun onFinishActivityClicked() {
        router.routeTo(DismissActivityRoute())
    }

    fun onFinishActivityWithResultOkClicked() {
        router.routeTo(DismissActivityForResultRoute(intentSetter = { intent ->
            intent.putExtra("msg", "You have successfully got the result code")
        }))
    }

    fun onFinishActivityWithResultCanceledClicked() {
        router.routeTo(DismissActivityForResultRoute(resultCode = Activity.RESULT_CANCELED))
    }

}