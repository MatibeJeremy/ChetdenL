// Welcome to this attempt at building a simple site using SpringBoot
// Author: Alloys Jeremy Matibe

package com.jeremyalloys.boot.lendint.interview_prep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// This is the core of my application. The beating heart - if this stops, our
// app dies!
@SpringBootApplication
public class InterviewPrepApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterviewPrepApplication.class, args);
	}

}
