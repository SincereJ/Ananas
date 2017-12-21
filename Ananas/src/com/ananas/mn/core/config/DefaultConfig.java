package com.ananas.mn.core.config;

import com.ananas.mn.core.server.Server;

import java.util.HashMap;
import java.util.Map;

public class DefaultConfig implements Config {

    public Map<String, Server> getConfig(){
        return new HashMap<String, Server>();
    }
}
