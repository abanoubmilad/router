/*
 * *
 *  * Created by Abanoub Milad Nassief Hanna
 *  * on 8/15/20 5:24 PM
 *  * Last modified 8/14/20 5:51 PM
 *
 */
/*
 * *
 *  * Created by Abanoub Milad Nassief Hanna
 *  * on 8/15/20 5:24 PM
 *  * Last modified 8/14/20 5:51 PM
 *
 */
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

