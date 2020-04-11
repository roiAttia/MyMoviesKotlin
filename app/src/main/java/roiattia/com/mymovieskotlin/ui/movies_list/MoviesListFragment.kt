package roiattia.com.mymovieskotlin.ui.movies_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView

import roiattia.com.mymovieskotlin.R
import roiattia.com.mymovieskotlin.utils.Constants.Companion.POPULAR
import roiattia.com.mymovieskotlin.utils.Constants.Companion.SORT_DESC

class MoviesListFragment : Fragment() {

    private val viewModel: MoviesListViewModel by activityViewModels()
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_movies_list, container, false)
        recyclerView = rootView.findViewById(R.id.rv)

        val itemDecor = GridItemDecoration()
        recyclerView.addItemDecoration(itemDecor)

        viewModel.fetchMovies(POPULAR, SORT_DESC)
        viewModel.getMoviesLiveData().observe(viewLifecycleOwner, Observer {
            val moviesAdapter = MoviesAdapter(requireContext(), it)
            recyclerView.adapter = moviesAdapter
        })
        return rootView
    }
}
