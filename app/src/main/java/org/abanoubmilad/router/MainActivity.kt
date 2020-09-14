package org.abanoubmilad.router

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
         *   listen to router
         */
        listenToRouter(viewModel.router)

        /*
        *   handle click event
        *   or use data binding
        */

        btn_github_chrome_tab.setOnClickListener {
            viewModel.onGithubChromeTabClicked()
        }

        btn_github_uri.setOnClickListener {
            viewModel.onGithubUriClicked()
        }

        btn_play_store.setOnClickListener {
            viewModel.onPlayStoreClicked()
        }
    }
}