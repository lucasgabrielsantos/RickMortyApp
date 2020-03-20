import dominando.android.retrofitmvvm.BuildConfig
import dominando.android.retrofitmvvm.network.RickMortyApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ServiceRetroFit {
    private const val BASE_URL = "https://rickandmortyapi.com/api/"
    private var retrofit: Retrofit? = null
        get() {
            if (field == null) {
                val httpClient = OkHttpClient.Builder()
                httpClient.readTimeout(30, TimeUnit.SECONDS)
                httpClient.connectTimeout(30, TimeUnit.SECONDS)
                httpClient.writeTimeout(30, TimeUnit.SECONDS)
                if (BuildConfig.DEBUG) {
                    val httpLoggingInterceptor = HttpLoggingInterceptor()
                    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                    httpClient.addInterceptor(httpLoggingInterceptor)
                }
                field = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build()
            }
            return field
        }

    @JvmStatic
    val apiService: RickMortyApi
        get() = retrofit!!.create(RickMortyApi::class.java)
}