package com.mcground.mgmod.common.logger;

public class MgmodLog {

    public static String modtag = "[MgMod]";

    public static void out(String text){
        System.out.println(modtag + " - " + text);
    }

    public static void error(String text){
        System.out.println(modtag + "(Error)" + " - " + text);
    }

    public static void warning(String text){
        System.out.println(modtag + "(Warning)" + " - " + text);
    }

    public static void success(String text){
        System.out.println(modtag + "(Success)" + " - " + text);
    }
}
