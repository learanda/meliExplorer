package ar.leandro.meliexplorer.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.leandro.meliexplorer.domain.MeliRepo
import ar.leandro.meliexplorer.domain.model.Article
import ar.leandro.meliexplorer.domain.model.Articles
import kotlinx.coroutines.launch

class MainViewModel(val meliRepoImpl: MeliRepo) : ViewModel() {

    val articlesList = MutableLiveData<Articles>()
    val articlesListException = MutableLiveData<Throwable>()
    val item = MutableLiveData<Article>()
    val itemException = MutableLiveData<Throwable>()
    val sellerArticles = MutableLiveData<Articles>()
    val sellerArticlesException = MutableLiveData<Throwable>()

    fun findArticles(query: String) {
        viewModelScope.launch {
            try {
                articlesList.value = meliRepoImpl.searchArticles(query)
            } catch (e: Exception) {
                articlesListException.value = e
            }
        }
    }

    fun findItem(id: String) {
        viewModelScope.launch {
            try {
                item.value = meliRepoImpl.searchItem(id)
            } catch (e: Exception) {
                itemException.value = e
            }
        }
    }

    fun findSellerArticles(id: String) {
        viewModelScope.launch {
            try {
                sellerArticles.value = meliRepoImpl.searchSellerArticles(id)
            } catch (e: Exception) {
                sellerArticlesException.value = e
            }
        }
    }
}