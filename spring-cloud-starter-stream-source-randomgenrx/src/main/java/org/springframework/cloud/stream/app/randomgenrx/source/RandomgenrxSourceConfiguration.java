/*
 * 
 * Copyright (c) 2018 Solace Corp.
 * 
 */
package org.springframework.cloud.stream.app.randomgenrx.source;

import java.time.Duration;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.stream.annotation.EnableBinding;

import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.reactive.StreamEmitter;

import reactor.core.publisher.Flux;

/**
 * A random number generator SCS source
 *
 * @author Solace Corp
 */
@EnableBinding(Source.class)
@EnableConfigurationProperties(RandomgenrxSourceProperties.class)
public class RandomgenrxSourceConfiguration {
	private final static Random _random = new Random();

	@Autowired
	private RandomgenrxSourceProperties properties;
	
	// Functional (reactive) style
	@StreamEmitter
	@Output(Source.OUTPUT)
	public Flux<String> emitRandomNumber() {
		return Flux.interval(Duration.ofSeconds(1)).map(l -> Double.toString(_random.nextDouble() * properties.getRandomMultiplier()));
	}
}


