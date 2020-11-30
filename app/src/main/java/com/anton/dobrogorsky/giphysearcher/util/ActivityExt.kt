package com.anton.dobrogorsky.giphysearcher.util

import androidx.fragment.app.Fragment
import com.anton.dobrogorsky.giphysearcher.R
import com.anton.dobrogorsky.giphysearcher.flow.main.MainActivity

val Fragment.mainActivity: MainActivity?
    get() = activity as? MainActivity

fun MainActivity.replaceFragment(fragment: Fragment) {
    supportFragmentManager.beginTransaction()
        .replace(R.id.main_fragment_container, fragment, fragment.tag)
        .addToBackStack(fragment.tag)
        .commitAllowingStateLoss()
}