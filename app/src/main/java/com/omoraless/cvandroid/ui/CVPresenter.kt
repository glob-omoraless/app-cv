package com.omoraless.cvandroid.ui

import com.omoraless.cvandroid.R
import com.omoraless.cvandroid.base.BasePresenter
import com.omoraless.cvandroid.model.CV
import com.omoraless.cvandroid.network.Api
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.json.JSONObject
import javax.inject.Inject

/**
 * The Presenter that will present the CV view.
 * @param cVView the CV view to be presented by the presenter
 * @property Api the API interface implementation
 * @property subscription the subscription to the API call
 */
class CVPresenter(cVView: CVView) : BasePresenter<CVView>(cVView) {
    @Inject
    lateinit var api: Api

    private var subscription: Disposable? = null

    override fun onViewCreated() {
        loadCV()
    }

    /**
     * Loads data from the API and presents them in the view when retrieved, or shows error if necessary
     */
    fun loadCV() {
        view.showLoading()
        subscription = api
                .getCVData()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnTerminate { view.hideLoading() }
                .subscribe(
                        { data -> view.updateCV(data) },
                        { view.showError(R.string.error) }
                )
    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }
}