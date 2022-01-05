import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import ru.apolonov.config.Browser;
import ru.apolonov.config.WebConfig;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WebTest {

    @Test
    public void webLocaleTest() {
        System.setProperty("environment", "local");

        WebConfig webConfig = ConfigFactory.create(WebConfig.class, System.getProperties());
        assertThat(webConfig.getBrowser()).isEqualTo(Browser.CHROME);
        assertThat(webConfig.browserVersion()).isEqualTo("97");
    }

    @Test
    public void webRemoteTest() {
        System.setProperty("environment", "remote");

        WebConfig webConfig = ConfigFactory.create(WebConfig.class, System.getProperties());
        assertThat(webConfig.getBrowser()).isEqualTo(Browser.FIREFOX);
        assertThat(webConfig.browserVersion()).isEqualTo("95");
        assertThat(webConfig.remoteUrl()).isEqualTo("https://user1:1234@selenoid.autotests.cloud/wd/hub/");
    }
}
