package org.mp.recipes.utils

import android.content.Context
import android.view.View
import android.widget.Toast



fun View.visible(){
    this.visibility = View.VISIBLE
}

fun View.gone(){
    this.visibility = View.GONE
}

fun String.shortToast(context: Context){
    Toast.makeText(context,this,Toast.LENGTH_SHORT).show()
}

fun String.longToast(context: Context){
    Toast.makeText(context,this,Toast.LENGTH_LONG).show()
}