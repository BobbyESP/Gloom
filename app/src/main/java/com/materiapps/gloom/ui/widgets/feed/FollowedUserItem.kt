package com.materiapps.gloom.ui.widgets.feed

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PersonAddAlt1
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.unit.dp
import com.materiapps.gloom.R
import com.materiapps.gloom.fragment.FollowedUserFeedItemFragment
import com.materiapps.gloom.utils.annotatingStringResource

@Composable
fun FollowedUserItem(
    item: FollowedUserFeedItemFragment,
    followData: Pair<Boolean, Int>? = null,
    onFollowPressed: (String) -> Unit = {},
    onUnfollowPressed: (String) -> Unit = {},
) {
    val actor = item.follower
    val user = item.followee
    val userLogin = user.feedUser?.login ?: user.feedOrg?.login
    val userId = user.feedUser?.id ?: user.feedOrg?.id!!
    val actorText = if (user.feedUser?.isViewer == true) annotatingStringResource(
        R.string.followed_you,
        actor.login
    ) {
        followedAnnotations(it)
    } else annotatingStringResource(R.string.followed_user, actor.login, userLogin ?: "ghost") {
        followedAnnotations(it)
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        FeedActor(
            iconUrl = actor.avatarUrl.toString(),
            iconDescription = stringResource(R.string.noun_users_avatar, actor.login),
            badgeIcon = Icons.Filled.PersonAddAlt1,
            badgeIconDescription = stringResource(R.string.noun_followed),
            text = actorText
        )

        FeedUserCard(
            user.feedUser to user.feedOrg,
            followData = followData,
            onFollowPressed = { onFollowPressed(userId) },
            onUnfollowPressed = { onUnfollowPressed(userId) }
        )
    }
}

@Composable
fun followedAnnotations(name: String) = when (name) {
    "name" -> SpanStyle(color = MaterialTheme.colorScheme.onSurface)
    "text" -> SpanStyle(color = MaterialTheme.colorScheme.onSurface.copy(0.7f))
    "other" -> SpanStyle(color = MaterialTheme.colorScheme.onSurface)
    else -> null
}