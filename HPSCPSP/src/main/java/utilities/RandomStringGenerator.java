package utilities;

import java.util.UUID;

public class RandomStringGenerator {

    public static String _generateRandomString(){
        UUID randomUUID = UUID.randomUUID();
        return randomUUID.toString().replaceAll("_", "");
    }
}
