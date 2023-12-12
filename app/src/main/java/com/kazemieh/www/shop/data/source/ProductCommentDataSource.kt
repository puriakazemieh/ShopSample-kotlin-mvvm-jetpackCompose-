package com.kazemieh.www.shop.data.source

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.kazemieh.www.shop.data.model.productdetail.Comment
import com.kazemieh.www.shop.repository.ProductDetailRepository
import javax.inject.Inject

class ProductCommentDataSource(
    private val repository: ProductDetailRepository,
    val productId: String
) :
    PagingSource<Int, Comment>() {
    override fun getRefreshKey(state: PagingState<Int, Comment>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.prevKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Comment> {
        return try {
            val nextPageNumber = params.key ?: 1
            val response = repository.getAllProductComments(
                pageNumber = nextPageNumber.toString(),
                pageSize = "10",
                id = productId
            ).data
            LoadResult.Page(data = response!!, prevKey = null, nextKey = nextPageNumber + 1)
        } catch (e: Exception) {
            Log.d("949494", " error = $e ")
            LoadResult.Error(e)
        }
    }


}