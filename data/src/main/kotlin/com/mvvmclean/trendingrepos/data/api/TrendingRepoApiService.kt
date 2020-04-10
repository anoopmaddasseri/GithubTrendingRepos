/*
 * @author   Anoop Maddasseri <anoopmaddasseri@gmail.com>
 * @version  1
 * @since    16th Feb 2020
 *
 * P.S. Increment version when editing
 */
package com.mvvmclean.trendingrepos.data.api

import com.mvvmclean.trendingrepos.data.models.response.TrendingRepoResponse
import retrofit2.http.GET


interface TrendingRepoApiService {
    @GET("repositories")
    suspend fun searchTrendingRepositories(): MutableList<TrendingRepoResponse>
}