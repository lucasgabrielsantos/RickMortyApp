import com.facebook.stetho.okhttp3.StethoInterceptor
import dominando.android.retrofitmvvm.BuildConfig
import dominando.android.retrofitmvvm.network.RickMortyApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class ServiceRetrofit {

    companion object {
        private const val BASE_URL = "https://rickandmortyapi.com/api/"

        // Instancia que criaremos do retrofit
        private var retrofit: Retrofit? = null

        private fun getRetrofit(): Retrofit {
            if (retrofit == null) { // configurações da conexão
                val httpClient = OkHttpClient.Builder()
                httpClient.readTimeout(30, TimeUnit.SECONDS)
                httpClient.connectTimeout(30, TimeUnit.SECONDS)
                httpClient.writeTimeout(30, TimeUnit.SECONDS)
                // Se for Debug habilitamos os logs
                if (BuildConfig.DEBUG) {
                    val httpLoggingInterceptor = HttpLoggingInterceptor()
                    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                    httpClient.addInterceptor(httpLoggingInterceptor)
                    httpClient.addNetworkInterceptor(StethoInterceptor())
                }
                // Inicializamos o retrofit
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build()
            }
            return retrofit!!
        }

        val getApiService: RickMortyApi
            get() = getRetrofit().create(RickMortyApi::class.java)

    }
}