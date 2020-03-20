package dominando.android.retrofitmvvm.repository

import ServiceRetrofit.Companion.getApiService
import dominando.android.retrofitmvvm.model.CharactersResponse
import io.reactivex.Observable

class CharacterRepository {

    fun characterResponseObservable(): Observable<CharactersResponse?>? {
        return getApiService.getCharactersResponse()
    }
}