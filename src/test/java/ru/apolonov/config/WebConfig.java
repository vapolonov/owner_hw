package ru.apolonov.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:${environment}.properties")
public interface WebConfig extends Config {

    @Key("browser.name")
    @DefaultValue("CHROME")
    Browser getBrowser();

    @Key("browser.version")
    @DefaultValue("95")
    String browserVersion();

    @Key("remote.url")
    String remoteUrl();

}
