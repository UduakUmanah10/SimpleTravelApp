package ps.room.vacationapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import androidx.core.content.res.ColorStateListInflaterCompat.inflate
import androidx.core.content.res.ComplexColorCompat.inflate
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import ps.room.vacationapp.data.Attraction
import ps.room.vacationapp.databinding.FragmentAttractionDetailBinding


class AttractionDetailFragment: BaseFragment() {

    private var _binding: FragmentAttractionDetailBinding? =null
    private val binding get()= _binding!!

    private val safeArgs:AttractionDetailFragmentArgs by navArgs()
    private val attraction: Attraction by lazy{ attractions.find{it.id == safeArgs.attractionId}!!}



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAttractionDetailBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.titleTextView.text = attraction.title
        binding.descriptionTextView.text = attraction.description
        Picasso.get().load(attraction.image_urls).into(binding.headerImageView)
        binding.monthsToVisitTextView.text = attraction.months_to_visit
        binding.numberofFactsTextView.text = "${attraction.facts.size} facts"
        binding.numberofFactsTextView.setOnClickListener{
            // to do

        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}