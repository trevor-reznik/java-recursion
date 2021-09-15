/**
 * Name: Christian P. Bynre
 * Course: CSC 210 Fall 21
 * File: RecursionTestClass.java
 * 
 * Recursion Test Cases for the six Functions assigned as part of PA3.
 * Use with jUnit.
 * 
 */
import static org.junit.Assert.assertEquals;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.IntStream;
import org.junit.Test;

public class RecursionTestClass {

  @Test
  public void testIndexOf_test1() {
    int result1 = Recursion.indexOf("Hello", "World");
    System.out.println("indexOf(Hello, World), got " + result1);
    assertEquals(-1, result1);
  }

  @Test
  public void testIndexOf_test2() {
    int result2 = Recursion.indexOf("boring", "ing");
    System.out.println("indexOf(boring, ing), got " + result2);
    assertEquals(3, result2);
  }

  @Test
  public void testIndexOf_test3() {
    int result2 = Recursion.indexOf("", "x");
    System.out.println("indexOf('', x), got " + result2);
    assertEquals(-1, result2);
  }

  @Test
  public void testIndexOf_test4() {
    int result2 = Recursion.indexOf("123", "2");
    System.out.println("indexOf(123, 2), got " + result2);
    assertEquals(1, result2);
  }

  // ────────────────────────────────────────────────────────────────────────────────

  public static Stack<Integer> generateStack(int lowerBound, int upperBound) {
    Stack<Integer> ret = new Stack<Integer>();
    IntStream.range(lowerBound, upperBound).forEachOrdered(n -> ret.push(n));
    return ret;
  }

  public static Stack<Integer> generateOddStack(
    int lowerBound,
    int upperBound
  ) {
    Stack<Integer> ret = new Stack<Integer>();
    for (
      int i = lowerBound % 2 != 0 ? lowerBound : lowerBound + 1;
      i < upperBound;
      i += 2
    ) {
      ret.push(i);
    }
    return ret;
  }

  public static void pushUntil(
    Stack<Integer> stack,
    int start,
    int upperBound
  ) {
    for (int i = start; i < upperBound; i++) {
      stack.push(i);
    }
  }

  @Test
  public void testRemoveEvenNumbers_test1() {
    Stack<Integer> stack = generateStack(0, 25);
    Stack<Integer> oddStack = generateOddStack(0, 12);
    pushUntil(oddStack, 12, 25);
    int result1 = Recursion.removeEvenNumbers(stack, 6);
    assertEquals(6, result1);
    assertEquals(oddStack, stack);
  }

  @Test
  public void testRemoveEvenNumbers_test2() {
    Stack<Integer> stack = generateStack(0, 12);
    Stack<Integer> oddStack = generateOddStack(0, 12);
    int result1 = Recursion.removeEvenNumbers(stack, 6);
    assertEquals(6, result1);
    assertEquals(oddStack, stack);
  }

  @Test
  public void testRemoveEvenNumbers_test3() {
    Stack<Integer> stack = generateStack(0, 4);
    Stack<Integer> oddStack = generateOddStack(0, 4);
    int result1 = Recursion.removeEvenNumbers(stack, 4);
    // assertEquals(3, result1);
    assertEquals(oddStack, stack);
  }

  @Test
  public void testRemoveEvenNumbers_test4() {
    Stack<Integer> stack = generateStack(0, 90);
    int result1 = Recursion.removeEvenNumbers(stack, 0);
    assertEquals(0, result1);
    assertEquals(stack, stack);
  }

  // ────────────────────────────────────────────────────────────────────────────────

  @Test
  public void testEvenDigits_test1() {
    int result1 = Recursion.evenDigits(12345);
    assertEquals(24, result1);
  }

  @Test
  public void testEvenDigits_test2() {
    int result1 = Recursion.evenDigits(11113335);
    assertEquals(0, result1);
  }

  @Test
  public void testEvenDigits_test3() {
    int result1 = Recursion.evenDigits(222);
    assertEquals(222, result1);
  }

  @Test
  public void testEvenDigits_test4() {
    int result1 = Recursion.evenDigits(0001001);
    assertEquals(00000, result1);
  }

  @Test
  public void testEvenDigits_test5() {
    int result1 = Recursion.evenDigits(0012);
    assertEquals(002, result1);
  }

