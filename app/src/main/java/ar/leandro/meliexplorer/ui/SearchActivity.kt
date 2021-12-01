package ar.leandro.meliexplorer.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ar.leandro.meliexplorer.R
import ar.leandro.meliexplorer.databinding.ActivitySearchBinding
import ar.leandro.meliexplorer.domain.ItemArticlesAdapter
import ar.leandro.meliexplorer.ui.viewmodels.SearchViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import retrofit2.HttpException

class SearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchBinding
    private val vm: SearchViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setListeners()
        setObservers()
    }

    private fun setListeners() {
        binding.btnSearch.setOnClickListener {
            vm.findArticles(binding.etSearch.text.toString())
        }
    }

    private fun setObservers() {
        vm.articlesList.observe(this, {
            if (it != null) {
                binding.rvArticles.adapter = ItemArticlesAdapter(it)
            }
        })
        vm.articlesListException.observe(this, this::handleException)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun handleException(exception: Throwable?) {
        if (exception is HttpException)
            when (exception.code()) {
                400 -> Toast.makeText(this, R.string.bad_request.toString(), Toast.LENGTH_LONG).show()
                404 -> Toast.makeText(this, R.string.resource_not_found.toString(), Toast.LENGTH_LONG).show()
                in 500..599 -> Toast.makeText(this, R.string.server_error.toString(), Toast.LENGTH_LONG).show()
                else -> Toast.makeText(this, R.string.unknown_error.toString(), Toast.LENGTH_LONG).show()
            }
    }
}