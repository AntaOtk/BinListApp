import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.binlistapp.history.domain.model.FullCardInfo
import com.example.binlistapp.history.presenter.HistoryViewModel
import com.example.binlistapp.ui.theme.HellGrey

@Composable
fun ExpandableCard(
    modifier: Modifier,
    viewmodel: HistoryViewModel,
    data: FullCardInfo,
) {
    var expandedState by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        onClick = {
            expandedState = !expandedState
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                modifier = Modifier
                    .clickable { expandedState = !expandedState },
                text = data.bin,
                fontSize = MaterialTheme.typography.titleMedium.fontSize,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            if (expandedState) {
                HistoryInfoCard(modifier, viewmodel, data)
            }
        }
    }
}

@Composable
fun HistoryInfoCard(modifier: Modifier, viewmodel: HistoryViewModel, currentData: FullCardInfo) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
            .clip(shape = RoundedCornerShape(16.dp))
            .background(HellGrey)
            .padding(16.dp)
    ) {
        Text(
            color = Color.Gray,
            text = "BANK: ${currentData.bank?.name ?: "-"}"
        )
        Row {
            Column {
                Text(
                    color = Color.Gray,
                    text = "Brand: ${currentData.brand}"
                )
                Spacer(modifier = modifier.padding(vertical = 8.dp))
                Text(
                    color = Color.Gray,
                    text = "country"
                )
                Text(
                    modifier = modifier.clickable {
                        currentData.country?.name?.let {
                            viewmodel.goToMap(
                                it
                            )
                        }
                    },
                    text = currentData.country?.name ?: "",
                )
            }
            Column {
                Text(
                    color = Color.Gray,
                    text = "Url:"
                )
                Text(
                    modifier = modifier.clickable {
                        currentData.bank?.url?.let {
                            viewmodel.goToUrl(
                                it
                            )
                        }
                    },
                    text = currentData.bank?.url ?: ""
                )
                Text(
                    color = Color.Gray,
                    text = "Мобильный телефон:"
                )
                Text(
                    modifier = modifier.clickable {
                        currentData.bank?.phone?.let {
                            viewmodel.goToCall(
                                it
                            )
                        }
                    },
                    text = currentData.bank?.phone ?: ""
                )
            }
        }
    }
}