package co.tiagoaguiar.tutorial.jokerappdev.frags

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.tiagoaguiar.tutorial.jokerappdev.R
import co.tiagoaguiar.tutorial.jokerappdev.models.Category
import co.tiagoaguiar.tutorial.jokerappdev.recy_view.CategoryItem
import com.xwray.groupie.GroupieAdapter

class HomeFrag : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.frag_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyView = view.findViewById<RecyclerView>(R.id.rv_main)
        recyView.layoutManager = LinearLayoutManager(requireContext())

        val groupieAdapter = GroupieAdapter()
        recyView.adapter = groupieAdapter

        groupieAdapter.add(CategoryItem(Category("Categoria 1", 0xfface6e)))
        groupieAdapter.add(CategoryItem(Category("Categoria 2", 0xffecd16d)))
        groupieAdapter.add(CategoryItem(Category("Categoria 3", 0xffded36e)))
        groupieAdapter.add(CategoryItem(Category("Categoria 4", 0xffcfd571)))
        groupieAdapter.notifyDataSetChanged()
    }
}