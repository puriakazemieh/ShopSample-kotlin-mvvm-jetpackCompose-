package com.kazemieh.www.shop.ui.screens.productdetail

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.kazemieh.www.shop.R
import com.kazemieh.www.shop.data.model.productdetail.NewComment
import com.kazemieh.www.shop.data.remote.NetworkResult
import com.kazemieh.www.shop.ui.component.OurLoading
import com.kazemieh.www.shop.ui.theme.DarkCyan
import com.kazemieh.www.shop.ui.theme.LightCyan
import com.kazemieh.www.shop.ui.theme.amber
import com.kazemieh.www.shop.ui.theme.cardBackground
import com.kazemieh.www.shop.ui.theme.darkText
import com.kazemieh.www.shop.ui.theme.grayAlpha
import com.kazemieh.www.shop.ui.theme.grayCategory
import com.kazemieh.www.shop.ui.theme.roundedShape
import com.kazemieh.www.shop.ui.theme.semiDarkText
import com.kazemieh.www.shop.ui.theme.spacing
import com.kazemieh.www.shop.util.Constants
import com.kazemieh.www.shop.util.Constants.USER_TOKEN
import com.kazemieh.www.shop.viewmodel.ProductDetailViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun NewCommentScreen(
    navController: NavController,
    productId: String,
    productName: String,
    imageUrl: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        Header(navController, productName, imageUrl)
        CommentForm(navController, productId)
    }

}


@Composable
private fun Header(
    navController: NavController,
    productName: String,
    imageUrl: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = MaterialTheme.spacing.extraSmall,
                horizontal = MaterialTheme.spacing.small
            ),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
    ) {

        IconButton(onClick = {
            navController.popBackStack()
        }) {
            Icon(
                imageVector = Icons.Filled.ArrowForward,
                contentDescription = "",
            )
        }

        Image(
            painter = rememberAsyncImagePainter(imageUrl),
            contentDescription = "",
            modifier = Modifier
                .padding(horizontal = MaterialTheme.spacing.small)
                .clip(MaterialTheme.roundedShape.small)
                .size(50.dp)

        )

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = stringResource(id = R.string.your_comment),
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.darkText
            )
            Text(
                text = productName,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.semiDarkText
            )
        }

    }
    Divider(color = MaterialTheme.colorScheme.grayCategory, thickness = 2.dp)


}


