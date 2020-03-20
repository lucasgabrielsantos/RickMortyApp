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
import java.util.*

class MainActivity : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    private var charactersViewModel: CharactersViewModel? = null
    private val results: List<Result> = ArrayList()
    private var adapterCharacters: CharacterAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        recyclerView!!.layoutManager = GridLayoutManager(this, 3)
        recyclerView!!.adapter = adapterCharacters

        charactersViewModel!!.listCharacters
        charactersViewModel!!.listLiveData.observe(this,
            Observer { results1: List<Result>? -> adapterCharacters!!.setUpdate(results1) })
    }

    fun initViews() {

        recyclerView = findViewById(R.id.recyclerView)
        charactersViewModel = ViewModelProviders.of(this).get(CharactersViewModel::class.java)
        adapterCharacters = CharacterAdapter(results)
    }
}