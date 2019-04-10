package fview

import android.content.Context

import androidx.core.content.ContextCompat
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.RelativeLayout
import com.dpk.customview.R


/**
 * Created by deepakkanyan on 1/15/19 , 2:40 PM.
 */
class LabelIcon  @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
        RelativeLayout(context, attrs, defStyleAttr)
{

    private var icon: ImageView? = null
    private var txtTitle: Label? = null
    private fun init(context: Context, attrs: AttributeSet?) {
        val a = context.obtainStyledAttributes(attrs, R.styleable.LabelIcon)
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.view_label_icon, this)

        txtTitle        = view.findViewById(R.id.txtValue)
        icon   = view.findViewById(R.id.icon)
        txtTitle!!.text = a.getString(R.styleable.LabelIcon_labeletext)
        txtTitle!!.hint = a.getString(R.styleable.LabelIcon_labelhint)
         icon!!.setImageDrawable(a.getDrawable(R.styleable.LabelIcon_labelicon))

        txtTitle!!.textSize  = a.getDimension(R.styleable.LabelIcon_labeleSize,14f)


        txtTitle!!.setTextColor(a.getColor(R.styleable.LabelIcon_labletextColor,
                ContextCompat.getColor(context,
                        R.color.customTextColor)))

        a.recycle()




    }


    var color : Int = 0
        set(value){
            field = value
            txtTitle!!.setTextColor(value)
        }


    var label : String? = ""
        set(value){
            field = value
            txtTitle!!.text = value
        }





    init {
        init(context, attrs)
    }
}