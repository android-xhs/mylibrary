package com.xhs.mylibrary2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    /**
     * 初始化View，子类只需要实现，不需要调用，在父类中已经调用了
     */
    abstract fun initView()
}