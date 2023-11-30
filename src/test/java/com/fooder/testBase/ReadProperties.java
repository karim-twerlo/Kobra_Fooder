package com.fooder.testBase;

import static Utilities.PropertiesLoader.readEnvFile;

public class ReadProperties {
    public static final String URL = System.getProperty("URL",readEnvFile("URL"));
    public static final String username = System.getProperty("username",readEnvFile("username"));
    public static final String password = System.getProperty("password",readEnvFile("password"));
    public static final String email = System.getProperty("email",readEnvFile("email"));
    public static final String Branch_Name_Localized = System.getProperty("Branch_Name_Localized",readEnvFile("Branch_Name_Localized"));
    public static final String Branch_Name = System.getProperty("Branch_Name",readEnvFile("Branch_Name"));
    public static final String Contact_Name = System.getProperty("Contact_Name",readEnvFile("Contact_Name"));
    public static final String Contact_Number = System.getProperty("Contact_Number",readEnvFile("Contact_Number"));
    public static final String Location = System.getProperty("Location",readEnvFile("Location"));
    public static final String City = System.getProperty("City",readEnvFile("City"));
    public static final String state = System.getProperty("state",readEnvFile("state"));
    public static final String Country = System.getProperty("Country",readEnvFile("Country"));
    public static final String MapSearch = System.getProperty("MapSearch",readEnvFile("MapSearch"));


}
