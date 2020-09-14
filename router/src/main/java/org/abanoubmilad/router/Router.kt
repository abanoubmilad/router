package org.abanoubmilad.router

import androidx.lifecycle.LiveData


class Router {

    private val _router =
        SingleLiveEvent<Route>()
    val router: LiveData<Route> = _router

    fun routeTo(route: Route) {
        _router.value = route
    }
}

