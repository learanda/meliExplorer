package ar.leandro.meliexplorer.data

import ar.leandro.meliexplorer.domain.Article
import ar.leandro.meliexplorer.domain.Articles

interface MeliRepo {

    suspend fun searchArticles(query: String): Articles

    suspend fun searchItem(id: String): Article

    suspend fun searchSellerArticles(id: String): Articles
}