package au.com.flymultiverse

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import au.com.flymultiverse.adapters.AirportListAdapter
import au.com.flymultiverse.databinding.FragmentItemListBinding
import au.com.flymultiverse.di.ViewModelProviderFactory
import au.com.flymultiverse.models.viewmodels.AirportListViewModel
import au.com.flymultiverse.util.EventObserver
import au.com.flymultiverse.util.Resource
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class ItemListFragment : DaggerFragment() {

    private var _binding: FragmentItemListBinding? = null
    @Inject lateinit var viewModelProviderFactory: ViewModelProviderFactory
    private lateinit var airportListViewModel : AirportListViewModel
    private var layoutBottomSheet: View? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        airportListViewModel = ViewModelProvider(requireActivity() , viewModelProviderFactory).get(AirportListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentItemListBinding.inflate(inflater, container, false).apply {
            listViewModel = airportListViewModel
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.lifecycleOwner = this.viewLifecycleOwner

        setupRecyclerView()
        setupObservers()
        hideBottomSheet()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        layoutBottomSheet = view.findViewById(R.id.layoutBottomSheet)
    }

    private fun setupRecyclerView() {
        _binding?.listViewModel?.let {
            binding.airportList.adapter = AirportListAdapter(it)
        }
    }

    private fun setupObservers() {

        binding.listViewModel?.openPetDetailPageEvent?.observe(viewLifecycleOwner, EventObserver {
            //open bottom view with details...
            showBottomSheet()
        })

        binding.listViewModel?._airports?.observe(viewLifecycleOwner, {
            when(it.status) {

                Resource.Status.LOADING -> {
                    airportListViewModel.isLoading.postValue(true)
                }

                Resource.Status.SUCCESS -> {
                    airportListViewModel.isLoading.postValue(false)
                    //refresh the data
                    if(!it.data.isNullOrEmpty()) {
                        it.data.let {
                            airportListViewModel.airports = it
                            binding.airportList?.adapter?.notifyDataSetChanged()
                        }
                    }
                }

                Resource.Status.ERROR -> {
                    Snackbar.make(binding.root, it.message ?: getString(R.string.error_message), Snackbar.LENGTH_SHORT).show()
                    airportListViewModel.isLoading.postValue(false)
                }
            }
        })
    }


    private fun hideBottomSheet() {
        layoutBottomSheet?.let {
            BottomSheetBehavior.from(it).setPeekHeight(0)
            BottomSheetBehavior.from(it).state = BottomSheetBehavior.STATE_HIDDEN
        }
    }

    private fun showBottomSheet() {
        layoutBottomSheet?.let {
            BottomSheetBehavior.from(it).state = BottomSheetBehavior.STATE_EXPANDED
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}