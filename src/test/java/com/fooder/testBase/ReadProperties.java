package com.fooder.testBase;

import Utilities.PropertiesLoader;
import com.fooder.PageBase.PageBase;

import java.util.Random;


public class ReadProperties {
    public static final String URL = getPropertyFromEnv("URL");
    public static final String username = getPropertyFromEnv("username");
    public static final String password = getPropertyFromEnv("password");

    public static final String Branch_Name = generateRandomDigits(5) + getPropertyFromBranch("Branch_Name");
    public static final String Branch_Name_Localized = Branch_Name;
    public static final String Contact_Name = getPropertyFromBranch("Contact_Name");
    public static final String Contact_Number = getPropertyFromBranch("Contact_Number");
    public static final String Location = getPropertyFromBranch("Location");
    public static final String City = getPropertyFromBranch("City");
    public static final String state = getPropertyFromBranch("state");
    public static final String Country = getPropertyFromBranch("Country");
    public static final String MapSearch = getPropertyFromBranch("MapSearch");
    public static final String deliveryAreaName = generateRandomDigits(5) + getPropertyFromBranch("deliveryAreaName");
    public static final String deliveryDistance = getPropertyFromBranch("deliveryDistance");
    public static final String deliveryFees = getPropertyFromBranch("deliveryFees");
    public static final String extraDistanceFees = getPropertyFromBranch("extraDistanceFees");
    public static final String deliveryAreaType = getPropertyFromBranch("deliveryAreaType");
    public static final String New_Branch_Name_Localized = Branch_Name;
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
    public static final String Role_name_l = generateRandomDigits(5) + getPropertyFromLeader("Role_name");
    public static final String Role_name_c = generateRandomDigits(5) + getPropertyFromCashier("Role_name");
    public static final String Role_name_m = generateRandomDigits(5) + getPropertyFromManager("Role_name");
    public static final String Group_Name = generateRandomDigits(5) + getPropertyFromGroup("name");
    public static final String Group_Localized_Name = Group_Name;

    public static final String Category_Name = generateRandomDigits(5) + getPropertyFromCategory("name");
    public static final String Category_localizedName = Category_Name;
    public static final String Category_description = getPropertyFromCategory("description");
    public static final String Category_localizedDescription = getPropertyFromCategory("localizedDescription");
    public static final String Product_tax_Group = getPropertyFromProduct("tax_Group");
    public static final String Product_costing_Method = getPropertyFromProduct("costing_Method");
    public static final String Product_name = generateRandomDigits(5) + getPropertyFromProduct("name");
    public static final String Product_desc = getPropertyFromProduct("desc");
    public static final String Product_descLocalized = getPropertyFromProduct("descLocalized");
    public static final String Product_localized_name = Product_name;
    public static final String Product_calories = getPropertyFromProduct("calories");
    public static final String Product_price = getPropertyFromProduct("price");
    public static final String Product_sku = getPropertyFromProduct("sku");
    public static final String Product_prepTime = getPropertyFromProduct("prepTime");
    public static final String Modifier_Name = generateRandomDigits(5) + getPropertyFromModifier("name");
    public static final String Modifier_Localized_Name = Modifier_Name;
    public static final String Modifier_Reference = getPropertyFromModifier("reference");
    public static final String New_Modifier_Name = Modifier_Name;
    public static final String New_Modifier_Localized_Name = Modifier_Name;
    public static final String New_Modifier_Reference = getPropertyFromModifier("new_reference");
    public static final String Option_tax_Group = getPropertyFromOption("tax_Group");
    public static final String Option_costing_Method = getPropertyFromOption("costing_Method");
    public static final String Option_name = generateRandomDigits(5) + getPropertyFromOption("name");
    public static final String Option_localized_name = Option_name;
    public static final String Option_calories = getPropertyFromOption("calories");
    public static final String Option_price = getPropertyFromOption("price");
    public static final String Option_sku = getPropertyFromOption("sku");
    public static final String Client_Name = generateRandomDigits(5) + getPropertyFromClient("name");
    public static final String Client_Mobile = getPropertyFromClient("mobile");
    public static final String Client_Location = getPropertyFromClient("location");
    public static final String Client_Notes = getPropertyFromClient("notes");
    public static final String Driver_Name = generateRandomDigits(5) + getPropertyFromDriver("name");
    public static final String Driver_Mobile = getPropertyFromDriver("mobile");

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
    private static String getPropertyFromClient(String propertyName) {
        return System.getProperty(propertyName, PropertiesLoader.readClientFile(propertyName));
    }
    private static String getPropertyFromDriver(String propertyName) {
        return System.getProperty(propertyName, PropertiesLoader.readDriverFile(propertyName));
    }
    private static String generateRandomDigits(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length should be greater than 0");
        }

        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int digit = random.nextInt(10); // Generates a random digit (0 to 9)
            stringBuilder.append(digit);
        }

        return stringBuilder.toString();
    }


}
