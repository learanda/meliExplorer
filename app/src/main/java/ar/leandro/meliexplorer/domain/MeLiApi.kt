package ar.leandro.meliexplorer.domain

import ar.leandro.meliexplorer.domain.model.Article
import ar.leandro.meliexplorer.domain.model.Articles
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MeLiApi {

    companion object {
        const val ARG: String = "MLA"
    }

    @GET("sites/$ARG/search")
    suspend fun getArticles(@Query("q") query: String): Response<Articles>

    /*@GET("items/{itemId}")
    suspend fun getItem(@Path("itemId") id: String): Response<Article>

    @GET("sites/$ARG/search")
    suspend fun getSellerArticles(@Query("seller_id") id: String): Response<Articles>*/

}