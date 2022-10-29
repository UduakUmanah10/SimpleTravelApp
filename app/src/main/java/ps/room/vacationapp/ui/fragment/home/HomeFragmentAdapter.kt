package ps.room.vacationapp.ui.fragment.home


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ps.room.vacationapp.R
import ps.room.vacationapp.data.Attraction
import ps.room.vacationapp.databinding.ViewHolderAttractionBinding

class HomeFragmentAdapter(
    private val onClickedCallback: ()-> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){


   private val attractions = ArrayList<Attraction>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

       return AttractionViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        (holder as AttractionViewHolder).onBind(attractions[position], onClickedCallback)
    }

    override fun getItemCount(): Int {

      return  attractions.size
    }

    fun setData(attractions:List<Attraction>){
        this.attractions.clear()
        this.attractions.addAll(attractions)
        notifyDataSetChanged()
    }

    inner class AttractionViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(
        R.layout.view_holder_attraction,
            parent,
            false)
    ) {

        private val binding = ViewHolderAttractionBinding.bind(itemView)

        fun onBind(attraction: Attraction, onClicked: () -> Unit){

            binding.titleTextView.text = attraction.title
            //using picasso to load image
            Picasso.get().load(attraction.image_urls).into(binding.headerImageView)
            binding.monthsToVisit.text = attraction.months_to_visit

            binding.root.setOnClickListener{
                onClicked()

            }


        }

    }

}