package dora.edu.domain.interactor;

import dora.edu.domain.executor.PostExecutionThread;
import dora.edu.domain.executor.ThreadExecutor;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Dora on 7/17/2017.
 */

public abstract class UseCase<T, Params> {

    private final ThreadExecutor mThreadExecutor;
    private final PostExecutionThread mPostExecutionThread;
    private final CompositeDisposable mDisposables;

    public UseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        mThreadExecutor = threadExecutor;
        mPostExecutionThread = postExecutionThread;
        mDisposables = new CompositeDisposable();
    }

    abstract Observable<T> buildUseCaseObservable(Params params);

    public void execute(DisposableObserver disposableObserver, Params params) {
        final Observable<T> observable = this.buildUseCaseObservable(params)
                .subscribeOn(Schedulers.from(mThreadExecutor))
                .observeOn(mPostExecutionThread.getScheduler());
        addDisposables(observable.subscribeWith(disposableObserver));
    }

    public void dispose() {
        if (!mDisposables.isDisposed()) {
            mDisposables.dispose();
        }
    }

    private void addDisposables(Disposable disposable) {
        mDisposables.add(disposable);
    }

}
