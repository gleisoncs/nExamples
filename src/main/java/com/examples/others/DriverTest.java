package com.examples.others;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverTest {

	public static void main(String[] argv) {

		System.out.println("-------- MySQL JDBC Connection Testing ------------");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}

		System.out.println("MySQL JDBC Driver Registered!");
		Connection connection = null;

		try {
//			connection = DriverManager.getConnection("jdbc:mysql://cluster1.cluster-c1gqd93z7hsd.eu-west-2.rds.amazonaws.com:3306/rightitnow", "root", "admin1234");
//			connection = DriverManager.getConnection("jdbc:mysql:loadbalance://cluster1.cluster-c1gqd93z7hsd.eu-west-2.rds.amazonaws.com:3306/rightitnow?characterEncoding=utf8&useUnicode=yes&useSSL=false", "root", "admin1234");
			connection = DriverManager.getConnection("jdbc:mysql:loadbalance://ec2-35-183-48-121.ca-central-1.compute.amazonaws.com:3306,ec2-35-183-40-55.ca-central-1.compute.amazonaws.com:3306/rightitnow_5?characterEncoding=utf8&useUnicode=yes&useSSL=false", "root", "admin");
			

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
	}
}
