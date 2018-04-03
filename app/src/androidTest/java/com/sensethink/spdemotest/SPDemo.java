package com.sensethink.spdemotest;

import android.content.Context;
import android.graphics.Path;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.Tracer;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiSelector;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import javax.crypto.spec.OAEPParameterSpec;

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
    private static final String Package = "com.senseplay.spdemo";
    private static final String MainActivity = ".MainActivity";

    private static void StartSPDemo() throws IOException {
        Operate.StartApp(Package, MainActivity);
    }


    @BeforeClass
    public static void BeforeClass() throws Exception {
        Operate.StopApp(Package);

    }

    @AfterClass()
    public static void AfterClass() throws Exception {

    }

    @Before
    public void Before() throws Exception {
        mContext = InstrumentationRegistry.getTargetContext();
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        if (!mDevice.getCurrentPackageName().equals(Package)) {
            SPDemo.StartSPDemo();
            return;
        }
        this.Return2Home();

    }

    private void Return2Home() throws IOException {
        for (int i = 0; i < 50; i++) {
            Operate.sleep(500);
            if (mDevice.findObject(new UiSelector().text("KEYMAP读写")).exists()) {
                return;
            } else {
                mDevice.pressBack();
            }
            if (!mDevice.getCurrentPackageName().equals(Package)) {
                this.StartSPDemo();
                return;
            }
        }
    }

    @After
    public void After() throws IOException {
    }


    @Test
    public void RepeatSwitchUSB() throws Exception {
        mDevice.findObject(new UiSelector().text("搜索设备")).click();
        for (int i = 0; i < 100; i++) {
            Operate.Info(i);
            mDevice.findObject(new UiSelector().text("OPEN USB")).click();
            mDevice.findObject(new UiSelector().text("CLOSE USB")).click();
        }
    }

    @Test
    public void RepeatSetAndClearUID() throws Exception {
    }

    @Test
    public void A_Login() throws Exception {
        String account = "13641746250";
        String password = "123456";
        Operate.StartApp("com.senseplay.spdemo", ".MainActivity");
        mDevice.findObject(new UiSelector().text("登陆注册")).click();
        mDevice.findObject(new UiSelector().text("登陆")).click();
        mDevice.findObject(new UiSelector().text("Phone Number or Email")).setText(account);
        mDevice.findObject(new UiSelector().resourceId("pwd")).setText(password);
        mDevice.findObject(new UiSelector().description("login").className("android.widget.Button")).click();
        mDevice.findObject(new UiSelector().text("获取用户信息")).click();
        String login_info = mDevice.findObject(new UiSelector().resourceId("com.senseplay.spdemo:id/login_info_text")).getText();
        assertEquals(true, login_info.contains(account));


    }

}
