package com.lifecompany.base

import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import moxy.MvpPresenter
import timber.log.Timber

abstract class BasePresenter<V : BaseView> : MvpPresenter<V>() {

    private val disposable = CompositeDisposable()

    fun dispose() = disposable.dispose()

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }

    fun <T> subscribe(observable: Single<T>, action: ((T) -> Unit)) {
        viewState.showProgress()
        disposable.add(
            observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally { viewState.hideProgress() }
                .subscribe({ action(it) },
                    { throwable ->
                        viewState?.onError(throwable.message ?: "Error")
                        Timber.e(throwable)
                    })
        )
    }

    fun <T> subscribe(observable: Observable<T>, action: ((T) -> Unit)) {
        viewState.showProgress()
        disposable.add(
            observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally { viewState.hideProgress() }
                .subscribe({ action(it) },
                    {
                        viewState?.onError(it.message ?: "Error")
                        Timber.e(it)
                    })
        )
    }

    fun <T> subscribe(observable: Maybe<T>, action: ((T) -> Unit)) {
        viewState.showProgress()
        disposable.add(
            observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally { viewState.hideProgress() }
                .subscribe({ action(it) },
                    {
                        viewState?.onError(it.message ?: "Error")
                        Timber.e(it)
                    })
        )
    }

    fun <T> subscribe(observable: Flowable<T>, action: ((T) -> Unit)) {
        viewState.showProgress()
        disposable.add(
            observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally { viewState.hideProgress() }
                .subscribe({ action(it) },
                    {
                        viewState?.onError(it.message ?: "Error")
                        Timber.e(it)
                    })
        )
    }

    fun <T> subscribe(observable: Single<T>, action: ((T) -> Unit), error: ((Throwable) -> Unit)) {
        viewState.showProgress()
        disposable.add(
            observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally { viewState.hideProgress() }
                .subscribe({ action(it) },
                    {
                        error(it)
                        Timber.e(it)
                    })
        )
    }

    fun <T> subscribe(
        observable: Observable<T>,
        action: ((T) -> Unit),
        error: ((Throwable) -> Unit)
    ) {
        viewState.showProgress()
        disposable.add(
            observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally { viewState.hideProgress() }
                .subscribe({ action(it) },
                    {
                        error(it)
                        Timber.e(it)
                    })
        )
    }

}
