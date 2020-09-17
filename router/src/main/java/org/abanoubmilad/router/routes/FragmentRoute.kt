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
package org.abanoubmilad.router.routes

import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

open class FragmentRoute<T : Fragment>(
    private val fragmentClass: Class<T>,
    private val bundleSetter: ((Bundle) -> Unit)? = null
) : Route() {

    fun buildFragment(): Fragment = fragmentClass.newInstance()
    fun buildBundle(): Bundle? {
        if (bundleSetter == null) return null
        val bundle = Bundle()
        bundleSetter.invoke(bundle)
        return bundle
    }


    override fun runOn(runner: Fragment) {
        val fragment = buildFragment()
        fragment.arguments = buildBundle()
        when (fragment) {
            is DialogFragment -> fragment.show(runner.childFragmentManager, null)
        }

    }

    override fun runOn(runner: FragmentActivity) {
        val fragment = buildFragment()
        fragment.arguments = buildBundle()
        when (fragment) {
            is DialogFragment -> fragment.show(runner.supportFragmentManager, null)
        }

    }
}