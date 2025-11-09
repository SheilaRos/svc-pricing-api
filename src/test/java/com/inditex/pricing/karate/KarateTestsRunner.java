package com.inditex.pricing.karate;

import com.inditex.pricing.PricingApplication;
import com.intuit.karate.junit5.Karate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(classes = {PricingApplication.class},
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
)
@ActiveProfiles({"test"})
@TestPropertySource(properties = "server.port=8082")
public class KarateTestsRunner {

    @Karate.Test
    Karate test() {
        return Karate.run().relativeTo(getClass()).outputJunitXml(true);
    }
}
