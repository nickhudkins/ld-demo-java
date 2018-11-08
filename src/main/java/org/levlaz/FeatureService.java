package org.levlaz;

import com.launchdarkly.client.LDClient;
import com.launchdarkly.client.LDUser;

import org.levlaz.FeatureProvider;

public class FeatureService {
    private final LDClient featureProvider;

    public FeatureService() {
        featureProvider = FeatureProvider.INSTANCE.getInstance();
    }

    public Boolean boolVariation(String key, LDUser user, Boolean fallback) {
        return featureProvider.boolVariation(key, user, fallback);
    }
}