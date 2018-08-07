package org.levlaz;

import com.launchdarkly.client.*;

/**
 * Singleton Enum
 */
public enum FeatureProvider {
    INSTANCE;

    private LDClient ldClient = new LDClient(System.getenv("LD_SDK_KEY"));
    
    public LDClient getInstance() {
        return ldClient;
    }
}