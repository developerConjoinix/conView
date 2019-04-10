package fview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater

import android.widget.RelativeLayout
import com.dpk.customview.R



/**
 * Created by deepakkanyan on 2/23/19 , 11:53 AM.
 */
class LRLabel @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
        RelativeLayout(context, attrs, defStyleAttr)
{


    private var txtLeft: Label? = null
    private var txtRight: Label? = null
    private fun init(context: Context, attrs: AttributeSet?) {
        val a = context.obtainStyledAttributes(attrs, R.styleable.LRLabel)
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.view_left_right_text, this)

        txtLeft        = view.findViewById(R.id.leftText)
        txtRight     = view.findViewById(R.id.rightText)
        txtLeft!!.text = a.getString(R.styleable.LRLabel_leftText)
        txtRight!!.text = a.getString(R.styleable.LRLabel_rightText)

        txtLeft!!.textSize  = a.getDimension(R.styleable.LRLabel_rlSize,14f)
        txtRight!!.textSize  = a.getDimension(R.styleable.LRLabel_rlSize,14f)

        if(a.getBoolean(R.styleable.LRLabel_boldIt,false))
        {
            txtLeft?.setMediumFont()
            txtRight ?.setMediumFont()

        }
       // txtTitle!!.textSize  = a.getDimension(R.styleable.LabelIcon_labeleSize,14f)

        val color = a.getColor(R.styleable.LRLabel_rlColor,  context.resources.getColor(R.color.customTextColor))
        txtLeft?.setTextColor(color)
        txtRight?.setTextColor(color)
       // txtTitle!!.setTextColor(a.getColor(R.styleable.LabelIcon_labletextColor,
           //     ContextCompat.getColor(context,
                //        R.color.textPrimary)))

        a.recycle()




    }


   var color : Int = 0
        set(value){
            field = value
            txtRight!!.setTextColor(value)
        }


    var leftText : String = ""
        set(value){
            field = value
            txtLeft!!.text = value
        }

    var rightText : String = ""
        set(value){
            field = value
            txtRight!!.text = value
        }




    init {
        init(context, attrs)
    }
}