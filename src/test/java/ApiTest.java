import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import ru.apolonov.config.ApiConfig;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class ApiTest {

    @Test
    public void apiTest() {
        ApiConfig apiConfig = ConfigFactory.create(ApiConfig.class, System.getProperties());

        assertThat(apiConfig.baseUrl()).isEqualTo("https://apolonov.ru");
        assertThat(apiConfig.token()).isEqualTo("token");
    }

    @Test
    public void apiWithTempFileTest() throws IOException {
        String content = "token=another_token";
        Path props = Paths.get("C:/temp/token.properties");

        Files.write(props, content.getBytes(StandardCharsets.UTF_8));

        ApiConfig apiConfig = ConfigFactory.create(ApiConfig.class, System.getProperties());
        assertThat(apiConfig.baseUrl()).isEqualTo("https://apolonov.ru");
        assertThat(apiConfig.token()).isEqualTo("another_token");

        Files.delete(props);
    }
}
