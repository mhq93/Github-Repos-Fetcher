package com.mhq.github_trending_repos

import android.app.Application
import com.mhq.github_trending_repos.data.AppContainer
import com.mhq.github_trending_repos.data.DefaultAppContainer

class GithubReposApplication: Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}