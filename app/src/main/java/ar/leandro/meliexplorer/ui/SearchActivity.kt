package ar.leandro.meliexplorer.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ar.leandro.meliexplorer.databinding.ActivitySearchBinding
import ar.leandro.meliexplorer.domain.ItemArticlesAdapter
import ar.leandro.meliexplorer.ui.viewmodels.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchBinding
    private val vm: MainViewModel by viewModel()

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
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}