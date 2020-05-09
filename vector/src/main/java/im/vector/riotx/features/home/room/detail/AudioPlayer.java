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

import android.media.MediaPlayer;
import android.util.Log;

import java.io.File;
import java.io.IOException;

public class AudioPlayer {
    private static MediaPlayer mp;

    public static void playAudio(File file){

        if(mp != null){
            if (mp.isPlaying()){
               stopPlaying();
            }
        }

        mp = new MediaPlayer();
        try {
            mp.setDataSource(file.getAbsolutePath());
            mp.prepare();
            mp.start();
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("Audio Player", "Failed to play audio file");
        }

    }

    private static void stopPlaying() {
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }
    }
}
