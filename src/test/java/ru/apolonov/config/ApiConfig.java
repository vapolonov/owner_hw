package ru.apolonov.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "file:C:/temp/token.properties",
        "classpath:token.properties"
})
public interface ApiConfig extends Config {

    @Key("base.url")
    @DefaultValue("https://apolonov.ru")
    String baseUrl();

    @Key("token")
    String token();
}
