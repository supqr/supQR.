package com.coderbunker.supqr.util;

import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.util.Set;

@Slf4j
public class ReflectionUtil {

	public static Set<Class<?>> findClasses (Class<? extends Annotation> clazz) {
		Reflections reflections = new Reflections("ch.jooel.smarttype");
		Set<Class<?>> classes = reflections.getTypesAnnotatedWith(clazz);
		log.info("Found {} classes annotated with @{}", classes.size(), clazz.getSimpleName());
		return classes;
	}

}
