/*
 * Copyright 2019 New Vector Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package im.vector.riotx.features.home.room.list.actions

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import im.vector.riotx.R

sealed class RoomListQuickActions(@StringRes val titleRes: Int, @DrawableRes val iconResId: Int) {

    data class NotificationsAllNoisy(val roomId: String) : RoomListQuickActions(
            R.string.room_list_quick_actions_notifications_all_noisy,
            R.drawable.ic_room_actions_notifications_all_noisy
    )

    data class NotificationsAll(val roomId: String) : RoomListQuickActions(
            R.string.room_list_quick_actions_notifications_all,
            R.drawable.ic_room_actions_notifications_all
    )

    data class NotificationsMentionsOnly(val roomId: String) : RoomListQuickActions(
            R.string.room_list_quick_actions_notifications_mentions,
            R.drawable.ic_room_actions_notifications_mentions
    )

    data class NotificationsMute(val roomId: String) : RoomListQuickActions(
            R.string.room_list_quick_actions_notifications_mute,
            R.drawable.ic_room_actions_notifications_mutes
    )

    data class Settings(val roomId: String) : RoomListQuickActions(
            R.string.room_list_quick_actions_settings,
            R.drawable.ic_room_actions_settings
    )

    data class Leave(val roomId: String) : RoomListQuickActions(
            R.string.room_list_quick_actions_leave,
            R.drawable.ic_room_actions_leave
    )

    companion object {
        fun all(roomId: String): List<RoomListQuickActions> {
            return listOf(
                    NotificationsAllNoisy(roomId),
                    NotificationsAll(roomId),
                    NotificationsMentionsOnly(roomId),
                    NotificationsMute(roomId),
                    Settings(roomId),
                    Leave(roomId)
            )
        }
    }
}
