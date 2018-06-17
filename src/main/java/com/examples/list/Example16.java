package com.examples.list;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Example16 {
	
	public static void main(String[] args) {
		
		LinkedHashMap<Long, String> a = new LinkedHashMap<Long, String>();
		a.put(new Long(1), new String("Entity1"));
		
		LinkedHashMap<Long, String> b = new LinkedHashMap<Long, String>();
		b.put(new Long(1), new String("Entity1"));
		b.put(new Long(2), new String("Entity2"));
		
		LinkedHashMap<String, LinkedHashMap<Long, String>> c = new LinkedHashMap<String, LinkedHashMap<Long, String>>();
		c.put("EntityGroupType1", a);
		c.put("EntityGroupType2", b);
		List<String> groups = new ArrayList<String>();
		c.forEach((k,v)->v.forEach((x,y) -> groups.add(y.toString())));
		String groups2 = groups.toString().replaceAll("\\[", "").replaceAll("\\]", "");
		System.out.println(groups2);
	}
}