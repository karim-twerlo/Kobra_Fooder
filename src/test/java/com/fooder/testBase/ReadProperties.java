package com.fooder.testBase;

import Utilities.PropertiesLoader;



public class ReadProperties {
    public static final String URL = getProperty("URL");
    public static final String username = getProperty("username");
    public static final String password = getProperty("password");
    public static final String email = getProperty("email");
    public static final String Branch_Name_Localized = getProperty("Branch_Name_Localized");
    public static final String Branch_Name = getProperty("Branch_Name");
    public static final String Contact_Name = getProperty("Contact_Name");
    public static final String Contact_Number = getProperty("Contact_Number");
    public static final String Location = getProperty("Location");
    public static final String City = getProperty("City");
    public static final String state = getProperty("state");
    public static final String Country = getProperty("Country");
    public static final String MapSearch = getProperty("MapSearch");

    private static String getProperty(String propertyName) {
        return System.getProperty(propertyName, PropertiesLoader.readEnvFile(propertyName));
    }

}
