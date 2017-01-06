package me.pjq.androidunittestdemo;

import android.content.Context;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by i329817(Jianqing.Peng@sap.com) on 1/5/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class AndroidTest {
    private static final String TAG = "AndroidTest";

    @Mock
    private Context context;

    @Before
    public void setUp() {
//        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAndroid() {
        when(context.getString(R.string.app_name)).thenReturn("AndroidUnitTestDemo");
        String name = context.getString(R.string.app_name);
        assertNotNull(name);
        assertThat(name, is("AndroidUnitTestDemo"));
    }

    @After
    public void tearDown() {
        context = null;
    }
}
