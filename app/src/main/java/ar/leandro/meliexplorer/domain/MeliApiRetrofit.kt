package ar.leandro.meliexplorer.domain

import ar.leandro.meliexplorer.domain.model.Article
import ar.leandro.meliexplorer.domain.model.Articles
import com.google.gson.Gson
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MeliApiRetrofit {

    private fun getAPI(): MeLiApi {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.mercadolibre.com")
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()

        return retrofit.create(MeLiApi::class.java)
    }

    suspend fun getArticles(query: String): Response<Articles> {
        return getAPI().getArticles(query)
    }

    /*suspend fun getItem(id: String): Response<Article> {
        return getAPI().getItem(id)
    }

    suspend fun getSellerArticles(id: String): Response<Articles> {
        return getAPI().getSellerArticles(id)
    }*/
}