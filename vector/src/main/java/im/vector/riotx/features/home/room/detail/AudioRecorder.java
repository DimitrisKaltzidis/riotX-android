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

package im.vector.riotx.features.home.room.detail;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.util.Log;

import androidx.core.app.ActivityCompat;

import java.io.IOException;

import im.vector.matrix.android.api.session.content.ContentAttachmentData;

public class AudioRecorder {
    private static final String LOG_TAG = "AudioRecordTest";
    private static String fileName = null;

    private static MediaRecorder recorder = null;

    public static void startRecording(Context activity) {
        // Record to the external cache directory for visibility
        fileName = activity.getExternalCacheDir().getAbsolutePath();
        fileName += "/audiorecordtest.3gp";

        if(recorder!=null){
            stopRecorder();
        }

        recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recorder.setOutputFile(fileName);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try {
            recorder.prepare();
        } catch (IOException e) {
            Log.e(LOG_TAG, "prepare() failed");
        }

        recorder.start();
    }

    public static String stopRecording() {
        stopRecorder();

        return fileName;
    }

    private static void stopRecorder() {
        recorder.stop();
        recorder.release();
        recorder = null;
    }

    /* mimeType = mimeType,
                type = mapType(),
                size = size,
                name = displayName,
                duration = duration,
                queryUri = contentUri*/
}
