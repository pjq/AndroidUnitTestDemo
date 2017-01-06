package me.pjq.androidunittestdemo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.eq;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

/**
 * Created by i329817(Jianqing.Peng@sap.com) on 1/6/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class AndroidMockitoTest {
    @Mock
    private UserApi userApi;

    private UserApiCaller userApiCaller;

    @Captor
    private ArgumentCaptor<UserApi.Callback<Object>> callbackArgumentCaptor;

    @Before
    public void setUp() {
        userApiCaller = new UserApiCaller();
        userApiCaller.setUserApi(userApi);
    }

    @Test
    public void testUserApi() {
        userApiCaller.call();
        Mockito.verify(userApi).register(Mockito.anyString(), callbackArgumentCaptor.capture());
        Object result = new String("mockito result");
        callbackArgumentCaptor.getValue().onSuccess(result);
        assertEquals(userApiCaller.getValue(), result);

        callbackArgumentCaptor.getValue().onFailed("mockito failed", result);
        assertEquals(userApiCaller.getValue(), result);

        Mockito.verify(userApi).register(eq("jack"), callbackArgumentCaptor.capture());
        assertEquals(userApiCaller.getValue(), result);
    }

    @After
    public void tearDown() {
        userApi = null;
        userApiCaller = null;
        callbackArgumentCaptor = null;
    }
}
