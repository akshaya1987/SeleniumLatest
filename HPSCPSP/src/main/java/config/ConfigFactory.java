package config;
import org.aeonbits.owner.ConfigCache;
public class ConfigFactory {
        private ConfigFactory(){

        }
        public static Configurations getConfig(){
            return ConfigCache.getOrCreate(Configurations.class);
        }
}
