package dominando.android.retrofitmvvm.model

import com.google.gson.annotations.Expose

class Result {
    @Expose
    var created: String? = null
    @Expose
    var episode: List<String>? = null
    @Expose
    var gender: String? = null
    @Expose
    var id: Long? = null
    @Expose
    var image: String? = null
    @Expose
    var location: Location? = null
    @Expose
    var name: String? = null
    @Expose
    var origin: Origin? = null
    @Expose
    var species: String? = null
    @Expose
    var status: String? = null
    @Expose
    var type: String? = null
    @Expose
    var url: String? = null

}