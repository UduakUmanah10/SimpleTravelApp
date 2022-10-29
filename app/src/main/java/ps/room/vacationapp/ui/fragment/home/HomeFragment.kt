package ps.room.vacationapp.ui.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        val Homeadapter = HomeFragmentAdapter{
            // handle item being clicked
        }
        binding.recyclerView.adapter = Homeadapter

        Homeadapter.setData(emptyList())

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}