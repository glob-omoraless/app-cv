package com.omoraless.cvandroid.injection.component

import com.omoraless.cvandroid.base.BaseView
import com.omoraless.cvandroid.injection.module.ContextModule
import com.omoraless.cvandroid.injection.module.NetworkModule
import com.omoraless.cvandroid.ui.CVPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [(ContextModule::class), (NetworkModule::class)])
interface PresenterInjector {
    /**
     * Injects required dependencies into the specified CVPresenter.
     * @param cvPresenter CVPresenter in which to inject the dependencies
     */
    fun inject(cvPresenter: CVPresenter)

    @Component.Builder
    interface Builder {
        fun build(): PresenterInjector

        fun networkModule(networkModule: NetworkModule): Builder
        fun contextModule(contextModule: ContextModule): Builder

        @BindsInstance
        fun baseView(baseView: BaseView): Builder
    }
}