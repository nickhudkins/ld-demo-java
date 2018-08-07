package org.levlaz;

import com.launchdarkly.client.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Singleton Enum
 */
public enum FeatureProvider {
    INSTANCE;

    private static final int KEY_START_INDEX = 0;
    private static final int KEY_END_INDEX = 10;

    private static final Logger logger = 
        LoggerFactory.getLogger(FeatureProvider.class.getName());
    private LDClient ldClient = new LDClient(System.getenv("LD_SDK_KEY"));
    
    public LDClient getInstance() {
        checkEnv();
        return ldClient;
    }

    public void checkEnv() {
        if (System.getenv("LD_SDK_KEY") == null) {
            logger.warn("LD_SDK_KEY is not set as an ENV VAR " + 
                "Feature Flags will fallback");
        } else {
            logger.info("LD_SDK_KEY starts with: " + 
                System.getenv("LD_SDK_KEY").substring(
                    KEY_START_INDEX, KEY_END_INDEX));
        }
    }
}