package com.jbrasileiro.ms.votacao.commons.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

import org.apache.commons.io.IOUtils;

public class ResourceReader {

	public String read(
		String fileName) {
		ClassLoader classLoader = getClass().getClassLoader();
		try (InputStream resource = classLoader.getResourceAsStream(fileName)) {
			if (Objects.isNull(resource)) {
				throw new IllegalArgumentException("Could not find file: ".concat(fileName));
			} else {
				return IOUtils.toString(resource, "UTF-8");
			}
		} catch (IOException e) {
			throw new IllegalArgumentException("Could not load file: ".concat(fileName), e);
		}
	}
}
