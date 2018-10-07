package com.sb.drone.example.sbdronedemo;

import com.sb.drone.example.sbdronedemo.controllers.HelloWorldController;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SbDroneDemoApplicationTests {

	@Autowired
	private HelloWorldController helloWorldController;

	@Test
	public void contextLoads() {
		Assertions.assertThat(helloWorldController).isNotNull();
	}

}
