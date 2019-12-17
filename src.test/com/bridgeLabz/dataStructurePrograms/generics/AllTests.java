package com.bridgeLabz.dataStructurePrograms.generics;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestDeque.class, TestLinkedList.class, TestQueue.class, TestStack.class })
public class AllTests {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(TestDeque.class, TestLinkedList.class, TestQueue.class, TestStack.class);

		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println(result.wasSuccessful());
	}

}
