package ps.room.vacationapp.ui.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import ps.room.vacationapp.databinding.FragmentHomeBinding
import ps.room.vacationapp.ui.fragment.BaseFragment

class HomeFragment : BaseFragment() {
    private  var _binding:FragmentHomeBinding? = null
    // to prevent memory leaks
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val homeadapter = HomeFragmentAdapter{ attractionId->
            val navDirections = HomeFragmentDirections.actionHomeFragmentToAttractionDetailFragment(attractionId)
            navController.navigate(navDirections)

        // lambda making use of the exported variable
        }

        binding.recyclerView.adapter = homeadapter
        binding.recyclerView.addItemDecoration(DividerItemDecoration(requireActivity(),RecyclerView.VERTICAL))
        homeadapter.setData(attractions)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}