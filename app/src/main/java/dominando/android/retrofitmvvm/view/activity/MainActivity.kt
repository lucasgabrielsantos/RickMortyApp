package dominando.android.retrofitmvvm.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dominando.android.retrofitmvvm.R
import dominando.android.retrofitmvvm.model.Result
import dominando.android.retrofitmvvm.view.adapter.CharacterAdapter
import dominando.android.retrofitmvvm.viewmodel.CharactersViewModel


class MainActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    private var characterViewModel: CharactersViewModel? = null
    val results: List<Result> = ArrayList()
    private var adapter: CharacterAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        recyclerView?.layoutManager = GridLayoutManager(this, 2)
        recyclerView?.adapter = adapter

        characterViewModel?.Listcharacter

        characterViewModel?.listLiveData!!.observe(this,
            Observer<List<Result?>> { results1: List<Result?> ->
                CharacterAdapter(results).setUpdate(results1)
            })

    }

    private fun initViews() {

        recyclerView = findViewById(R.id.recyclerView)
        characterViewModel = ViewModelProviders.of(this).get(CharactersViewModel::class.java)
        adapter = CharacterAdapter(results)
    }
}
