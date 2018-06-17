package com.examples.list;

import java.util.ArrayList;

public class Example14 {

	public static void main(String[] args) {
		ArrayList<ServiceTag> tags = new ArrayList<ServiceTag>();
		tags.add(new ServiceTag(new Long(1), "A"));
		tags.add(new ServiceTag(new Long(1), "A"));
		tags.add(new ServiceTag(new Long(2), "B"));
		long deduplicates = tags.stream().map(s -> s.getTag()).distinct().count();
		System.out.println(tags.size() - deduplicates);
	}
}

class ServiceTag {

	private Long id;
	private String tag;

	public ServiceTag(Long id, String tag) {
		this.id = id;
		this.tag = tag;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
}