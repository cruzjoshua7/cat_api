package com.verycool.catapicall.domain

import com.verycool.catapicall.data.model.CatsDetailsItemModel
import com.verycool.catapicall.data.repositroy.CatsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCatsUseCase @Inject constructor(
    private val repository: CatsRepository
) {

    operator fun invoke(
        limit:Int,
        hasBreed:Int
    ) : Flow<UiState<List<CatsDetailsItemModel>>> = flow {
        emit(UiState.LOADING)
        val response = repository.getCats(limit, hasBreed)
        if(response.isSuccessful){
            response.body()?.let { cats ->
                emit(UiState.SUCCESS(cats))
            } ?: throw Exception("No cats found")
        } else throw Exception(response.errorBody()?.string())
    }.catch { e->
        if(e is Exception){
            emit(UiState.ERROR(e))
        }
    }
}