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

        implementation 'com.github.abanoubmilad:router:0.1'
        
    }
```

How to use
==========

```kotlin
class CustomActivity : Activity {
  
    private val viewModel: CustomViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.example_activity)
        
        /*
        *   listen to router
        */
        listenToRouter(viewModel.router)

        /*
        *   handle click event 
        *   or use data binding
        */
        btn_website.setOnClickListener{
            viewModel.onWebsiteClicked()
        }
    }
}

class CustomViewModel : ViewModel {

    val router = Router()
    
    fun onWebsiteClicked(){
        /*
        *   create a route to start a chrome tab
        */
        router.routeTo(ChromeTabRoute("https://github.com/abanoubmilad"))
    }
  
}

```