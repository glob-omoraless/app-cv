package com.omoraless.cvandroid.ui

import androidx.annotation.StringRes
import com.omoraless.cvandroid.base.BaseView
import com.omoraless.cvandroid.model.CV


interface CVView : BaseView {

    fun updateCV(cvdata: CV)

    /**
     * Displays an error in the view
     * @param error the error to display in the view
     */
    fun showError(error: String)

    /**
     * Displays an error in the view
     * @param errorResId the resource id of the error to display in the view
     */
    fun showError(@StringRes errorResId: Int) {
        this.showError(getContext().getString(errorResId))
    }

    /**
     * Displays the loading indicator of the view
     */
    fun showLoading()

    /**
     * Hides the loading indicator of the view
     */
    fun hideLoading()
}