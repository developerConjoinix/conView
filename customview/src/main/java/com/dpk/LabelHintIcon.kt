package fview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.RelativeLayout
import com.dpk.customview.R


/**
 * Created by deepakkanyan on 1/21/19 , 6:10 PM.
 */
class LabelHintIcon  @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
        RelativeLayout(context, attrs, defStyleAttr){



    private var icon: ImageView? = null
    private var txtTitle: Label? = null
    private var hintText : Label? = null
    private fun init(context: Context, attrs: AttributeSet?) {
        val a = context.obtainStyledAttributes(attrs, R.styleable.LabelHintIcon)
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.view_hint_image_label, this)

        txtTitle         = view.findViewById(R.id.txtValue)
        hintText         = view.findViewById(R.id.txtHint)
        icon             = view.findViewById(R.id.editImage)

        txtTitle!!.text  = a.getString(R.styleable.LabelHintIcon_labelText)
        hintText!!.text  = a.getString(R.styleable.LabelHintIcon_labelHint)
        icon!!.setImageDrawable(a.getDrawable(R.styleable.LabelHintIcon_labelIcon))

      //  txtTitle!!.setTextColor(a.getColor(R.styleable.LabelIcon_labletextColor,ContextCompat.getColor(context, R.color.textPrimary)))
        txtTitle!!.textSize  = a.getDimension(R.styleable.LabelHintIcon_labelSize,14f)
        a.recycle()




    }

    var text: String? = ""
          set(value){
              field = value
              txtTitle!!.text = value
          }

    var hintLabel: String? = ""
        set(value){
            field = value
            hintText!!.text = value
        }



    /*
        private fun setHintText(text: String) {
            hintText!!.text = text
        }


        private fun setIcon(id: Drawable?) {

            icon!!.setImageDrawable(id)
        }*/
    init {
        init(context, attrs)
    }




}