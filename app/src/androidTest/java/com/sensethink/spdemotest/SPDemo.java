package com.sensethink.spdemotest;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiSelector;
import android.util.Log;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import common.Operate;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class SPDemo {
    private UiDevice mDevice = null;
    private Context mContext = null;

    @BeforeClass
    public static void BeforeClass() throws Exception {
        Log.i("wuyou", "SPDemo Test Start.");
        SPDemo.Login("13641746250","123456");
    }

    @AfterClass()
    public static void AfterClass() {
        Log.i("wuyou", "SPDemo Test Finished.");


    }

    @Before
    public void Before() throws IOException {
        mContext = InstrumentationRegistry.getTargetContext();
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        mDevice.executeShellCommand("am start -n com.senseplay.spdemo/.MainActivity");
    }

    @After
    public void After() throws IOException {
        mDevice.executeShellCommand("am force-stop com.senseplay.spdemo");
    }


    @Test
    public void RepeatSwitchUSB() throws Exception {
        mDevice.findObject(new UiSelector().text("搜索设备")).click();
        for (int i = 0; i < 100; i++) {
            mDevice.findObject(new UiSelector().text("OPEN USB")).click();
            mDevice.findObject(new UiSelector().text("CLOSE USB")).click();
        }
    }

    @Test
    public void RepeatSetAndClearUID() throws Exception {
    }

    public void Login(String Account, String Password) throws IOException{
        Operate.StartApp("com.senseplay.spdemo", ".test.LoginActivity");

    }

}
