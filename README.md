Router
======

A clean quick to use MVVM Router

MIT License - Copyright (c) 2020 Abanoub Milad Nassief Hanna\
abanoubcs@gmail.com\
[@Linkedin](https://www.linkedin.com/in/abanoubmilad/)\
[@Github](https://github.com/abanoubmilad)



<p align="center">
  <img src="readme_res/router.jpg" width="500">
</p>

How to add
==========

Add to project level `build.gradle`

```Groovy

allprojects {
    repositories {

        maven { url "https://jitpack.io" }
        
    }
}
```

Add to app level `build.gradle`

```Groovy
    dependencies {

        implementation 'com.github.abanoubmilad:router:0.3'
        
    }
```

How to use
==========

```kotlin
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

class MainViewModel : ViewModel() {
    val router = Router()


    fun onGithubChromeTabClicked() {
        /*
        *   create a route to start a chrome tab
        */
        router.routeTo(ChromeTabRoute("https://github.com/abanoubmilad"))
    }

    fun onGithubUriClicked() {
        /*
        *   create a route to view uri
        */
        router.routeTo(UriRoute("https://github.com/abanoubmilad"))
    }

    fun onPlayStoreClicked() {
        /*
        *   create a route to view an app on play store
        */
        router.routeTo(PlayStoreRoute("abanoubm.dayra"))
    }
}

```



Custom Routes
=============

You can easily add your own custom routes by extending the abstract Route class
and implementing the runOn funs

```kotlin
abstract class Route {
    open fun runOn(runner: Fragment) {
        runner.activity?.let { activity ->
            runOn(activity)
        }

    }

    abstract fun runOn(runner: FragmentActivity)
}
```



Ready to use routes
===================

```kotlin
   /*
    *   starts an activity that can action view this uri
    *   or intent chooser depending on the user's installed apps
    *   if uri is empty or no activity found nothing happens
    *
    */
class UriRoute(private val uri: String?)

   /*
    *   starts play store displaying the app with that specific applicationId
    *   or intent chooser depending on the user's installed apps
    *   if no activity found nothing happens
    *
    */
class PlayStoreRoute(private val applicationId: String)

   /*
    *   starts chrome tab displaying URL
    *   or intent chooser depending on the user's installed apps
    *   if url is empty or no activity found nothing happens
    *
    */
class ChromeTabRoute(
    private val url: String?
) 

   /*
    *   starts an activity specified by its class
    *   intentSetter: sets any flags or data to the intent
    *   performFinish: if true finished the current activity
    *
    */
class ActivityRoute(
    private val activityClass: Class<*>,
    private val intentSetter: ((Intent) -> Unit)? = null,
    private val performFinish: Boolean = false
)

   /*
    *   starts an activity for result specified by its class
    *   requestCode: the required request code
    *   intentSetter: sets any flags or data to the intent
    *
    */
class ActivityForResultRoute(
    private val requestCode: Int, activityClass: Class<*>,
    intentSetter: ((Intent) -> Unit)? = null
)

  /*
    *   starts a dialog fragment or bottom sheet fragment specified by its class
    *   (any fragment class that is DialogFragment or a child of it)
    *   bundleSetter: sets any data to the bundle
    *
    */
open class FragmentRoute<T : Fragment>(
    private val fragmentClass: Class<T>,
    private val bundleSetter: ((Bundle) -> Unit)? = null
)

  /*
    *   finishes the current activity
    *
    */
class DismissActivityRoute : Route() {
    override fun runOn(runner: FragmentActivity) {
        runner.finish()
    }
}

  /*
    *   finishes the current activity
    *   and sets the activity result
    *   resultCode : Standard activity result default is RESULT_OK operation succeeded
    *   intentSetter: sets any result data to the intent
    * 
    */
class DismissActivityForResultRoute(
    private val resultCode: Int = Activity.RESULT_OK,
    private val intentSetter: ((Intent) -> Unit)? = null
) 
```
  

Labyrinth routes
===================

these routes take effect only if the activity is implements the INavHolder
For more info check [@Github](https://github.com/abanoubmilad/Labyrinth)
    
  
  
```kotlin
    /*
    *   nav to a specific bottom navigation tab
    *   navTabIndex: tab index 0-indexed
    *   clearAllTop: clear all fragments in that tab (root tab fragment is not cleared)
    *
    */      
class NavTabRoute(
    private val navTabIndex: Int,
    private val clearAllTop: Boolean? = null
)


    /*
    *   for the current navigation tab
    *   dismiss the current fragment 
    *   bundleSetter: sets any data to the bundle
    *
    */   
class DismissRoute(
    private val clearAllTop: Boolean? = null
) 


    /*
    *   if navTabIndex is passed nav to a specific bottom navigation tab specified by navTabIndex
    *   else use the current navigation tab
    *   then push the fragment specified by its class into tab
    *   navTabIndex: tab index 0-indexed
    *   bundleSetter: sets any data to the bundle
    *
    */      
class NavFragmentRoute<T : Fragment>(
    private val navTabIndex: Int? = null,
    fragmentClass: Class<T>,
    bundleSetter: ((Bundle) -> Unit)? = null
)

    /*
    *   for the current navigation tab
    *   dismiss the current fragment and 
    *   push the fragment specified by its class into navigation tab
    *   bundleSetter: sets any data to the bundle
    *
    */   
class NavFragmentDismissRoute<T : Fragment>(
    fragmentClass: Class<T>,
    bundleSetter: ((Bundle) -> Unit)? = null
)


```