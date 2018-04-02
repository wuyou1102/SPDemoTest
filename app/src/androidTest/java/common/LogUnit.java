package common;

import android.util.Log;

/**
 * Created by dell on 2018/3/23.
 */

public class LogUnit {
    private String Tag;
    private String LogPath;

    public LogUnit(String Tag, String Path) {
        this.Tag = Tag;
        this.LogPath = Path;

    }

    public void d(Object msg) {
        Log.d(this.Tag, msg + "");
    }

    public void i(Object msg) {
        Log.i(this.Tag, msg + "");
    }

    public void w(Object msg) {
        Log.w(this.Tag, msg + "");
    }

    public void e(Object msg) {
        Log.e(this.Tag, msg + "");
    }
}
