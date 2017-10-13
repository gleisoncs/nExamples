package com.examples.list;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Example7 {
	private static String FILENAME = null;

	static {
		ClassLoader classLoader = Example7.class.getClassLoader();
		File file = new File(classLoader.getResource("example7.csv").getFile());
		FILENAME = file.toString();
	}
	
	public static void main(String args[]) {
		Function<String, DataFile> mapLineToDataFile = new Function<String, DataFile>() {
			public DataFile apply(String line) {
				String[] lineSplited = line.split(";");
				return new DataFile(lineSplited[0], lineSplited[1], lineSplited[2], new Double(lineSplited[3]), new Double(lineSplited[4]));
			}
		};	

		try {
			long a = System.currentTimeMillis();
			List<DataFile> listOfDataFile = Files.lines(Paths.get(FILENAME)).map(mapLineToDataFile).collect(Collectors.toList());
			long b = System.currentTimeMillis() - a;
			System.out.println(b);
			
//			BufferedReader reader = new BufferedReader(new FileReader(URI));
//			String line = null;
//			while((line = reader.readLine()) != null){
//				System.out.println(line);
//			}
			
//			ResultStatistics result1 = listOfDataFile.stream().map(DataFile::getValue).collect(ResultStatistics::new, (r, p) -> { r.list.add(p); r.sum += p; },(r1,p1) -> { });
//			System.out.println(result1.sum);
//			System.out.println(result1.list);
			
			Map<String, List<DataFile>> result2 = listOfDataFile.stream().collect(Collectors.groupingBy(DataFile::getGroup));
			System.out.println(result2);
			
//			Map<String, Set<Double>> result3 = listOfDataFile.stream().collect(Collectors.groupingBy(DataFile::getGroup, Collectors.mapping(DataFile::getValue, Collectors.toSet())));
//			System.out.println(result3);
//			
//			Map<String, Double> result4 = listOfDataFile.stream().collect(Collectors.groupingBy(DataFile::getGroup,Collectors.summingDouble(DataFile::getValue)));
//			System.out.println(result4);
//			
//			Double result5 = listOfDataFile.stream().collect(Collectors.summingDouble(DataFile::getValue));
//			System.out.println(result5);
//			
//			System.out.println(listOfDataFile);
//			listOfDataFile.sort(Comparator.comparing(DataFile::getName));
//			System.out.println(listOfDataFile);
		} catch (Exception e) {
		}
	}
}

class ResultStatistics{
	List<Double> list = new ArrayList<>();
	Double sum = new Double(0);
}

class DataFile {
	private String number;
	private String group;
	private String name;
	private Double age;
	private Double value;

	public DataFile(String number, String group, String name, Double age, Double value) {
		this.number = number;
		this.group = group;
		this.name = name;
		this.age = age;
		this.value = value;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAge() {
		return age;
	}

	public void setAge(Double age) {
		this.age = age;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String toString(){
		return String.format("DataFile[number=%s,group=%s,name=%s,age=%s,value=%s]", number, group, name, age, value);
	}
}