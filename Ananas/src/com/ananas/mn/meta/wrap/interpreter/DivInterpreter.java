package com.ananas.mn.meta.wrap.interpreter;

import java.util.List;
import java.util.Map;

public interface DivInterpreter extends Interpreter{

	public boolean parse(List metaList);
	
	public boolean parse(Map meta);
	
}
