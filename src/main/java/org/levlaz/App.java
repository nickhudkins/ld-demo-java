package org.levlaz;

import java.io.IOException;
import com.launchdarkly.client.LDUser;
import com.launchdarkly.client.LDClient;

/**
 * Sample LaunchDarkly Demo Application
 *
 */
public class App 
{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main( String[] args ) throws IOException
    {
        LDClient ldClient = FeatureProvider.INSTANCE.getInstance();
        LDUser user = new LDUser.Builder("9fdd8ec6e1bad87f5af47ee55468b61e")
            .privateEmail("lev@acme.com")
            .custom("companyName", "ACME")
            .build();

        boolean showFeature = ldClient.boolVariation("show-message", user, false);

        if (showFeature) {
            System.out.println(ANSI_GREEN + "The Feature Flag is ON!" + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "The Feature Flag is OFF!" + ANSI_RESET);
        }

        ldClient.flush();
        ldClient.close();
    }
}
