package co.tiagoaguiar.tutorial.jokerappdev.views.frags

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import co.tiagoaguiar.tutorial.jokerappdev.R
import co.tiagoaguiar.tutorial.jokerappdev.data.CategRemoteDataSource
import co.tiagoaguiar.tutorial.jokerappdev.databinding.FragHomeBinding
import co.tiagoaguiar.tutorial.jokerappdev.models.Category
import co.tiagoaguiar.tutorial.jokerappdev.presenter.HomePresenter
import co.tiagoaguiar.tutorial.jokerappdev.views.recy_view.CategoryItem
import com.xwray.groupie.GroupieAdapter

class HomeFrag : Fragment() {

    private val binding by lazy {
        FragHomeBinding.inflate(layoutInflater)
    }
    private val presenter by lazy {
        HomePresenter(this)
    }
    private val progBar by lazy {
        binding.progressBar
    }
    private val groupieAdapter = GroupieAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.frag_home, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

        val recyView = binding.rvMain
        recyView.layoutManager = LinearLayoutManager(requireContext())

        presenter.findAllCategs()

        recyView.adapter = groupieAdapter
    }

    fun showCategs(response: List<Category>) {
        val categories = response.map { category -> CategoryItem(category) }

        groupieAdapter.addAll(categories)
        groupieAdapter.notifyDataSetChanged()
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