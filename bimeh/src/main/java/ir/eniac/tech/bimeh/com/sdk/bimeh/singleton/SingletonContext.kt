package ir.eniac.tech.bimeh.com.sdk.bimeh.singleton

import android.annotation.SuppressLint
import android.content.Context

/**
 * Created by Javad.Abadi on 7/2/2018.
 */
class SingletonContext private constructor()
{
    var context: Context? = null


    companion object
    {
        @SuppressLint("StaticFieldLeak")
        val instance = SingletonContext()
    }


}
