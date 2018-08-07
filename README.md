# ld-demo-java

Java Sandbox for LaunchDarkly 

## FeatureProvider

The FeatureProvider class implements the LaunchDarkly client as a singleton. It uses the approach documented here: https://dzone.com/articles/java-singletons-using-enum 

There is some fancy stuff in here for logging and checking that the environment variable 
for the LD_SDK_KEY exists. The most basic implementation of this could look like this: 

```
package org.levlaz;

import com.launchdarkly.client.LDClient;

/**
 * Singleton Enum
 */
public enum FeatureProvider {
    INSTANCE;

    private LDClient ldClient = new LDClient(System.getenv("LD_SDK_KEY"));
    
    public LDClient getInstance() {
        checkEnv();
        return ldClient;
    }
}
```

## Usage 

You can run this without LauncDarkly, but feature flags will fall back to the hard coded fallback 
value. If you want to use LaunchDarkly you need the following: 

1. A valid `LD_SDK_KEY` exported as an environment variable. 
2. A feature flag called `show-message` that exists in the same environment that your `LD_SDK_KEY` maps to. 

We use a Makefile to make it easier to build and run this project. 

### Building 

You can run `make build` to build this project for the first time. 

### Running 

You can run `make run` to run the project. 

