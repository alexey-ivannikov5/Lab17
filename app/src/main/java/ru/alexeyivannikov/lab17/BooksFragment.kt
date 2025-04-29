package ru.alexeyivannikov.lab17

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import ru.alexeyivannikov.lab17.databinding.FragmentBooksBinding


class BooksFragment : Fragment() {
    private var _binding: FragmentBooksBinding? = null
    private val binding: FragmentBooksBinding
        get() = _binding ?: throw RuntimeException()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBooksBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        childFragmentManager
            .beginTransaction()
            .replace(R.id.fcBook, BookInfoFragment.newFragment(BookInfoFragment.NEW_MODE))
            .commit()

        binding.tabsBooksStatus.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab?.position == 0) {
                    childFragmentManager
                        .beginTransaction()
                        .replace(
                            R.id.fcBook,
                            BookInfoFragment.newFragment(BookInfoFragment.NEW_MODE)
                        )
                        .commit()
                } else if (tab?.position == 1) {
                    childFragmentManager
                        .beginTransaction()
                        .replace(
                            R.id.fcBook,
                            BookInfoFragment.newFragment(BookInfoFragment.READ_MODE)
                        )
                        .commit()
                } else {
                    Toast.makeText(requireActivity(), "Error", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}

        })
    }
}