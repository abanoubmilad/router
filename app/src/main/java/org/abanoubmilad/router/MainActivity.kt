package org.abanoubmilad.router

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
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

        viewModel.msg.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })

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

        btn_open_activity.setOnClickListener {
            viewModel.onOpenActivityClicked()
        }

        btn_open_activity_for_result.setOnClickListener {
            viewModel.onOpenActivityForResultClicked()
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        viewModel.onActivityResult(requestCode, resultCode, data)
    }
}