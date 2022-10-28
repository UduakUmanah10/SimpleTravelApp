package ps.room.vacationapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import ps.room.vacationapp.R
import ps.room.vacationapp.databinding.FragmentHomeBinding

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

        val recyclerView = binding.recyclerView

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}