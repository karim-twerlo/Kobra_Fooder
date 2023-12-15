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
    public static final String Role_m = getPropertyFromManager("Role");
    public static final String Role_l = getPropertyFromLeader("Role");
    public static final String Role_c = getPropertyFromCashier("Role");
    public static final String Role_email_l = getPropertyFromLeader("Role_email");
    public static final String Role_email_c = getPropertyFromCashier("Role_email");
    public static final String Role_email_m = getPropertyFromManager("Role_email");
    public static final String Role_password_l = getPropertyFromLeader("Role_password");
    public static final String Role_password_c = getPropertyFromCashier("Role_password");
    public static final String Role_password_m = getPropertyFromManager("Role_password");
    public static final String Role_name_l = getPropertyFromLeader("Role_name");
    public static final String Role_name_c = getPropertyFromCashier("Role_name");
    public static final String Role_name_m = getPropertyFromManager("Role_name");
    public static final String Group_Name = getPropertyFromGroup("name");
    public static final String Group_Localized_Name = getPropertyFromGroup("localizedName");

    public static final String Category_Name = getPropertyFromCategory("name");
    public static final String Category_localizedName = getPropertyFromCategory("localizedName");
    public static final String Category_description = getPropertyFromCategory("description");
    public static final String Category_localizedDescription = getPropertyFromCategory("localizedDescription");
    public static final String Product_tax_Group = getPropertyFromProduct("tax_Group");
    public static final String Product_costing_Method = getPropertyFromProduct("costing_Method");
    public static final String Product_name = getPropertyFromProduct("name");
    public static final String Product_desc = getPropertyFromProduct("desc");
    public static final String Product_descLocalized = getPropertyFromProduct("descLocalized");
    public static final String Product_localized_name = getPropertyFromProduct("localized_name");
    public static final String Product_calories = getPropertyFromProduct("calories");
    public static final String Product_price = getPropertyFromProduct("price");
    public static final String Product_sku = getPropertyFromProduct("sku");
    public static final String Product_prepTime = getPropertyFromProduct("prepTime");
    public static final String Modifier_Name = getPropertyFromModifier("name");
    public static final String Modifier_Localized_Name = getPropertyFromModifier("localized_Name");
    public static final String Modifier_Reference = getPropertyFromModifier("reference");
    public static final String New_Modifier_Name = getPropertyFromModifier("new_name");
    public static final String New_Modifier_Localized_Name = getPropertyFromModifier("new_localized_Name");
    public static final String New_Modifier_Reference = getPropertyFromModifier("new_reference");
    public static final String Option_tax_Group = getPropertyFromOption("tax_Group");
    public static final String Option_costing_Method = getPropertyFromOption("costing_Method");
    public static final String Option_name = getPropertyFromOption("name");
    public static final String Option_localized_name = getPropertyFromOption("localized_name");
    public static final String Option_calories = getPropertyFromOption("calories");
    public static final String Option_price = getPropertyFromOption("price");
    public static final String Option_sku = getPropertyFromOption("sku");

    private static String getPropertyFromEnv(String propertyName) {
        return System.getProperty(propertyName, PropertiesLoader.readEnvFile(propertyName));
    }
    private static String getPropertyFromManager(String propertyName) {
        return System.getProperty(propertyName, PropertiesLoader.readManagerFile(propertyName));
    }
    private static String getPropertyFromLeader(String propertyName) {
        return System.getProperty(propertyName, PropertiesLoader.readLeaderFile(propertyName));
    }
    private static String getPropertyFromCashier(String propertyName) {
        return System.getProperty(propertyName, PropertiesLoader.readCashierFile(propertyName));
    }
    private static String getPropertyFromBranch(String propertyName) {
        return System.getProperty(propertyName, PropertiesLoader.readBBranchFile(propertyName));
    }
    private static String getPropertyFromGroup(String propertyName) {
        return System.getProperty(propertyName, PropertiesLoader.readGroupFile(propertyName));
    }
    private static String getPropertyFromCategory(String propertyName) {
        return System.getProperty(propertyName, PropertiesLoader.readCategoryFile(propertyName));
    }
    private static String getPropertyFromProduct(String propertyName) {
        return System.getProperty(propertyName, PropertiesLoader.readProductFile(propertyName));
    }
    private static String getPropertyFromModifier(String propertyName) {
        return System.getProperty(propertyName, PropertiesLoader.readModifierFile(propertyName));
    }
    private static String getPropertyFromOption(String propertyName) {
        return System.getProperty(propertyName, PropertiesLoader.readOptionFile(propertyName));
    }


}
