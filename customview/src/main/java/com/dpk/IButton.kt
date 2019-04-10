package fview

import android.content.Context
import android.graphics.Typeface
import androidx.appcompat.widget.AppCompatButton
import android.util.AttributeSet
import com.dpk.customview.R

/**
 * Created by deepakkanyan on 1/14/19 , 11:42 AM.
 */
class IButton  @JvmOverloads constructor(context: Context?, attrs: AttributeSet? = null, defStyleAttr: Int =  0) :
        AppCompatButton(context, attrs, defStyleAttr) {


    init {

        style(context!! , attrs!!)
    }

    //  internal var customFont: String
    private fun style(context: Context, attrs: AttributeSet) {

        val a = context.obtainStyledAttributes(attrs,
                R.styleable.IButton)
        val cf = a.getInteger(R.styleable.IButton_fontName, 3)

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


    fun setHint(hint: String) {

        super.setHint(hint)

    }

    override fun setText(text: CharSequence?, type: BufferType?) {
        super.setText(text, type)
    }

}
