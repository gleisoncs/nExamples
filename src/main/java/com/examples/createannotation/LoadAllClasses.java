package com.examples.createannotation;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class LoadAllClasses {

	public static void main(String[] args) {
		try {
			System.out.println(getAllClassesInPackageContaining("com.examples.createannotation"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static List<Class<?>> getAllClassesInPackageContaining(String pac) throws IOException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	    String packageName = pac.replace(".", "/");
		String clazzPath = classLoader.getResource(packageName).getPath();
		Path packagePath = Paths.get(clazzPath);

		final List<Class<?>> packageClasses = new ArrayList<>();

		Files.walkFileTree(packagePath, new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				String filename = file.getName(file.getNameCount() - 1).toString();

				if (filename.endsWith(".class") && !(filename.contains("$"))) {
					String className = filename.replace(".class", "");

					try {
						Class<?> loadedClazz = Class.forName(pac + "." + className);
						if (loadedClazz.isAnnotationPresent(Huep.class))
							packageClasses.add(loadedClazz);
					} catch (ClassNotFoundException e) {
						System.err.println("class not found: " + e.getMessage());
					}
				}

				return super.visitFile(file, attrs);
			}
		});

		return packageClasses;
	}

}
