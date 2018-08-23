package com.axxes.aspects;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.axxes.service.PlainService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/system-configuration.xml")
public class TracingTest {

	@Autowired
	PlainService plainService;

	@Test
	public void callService() {
		plainService.doSomething();
	}

}
