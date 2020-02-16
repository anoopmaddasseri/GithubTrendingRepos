package com.gojek.trendingrepos.features.trendingrepo

import android.os.Bundle
import com.gojek.trendingrepos.R
import com.gojek.trendingrepos.base.BaseActivity

class TrendingRepoSearchActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trending_repository)
    }

    override fun getLayoutId() =
        R.layout.activity_trending_repository

    override fun initComponents(savedInstanceState: Bundle?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
