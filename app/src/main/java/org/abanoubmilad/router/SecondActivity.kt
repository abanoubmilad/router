/*
 * *
 *  * Created by Abanoub Milad Nassief Hanna
 *  * on 8/15/20 5:24 PM
 *  * Last modified 8/14/20 5:51 PM
 *
 */
package org.abanoubmilad.router

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    private val viewModel: SecondViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        /*
         *   listen to router
         */
        listenToRouter(viewModel.router)

        /*
        *   handle click event
        *   or use data binding
        */
        btn_finish_activity.setOnClickListener {
            viewModel.onFinishActivityClicked()
        }

        btn_finish_activity_with_result_ok.setOnClickListener {
            viewModel.onFinishActivityWithResultOkClicked()
        }
        btn_finish_activity_with_result_canceled.setOnClickListener {
            viewModel.onFinishActivityWithResultCanceledClicked()
        }
    }
}