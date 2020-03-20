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
    var listLiveData: LiveData<List<Result>> = listMutableLiveData
    private val disposable = CompositeDisposable()
    private val respository = CharacterRepository()
    val listCharacters: Unit
        get() {
            disposable.add(
                respository.characterResponseObservable()!!
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ charactersResponse ->
                        listMutableLiveData.setValue(charactersResponse?.results) },
                        { throwable: Throwable -> Log.i("LOG", "MESSAGE -> " + throwable.message) })
            )
        }
}


