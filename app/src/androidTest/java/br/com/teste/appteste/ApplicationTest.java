package br.com.teste.appteste;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@SmallTest
@RunWith(AndroidJUnit4.class)
public class ApplicationTest {

    @Test
    public void shouldValidAppPackageName() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("br.com.teste.appteste", appContext.getPackageName());
    }
}