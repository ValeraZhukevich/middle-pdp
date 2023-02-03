package config;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class SelenoidConfig implements BeforeEachCallback {
    @Override
    public void beforeEach(ExtensionContext context) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;
        Configuration.remote = "http://34.88.77.186:4444/wd/hub";
    }
}
