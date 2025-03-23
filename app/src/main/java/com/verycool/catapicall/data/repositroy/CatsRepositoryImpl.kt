package com.verycool.catapicall.data.repositroy

import com.verycool.catapicall.data.model.CatsDetailsItemModel
import com.verycool.catapicall.data.service.ApiService
import retrofit2.Response
import javax.inject.Inject

class CatsRepositoryImpl@Inject constructor(
    private val service : ApiService
):CatsRepository {
    override suspend fun getCats(limit: Int, hasBreed: Int): Response<List<CatsDetailsItemModel>> {
        return service.getCats(hasBreed, limit)
    }
}