  @Test
  public void testEvenDigitsNegative() {
    int result1 = Recursion.evenDigits(-12);
    assertEquals(-2, result1);
  }

  // ────────────────────────────────────────────────────────────────────────────────

  public static Queue<Character> toQueue(String mathExpression) {
    Queue<Character> test = new LinkedList<Character>();
    for (int i = 0; i < mathExpression.length(); i++) {
      test.add(mathExpression.charAt(i));
    }
    return test;
  }

  @Test
  public void testEval1() {
    int result1 = Recursion.evaluate(toQueue("(((1+2)*(3+1))+(1*(2+2)))"));
    assertEquals(16, result1);
  }

  @Test
  public void testEval2() {
    int result1 = Recursion.evaluate(toQueue("(((1+1)*(3+2))+(1*(1+1)))"));
    assertEquals(12, result1);
  }

  @Test
  public void testEval3() {
    int result1 = Recursion.evaluate(toQueue("(((1+1)+(2*(3+1)))"));
    assertEquals(10, result1);
  }

  @Test
  public void testEval4() {
    int result1 = Recursion.evaluate(toQueue("((1+0))"));
    assertEquals(1, result1);
  }
  // ────────────────────────────────────────────────────────────────────────────────


  public static Stack<Integer> genStack(int range) { 
    Stack<Integer> test = new Stack<Integer>();
    for (int i = 0; i < range; i++) {
      test.push(i);
    }
    return test;
  }
  
  public static Stack<Integer> genDoubleStack(int range) { 
    Stack<Integer> test = new Stack<Integer>();
    for (int i = 0; i < range; i++) {
      test.push(i);
      test.push(i);
    }
    return test;
  }

  @Test
  public void testRepeatStack1() {
	Stack<Integer> test = genStack(5);
	Recursion.repeatStack(test);
    Stack<Integer> ref = genDoubleStack(5);
	assertEquals(ref, test);
  }
  @Test
  public void testRepeatStack2() {
    Stack<Integer> test = genStack(114);
    Recursion.repeatStack(test);
    Stack<Integer> ref = genDoubleStack(114);
    assertEquals(ref, test);
  }
  
  @Test
  public void testRepeatStack3() {
	Stack<Integer> test = genStack(1);
	Recursion.repeatStack(test);
    Stack<Integer> ref = genDoubleStack(1);
	assertEquals(ref, test);
  }


  // ────────────────────────────────────────────────────────────────────────────────

  public static Queue<Integer> genQueue(int upperBound) {
    Queue<Integer> test = new LinkedList<Integer>();
    for (int i = 0; i < upperBound; i++) {
      test.add(i);
    }
    return test;
  }

  public static Queue<Integer> doubleQueue(int upperBound) {
    Queue<Integer> test = new LinkedList<Integer>();
    for (int i = 0; i < upperBound; i++) {
      test.add(i * 2);
    }
    return test;
  }

  @Test
  public void testDblQueue1() {
	Queue<Integer> test = genQueue(2);
	Recursion.doubleElements(test);
    Queue<Integer> ref = doubleQueue(2);
	assertEquals(ref, test);
  }
  @Test
  public void testDblQueue2() {
	Queue<Integer> test = genQueue(3);
	Recursion.doubleElements(test);
    Queue<Integer> ref = doubleQueue(3);
	assertEquals(ref, test);
  }
  @Test
  public void testDblQueue3() {
	Queue<Integer> test = genQueue(9);
	Recursion.doubleElements(test);
    Queue<Integer> ref = doubleQueue(9);
	assertEquals(ref, test);
  }
  @Test
  public void testDblQueue4() {
	Queue<Integer> test = genQueue(0);
	Recursion.doubleElements(test);
    Queue<Integer> ref = doubleQueue(0);
	assertEquals(ref, test);
  }
  @Test
  public void testDblQueue5() {
	Queue<Integer> test = genQueue(22);
	Recursion.doubleElements(test);
    Queue<Integer> ref = doubleQueue(22);
	assertEquals(ref, test);
  }
  @Test
  public void testDblQueue6() {
	Queue<Integer> test = genQueue(15);
	Recursion.doubleElements(test);
    Queue<Integer> ref = doubleQueue(15);
	assertEquals(ref, test);
  }

}
