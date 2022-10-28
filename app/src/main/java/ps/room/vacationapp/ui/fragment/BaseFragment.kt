package ps.room.vacationapp.ui.fragment

import androidx.fragment.app.Fragment
import ps.room.vacationapp.ui.MainActivity

abstract class BaseFragment: Fragment() {

    protected val navController by lazy{
        (activity as MainActivity).navController
    }
}