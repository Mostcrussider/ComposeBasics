package future.birthday.era

import android.content.res.Resources
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import future.birthday.era.ui.theme.FutureBirthdayApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FutureBirthdayApplicationTheme {
                Surface(
                    modifier = Modifier,
                    color = MaterialTheme.colorScheme.background,
                ) {
                    TaskBusinessCard(modifier = Modifier)
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(8.dp)
    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5f,
            modifier = Modifier.align(alignment = Alignment.Center)
        )
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    FutureBirthdayApplicationTheme {
        GreetingImage(
            message = stringResource(R.string.happy_birthday_sam),
            from = stringResource(R.string.from_emma)
        )
    }
}

@Composable
fun ArticleText(modifier: Modifier = Modifier) {
    Column(modifier.padding(16.dp)) {
        Text(
            text = stringResource(R.string.jetpack_compose_tutorial_heading),
            fontSize = 24.sp,
            lineHeight = 24.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = stringResource(R.string.jetpack_compose_subparagraph_1),
            textAlign = TextAlign.Justify
        )
        Text(
            text = stringResource(R.string.jetpack_compose_subparagraph2),
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
        )
    }
}

@Composable
fun ArticleImage(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    Column(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        ArticleText(modifier = Modifier)
    }
}

@Composable
fun MyTask(modifier: Modifier = Modifier) {
    Column(modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            TaskText(
                stringResource(R.string.text_composable),
                stringResource(R.string.text_composable_des),
                Modifier
                    .weight(1f)
                    .background(colorResource(R.color.blue1))
            )
            TaskText(
                stringResource(R.string.image_composable),
                stringResource(R.string.image_composable_desc),
                Modifier
                    .weight(1f)
                    .background(colorResource(R.color.blue2))
            )

        }
        Row(Modifier.weight(1f)) {
            TaskText(
                stringResource(R.string.row_composable),
                stringResource(R.string.row_composable_desc),
                Modifier
                    .weight(1f)
                    .background(colorResource(R.color.blue3))
            )
            TaskText(
                stringResource(R.string.column_composable),
                stringResource(R.string.column_composable_desc),
                Modifier
                    .weight(1f)
                    .background(colorResource(R.color.blue4))
            )
        }
    }
}

@Composable
fun TaskText(
    heading: String,
    description: String,
    modifier: Modifier
) {
    Column(modifier = modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = heading,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun TaskBusinessCard(modifier: Modifier = Modifier) {
    Column(
        modifier
            .fillMaxWidth()
            .background(colorResource(R.color.blue1)))
    {
        Column(
            modifier.weight(0.6f).padding(top = 32.dp).align(Alignment.CenterHorizontally),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val image = painterResource(R.drawable.android_logo)
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .width(150.dp)
                    .background(colorResource(R.color.black))
            )
            Text(
                text = stringResource(R.string.jennifer_doe),
                color = Color.White,
                fontSize = 50.sp,
            )

            Text(
                text = "Android Developer Extraordinaire",
                color = Color(0xFF3ddc84),
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 16.dp)
            )
        }
        Column(modifier.weight(0.4f).align(Alignment.CenterHorizontally).padding(bottom = 48.dp),
            verticalArrangement = Arrangement.Bottom)
        {
            BottomCard(painterResource(R.drawable.ic_call), "+11 (123) 444 555 666", colorResource(R.color.teal_700),modifier = modifier.padding(4.dp))
            BottomCard(painterResource(R.drawable.ic_share), "@AndroidDev", colorResource(R.color.teal_700),modifier = modifier.padding(4.dp))
            BottomCard(painterResource(R.drawable.ic_message), "jen.doe@android.com", colorResource(R.color.teal_700),modifier = modifier.padding(4.dp))
        }
    }
}

@Composable
fun BottomCard(image: Painter, text: String, color : Color, modifier: Modifier = Modifier) {
    Row(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            colorFilter = ColorFilter.tint(color),
        )
        Text(
            text = text,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}