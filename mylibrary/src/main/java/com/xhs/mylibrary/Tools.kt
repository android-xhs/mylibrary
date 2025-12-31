package com.xhs.mylibrary

import android.content.Context
import android.widget.Toast

object Tools {

}
fun Int.calculate(another: Int ) = this + another
fun String.form() = "$this 我是库文件的方法"
fun String.add() = "$this 我是新添加的方法"
fun String.dev() = "$this 我是分支dev添加的方法"
fun String.toast(context: Context) = Toast.makeText(context,this, Toast.LENGTH_SHORT).show()