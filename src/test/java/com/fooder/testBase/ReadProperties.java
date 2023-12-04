package com.fooder.testBase;

import Utilities.PropertiesLoader;



public class ReadProperties {
    public static final String URL = getPropertyFromEnv("URL");
    public static final String username = getPropertyFromEnv("username");
    public static final String password = getPropertyFromEnv("password");
    public static final String Branch_Name_Localized = getPropertyFromBranch("Branch_Name_Localized");
    public static final String Branch_Name = getPropertyFromBranch("Branch_Name");
    public static final String Contact_Name = getPropertyFromBranch("Contact_Name");
    public static final String Contact_Number = getPropertyFromBranch("Contact_Number");
    public static final String Location = getPropertyFromBranch("Location");
    public static final String City = getPropertyFromBranch("City");
    public static final String state = getPropertyFromBranch("state");
    public static final String Country = getPropertyFromBranch("Country");
    public static final String MapSearch = getPropertyFromBranch("MapSearch");
    public static final String deliveryAreaName = getPropertyFromBranch("deliveryAreaName");
    public static final String deliveryDistance = getPropertyFromBranch("deliveryDistance");
    public static final String deliveryFees = getPropertyFromBranch("deliveryFees");
    public static final String extraDistanceFees = getPropertyFromBranch("extraDistanceFees");
    public static final String deliveryAreaType = getPropertyFromBranch("deliveryAreaType");
    public static final String New_Branch_Name_Localized = getPropertyFromBranch("New_Branch_Name_Localized");
    public static final String Mini_Card_Value = getPropertyFromBranch("Mini_Card_Value");
    public static final String Average_Cancellation_Time = getPropertyFromBranch("Average_Cancellation_Time");
    public static final String Max_Cash_Value = getPropertyFromBranch("Max_Cash_Value");
    public static final String Average_Preparation_Time = getPropertyFromBranch("Average_Preparation_Time");




    private static String getPropertyFromEnv(String propertyName) {
        return System.getProperty(propertyName, PropertiesLoader.readEnvFile(propertyName));
    }
    private static String getPropertyFromBranch(String propertyName) {
        return System.getProperty(propertyName, PropertiesLoader.readBBranchFile(propertyName));
    }

}
