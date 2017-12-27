package com.ananas.mn.meta.tool;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ananas.mn.meta.service.MetaService;

@Controller
@RequestMapping("/meta")
public class SaveMeta {

	@Autowired
	private MetaService metaService;
	
	@RequestMapping("/saveMeta")
	public String saveMeta(ModelMap modelMap) {
		String context = "";
		
		context += "{\"temp\":\"<div id='divId' name='divName' class='divClass' style='background-color:greey'></div>\",\"prop\":[{\"name\":\"id\"},{\"name\":\"name\"},{\"name\":\"class\"},{\"name\":\"style\"}]}";
		
		
		Map<String, Object> map = new HashMap() ;
			
		map.put("name", "metaDiv");
		map.put("context", context);
		
		int index = metaService.insertIntoMeta(map);
		
		  modelMap.put("msg", "Hello!:"+index);  
		
		return "hello";
	}
	
}
