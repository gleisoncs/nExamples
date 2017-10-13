package com.examples.others;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher {

	public static void main(String[] args) {
		String ms4 = "Aug 16 07:19:53 pnjsrchrec08.barnesandnoble.comLogfileMonitor|1502882393|pnjsrchrec08|critical|Logfile|OS|openView-6800.log|Wed Aug 16 07:15:01 2017|critical|Tomcat is not responsive; Solr service will be affected. Restart Solr if the problem persists.|LogfileMonitor";
		// Pattern entityPattern4 =
		// Pattern.compile("^\\w+\\s+\\d+\\s+\\d+:\\d+:\\d+\\s+\\S+\\s+\\w+\\|\\d+\\|(\\w+)\\|");
		Pattern entityPattern4 = Pattern.compile("^\\w+\\s+\\d+\\s+\\S+\\s+\\w+\\.+\\w+\\.+\\w+\\|+\\d+\\|+(\\w+)");
		// Pattern entityPattern4 =
		// Pattern.compile("^\\w+\\s+\\d+\\s+\\S+\\s+\\w+\\.+\\w+\\.+\\w+\\|+\\d+\\|+\\w+\\|(\\w+)");
		Matcher entityMatcher4 = entityPattern4.matcher(ms4);
		// Matcher severityMatcher4 = severityPattern4.matcher(ms4);
		if (entityMatcher4.lookingAt()) {
			System.out.println(entityMatcher4.group(1));
			// System.out.println("*********** Severity is " +
			// severityMatcher4.group(1));
		}
	}

}
