package au.com.flymultiverse.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import au.com.flymultiverse.databinding.ItemListContentBinding
import au.com.flymultiverse.models.entitymodels.Airport
import au.com.flymultiverse.models.viewmodels.AirportListViewModel

class AirportListAdapter(private val viewModel: AirportListViewModel) : RecyclerView.Adapter<AirportListAdapter.ViewHolder>() {

    class ViewHolder private constructor(val binding: ItemListContentBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(viewModel: AirportListViewModel, item: Airport?) {
            binding.airportViewModel = viewModel
            binding.airport = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup) : ViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ItemListContentBinding.inflate(inflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = viewModel.airports?.get(position)
        holder.bind(viewModel, item)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return viewModel.airports?.size ?: 0
    }

}