@Composable
fun CommentForm(
    navController: NavController,
    productId: String,
    viewModel: ProductDetailViewModel = hiltViewModel()
) {
    var sliderValue by remember {
        mutableStateOf(0f)
    }

    val score = when (sliderValue.toInt()) {
        1 -> ""
        2 -> stringResource(id = R.string.very_bad)
        3 -> stringResource(id = R.string.bad)
        4 -> stringResource(id = R.string.normal)
        5 -> stringResource(id = R.string.good)
        6 -> stringResource(id = R.string.very_good)
        else -> ""
    }

    Text(
        text = score,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = MaterialTheme.spacing.medium),
        style = MaterialTheme.typography.headlineLarge,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.darkText,
        textAlign = TextAlign.Center
    )


    Slider(
        value = sliderValue,
        onValueChange = { sliderValue = it },
        modifier = Modifier
            .padding(horizontal = MaterialTheme.spacing.large),
        onValueChangeFinished = {

        },
        valueRange = 1f..6f,
        steps = 4,
        colors = SliderDefaults.colors(
            thumbColor = MaterialTheme.colorScheme.amber,
            activeTickColor = MaterialTheme.colorScheme.amber,
            inactiveTickColor = MaterialTheme.colorScheme.grayAlpha,
            activeTrackColor = MaterialTheme.colorScheme.amber,
            inactiveTrackColor = MaterialTheme.colorScheme.grayCategory
        )

    )
    Divider(
        modifier = Modifier
            .padding(top = MaterialTheme.spacing.semiMedium),
        color = MaterialTheme.colorScheme.grayCategory,
        thickness = 1.dp,
    )


    var commentTitle by remember { mutableStateOf("") }
    var commentBody by remember { mutableStateOf("") }

    val context = LocalContext.current


    var loading by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(true) {

        viewModel.newCommentResult.collectLatest { newCommentResult ->
            when (newCommentResult) {
                is NetworkResult.Success -> {
                    if (newCommentResult.message.equals("کامنت با موفقیت ثبت شد")) { //todo edit backend
                        navController.popBackStack()
                    }
                    loading = false
                }

                is NetworkResult.Error -> {
                    loading = false
                    Log.e("3636", "ProductDetailScreen error : ${newCommentResult.message}")
                }

                is NetworkResult.Loading -> {

                }

            }
        }

    }


    Column(
        modifier = Modifier
            .padding(horizontal = MaterialTheme.spacing.medium)
    ) {
        Text(
            modifier = Modifier
                .padding(vertical = MaterialTheme.spacing.medium),
            text = stringResource(id = R.string.say_your_comment),
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.darkText,
        )



        Text(
            modifier = Modifier
                .padding(MaterialTheme.spacing.extraSmall),
            text = stringResource(id = R.string.comment_title),
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.darkText,
        )

        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = commentTitle,
            onValueChange = {
                commentTitle = it
            },
            maxLines = 1,
            singleLine = true,
            shape = MaterialTheme.roundedShape.small,
            colors = TextFieldDefaults.colors(
                focusedTextColor = MaterialTheme.colorScheme.darkText,
                unfocusedTextColor = MaterialTheme.colorScheme.LightCyan,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = MaterialTheme.colorScheme.darkText
//                focusedContainerColor = MaterialTheme.colorScheme.cardBackground
            )
        )



        Text(
            modifier = Modifier
                .padding(
                    top = MaterialTheme.spacing.biggerMedium,
                    start = MaterialTheme.spacing.extraSmall,
                    bottom = MaterialTheme.spacing.extraSmall,
                ),
            text = stringResource(id = R.string.comment_text),
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.darkText,
        )

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            value = commentBody,
            onValueChange = { commentBody = it },
            shape = MaterialTheme.roundedShape.small,
            colors = TextFieldDefaults.colors(
                focusedTextColor = MaterialTheme.colorScheme.darkText,
                unfocusedTextColor = MaterialTheme.colorScheme.LightCyan,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = MaterialTheme.colorScheme.darkText
//                focusedContainerColor = MaterialTheme.colorScheme.cardBackground
            ),
            maxLines = 3,
        )


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = MaterialTheme.spacing.small,
                ),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            val checkedState = remember { mutableStateOf(false) }

            Checkbox(
                checked = checkedState.value,
                onCheckedChange = { checkedState.value = it },
                colors = CheckboxDefaults.colors(MaterialTheme.colorScheme.DarkCyan)
            )
            Text(
                text = stringResource(id = R.string.comment_anonymously),
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.darkText,
            )
        }

        Divider(color = MaterialTheme.colorScheme.grayCategory, thickness = 2.dp)


        if (loading) {
            OurLoading(height = 60.dp, isDark = true)
        } else {
            OutlinedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        vertical = MaterialTheme.spacing.medium
                    ),
                onClick = {
                    loading = true
                    val newComment = NewComment(
                        token = USER_TOKEN,
                        productId = productId,
                        star = (sliderValue - 1).toInt(),
                        title = commentTitle,
                        description = commentBody,
                        userName = "کاربر مهمان" //todo change user name
                    )
                    if (newComment.title.isBlank()) {
                        loading = false
                        Toast.makeText(
                            context,
                            context.getString(R.string.comment_title_null),
                            Toast.LENGTH_LONG
                        ).show()
                    } else if (newComment.star == 0) {
                        loading = false
                        Toast.makeText(
                            context,
                            context.getString(R.string.comment_star_null),
                            Toast.LENGTH_LONG
                        ).show()
                    } else if (newComment.description.isBlank()) {
                        loading = false
                        Toast.makeText(
                            context,
                            context.getString(R.string.comment_body_null),
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        viewModel.setNewComment(newComment)
                    }

                }
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = MaterialTheme.spacing.extraSmall),

                    text = stringResource(id = R.string.set_new_comment),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.semiDarkText
                )
            }
        }


    }
}










