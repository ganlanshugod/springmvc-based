package org.bana.test.springmvcjavaconfig.config.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

/**
 * @author liuwenjie
 */
@Configuration
@PropertySource({"classpath:/project.properties","classpath:/env.properties"})
public class AppConfig {
	
	@Autowired
	Environment env;
	
	@Bean//如果项在@Value中使用${}的方式必须要声明此类
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
	
	@Value("${app.author}")
	private String author;

	@Bean
	public EnvTest testBean() {
		EnvTest testBean = new EnvTest();
		testBean.setName(env.getProperty("app.name"));
		testBean.setAuthor(author);
		testBean.setVersion(env.getProperty("app.version"));
		return testBean;
	}
	
	
}
