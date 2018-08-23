package com.axxes.aspect;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.axxes.configuration.SystemConfiguration;
import com.axxes.repository.SimpleRepository;
import com.axxes.service.SimpleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SystemConfiguration.class)
public class ClassNameAspectTest {

	@Autowired
	ClassNameAspect aroundTracingAspect;

	@Autowired
	SimpleService simpleService;

	@Autowired
	SimpleRepository simpleRepository;
	
	@Before
	public void setUp() {
		aroundTracingAspect.resetCalled();
	}

	@Test
	public void tracingOnServiceIsCalled() {
		assertThat(aroundTracingAspect.getCalled(), is(0));
		simpleService.doSomething();
		assertThat(aroundTracingAspect.getCalled(), is(1));
	}
	
	@Test
	public void tracingOnRepsositoryIsNotCalled() {
		assertThat(aroundTracingAspect.getCalled(), is(0));
		simpleRepository.doSomething();
		assertThat(aroundTracingAspect.getCalled(), is(0));
	}

}
