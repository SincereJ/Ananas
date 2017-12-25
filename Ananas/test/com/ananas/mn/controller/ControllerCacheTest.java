package com.ananas.mn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ananas.mn.core.cache.CacheUtils;
import com.ananas.mn.core.client.Client;

@Controller
@RequestMapping("/mvc")
public class ControllerCacheTest {
	
	@Autowired
	private Client client;

	@RequestMapping("/hello")
	public String sayHello(ModelMap modelMap) {  
		try {
		
		String s = (String) CacheUtils.get("a");
		System.out.println(s);
		
		
        modelMap.put("msg", "Hello!:"+s);  
        
        List list = client.getAllCache();
        System.out.println(list);
        
		}catch(Exception e ) {
			e.printStackTrace();
		}
		
		return "hello";  
    } 

}
