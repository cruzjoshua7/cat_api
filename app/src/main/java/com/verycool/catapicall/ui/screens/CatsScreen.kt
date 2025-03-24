package com.verycool.catapicall.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.verycool.catapicall.R
import com.verycool.catapicall.domain.UiState
import com.verycool.catapicall.viewmodel.CatsViewModel

private const val TAG = "CatsScreen"

@Composable
fun CatsScreen(
    modifier: Modifier,
    viewModel: CatsViewModel
){
    val state = viewModel.catsState.collectAsState().value

    when(state){
        is UiState.ERROR -> { Log.e(TAG,"CatsScreen: ${state.e}")}
        UiState.LOADING -> {
            Column {
                CircularProgressIndicator()
            }
        }
        is UiState.SUCCESS -> {
            val cats = state.response

            LazyColumn(
                modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                items(cats){ cat ->
                    Card {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(cat.url)
                                .error(R.drawable.ic_launcher_background)
                                .build(),
                            contentDescription = "its a cat"
                        )
                        Text("the id ${cat.id}")
                        Text("Breed: ${cat.breeds.toString()}")
                    }
                }
            }
        }
    }
}