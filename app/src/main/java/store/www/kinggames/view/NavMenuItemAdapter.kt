package store.www.kinggames.view
import android.graphics.Color
import store.www.kinggames.util.NavMenuItemDetailsLookup
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.widget.RecyclerView
import store.www.kinggames.R
import store.www.kinggames.domain.NavMenuItem
import store.www.kinggames.util.NavMenuItemDetails

class NavMenuItemsAdapter( val items: List<NavMenuItem> ) :
    RecyclerView.Adapter<NavMenuItemsAdapter.ViewHolder>() {

    lateinit var selectionTracker: SelectionTracker<Long>

    override fun onCreateViewHolder(
        parent: ViewGroup,
        type: Int ): ViewHolder {

        val layout = LayoutInflater
            .from( parent.context )
            .inflate(
                R.layout.nav_menu_item,
                parent,
                false
            )

        return ViewHolder( layout )
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int ) {

        holder.setData( items[ position ] )
    }

    override fun getItemCount() = items.size

    inner class ViewHolder( itemView: View) :
        RecyclerView.ViewHolder( itemView ) {

        private val ivIcon: ImageView
        private val tvLabel: TextView


        val itemDetails: NavMenuItemDetails
        init {
            ivIcon = itemView.findViewById(R.id.iv_icon)
            tvLabel = itemView.findViewById(R.id.tv_label)
            itemDetails = NavMenuItemDetails()
        }

            fun setData(item: NavMenuItem) {

                tvLabel.text = item.label

                if (item.iconId != NavMenuItem.DEFAULT_ICON_ID) {
                    ivIcon.setImageResource(item.iconId)
                    ivIcon.visibility = View.VISIBLE
                } else {
                    ivIcon.visibility = View.GONE
                }
                /*
             * São nos blocos condicionais a seguir que devem vir os
             * algoritmos de atualização de UI, isso para indicar o
             * item selecionado e os itens não selecionados.
             * */
                itemDetails.item = item
                itemDetails.adapterPosition = adapterPosition
                if( selectionTracker.isSelected( itemDetails.getSelectionKey() ) ){
                    itemView.setBackgroundColor(
                        ContextCompat.getColor(
                            itemView.context,
                            R.color.colorNavItemSelected
                        )
                    )
                }else{
                    itemView.setBackgroundColor( Color.TRANSPARENT )
                }
            }
        }
    }
