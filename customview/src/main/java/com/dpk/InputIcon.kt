package fview

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import android.text.InputType
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.RelativeLayout
import com.dpk.customview.R



/**
 * Created by deepakkanyan on 1/15/19 , 12:12 PM.
 */
class InputIcon @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null,
                                          defStyleAttr: Int = 0) :
        RelativeLayout(context, attrs, defStyleAttr)
{

    private var icon: ImageView? = null
    private var txtTitle: InputField? = null
    private fun init(context: Context, attrs: AttributeSet?) {
        val a = context.obtainStyledAttributes(attrs, R.styleable.InputIcon)
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.view_input_icon, this)

        txtTitle        = view.findViewById(R.id.txtValue)
        icon   = view.findViewById(R.id.icon)
        txtTitle!!.setText(a.getString(R.styleable.InputIcon_text))
        txtTitle!!.hint = a.getString(R.styleable.InputIcon_hint)
        txtTitle!!.inputType  = a.getInt(R.styleable.InputIcon_inputType, InputType.TYPE_CLASS_TEXT)

        setIcon(a.getDrawable(R.styleable.InputIcon_icon))





        txtTitle!!.setTextColor(a.getColor(R.styleable.InputIcon_textColor,
                ContextCompat.getColor(context,
                        R.color.customTextColor)))

        a.recycle()




        }


    public fun inputType( type : Int)
    {
        txtTitle!!.inputType = type
    }

        private fun setTitleText(txt: String) {
            txtTitle!!.setText(txt)
        }


         private fun setTitleHint(txt: String) {
            txtTitle!!.hint = txt
        }


        private fun setIcon(id: Drawable?) {

            icon!!.setImageDrawable(id)
        }
                init {
            init(context, attrs)
        }

    public fun getText() : String {

        return  txtTitle!!.text.toString()
    }
}