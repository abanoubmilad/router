package org.abanoubmilad.router

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

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
    }
}