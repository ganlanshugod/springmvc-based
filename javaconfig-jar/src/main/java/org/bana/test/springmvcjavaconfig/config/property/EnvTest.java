package org.bana.test.springmvcjavaconfig.config.property;

import org.springframework.beans.factory.annotation.Value;

public class EnvTest {

	@Value("${project.source}")
	private String source;
	@Value("${project.condition}")
	private String condition;
	@Value("${project.remark}")
	private String remark;

	private String name;
	@Value("${app.version}kankan")
	private String version;
	private String author;
	
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "EnvTest [source=" + source + ", condition=" + condition + ", remark=" + remark + ", name=" + name
				+ ", version=" + version + ", author=" + author + "]";
	}

}
