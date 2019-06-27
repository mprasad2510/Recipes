package org.mp.recipes.data

import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mp.recipes.data.remote.Network
import org.mp.recipes.data.remote.model.*

class RepositoryImplTest {
    @Mock
    private lateinit var network: Network
    private lateinit var repository: RepositoryImpl

    @Before
    fun setUpRepository(){
        MockitoAnnotations.initMocks(this)
        repository = RepositoryImpl(network)
    }

    @Test
    fun loadListTest(){
        val listResponse = Mockito.mock(Response::class.java)
        whenever(network.loadList()).thenReturn(Single.just(listResponse))
        repository.loadList()
        Mockito.verify<Network>(network).loadList()
    }

   @Test
   fun loadListDetail()
   {
       val listDetailResponse = Mockito.mock(DetailResponse::class.java)
       whenever(network.loadDetail("")).thenReturn(Single.just(listDetailResponse))
       repository.loadDetailList("")
       Mockito.verify<Network>(network).loadDetail("")
   }

    @Test
    fun loadImageInDetail()
    {
        val imageResponse =  Mockito.mock(LoadImageResponse::class.java)
        whenever(network.loadImage("")).thenReturn(Single.just(imageResponse))
        repository.loadImage("")
        Mockito.verify<Network>(network).loadImage("")
    }
    @Test
    fun loadTagsInDetail()
    {
        val tagsResponse = Mockito.mock(LoadTagsResponse::class.java)
        whenever(network.loadTags("")).thenReturn(Single.just(tagsResponse))
        repository.loadTags("")
        Mockito.verify<Network>(network).loadTags("")
    }
    companion object {
       // private val listResponse = Mockito.mock(Response::class.java)
       // private val listDetailResponse = Mockito.mock(DetailResponse::class.java)
      //  private val imageResponse =  Mockito.mock(LoadImageResponse::class.java)
       // private val tagsResponse = Mockito.mock(LoadTagsResponse::class.java)
    }
}