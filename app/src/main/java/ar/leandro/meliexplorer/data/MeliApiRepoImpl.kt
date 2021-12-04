package ar.leandro.meliexplorer.data

import ar.leandro.meliexplorer.domain.model.Article
import ar.leandro.meliexplorer.domain.model.Articles
import ar.leandro.meliexplorer.domain.MeliApiRetrofit
import ar.leandro.meliexplorer.domain.MeliRepo

class MeliApiRepoImpl: MeliRepo {

    override suspend fun searchArticles(query: String): Articles {

        val response = MeliApiRetrofit().getArticles(query)
        return response.body()!!
    }

    /*override suspend fun searchItem(id: String): Article {

        val response = MeliApiRetrofit().getItem(id)
        return response.body()!!
    }

    override suspend fun searchSellerArticles(id: String): Articles {

        val response = MeliApiRetrofit().getSellerArticles(id)
        return response.body()!!
    }*/
}