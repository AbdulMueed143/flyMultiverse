package au.com.flymultiverse

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import au.com.flymultiverse.databinding.FragmentItemDetailBinding
import au.com.flymultiverse.di.ViewModelProviderFactory
import au.com.flymultiverse.models.viewmodels.AirportListViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a [ItemListFragment]
 * in two-pane mode (on larger screen devices) or self-contained
 * on handsets.
 */
class ItemDetailFragment : DaggerFragment() {

    /**
     * The placeholder content this fragment is presenting.
     */
    @Inject
    lateinit var viewModelProvierFactory: ViewModelProviderFactory
    private lateinit var listViewModel: AirportListViewModel

    private var _binding: FragmentItemDetailBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listViewModel = ViewModelProvider(requireActivity(), viewModelProvierFactory).get(AirportListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentItemDetailBinding.inflate(inflater, container, false).apply {
            airportListViewModel = listViewModel
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.lifecycleOwner = this.viewLifecycleOwner
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}