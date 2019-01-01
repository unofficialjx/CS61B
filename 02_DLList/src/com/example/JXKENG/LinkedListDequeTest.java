package com.example.JXKENG;

/** Performs some basic linked list tests. */
public class LinkedListDequeTest {
	
	/* Utility method for printing out empty checks. */
	public static boolean checkEmpty(boolean expected, boolean actual) {
		if (expected != actual) {
			System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Utility method for printing out empty checks. */
	public static boolean checkSize(int expected, int actual) {
		if (expected != actual) {
			System.out.println("size() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Prints a nice message based on whether a test passed. 
	 * The \n means newline. */
	public static void printTestStatus(boolean passed) {
		if (passed) {
			System.out.println("Test passed!\n");
		} else {
			System.out.println("Test failed!\n");
		}
	}

	/** Adds a few things to the list, checking isEmpty() and size() are correct, 
	  * finally printing the results. 
	  *
	  * && is the "and" operation. */
	public static void addIsEmptySizeTest() {
		System.out.println("Running add/isEmpty/Size test.");

		DLList<String> lld1 = new DLList<>();

		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst("front");

		passed = checkSize(1, lld1.size()) && passed;
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.addLast("middle");
		passed = checkSize(2, lld1.size()) && passed;

		lld1.addLast("back");
		passed = checkSize(3, lld1.size()) && passed;

		System.out.println("Printing out deque: ");
		lld1.printDeque();

		printTestStatus(passed);
	}

	/** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
	public static void addRemoveTest() {

		System.out.println("Running add/remove test.");

		DLList<Integer> lld1 = new DLList<>();
		// should be empty 
		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst(10);
		// should not be empty 
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.removeFirst();
		// should be empty 
		passed = checkEmpty(true, lld1.isEmpty()) && passed;

		printTestStatus(passed);

	}


	/** Checking removeFirst and removeLast methods */
	public static void removeTest() {

		System.out.println("Running remove test");

		DLList<Integer> lld1 = new DLList<>(20);

		lld1.addFirst(15);
		lld1.addFirst(10);
		lld1.addLast(25);
		lld1.removeFirst();
		System.out.println("Expected: 15 20 25");
		System.out.print("Actual: ");
		lld1.printDeque();

		lld1.addLast(30);
		lld1.addLast(35);
		lld1.removeLast();
		System.out.println("Expected: 15 20 25 30");
		System.out.print("Actual: ");
		lld1.printDeque();


	}
	/** Checking recursiveGet method */
	public static void recursiveGetTest() {

		System.out.println("Running recursiveGet test");

		DLList<Integer> lld1 = new DLList<>(20);

		lld1.addFirst(15);
		lld1.addLast(25);
		System.out.println("Expected: 15 20 25");
		System.out.print("Actual: ");
		System.out.print(lld1.getRecursive(0) + " ");
		System.out.print(lld1.getRecursive(1) + " ");
		System.out.print(lld1.getRecursive(2) + " ");
		System.out.println();

		System.out.println("Test passed!");

	}

	public static void main(String[] args) {
		System.out.println("Running tests.\n");
		addIsEmptySizeTest();
		addRemoveTest();
		removeTest();
		recursiveGetTest();
	}
} 