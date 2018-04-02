package common;

import android.graphics.Path;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiDevice;

import com.sensethink.spdemotest.SPDemo;

import java.io.IOException;

/**
 * Created by dell on 2018/3/23.
 */

public class Operate {

    private static LogUnit mLog = new LogUnit("wuyou", "/sdcard/aaa/");

    public static void Info(Object msg) {
        mLog.i(msg);
    }

    public static void Error(Object msg) {
        mLog.e(msg);
    }

    public static void Warm(Object msg) {
        mLog.w(msg);
    }

    public static void Debug(Object msg) {
        mLog.d(msg);
    }


    public static void StartApp(String Package, String Activity) throws IOException {
        UiDevice mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        mDevice.executeShellCommand("am start -n " + Package + "/" + Activity);
        Operate.Info("StartApp:" + Package + "/" + Activity);
    }

    public static void StopApp(String Package) throws IOException {
        UiDevice mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        mDevice.executeShellCommand("am force-stop " + Package);
        Operate.Info("StopApp :" + Package);
    }

    public static void sleep(long millisecond) {
        try {
            Thread.sleep(millisecond);
        } catch (Exception InterruptedException) {
            Operate.Error("millisecond:" + millisecond);
        }
    }
}

