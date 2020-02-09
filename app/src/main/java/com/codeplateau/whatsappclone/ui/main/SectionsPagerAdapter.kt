package com.codeplateau.whatsappclone.ui.main

import android.content.Context
import androidx.core.content.res.TypedArrayUtils.getString
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.codeplateau.whatsappclone.R
import com.codeplateau.whatsappclone.ui.main.fragments.CallsFragment
import com.codeplateau.whatsappclone.ui.main.fragments.ChatsFragement
import com.codeplateau.whatsappclone.ui.main.fragments.StatusFragment


class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).

        var fragment: Fragment? = null
        if (position == 0) {
            fragment = ChatsFragement()
        } else if (position == 1) {
            fragment = StatusFragment()
        } else if (position == 2) {
            fragment = CallsFragment()
        }
        return fragment!!

    }

    override fun getPageTitle(position: Int): CharSequence? {
        var title: String? = null
        if (position == 0) {
            title = "chats"
        } else if (position == 1) {
            title = "Status"
        } else if (position == 2) {
            title = "Calls"
        }
        return title
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 3
    }
}