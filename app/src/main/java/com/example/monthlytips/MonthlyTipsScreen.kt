package com.example.monthlytips

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.monthlytips.model.MonthlyTip
import com.example.monthlytips.ui.theme.MonthlyTIpsTheme
import com.example.monthlytips.ui.theme.Shapes

@Composable
fun TipItem(
    tip: MonthlyTip,
    modifier: Modifier = Modifier
){
    var expanded by remember {
        mutableStateOf(false)
    }
    Card(
        modifier = modifier,
        shape = Shapes.medium
    ){
        TipButton(day = tip.day, onClick = { expanded = !expanded})
        if (expanded){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ){
                TipImage(tipImg = tip.imgRes)
                TipInformation(tipText = tip.tipRes)
            }
        }
    }
    Spacer(modifier = modifier.height(10.dp))
}

@Composable
fun TipButton(
    day: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    TextButton(
        onClick = onClick,
        modifier = modifier
            .padding(dimensionResource(id = R.dimen.padding_medium))
            .fillMaxWidth()
    ) {
        Text(
            text = "Day $day",
            style = MaterialTheme.typography.titleLarge,
        )
    }
}

@Composable
fun TipInformation(
    @StringRes tipText: Int,
    modifier: Modifier = Modifier,
){
    Text(
        text = stringResource(id = tipText),
        style = MaterialTheme.typography.bodyLarge,
        modifier = modifier.padding(dimensionResource(id = R.dimen.padding_medium))
    )
}

@Composable
fun TipImage(
    @DrawableRes tipImg: Int,
    modifier: Modifier = Modifier
){
    Image(
        painter = painterResource(id = tipImg),
        contentDescription = null,
        modifier = modifier
            .size(height = 128.dp, width = 256.dp)
            .padding(dimensionResource(id = R.dimen.padding_small))
            .clip(Shapes.large),
        contentScale = ContentScale.Crop
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TipTopAppBar(
    modifier: Modifier = Modifier
){
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "IT-Советы",
                style = MaterialTheme.typography.displayLarge
            )
        },
        modifier = modifier
    )
}


@Preview("Light Theme", showSystemUi = true)
@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES, showSystemUi = true)
@Composable
fun HeroPreview() {
    val tip = MonthlyTip(
        1,
        R.string.day_1,
        R.drawable.day_1
    )
    MonthlyTIpsTheme {
        TipItem(tip = tip)
    }
}