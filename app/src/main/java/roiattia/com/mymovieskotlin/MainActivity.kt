package roiattia.com.mymovieskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import roiattia.com.mymovieskotlin.databinding.ActivityMainBinding
import roiattia.com.mymovieskotlin.ui.movies_list.MoviesListViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val moviesListViewModel: MoviesListViewModel by viewModels()
    }
}
