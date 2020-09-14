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