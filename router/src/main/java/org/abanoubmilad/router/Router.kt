package org.abanoubmilad.router

import androidx.lifecycle.LiveData
import org.abanoubmilad.router.routes.Route


class Router {

    private val _route =
        SingleLiveEvent<Route>()
    val route: LiveData<Route> = _route

    fun routeTo(route: Route) {
        _route.value = route
    }
}

