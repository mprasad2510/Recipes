package org.mp.recipes.data.di.feature.home

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import dagger.android.AndroidInjector
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import dagger.android.HasActivityInjector
import kotlinx.android.synthetic.main.activity_main.*
import org.mp.recipes.R
import org.mp.recipes.data.di.base.BaseActivity
import org.mp.recipes.data.di.feature.home.detail.UserActivity
import org.mp.recipes.data.di.mvibase.MviView
import org.mp.recipes.data.remote.model.Fields
import org.mp.recipes.data.remote.model.Items
import org.mp.recipes.utils.gone
import org.mp.recipes.utils.visible


class HomeActivity : BaseActivity(), MviView<HomeIntent, HomeViewState>, HasActivityInjector {

    override fun bind() {
        newsRv.layoutManager = LinearLayoutManager(this)

        viewModel.processIntents(intents())
        viewModel.states().observe(this, Observer { if (it != null) render(it) })

    }

    override fun layoutId(): Int = R.layout.activity_main


    @Inject
    lateinit var factory: HomeViewmodelFactory

    private val clickIntent = PublishSubject.create<HomeIntent.ClickIntent>()



    private val viewModel: HomeViewModel by lazy(LazyThreadSafetyMode.NONE) {
        ViewModelProviders.of(this, factory).get(HomeViewModel::class.java)
    }

    private fun initialIntent(): Observable<HomeIntent.InitialIntent> {
        return Observable.just(HomeIntent.InitialIntent)
    }

    override fun intents(): Observable<HomeIntent> {
        return Observable.merge(initialIntent(), clickIntent)
    }

    override fun render(state: HomeViewState) {
        with(state) {
            if (isLoading) {
                progressBar.visible()
            } else {
                progressBar.gone()
            }
            if (!articles.isEmpty()) {
                newsRv.adapter = NewsAdapter(articles, { clickItem -> clickIntent.onNext(HomeIntent.ClickIntent(clickItem)) })
            }
            if(showShareOption){

                showIntent(articles)
            }


        }
    }
    private var itemPosition: Int = 0
    private  var  itemValue:String? = ""
    private fun showIntent(articles: List<Items>) {
        for (value in articles) {

            itemValue = value.fields?.title
        }

        for (position in articles.indices) {

            itemPosition = position
        }
        Log.d("***POS OF ARTICLE***", "$itemPosition")
        Log.d("***ID OF ARTICLE***", "$itemValue")
            val intent = Intent(this@HomeActivity, UserActivity::class.java)
             with(intent)
             {
                 putExtra("id", itemValue)
                 putExtra("position", itemPosition)
                 Log.d("***ID OF ARTICLE1***", "$itemValue")
             }
            startActivity(intent)

    }


    override fun activityInjector(): AndroidInjector<Activity> {
        return injector
    }

}
