package com.hotelapi.project.util;

import java.util.concurrent.ThreadLocalRandom;

public class Util {

    public static String createRoomNumber() {
        int room = ThreadLocalRandom.current().nextInt(1, 21);
        return String.format("%02d", room);
    }
}
