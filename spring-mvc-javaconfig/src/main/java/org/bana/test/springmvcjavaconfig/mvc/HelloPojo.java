package org.bana.test.springmvcjavaconfig.mvc;

public class HelloPojo {

	private String name;
	private String value;
	private Integer size;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "HelloPojo [name=" + name + ", value=" + value + ", size=" + size + "]";
	}
	
}
