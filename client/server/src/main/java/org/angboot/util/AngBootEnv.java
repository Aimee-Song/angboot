/*
 * Copyright (c) 2019, AngBoot Technology Corp, All Rights Reserved.
 *
 * The software and information contained herein are copyrighted and
 * proprietary to AngBoot Technology Corp. This software is furnished
 * pursuant to a written license agreement and may be used, copied,
 * transmitted, and stored only in accordance with the terms of such
 * license and with the inclusion of the above copyright notice. Please
 * refer to the file "COPYRIGHT" for further copyright and licensing
 * information. This software and information or any other copies
 * thereof may not be provided or otherwise made available to any other
 * person.
 */

package org.angboot.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import java.io.*;
import java.net.URISyntaxException;
import java.util.Hashtable;
import java.util.Properties;

public class AngBootEnv {
   public static Properties getInternalProperties() {
      return (Properties)
         ConfigurationContext.getContext().get(PROPERTIES_KEY);
   }

   public static synchronized void clear() {
      ConfigurationContext.getContext().remove(PROPERTIES_KEY);
   }

   /**
    * Initialize the properties with the specific location of
    * angboot.properties . This is called automatically
    * before any method in this class is used for the first time.
    */
   static synchronized void init() {
      if(getInternalProperties() != null) {
         return;
      }

      String configHome =
         ConfigurationContext.getContext().getHome();

      Properties angBootProperties
         = AngBootUtil.loadProperties(configHome, "angboot.properties");

      Properties defaultProperties = null;

      try {
         defaultProperties = AngBootUtil.loadProperties(
            ResourceUtils.getFile("classpath:config/").getPath(), "default.properties");
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }

      putProperties(new DefaultProperties(angBootProperties, defaultProperties));
   }

   private static void putProperties(Properties prop) {
      ConfigurationContext.getContext().put(PROPERTIES_KEY, prop);
   }

   public static String getProperty(String name) {
      init();

      Properties prop = getInternalProperties();
      String val = prop.getProperty(name);

      return val;
   }

   /**
    * Get a property value with a default if the property is not defined.
    */
   public static String getProperty(String name, String defaultValue) {
      String val = AngBootEnv.getProperty(name);

      if(val == null) {
         val = defaultValue;
      }

      return val;
   }

   /**
    * Get a property int value with a default if the property is not defined.
    */
   public static int getIntegerProperty(String name, int defaultValue) {
      String val = AngBootEnv.getProperty(name);
      int result = defaultValue;

      if(val != null) {
         try {
            result = Integer.parseInt(val);
         }
         catch(Exception ignore) {
            // TODO Log Format
            LOGGER.info("Parse property error. Key is: {}, Value is: " + val, name);
         }
      }

      return result;
   }

   /**
    * Get a property as a boolean value.
    */
   public static Boolean getBoolean(String name) {
      String str = getProperty(name);
      Boolean val = false;

      if(!StringUtils.isEmpty(str)) {
         val = (Boolean) cache.get(name);

         if(val == null) {
            cache.put(name, val = Boolean.valueOf(str));
         }
      }

      return val;
   }

   public static String getHome() {
      return AngBootEnv.getProperty(ANGBOOT_HOME_KEY);
   }

   private static Hashtable cache = new Hashtable(); // cached objects

   public static final String ANGBOOT_HOME_KEY = "angboot.home";
   private static final String PROPERTIES_KEY = AngBootEnv.class.getName() + ".properties";

   private static final Logger LOGGER = LoggerFactory.getLogger(AngBootEnv.class);
}
