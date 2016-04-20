package com.uphold.uphold_android_sdk.test.integration.client.restadapter;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;

import com.darylteo.rx.promises.java.Promise;
import com.darylteo.rx.promises.java.functions.RepromiseFunction;
import com.uphold.uphold_android_sdk.BuildConfig;
import com.uphold.uphold_android_sdk.client.errorhandling.UpholdRetrofitErrorHandling;
import com.uphold.uphold_android_sdk.client.restadapter.UpholdRestAdapter;
import com.uphold.uphold_android_sdk.model.Card;
import com.uphold.uphold_android_sdk.model.User;
import com.uphold.uphold_android_sdk.test.util.Fixtures;
import com.uphold.uphold_android_sdk.test.util.MockRestAdapter;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

import retrofit.RestAdapter;
import retrofit.client.Header;
import retrofit.client.Request;

/**
 * UpholdRestAdapter integration tests.
 */

@RunWith(AndroidJUnit4.class)
@SmallTest
public class UpholdRestAdapterTest {

    @Test
    public void setAdapterShouldSetTheAdapter() {
        UpholdRestAdapter upholdRestAdapter = new UpholdRestAdapter();
        RestAdapter adapter = new RestAdapter.Builder().setEndpoint(BuildConfig.API_SERVER_URL)
            .setErrorHandler(new UpholdRetrofitErrorHandling())
            .setRequestInterceptor(upholdRestAdapter.getUpholdRequestInterceptor("foobar"))
            .build();

        upholdRestAdapter.setAdapter(adapter);

        Assert.assertEquals(adapter, upholdRestAdapter.getAdapter());
    }

    @Test
    public void upholdRestAdapterWithTokenShoulSetTheUpholdCustomHeadersWithAuthenticationHeader() throws Exception {
        MockRestAdapter<Card> adapter = new MockRestAdapter<>("fuz", null, null);

        adapter.request(new RepromiseFunction<UpholdRestAdapter, Card>() {
            @Override
            public Promise<Card> call(UpholdRestAdapter adapter) {
                User user = Fixtures.loadUser();

                user.setUpholdRestAdapter(adapter);

                return user.getCardById("foobar");
            }
        });

        Request request = adapter.getRequest();

        Assert.assertEquals(request.getHeaders().size(), 2);
        Assert.assertTrue(request.getHeaders().contains(new Header("Authorization", "Bearer fuz")));
        Assert.assertTrue(request.getHeaders().contains(new Header("User-Agent", "uphold-android-sdk/0.2.0-rc.1 (https://github.com/uphold/uphold-sdk-android)")));
    }

    @Test
    public void setUpholdRequestInterceptorWithEmptyTokenShouldSetTheUpholdCustomHeadersWithoutAuthenticationHeader() throws Exception {
        MockRestAdapter<Card> adapter = new MockRestAdapter<>("", null, null);

        adapter.request(new RepromiseFunction<UpholdRestAdapter, Card>() {
            @Override
            public Promise<Card> call(UpholdRestAdapter adapter) {
                User user = Fixtures.loadUser();

                user.setUpholdRestAdapter(adapter);

                return user.getCardById("foobar");
            }
        });

        Request request = adapter.getRequest();

        Assert.assertEquals(request.getHeaders().size(), 1);
        Assert.assertTrue(request.getHeaders().contains(new Header("User-Agent", "uphold-android-sdk/0.2.0-rc.1 (https://github.com/uphold/uphold-sdk-android)")));
    }

    @Test
    public void setUpholdRequestInterceptorWithNullTokenShouldSetTheUpholdCustomHeadersWithoutAuthenticationHeader() throws Exception{
        MockRestAdapter<Card> adapter = new MockRestAdapter<>(null, null, null);

        adapter.request(new RepromiseFunction<UpholdRestAdapter, Card>() {
            @Override
            public Promise<Card> call(UpholdRestAdapter adapter) {
                User user = Fixtures.loadUser();

                user.setUpholdRestAdapter(adapter);

                return user.getCardById("foobar");
            }
        });

        Request request = adapter.getRequest();

        Assert.assertEquals(request.getHeaders().size(), 1);
        Assert.assertTrue(request.getHeaders().contains(new Header("User-Agent", "uphold-android-sdk/0.2.0-rc.1 (https://github.com/uphold/uphold-sdk-android)")));
    }

}
