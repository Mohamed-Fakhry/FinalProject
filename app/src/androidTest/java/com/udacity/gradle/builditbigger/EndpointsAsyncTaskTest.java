package com.udacity.gradle.builditbigger;

import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.fail;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class EndpointsAsyncTaskTest {

    @Test
    public void testEndpoints() throws Exception {
        try {
            new EndpointsAsyncTask().execute(new MainActivity.OnGetJokeListener() {
                @Override
                public void onRecive(String joke, boolean success) {
                    assertNotNull("Joke is Null", joke);
                    assertFalse("Joke is Empty", joke.isEmpty());
                    assertEquals(success, true);
                }
            });
            Thread.sleep(3000);
        } catch (Exception ignored) {
            fail(ignored.getMessage());
        }
    }
}
