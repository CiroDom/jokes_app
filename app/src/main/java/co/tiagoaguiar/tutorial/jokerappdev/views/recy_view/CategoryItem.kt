package co.tiagoaguiar.tutorial.jokerappdev.views.recy_view

import android.view.View
import android.widget.LinearLayout
import co.tiagoaguiar.tutorial.jokerappdev.R
import co.tiagoaguiar.tutorial.jokerappdev.models.Category
import com.google.android.material.textview.MaterialTextView
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item

class CategoryItem(val category: Category) : Item<CategoryItem.CategoryVHolder>() {

    inner class CategoryVHolder(itemView: View) : GroupieViewHolder(itemView)

    override fun createViewHolder(itemView: View) = CategoryVHolder(itemView)

    override fun bind(holder: CategoryVHolder, position: Int) {
        val itemView = holder.itemView

        itemView.findViewById<MaterialTextView>(R.id.txt_category).text = category.name
        itemView.findViewById<LinearLayout>(R.id.category_container).setBackgroundColor(category.backGroundColor.toInt())
    }

    override fun getLayout() = R.layout.category_item

}