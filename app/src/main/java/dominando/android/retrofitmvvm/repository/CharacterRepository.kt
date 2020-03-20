package dominando.android.retrofitmvvm.repository

import ServiceRetroFit.apiService
import dominando.android.retrofitmvvm.model.CharactersResponse
import io.reactivex.Observable

class CharacterRepository {
    fun characterResponseObservable(): Observable<CharactersResponse?>? {
        return apiService.charactersResponse
    }
}