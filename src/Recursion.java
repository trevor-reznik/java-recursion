/**
 * Name: Christian P. Bynre
 * Course: CSC 210 Fall 21
 * File: Recursion.java
 * 
 * Recursion Functions for PA3.
 * 
 * Usage: java ./Recursion.java
 */

import java.util.Queue;
import java.util.Stack;

public class Recursion {

  /**
   * Recursive function that finds the index of s2 in s1.
   *
   * @param s1
   * @param s2
   * @return Returns the index of the first time that
   * 			s2 appears in s1 or -1 if s2 is not contained
   * 			in s1.
   */
  public static int indexOf(String s1, String s2) {
    return s2.length() > s1.length()
      ? -1
      : s1.substring(0, s2.length()).equals(s2)
        ? 0
        : indexOf(s1.substring(1), s2) == -1
          ? -1
          : 1 + indexOf(s1.substring(1), s2);
  }

  /**
   * Write a recursive function that removes the first k even numbers
   * from the stack. If there are less than k even elements in the stack,
   * just remove all even elements. Do not use any loops or data structures
   * other than the stack passed in as a parameter.
   * 
   * @param stack
   * @param k
   * @return Returns the number of elements removed from the stack.
   */
  public static int removeEvenNumbers(Stack<Integer> stack, int k) {
    if (k == 0) {
      return 0;
    }
    int i = removeEvenNumbers(stack, k - 1);
    if (i < stack.size()) {
      if (stack.get(i) % 2 == 0) {
        stack.remove(i);
      }
    }
    return 1 + removeEvenNumbers(stack, k - 1);
  }

  /**
   * Recursive function that accepts an integer and
   * returns a new number containing only the even digits, in the same
   * order. If there are no even digits, return 0.
   * 
   * @param n An integer.
   * @return The input with only the even digits remaining in the same
   * order.
   */
  public static int evenDigits(int n) {
    if (n == 0) {
      return n;
    }
    int dig = n % 10;
    int carry = evenDigits(Integer.valueOf(n / 10));
    if (dig % 2 == 0) {
      carry *= 10;
      carry += dig;
    }

    return carry;
  }

  /**
   * Recursive function that evaluates a Queue<Character> as a mathematical
   * expression. This queue can have any of the following characters:
   * { '(', ')', '+', '*'} or any single digit number. Evaluates expression and
   * return the result. For example, for the expression:
   * "(((1+2)*(3+1))+(1*(2+2)))", each of these characters would be in the
   * q. As you recursively evaluate characters from the expression, you will
   * remove the characters from the q. After evaluating the above expression,
   * you should return 16. Requires that there are NO two digit numbers,
   * and that the expression is well formed (parenthesis match, etc...).
   * 
   * @param q Mathematical expression using addition and multiplication.
   * @return The result of the mathematical expression.
   */
  public static int evaluate(Queue<Character> q) {
    int first;
    if (q.peek() == '(') {
      q.poll();
      first = evaluate(q);
      q.poll();
    } else {
      first = Character.getNumericValue(q.poll());
    }
    if (q.isEmpty()) {
      return first;
    }

    Character operator = q.poll();
    if (q.isEmpty()) {
      return first;
    }

    int second;
    if (q.peek() == '(') {
      q.poll();
      second = evaluate(q);
      q.poll();
    } else {
      second = Character.getNumericValue(q.poll());
    }
    if (q.isEmpty()) {
      return first;
    }

    return operator == '+' ? first + second : first * second;
  }

  /**
   * Write a recursive function that accepts a stack of integers and
   * replaces each int with two copies of that integer. For example,
   * calling repeatStack and passing in a stack of { 1, 2, 3} would change
   * the stack to hold { 1, 1, 2, 2, 3, 3}. Do not use any loops. Do not use
   * any data structures other than the stack passed in as a parameter.
   * 
   * @param stack
   */
  public static void repeatStack(Stack<Integer> stack) {
    if (!stack.empty()) {
      int first = stack.pop();

      repeatStack(stack);

      stack.push(first);
      stack.push(first);
    }
  }

  /**
   * Recursive function that accepts a Queue<Integer>. It
   * changes every int in this queue to be double its original
   * value. Uses helper function which reverses a queue with a 
   * modifier applied to each value.
   * 
   * @param q
   */
  public static void doubleElements(Queue<Integer> q) {
    dblQueue(q, 2);
    dblQueue(q, 1);
  }

  public static void dblQueue(Queue<Integer> q, int modifier) {
    if (!q.isEmpty()) {
      int cur = q.poll();
      dblQueue(q, modifier);
      q.add(cur * modifier);
    }
  }

  public static void main(String[] args) {
  }
}
