package fview

import android.content.Context
import android.graphics.Typeface
import androidx.appcompat.widget.AppCompatEditText
import android.util.AttributeSet
import com.dpk.customview.R


/**
 * Created by deepak Kanyan on 1/14/19 , 11:41 AM.
 */
class InputField  @JvmOverloads constructor(context: Context?, attrs: AttributeSet? = null,
                                            defStyleAttr: Int =  android.R.attr.editTextStyle) :
        AppCompatEditText(context, attrs, defStyleAttr) {


    init {

        style(context!! , attrs!!)
    }

    //  internal var customFont: String
    private fun style(context: Context, attrs: AttributeSet) {

        val a = context.obtainStyledAttributes(attrs,
                R.styleable.InputField)
        val cf = a.getInteger(R.styleable.InputField_fontName, 3)

        val fontName: Int
        fontName = when (cf) {
            1 -> R.string.Bold
            2 -> R.string.Medium
            else -> R.string.Normal
        }

        val customFont = resources.getString(fontName)
        val tf = Typeface.createFromAsset(context.assets,
                "fonts/$customFont.ttf")
        typeface = tf



        a.recycle()
    }





}
