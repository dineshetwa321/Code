package a.array.cond;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BadgeRecord {

	// Entry exit
	// https://leetcode.com/discuss/interview-question/4366572/Atlassian-or-PSE-or-Screening-or-Reject/

	public static Map<String, Set<String>> checkEmployeeRecord(String records[][]) {
		Map<String, Set<String>> result = new HashMap<>();
		
		Set<String> exitWithoutEntry = new HashSet<>();
		Set<String> entryWithoutExit = new HashSet<>();
		Set<String> room = new HashSet<>();

		for (String record[] : records) {
			
			String employeeName = record[0];
			String isEntryExit = record[1];
			if (isEntryExit.equalsIgnoreCase("exit")) {
				// if employee is the room that means valid entry otherwise it's exit without an
				// entry
				if (!room.remove(employeeName)) {
					exitWithoutEntry.add(employeeName);
				}
			} else if (!room.add(employeeName)) { // it's enter case and room should not have entry of this employee
				entryWithoutExit.add(employeeName);
			}
		}
		entryWithoutExit.addAll(room);// log entry ends
		result.put("enter", entryWithoutExit);
		result.put("exit", exitWithoutEntry);
		return result;
	}

	public static void main(String[] args) {

		checkEmployeeRecord(records);
	}

	static String[][] records = { { "Paul", "enter" }, // no issue
			{ "Pauline", "exit" }, // issue, means she entered the room w/o using badge, exit w/o enter
			{ "Paul", "enter" }, { "Paul", "exit" }, { "Martha", "exit" }, { "Joe", "enter" }, { "Martha", "enter" },
			{ "Steve", "enter" }, { "Martha", "exit" }, { "Jennifer", "enter" }, { "Joe", "enter" },
			{ "Curtis", "exit" }, { "Curtis", "enter" }, { "Joe", "exit" }, { "Martha", "enter" }, { "Martha", "exit" },
			{ "Jennifer", "exit" }, { "Joe", "enter" }, { "Joe", "enter" }, { "Martha", "exit" }, { "Joe", "exit" },
			{ "Joe", "exit" }, };
}
