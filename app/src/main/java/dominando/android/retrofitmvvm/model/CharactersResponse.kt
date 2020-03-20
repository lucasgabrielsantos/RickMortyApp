package dominando.android.retrofitmvvm.model

import com.google.gson.annotations.Expose

class CharactersResponse {
    @Expose
    var info: Info? = null
    @Expose
    var results: List<Result>? =
        null

}