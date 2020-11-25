package com.example.hwassignment2

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class ObjDetailScreenGenerator(val ctx : Context) {
    lateinit var layoutObj : LinearLayout
    fun generate() : LinearLayout {
        layoutObj = LinearLayout(ctx)

        val tParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        tParams.topMargin = 70
        tParams.bottomMargin = 70
        var tv = TextView(ctx)
        tv.text = "Please Enter Claim Information"
        tv.setBackgroundColor(Color.WHITE)
        tv.setTypeface(Typeface.create("Times New Roman", Typeface.BOLD))
        tv.setTextSize(18F)
        tv.gravity = Gravity.CENTER
        tv.setTextColor(Color.BLACK)
        layoutObj.addView(tv, tParams)

        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )

        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.VERTICAL
        layoutObj.setBackgroundColor(Color.WHITE)

        val fldRowGenerator = ObjDetailSectionGenerator(ctx)
        val colView = fldRowGenerator.generate()
        layoutObj.addView(colView)

        val nLayout = LinearLayout(ctx)
        val nParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        //
        nParams.gravity = Gravity.RIGHT
        nLayout.layoutParams = nParams
        nLayout.orientation = LinearLayout.HORIZONTAL
        nLayout.setBackgroundColor(Color.GRAY)
        //
        val nButton = Button(ctx)
        nButton.text = "Add"
        nButton.setId(R.id.add_btn)
        nButton.setBackgroundColor(Color.CYAN)

        val nbParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        nbParams.gravity = Gravity.BOTTOM
        nLayout.addView(nButton, nbParams)
        //
        layoutObj.addView(nLayout)

        val sParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        sParams.topMargin = 70
        sParams.bottomMargin = 70
        val status = TextView(ctx)
        status.setId(R.id.status)
        status.text = "Status: "
        status.setBackgroundColor(Color.WHITE)
        status.setTextSize(18F)
        status.gravity = Gravity.CENTER
        status.setTextColor(Color.BLACK)
        layoutObj.addView(status, sParams)

        return layoutObj
    }
}