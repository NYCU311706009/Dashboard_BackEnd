package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Entity.Machine;
import com.example.demo.Repository.MachineRepository;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private MachineRepository machineRepository;
	
	@Test
	void contextLoads() {
	}

	
}
