package com.ananas.mn.core.client;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

public interface Client {

	 @SuppressWarnings("rawtypes")
	 public List getAllCache();
	 
}
