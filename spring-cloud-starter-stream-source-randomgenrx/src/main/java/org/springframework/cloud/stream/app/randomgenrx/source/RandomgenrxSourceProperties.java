/*
 * 
 * Copyright (c) 2018 Solace Corp.
 * 
 */
package org.springframework.cloud.stream.app.randomgenrx.source;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Configuration properties for the Random Gen Source module.
 *
 * @author Solace Corp.
 */
@ConfigurationProperties("randomgenrx")
public class RandomgenrxSourceProperties {
	private int randomMultiplier = 100;

	public void setRandomMultiplier(int randomMultiplier) {
		this.randomMultiplier = randomMultiplier;
	}

	public int getRandomMultiplier() {
		return randomMultiplier;
	}
}
