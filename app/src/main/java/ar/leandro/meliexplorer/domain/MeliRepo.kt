package ar.leandro.meliexplorer.domain

import ar.leandro.meliexplorer.domain.model.Article
import ar.leandro.meliexplorer.domain.model.Articles

interface MeliRepo {

    suspend fun searchArticles(query: String): List<Article>

    /*suspend fun searchItem(id: String): Article

    suspend fun searchSellerArticles(id: String): Articles*/
}