package chaudhari.mayank.dindinn.utils

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MavericksState

open class MvRxViewModel<S : MavericksState>(state: S) : BaseMvRxViewModel<S>(state)
