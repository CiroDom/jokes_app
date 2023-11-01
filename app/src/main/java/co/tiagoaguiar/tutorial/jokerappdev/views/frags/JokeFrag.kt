package co.tiagoaguiar.tutorial.jokerappdev.views.frags

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import co.tiagoaguiar.tutorial.jokerappdev.R
import co.tiagoaguiar.tutorial.jokerappdev.databinding.FragJokeBinding
import co.tiagoaguiar.tutorial.jokerappdev.core.models.Joke
import co.tiagoaguiar.tutorial.jokerappdev.core.presenter.JokePresenter
import com.squareup.picasso.Picasso

class JokeFrag : Fragment() {

    private val binding by lazy {
        FragJokeBinding.inflate(layoutInflater)
    }

    private val progBar by lazy {
        binding.progressBar
    }

    private val txtJoke by lazy {
        binding.txtJoke
    }

    private val imgJoke by lazy {
        binding.imgJoke
    }

    private val presenter by lazy {
        JokePresenter(this)
    }

    companion object {
        const val CATEG_KEY = "category"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fab = binding.fab

        if (arguments != null) {
            val categName = arguments?.getString(CATEG_KEY)!!

            activity?.findViewById<Toolbar>(R.id.toolbar)?.title =
                categName.replaceFirstChar { it.uppercaseChar() }

            fab.setOnClickListener {
                presenter.findByCateg(categName)
                Log.i("categJoke", "fab - findcategJoke")
            }

            presenter.findByCateg(categName)
            Log.i("categJoke", "normal - findcategJoke")
        } else {
            activity?.findViewById<Toolbar>(R.id.toolbar)?.title = getString(R.string.random_joke)

            fab.setOnClickListener {
                presenter.findDayJoke()
                Log.i("dayJoke", "fab - findDayJoke")
            }

            presenter.findDayJoke()
            Log.i("dayJoke", "normal - findDayJoke")
        }
    }

    fun showJoke(joke: Joke) {
        txtJoke.text = joke.text

        Picasso.get().load(joke.iconUrl).into(imgJoke)
    }

    fun showProgBar() {
        progBar.visibility = View.VISIBLE
    }

    fun hideProgBar() {
        progBar.visibility = View.INVISIBLE
    }

    fun showFailure(messege: String) {
        Toast.makeText(requireContext(), messege, Toast.LENGTH_SHORT).show()
    }
}