package com.verycool.catapicall.data.service

import com.verycool.catapicall.data.model.CatsDetailsItemModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(PATH)
    suspend fun getCats(
        @Query(HAS_BREEDS) hasBreeds:Int,
        @Query(LIMIT_Q) limit : Int
    ) : Response<List<CatsDetailsItemModel>>

}