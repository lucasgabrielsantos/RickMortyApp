package dominando.android.retrofitmvvm.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dominando.android.retrofitmvvm.model.Result
import dominando.android.retrofitmvvm.repository.CharacterRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class CharactersViewModel(application: Application) : AndroidViewModel(application) {

    private val listMutableLiveData = MutableLiveData<List<Result>>()
    val listLiveData: LiveData<List<Result>> = listMutableLiveData
    private val disposable = CompositeDisposable()
    private val repository = CharacterRepository()

    val Listcharacter: Unit
        get() {
            disposable.add(
                repository.characterResponseObservable()!!
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ charactersResponse ->
                        listMutableLiveData.setValue(charactersResponse?.results) })
                    { throwable -> Log.i("ERREI", "MESSAGE -> " + throwable.message) })
        }

}


