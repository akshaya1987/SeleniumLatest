package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources(
        "file:./src/test/resources/config/config.properties"
)
public interface Configurations extends Config {
    @Key("browser")
    String browser();

    @DefaultValue("url")
    String url();

    @DefaultValue("")
    String username();

    @DefaultValue("")
    String password();

    @Key("screenshot_needed")
    String screenshot_needed();
}
