package com.omoraless.cvandroid.base

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Provides required methods and presenter
 * instantiation and calls.
 * @param P the type of the presenter the Activity is based on
 */
abstract class BaseActivity<P : BasePresenter<BaseView>> : BaseView, AppCompatActivity() {
    protected lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = instantiatePresenter()
    }

    /**
     * Instantiates the presenter the Activity is based on.
     */
    protected abstract fun instantiatePresenter(): P

    override fun getContext(): Context {
        return this
    }
}