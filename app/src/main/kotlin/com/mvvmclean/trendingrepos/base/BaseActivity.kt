/*
 * @author   Anoop Maddasseri <anoopmaddasseri@gmail.com>
 * @version  1
 * @since    16th Feb 2020
 *
 * P.S. Increment version when editing
 */
package com.mvvmclean.trendingrepos.base

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.mvvmclean.trendingrepos.R
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.layout_toolbar.*

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initComponents(savedInstanceState)
    }

    protected fun showAlertMessage(message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.app_name))
        builder.setMessage(message)
        builder.setPositiveButton(android.R.string.ok) { dialog, _ ->
            dialog.dismiss()
        }
        builder.show()
    }

    protected fun enableHomeUp(@StringRes title: Int) {
        enableHomeUp(getString(title))
    }

    protected fun enableHomeUp(title: String?) {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        toolbarTitle.text = title
        toolbar.setNavigationIcon(R.drawable.ic_home_up)
        toolbar.setNavigationOnClickListener { supportFinishAfterTransition() }
    }

    protected abstract fun getLayoutId(): Int

    protected abstract fun initComponents(savedInstanceState: Bundle?)

}