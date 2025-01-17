package org.autojs.autojs.core.ui.inflater.inflaters

import android.widget.ProgressBar
import androidx.appcompat.R
import org.autojs.autojs.core.ui.inflater.ResourceParser
import org.autojs.autojs.core.ui.inflater.ViewCreator
import org.autojs.autojs.core.ui.inflater.util.Res

/**
 * Created by Stardust on 2017/11/29.
 * Transformed by SuperMonster003 on May 20, 2023.
 */
open class ProgressBarInflater<V : ProgressBar>(resourceParser: ResourceParser) : BaseViewInflater<V>(resourceParser) {

    override fun getCreator(): ViewCreator<in V> = ViewCreator { context, attrs ->
        fun hasTrueAttr(name: String) = attrs["android:$name"] == "true"

        attrs["style"]?.let { return@ViewCreator ProgressBar(context, null, 0, Res.parseStyle(context, it)) }

        if (hasTrueAttr("isHorizontal") || hasTrueAttr("horizontal")) {
            return@ViewCreator ProgressBar(context, null, 0, R.style.Base_Widget_AppCompat_ProgressBar_Horizontal)
        }
        return@ViewCreator ProgressBar(context)
    }

}