package common;

import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiDevice;
import android.util.Log;

import java.io.IOException;

/**
 * Created by dell on 2018/3/23.
 */

public class Operate {


    public static void Info(String msg) {
        Log.i("wuyou", msg);
    }


    public static void StartApp(String Package, String Activity) throws IOException {
        UiDevice mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        mDevice.executeShellCommand("am start -n " + Package + "/" + Activity);
    }

    public static void StopApp(String Package) throws IOException {
        UiDevice mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        mDevice.executeShellCommand("am force-stop " + Package);
    }

}

