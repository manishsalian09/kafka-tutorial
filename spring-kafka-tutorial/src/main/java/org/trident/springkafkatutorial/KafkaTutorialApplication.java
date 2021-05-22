package org.trident.springkafkatutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.trident.springkafkatutorial.service.MessageProducerService;

@SpringBootApplication
public class KafkaTutorialApplication implements CommandLineRunner {

	@Autowired
	private MessageProducerService messageProducerService;

	public static void main(String[] args) {
		SpringApplication.run(KafkaTutorialApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		messageProducerService.produce();
	}
}
