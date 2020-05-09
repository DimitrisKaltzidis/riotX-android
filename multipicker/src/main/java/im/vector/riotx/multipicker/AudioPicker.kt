/*
 * Copyright (c) 2020 New Vector Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package im.vector.riotx.multipicker

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.media.MediaMetadataRetriever
import android.net.Uri
import android.provider.MediaStore
import im.vector.riotx.multipicker.entity.MultiPickerAudioType
import java.io.File
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.concurrent.TimeUnit

/**
 * Audio file picker implementation
 */
class AudioPicker(override val requestCode: Int) : Picker<MultiPickerAudioType>(requestCode) {

    /**
     * Call this function from onActivityResult(int, int, Intent).
     * Returns selected audio files or empty list if request code is wrong
     * or result code is not Activity.RESULT_OK
     * or user did not select any files.
     */
    override fun getSelectedFiles(context: Context, requestCode: Int, resultCode: Int, data: Intent?): List<MultiPickerAudioType> {
        if (requestCode != this.requestCode && resultCode != Activity.RESULT_OK) {
            return emptyList()
        }

        val audioList = mutableListOf<MultiPickerAudioType>()

        getSelectedUriList(data).forEach { selectedUri ->
            val projection = arrayOf(
                    MediaStore.Audio.Media.DISPLAY_NAME,
                    MediaStore.Audio.Media.SIZE
            )

            context.contentResolver.query(
                    selectedUri,
                    projection,
                    null,
                    null,
                    null
            )?.use { cursor ->
                val nameColumn = cursor.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME)
                val sizeColumn = cursor.getColumnIndex(MediaStore.Audio.Media.SIZE)

                if (cursor.moveToNext()) {
                    val name = cursor.getString(nameColumn)
                    val size = cursor.getLong(sizeColumn)
                    var duration = 0L

                    context.contentResolver.openFileDescriptor(selectedUri, "r")?.use { pfd ->
                        val mediaMetadataRetriever = MediaMetadataRetriever()
                        mediaMetadataRetriever.setDataSource(pfd.fileDescriptor)
                        duration = mediaMetadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION).toLong()
                    }

                    audioList.add(
                            MultiPickerAudioType(
                                    name,
                                    size,
                                    context.contentResolver.getType(selectedUri),
                                    selectedUri,
                                    duration
                            )
                    )
                }
            }
        }
        return audioList
    }

    override fun createIntent(): Intent {
        return Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            putExtra(Intent.EXTRA_ALLOW_MULTIPLE, !single)
            type = "audio/*"
        }
    }

    override fun getSelectedFile(context: Context, uri: String): List<MultiPickerAudioType> {
        val audioList = mutableListOf<MultiPickerAudioType>()
        val  fileName = uri.replace(context.externalCacheDir.toString()+"/","")
        val f = File(context.externalCacheDir,fileName)
        val uris: Uri = Uri.fromFile(f)
        val mmr = MediaMetadataRetriever()
        mmr.setDataSource(context, uris)
        val durationStr = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION)
        val millSecond = durationStr.toLong()
        val seconds = TimeUnit.MILLISECONDS.toSeconds(millSecond)
        val fileSize: Long = java.lang.String.valueOf(f.length() / 1024).toLong()

      /*  val c: Calendar = Calendar.getInstance()
        val df = SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
        val formattedDate: String = df.format(c.time)*/
        audioList.add(
                MultiPickerAudioType(
                        "audio recording ($seconds sec)",
                        fileSize,
                        "audio/3gpp",
                        uris,
                        millSecond
                )
        )

        return audioList;
    }
}
