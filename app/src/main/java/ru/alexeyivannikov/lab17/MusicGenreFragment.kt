package ru.alexeyivannikov.lab17

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.alexeyivannikov.lab17.databinding.FragmentMusicGenreBinding

class MusicGenreFragment : Fragment() {
    private var _binding: FragmentMusicGenreBinding? = null
    private val binding: FragmentMusicGenreBinding
        get() = _binding ?: throw RuntimeException()

    private lateinit var genre: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = requireArguments()
        genre = args.getString(KEY_GENRE) ?: throw RuntimeException()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMusicGenreBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.tvMusicGenre.text = genre
    }

    companion object {
        private const val KEY_GENRE = "genre"

        fun newFragment(genre: MusicGenre): MusicGenreFragment {
            return MusicGenreFragment().apply {
                arguments = Bundle().apply {
                    putString(KEY_GENRE, genre.name)
                }
            }
        }
    }
}