package com.obourgain.algo.threeandfive;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Date: 15/07/13
 */
public class ThreeAndFiveTest {
    ThreeAndFive t = new ThreeAndFive();

    @Test
    public void solutionRecursiveCasImpossibles() {
        assertEquals("Pas de décomposition", t.decomposeRecursif(2));
        assertEquals("Pas de décomposition", t.decomposeRecursif(6));
        assertEquals("Pas de décomposition", t.decomposeRecursif(636));
    }


    @Test
    public void solutionRecursiveCasPossibles() {
        assertEquals("1", t.decomposeRecursif(1));
        assertEquals("1+3", t.decomposeRecursif(4));
        assertEquals("1*5", t.decomposeRecursif(5));
        assertEquals("(1+3)*5+3", t.decomposeRecursif(23));
        assertEquals("(1+3+3+3)*5", t.decomposeRecursif(50));

        assertEquals("((1*5+3)*5+3)*5", t.decomposeRecursif(215));

        // 616
        assertEquals("1+3+3+3+3+3+3+3", t.decomposeRecursif(22));
        assertEquals("(1+3+3+3+3+3+3+3)*5+3+3+3+3", t.decomposeRecursif(122));
        assertEquals("((1+3+3+3+3+3+3+3)*5+3+3+3+3)*5+3+3", t.decomposeRecursif(616));

        // 1024
        assertEquals("((1*5+3)*5)*5+3", t.decomposeRecursif(203));
        assertEquals("(((1*5+3)*5)*5+3)*5+3+3+3", t.decomposeRecursif(1024));

        // 2048
        assertEquals("(1+3+3+3+3+3)*5", t.decomposeRecursif(80));
        assertEquals("((1+3+3+3+3+3)*5)*5+3+3+3", t.decomposeRecursif(409));
        assertEquals("(((1+3+3+3+3+3)*5)*5+3+3+3)*5+3", t.decomposeRecursif(2048));
    }


    @Test
    public void testWithLargeValue() {
        assertEquals("((((((((1*5)*5+3)*5+3+3+3)*5+3)*5+3+3+3+3)*5)*5+3+3+3)*5)*5+3+3+3", t.decomposeRecursif(2345234));
        assertEquals("((((((((1*5)*5+3)*5+3+3+3)*5+3)*5+3+3+3+3)*5)*5+3+3+3)*5)*5+3+3+3", t.decomposeIteratif(2345234));
    }

    @Test
    public void solutionIterativeCasImpossibles() {
        assertEquals("Pas de décomposition", t.decomposeIteratif(2));
        assertEquals("Pas de décomposition", t.decomposeIteratif(6));
        assertEquals("Pas de décomposition", t.decomposeIteratif(636));
    }

    @Test
    public void solutionIterativeCasPossibles() {
        assertEquals("1", t.decomposeIteratif(1));
        assertEquals("1+3", t.decomposeIteratif(4));
        assertEquals("1*5", t.decomposeIteratif(5));
        assertEquals("(1+3)*5+3", t.decomposeIteratif(23));
        assertEquals("(1+3+3+3)*5", t.decomposeIteratif(50));

        assertEquals("((1*5+3)*5+3)*5", t.decomposeIteratif(215));

        // 616
        assertEquals("1+3+3+3+3+3+3+3", t.decomposeIteratif(22));
        assertEquals("(1+3+3+3+3+3+3+3)*5+3+3+3+3", t.decomposeIteratif(122));
        assertEquals("((1+3+3+3+3+3+3+3)*5+3+3+3+3)*5+3+3", t.decomposeIteratif(616));

        // 1024
        assertEquals("((1*5+3)*5)*5+3", t.decomposeIteratif(203));
        assertEquals("(((1*5+3)*5)*5+3)*5+3+3+3", t.decomposeIteratif(1024));

        // 2048
        assertEquals("(1+3+3+3+3+3)*5", t.decomposeIteratif(80));
        assertEquals("((1+3+3+3+3+3)*5)*5+3+3+3", t.decomposeIteratif(409));
        assertEquals("(((1+3+3+3+3+3)*5)*5+3+3+3)*5+3", t.decomposeIteratif(2048));
    }
}
