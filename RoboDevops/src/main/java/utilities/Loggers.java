package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Loggers {
    public static Logger log() {
        return LogManager.getLogger(Loggers.class);
    }

}

