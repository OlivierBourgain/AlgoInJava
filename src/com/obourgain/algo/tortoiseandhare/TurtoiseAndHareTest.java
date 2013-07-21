package com.obourgain.algo.tortoiseandhare;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import org.junit.Test;

public class TurtoiseAndHareTest {
   TurtoiseAndHare a = new TurtoiseAndHare();

   @Test
   public void testSimpleCaseWithoutLoop() {
      Node root = generateTestCaseWithoutLoop(10);
      assertFalse(a.containsLoop(root));
      assertEquals("No loop", a.checkLoop(root));
   }

   @Test
   public void testSimpleCase() {
      Node root = generateTestCaseWithLoop(4, 2);
      assertTrue(a.containsLoop(root));
      assertEquals("lambda = 2, mu = 4", a.checkLoop(root));
   }

   @Test
   public void testSimpleCase2() {
      Node root = generateTestCaseWithLoop(10, 4);
      assertTrue(a.containsLoop(root));
      assertEquals("lambda = 4, mu = 10", a.checkLoop(root));
   }

   @Test
   public void testLoopLengthOne() {
      Node root = generateTestCaseWithLoop(99, 1);
      assertTrue(a.containsLoop(root));
      assertEquals("lambda = 1, mu = 99", a.checkLoop(root));
   }

   @Test
   public void testLoopStartingAtPosZero() {
      Node root = generateTestCaseWithLoop(0, 10);
      assertTrue(a.containsLoop(root));
      assertEquals("lambda = 10, mu = 0", a.checkLoop(root));
   }

   /**
    * Génère une liste chainée contenant un tronc de 'mu' éléments, et un
    * cycle de 'lambda' éléments.
    */
   private Node generateTestCaseWithLoop(int mu, int lambda) {
      Node root = new Node(1);
      Node cur = root;

      for (int i = 2; i <= mu + 1; i++) {
         Node n = new Node(i);
         cur.setNext(n);
         cur = cur.getNext();
      }

      Node startOfLoop = cur;

      for (int i = 2; i <= lambda; i++) {
         Node n = new Node(mu + i);
         cur.setNext(n);
         cur = cur.getNext();
      }

      cur.setNext(startOfLoop);
      return root;
   }

   private Node generateTestCaseWithoutLoop(int size) {
      Node root = new Node(1);
      Node cur = root;
      for (int i = 1; i < size; i++) {
         Node n = new Node(i + 1);
         cur.setNext(n);
         cur = cur.getNext();
      }
      return root;
   }
}
