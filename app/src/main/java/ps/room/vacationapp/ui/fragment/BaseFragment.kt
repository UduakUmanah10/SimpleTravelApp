package ps.room.vacationapp.ui.fragment

import androidx.fragment.app.Fragment
import ps.room.vacationapp.data.Attraction
import ps.room.vacationapp.ui.MainActivity

abstract class BaseFragment: Fragment() {

    protected val navController by lazy{
        (activity as MainActivity).navController
    }

    protected val attractions :List<Attraction>
    get()=(activity as MainActivity).attractionsList


}