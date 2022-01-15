package com.sample.matrimony.support

import android.util.Log
import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.marginLeft
import androidx.viewpager2.widget.ViewPager2
import java.lang.Math.abs

class SlideTransformer(private val offscreenPageLimit: Int) : ViewPager2.PageTransformer {

    companion object {

        private const val DEFAULT_TRANSLATION_X = .0f
        private  var DEFAULT_TRANSLATION_FACTOR = 1.12f

        private const val SCALE_FACTOR = .050f
        private const val DEFAULT_SCALE = 1f
        private const val NEW_SCALE = 1.025f
        private const val NEW_ALPHA = 0.5f

        private const val ALPHA_FACTOR = .3f
        private const val DEFAULT_ALPHA = 1f

    }

    override fun transformPage(page: View, position: Float) {

        page.apply {

            ViewCompat.setElevation(page, -abs(position))

            val newscaleFactor = -SCALE_FACTOR * position + DEFAULT_SCALE
            val newalphaFactor = -ALPHA_FACTOR * position + DEFAULT_ALPHA
            val lessscaleFactor = SCALE_FACTOR * position + DEFAULT_SCALE
            val lessalphaFactor = ALPHA_FACTOR * position + DEFAULT_SCALE

            DEFAULT_TRANSLATION_FACTOR = width.toFloat()/1070

            when {
                position == 0f -> {
                    Log.e("pos0",position.toString())
                    translationX = DEFAULT_TRANSLATION_X
                    scaleX = DEFAULT_SCALE
                    scaleY = DEFAULT_SCALE
                    alpha = DEFAULT_ALPHA
                }
                position <0f -> {
                   /* val mg =-(width / DEFAULT_TRANSLATION_FACTOR) * position
                    Log.e("lesspos",mg.toString())
                    Log.e("width",width.toString())
                    Log.e("lesssc",lessscaleFactor.toString())
                    Log.e("pos",position.toString())*/
                    /*scaleX = newscaleFactor
                    scaleY = newscaleFactor
                    translationX = -(width / DEFAULT_TRANSLATION_FACTOR) * position
                    alpha = newalphaFactor*/
                }
                position<=offscreenPageLimit-1->{
                    val mg =-(width / DEFAULT_TRANSLATION_FACTOR) * position
                    Log.e("width",width.toString())
                    Log.e("gret",mg.toString())
                    Log.e("lesssc",lessscaleFactor.toString())
                    Log.e("pos",position.toString())
                    Log.e("trns", DEFAULT_TRANSLATION_FACTOR.toString())
                    scaleX = lessscaleFactor
                    scaleY = lessscaleFactor
                    translationX= -(width / DEFAULT_TRANSLATION_FACTOR) * position
                    alpha=newalphaFactor
                }
                else -> {
//                    Log.e("pos","0f")
                    translationX = DEFAULT_TRANSLATION_X
                    scaleX = DEFAULT_SCALE
                    scaleY = DEFAULT_SCALE
                    alpha = DEFAULT_ALPHA
                }
            }
        }
    }
}