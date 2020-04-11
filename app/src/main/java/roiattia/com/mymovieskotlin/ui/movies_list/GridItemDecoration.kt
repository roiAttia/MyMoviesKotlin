package roiattia.com.mymovieskotlin.ui.movies_list

import android.graphics.Rect
import android.util.Log
import android.view.View
import android.widget.GridLayout
import android.widget.LinearLayout
import androidx.core.view.marginBottom
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import roiattia.com.mymovieskotlin.utils.toDp
import roiattia.com.mymovieskotlin.utils.toPx

class GridItemDecoration: RecyclerView.ItemDecoration() {

    private val rightMargin: Int = 8.toPx()
    private val bottomMargin: Int = 8.toPx()

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val position = parent.getChildAdapterPosition(view)
        val param = view.layoutParams as GridLayoutManager.LayoutParams
        param.setMargins(0,0, rightMargin, bottomMargin)
        if(position % 2 == 0){
            view.layoutParams = param
        }
    }

}