package org.bana.test.springmvcjavaconfig.config.property;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/config/spring-context-properties.xml"})
public class EnvXmlTest {

	@Autowired
	private EnvTest env;

	@Test
	public void testAppName() {
		System.out.println(env.getName());
		System.out.println(env.getAuthor());
		System.out.println(env);
		assertEquals(env.getName(), "javaconfig-test");
		assertEquals(env.getAuthor(),"liuwenjie");
	}
}
