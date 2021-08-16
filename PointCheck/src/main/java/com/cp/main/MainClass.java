/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cp.main;
import org.springframework.context.annotation.ComponentScan;
/**
 *
 * @author 5031330
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ComponentScan("com.cp")
public class MainClass {

	public static void main(String[] args) {
		SpringApplication.run(MainClass.class, args);
	}
}