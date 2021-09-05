package au.com.flymultiverse.util

import android.view.View
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import au.com.flymultiverse.adapters.AirportListAdapter
import au.com.flymultiverse.models.entitymodels.Airport


@BindingAdapter("app:items")
fun setItems(listView: RecyclerView, items: List<Airport>?) {
    items?.let {
        (listView.adapter as AirportListAdapter).notifyDataSetChanged()
    }
}

@BindingAdapter("bind:visibility")
fun setVisibility(view: ProgressBar, isLoading: MutableLiveData<Boolean>) {
    if (isLoading.value == true)
        view.visibility = View.VISIBLE
    else
        view.visibility = View.GONE
}