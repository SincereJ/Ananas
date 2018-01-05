package com.ananas.mn.meta.tool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ananas.mn.meta.service.MetaService;
import com.ananas.mn.meta.wrap.wrapper.DivWrapper;
import com.ananas.mn.meta.wrap.wrapper.Wrapper;
import com.fasterxml.jackson.core.JsonProcessingException;

@Controller
@RequestMapping("/meta")
public class SaveMeta {

	@Autowired
	private MetaService metaService;
	
	@RequestMapping("/saveMeta")
	public String saveMeta(ModelMap modelMap) {
		
		String temp = "{\"temp\":\"<div id='divId' name='divName' class='divClass' style='background-color:greey'></div>\"}";
		String prop = "{\"prop\":[{\"name\":\"id\"},{\"name\":\"name\"},{\"name\":\"class\"},{\"name\":\"style\"}]}";
		String name = "metaDiv";
		
		Map<String, Object> map = new HashMap() ;
			
		map.put("name", name);
		map.put("temp", temp);
		map.put("prop", prop);
		
		int index = metaService.insertIntoMeta(map);
		
		modelMap.put("msg", "Hello!:"+index);  
		
		return "hello";
	}
	
	@RequestMapping(value = "/getDivMeta" , method = {RequestMethod.POST})
	public @ResponseBody List getDivMeta() {
		List metaList = metaService.getMetaList(null);
		return metaList;
	}
	
	@RequestMapping(value = "/saveMetaDivInst" , method = {RequestMethod.POST})
	@ResponseBody
	public void saveMetaDivInst(@RequestBody Map request){
		
		try {
			metaService.saveMetaDivInst(request);
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value = "/prewViewMetaDivInst", method = {RequestMethod.POST})
	@ResponseBody
	public boolean prewViewMetaDivInst(@RequestBody Map request) {
		
		Map meta = metaService.getMetaInstByName(request);
		
		DivWrapper wrapper = new DivWrapper();
		
		wrapper.setMeta(meta);
		wrapper.begin();
		
		return true;
		
	}
	
}
