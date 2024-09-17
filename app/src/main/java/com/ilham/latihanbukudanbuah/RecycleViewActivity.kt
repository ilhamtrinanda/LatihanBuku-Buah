package com.ilham.latihanbukudanbuah

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ilham.latihanbukudanbuah.adapter.BukuAdapter
import com.ilham.latihanbukudanbuah.model.ModelBuku

class RecycleViewActivity : AppCompatActivity() {

    private lateinit var rv_data : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycle_view)

        rv_data = findViewById(R.id.rv_data)

        // kita bikin array data
        val listBuku = listOf(
            ModelBuku(judul = "Buku Android Kotlin 2024", penerbit = "Ilham Trinanda"),
            ModelBuku(judul = "Buku Android Kotlin 2024", penerbit = "bakachi9"),
            ModelBuku(judul = "Buku Android Kotlin 2024", penerbit = "Ilham Trinanda"),
            ModelBuku(judul = "Buku Android Kotlin 2024", penerbit = "bakachi9"),
            ModelBuku(judul = "Buku Android Kotlin 2024", penerbit = "Ilham Trinanda")
        )

        val nBukuAdapter = BukuAdapter(listBuku)
        rv_data.apply {
            layoutManager = LinearLayoutManager(this@RecycleViewActivity)
            adapter = nBukuAdapter
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}