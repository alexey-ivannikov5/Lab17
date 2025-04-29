package ru.alexeyivannikov.lab17

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class MusicViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun createFragment(position: Int): Fragment {
        return MusicGenreFragment.newFragment(MusicGenre.entries[position])
    }

    override fun getItemCount(): Int {
        return MusicGenre.entries.size
    }
}