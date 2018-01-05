package com.ananas.mn.interpreter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

public class DivInterpreterTest {

	
	@Test
	public void divInterpreterTest() {
		
		
		String cc = "<div @id='divId' name='divName' class='divClass' style='background-color:greey'@>^</div>";
		String a = "@id='divId' name='divName' class='divClass' style='background-color:greey'@";
		String b = "id='b' name='c' class='d' style='e' ";
		
		System.out.println(cc.replaceAll(a, b));
		
		
	}
	
}
