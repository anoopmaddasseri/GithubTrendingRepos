package com.gojek.trendingrepos.activities

import android.os.Build
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.gojek.trendingrepos.R
import com.gojek.trendingrepos.features.trendingrepo.TrendingRepoSearchActivity
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.Shadows
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class TrendingRepoSearchActivity {

    private lateinit var trendingRepoTrendingRepoSearchActivity: TrendingRepoSearchActivity

    @Before
    fun setup() {
        trendingRepoTrendingRepoSearchActivity =
            Robolectric.buildActivity(TrendingRepoSearchActivity::class.java)
                .create()
                .resume()
                .get()
    }

    @Test
    fun `validate recycler list shown`() {
        val repoListView =
            trendingRepoTrendingRepoSearchActivity.findViewById<RecyclerView>(R.id.rvRepository)
        assertThat(repoListView).isNotNull()
        assertThat(repoListView.isVisible)
    }

    @Test
    fun `validate sort menu is displayed`() {
        trendingRepoTrendingRepoSearchActivity =
            Robolectric.buildActivity(TrendingRepoSearchActivity::class.java)
                .create()
                .visible()
                .get()
        val menu = Shadows.shadowOf(trendingRepoTrendingRepoSearchActivity).optionsMenu
        val menuItemSortByName = menu.findItem(R.id.action_sort_by_name)
        val menuItemSortByStars = menu.findItem(R.id.action_sort_by_stars)
        assertThat(menuItemSortByName.isVisible)
        assertThat(menuItemSortByStars.isVisible)
    }

}