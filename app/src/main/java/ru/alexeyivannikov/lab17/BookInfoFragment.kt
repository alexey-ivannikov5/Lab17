package ru.alexeyivannikov.lab17

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.alexeyivannikov.lab17.databinding.FragmentBookInfoBinding


class BookInfoFragment : Fragment() {

    private var _binding: FragmentBookInfoBinding? = null
    private val binding: FragmentBookInfoBinding
        get() = _binding ?: throw RuntimeException()

    private lateinit var mode: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = requireArguments()
        mode = args.getString(KEY_FRAGMENT_TYPE) ?: NEW_MODE
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBookInfoBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.tvBooksStatus.text = if (mode == READ_MODE) "Прочитанные" else "Новые"
    }

    companion object {
        private val KEY_FRAGMENT_TYPE = "type"
        const val READ_MODE = "read"
        const val NEW_MODE = "unread"
        fun newFragment(mode: String): BookInfoFragment {
            if (mode != READ_MODE && mode != NEW_MODE) {
                throw RuntimeException()
            }
            return BookInfoFragment().apply {
                arguments = Bundle().apply {
                    putString(KEY_FRAGMENT_TYPE, mode)
                }
            }
        }
    }
}