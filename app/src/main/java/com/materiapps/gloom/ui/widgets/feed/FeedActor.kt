package com.materiapps.gloom.ui.widgets.feed

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.materiapps.gloom.ui.components.BadgedItem

@Composable
fun FeedActor(
    iconUrl: String? = null,
    badgeIcon: ImageVector? = null,
    badgeIconDescription: String? = null,
    iconVector: ImageVector? = null,
    iconDescription: String? = null,
    text: AnnotatedString
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        BadgedItem(badge = if (badgeIcon != null) { ->
            Icon(
                badgeIcon,
                badgeIconDescription,
                modifier = Modifier
                    .size(12.dp)
                    .padding(0.4.dp)
            )
        } else null) {
            if (iconUrl != null)
                AsyncImage(
                    model = iconUrl,
                    contentDescription = iconDescription,
                    modifier = Modifier
                        .size(33.dp)
                        .clip(CircleShape)
                )

            if (iconVector != null)
                Icon(
                    imageVector = iconVector,
                    contentDescription = iconDescription,
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primary)
                        .size(33.dp)
                        .padding(7.dp)
                )
        }
        Text(text = text, style = MaterialTheme.typography.labelMedium)
    }
}

@Composable
fun FeedActor(
    iconUrl: String? = null,
    badgePainter: Painter? = null,
    badgeIconDescription: String? = null,
    iconPainter: Painter? = null,
    iconDescription: String? = null,
    text: AnnotatedString
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        BadgedItem(badge = if (badgePainter != null) { ->
            Icon(
                badgePainter,
                badgeIconDescription,
                modifier = Modifier
                    .size(12.dp)
                    .padding(0.4.dp)
            )
        } else null) {
            if (iconUrl != null)
                AsyncImage(
                    model = iconUrl,
                    contentDescription = iconDescription,
                    modifier = Modifier
                        .size(33.dp)
                        .clip(CircleShape)
                )

            if (iconPainter != null)
                Icon(
                    painter = iconPainter,
                    contentDescription = iconDescription,
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primary)
                        .size(33.dp)
                        .padding(7.dp)
                )
        }
        Text(text = text, style = MaterialTheme.typography.labelMedium)
    }
}
