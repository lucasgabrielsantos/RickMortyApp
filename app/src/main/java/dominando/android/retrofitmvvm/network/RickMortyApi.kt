package dominando.android.retrofitmvvm.network

import dominando.android.retrofitmvvm.model.CharactersResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface RickMortyApi {
    @get:GET("character")
    val charactersResponse: Observable<CharactersResponse?>?
}