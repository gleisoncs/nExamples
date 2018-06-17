package com.examples.createannotation;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

public class SpringClassScanner {

	public static void main(String[] args) throws Exception {
		System.out.println("Finding annotated classes using Spring:");
		new SpringClassScanner().findAnnotatedClasses("com.examples.createannotation");
	}

	public void findAnnotatedClasses(String scanPackage) {
		ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
		provider.addIncludeFilter(new AnnotationTypeFilter(Huep.class));
		for (BeanDefinition beanDef : provider.findCandidateComponents(scanPackage)) {
			printMetadata(beanDef);
		}
	}

	private void printMetadata(BeanDefinition beanDef) {
		try {
			Class<?> cl = Class.forName(beanDef.getBeanClassName());
			Huep findable = cl.getAnnotation(Huep.class);
			System.out.println(String.format("Found class: %s, with meta name: %s", cl.getSimpleName(), findable.tags()));
			System.out.println("tags: " + findable.tags()[0]);
			System.out.println("priority: " + findable.priority());
		} catch (Exception e) {
			System.err.println("Got exception: " + e.getMessage());
		}
	}
}