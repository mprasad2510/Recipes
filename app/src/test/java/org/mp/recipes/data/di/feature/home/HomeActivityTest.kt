package org.mp.recipes.data.di.feature.home

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import org.junit.Before
import org.junit.runner.RunWith
import org.mp.recipes.data.remote.model.Fields
import org.mp.recipes.data.remote.model.ItemsItem
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment

@RunWith(RobolectricTestRunner::class)
class HomeActivityTest {
    private lateinit var recyclerView : RecyclerView
    private lateinit var linearLayoutManger : LinearLayoutManager
    private lateinit var dataSource: List<ItemsItem>
    private lateinit var click:(Fields?)->Unit
    @Before
    fun setUp()
    {
        recyclerView = RecyclerView(RuntimeEnvironment.application.applicationContext)
        recyclerView.layout(0,0,500,500)
        linearLayoutManger = LinearLayoutManager(RuntimeEnvironment.application, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = linearLayoutManger
        val adapter = NewsAdapter(dataSource,click)
        recyclerView.adapter = adapter

    }
}