package dominando.android.retrofitmvvm.model

import com.google.gson.annotations.Expose

class Info {
    @Expose
    var count: Long? = null
    @Expose
    var next: String? = null
    @Expose
    var pages: Long? = null
    @Expose
    var prev: String? = null

}