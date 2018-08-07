# ld-demo-java

Java Sandbox for LaunchDarkly 

## FeatureProvider

The FeatureProvider class implements the LaunchDarkly client as a singleton. It uses the approach documented here: https://dzone.com/articles/java-singletons-using-enum 

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

