package com.ananas.mn.core.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;



public class ConfigProxyHolder extends PropertyPlaceholderConfigurer implements Config {

	private static Map<String,String> propertyMap;

	public static ConfigProxyHolder getConfigProxyHolderInstance() {
		return cp.getCpIns();
	}
	
    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
        super.processProperties(beanFactoryToProcess, props);
        propertyMap = new HashMap<String, String>();
        for (Object key : props.keySet()) {
            String keyStr = key.toString();
            String value = props.getProperty(keyStr);
            propertyMap.put(keyStr, value);
        }
    }

    //static method for accessing context properties
    public static Object getProperty(String name) {
        return propertyMap.get(name);
    }
    
    private static class cp {
		private static ConfigProxyHolder configProxyHolder;
		
		public static ConfigProxyHolder getCpIns() {
			if(configProxyHolder == null) {
				configProxyHolder= new ConfigProxyHolder();	
			}
			return configProxyHolder;
		}
		
	}
	
}
