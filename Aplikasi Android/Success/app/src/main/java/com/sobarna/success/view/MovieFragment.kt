package com.sobarna.success.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sobarna.success.MyApplication
import com.sobarna.success.core.data.Resource
import com.sobarna.success.core.ui.ViewModelFactory
import com.sobarna.success.core.ui.adapter.MovieAdapter
import com.sobarna.success.databinding.FragmentMovieBinding
import com.sobarna.success.viewmodel.HomeViewModel
import javax.inject.Inject

class MovieFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelFactory

    private val homeViewModel: HomeViewModel by viewModels{
        factory
    }

    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding!!


    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as MyApplication).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val movieAdapter = MovieAdapter()
            movieAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }


            homeViewModel.useCase.observe(viewLifecycleOwner, { movie ->
                if (movie != null) {
                    when (movie) {
                        is Resource.Loading -> binding.pbMovie.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding.pbMovie.visibility = View.GONE
                            movieAdapter.setData(movie.data)
                        }
                        is Resource.Error -> {
                            binding.pbMovie.visibility = View.GONE
                            Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            with(binding.rvMovie) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
