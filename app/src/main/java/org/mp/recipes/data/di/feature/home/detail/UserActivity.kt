package org.mp.recipes.data.di.feature.home.detail

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import com.bumptech.glide.Glide
import dagger.android.AndroidInjector
import dagger.android.HasActivityInjector
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject
import kotlinx.android.synthetic.main.activity_user.*
import org.mp.recipes.R
import org.mp.recipes.data.di.base.BaseActivity
import org.mp.recipes.data.di.mvibase.MviView
import org.mp.recipes.data.remote.model.Fields
import org.mp.recipes.utils.gone
import org.mp.recipes.utils.visible


class UserActivity : BaseActivity(), MviView<UserIntent, UserViewState>, HasActivityInjector {

    override fun bind() {
        viewModel.processIntents(intents())
        viewModel.states().observe(this, Observer { if (it != null) render(it) })
    }

    companion object
    {
        var id = ""
        var assetId = ""
    }

    override fun layoutId(): Int {
        val view = R.layout.activity_user
        id = intent.getStringExtra("id")
        return view
    }


    @Inject
    lateinit var factory: UserViewModelFactory

    private val clickIntent = PublishSubject.create<UserIntent.ClickIntent>()


    private val viewModel: UserViewModel by lazy(LazyThreadSafetyMode.NONE) {
        ViewModelProviders.of(this, factory).get(UserViewModel::class.java)
    }

    private fun initialIntent(): Observable<UserIntent.InitialIntent> {
        return Observable.just(UserIntent.InitialIntent)
    }

    private fun loadImageIntent(): Observable<UserIntent.LoadImageIntent>
    {
        return Observable.just(UserIntent.LoadImageIntent)
    }

    private fun loadTagsIntent(): Observable<UserIntent.LoadTagsIntent>
    {
        return Observable.just(UserIntent.LoadTagsIntent)
    }

    override fun intents(): Observable<UserIntent> {
        return Observable.merge(initialIntent(),loadImageIntent(),loadTagsIntent(), clickIntent)
    }

    override fun render(state: UserViewState) {
        with(state) {
            if (isLoadingUser) {
                progressBar1.visible()
            } else {
                progressBar1.gone()
            }
                Glide.with(coverImage).load("https:" + imageList?.file?.url).into(coverImage)
                text_by.text = userList?.title
                text_time.text = StringBuilder().append("Chef : ").append(userList?.name)
                text_parent.text = StringBuilder().append("tags : ").append(tagsList?.name)
                text_comments.text = StringBuilder().append("Calories : ").append(userList?.calories.toString())
                text_kids.text = StringBuilder().append("Description : ").append(userList?.description)
            if (showShareOption) {
                //showShareIntent(user)
            }

        }
    }

    private fun showShareIntent(shareArticle: Fields?) {
        shareArticle?.let {
            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.putExtra(
                Intent.EXTRA_TEXT,
                shareArticle.title
            )
            sendIntent.type = "text/plain"
            startActivity(sendIntent)
        }
    }


    override fun activityInjector(): AndroidInjector<Activity> {
        return injector
    }

}