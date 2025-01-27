package com.hotelapi.project.util;


public class Util {

    public static String createRoomNumber() {
        int room = (int) (Math.random() * 101);
        return String.format("%02d", room);
    }
}
