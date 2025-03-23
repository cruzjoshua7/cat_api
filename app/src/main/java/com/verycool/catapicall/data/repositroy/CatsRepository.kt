package com.verycool.catapicall.data.repositroy

import com.verycool.catapicall.data.model.CatsDetailsItemModel
import retrofit2.Response

interface CatsRepository {

    suspend fun getCats(
        limit:Int,
        hasBreed:Int
    ):Response<List<CatsDetailsItemModel>>

}