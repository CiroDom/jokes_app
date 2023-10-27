package co.tiagoaguiar.tutorial.jokerappdev.views.frags

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import co.tiagoaguiar.tutorial.jokerappdev.R
import co.tiagoaguiar.tutorial.jokerappdev.databinding.FragJokeBinding
import co.tiagoaguiar.tutorial.jokerappdev.models.Joke
import co.tiagoaguiar.tutorial.jokerappdev.presenter.JokePresenter

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
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categName = arguments?.getString(CATEG_KEY)!!

        activity?.findViewById<Toolbar>(R.id.toolbar)?.title = categName

        progBar.setOnClickListener {
            presenter.findByCateg(categName)
        }

        presenter.findByCateg(categName)
    }

    fun showJoke(joke: Joke) {
        txtJoke.text = joke.text

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