package ru.alexeyivannikov.lab17

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import ru.alexeyivannikov.lab17.databinding.FragmentMusicBinding

class MusicFragment : Fragment() {
    private var _binding: FragmentMusicBinding? = null
    private val binding: FragmentMusicBinding
        get() = _binding ?: throw RuntimeException()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMusicBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.vpMusicGenre.adapter = MusicViewPagerAdapter(this)

        TabLayoutMediator(binding.tabGenres, binding.vpMusicGenre) { tab, position ->
            when (position) {
                0 -> tab.text = resources.getString(R.string.genre_pop)
                1 -> tab.text = resources.getString(R.string.genre_rock)
                2 -> tab.text = resources.getString(R.string.genre_jazz)
                3 -> tab.text = resources.getString(R.string.genre_blues)
                4 -> tab.text = resources.getString(R.string.genre_HipHop)
                5 -> tab.text = resources.getString(R.string.genre_funk)
                6 -> tab.text = resources.getString(R.string.genre_disco)
                7 -> tab.text = resources.getString(R.string.genre_reggy)
            }
        }.attach()
    }

}