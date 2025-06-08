package com.epam.greenandtasty.utils;

import com.epam.greenandtasty.exceptions.NoSuchPropertyAvailableException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.epam.greenandtasty.constants.Constant.CONFIG_PROPERTIES;

public class ConfigReader {
    public static String getValue(String key) throws IOException, NoSuchPropertyAvailableException {
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream(CONFIG_PROPERTIES)) {

            properties.load(input);

            if (!properties.containsKey(key)) {
                throw new NoSuchPropertyAvailableException();
            }

            return properties.getProperty(key);
        } catch (IOException ioException) {
            throw new IOException();
        }
    }
}
