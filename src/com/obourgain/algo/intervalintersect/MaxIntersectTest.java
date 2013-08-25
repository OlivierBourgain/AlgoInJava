package com.obourgain.algo.intervalintersect;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MaxIntersectTest {

    @Test
    public void testSimpleCase() {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 5));
        list.add(new Interval(2, 6));
        list.add(new Interval(3, 4));
        list.add(new Interval(6, 8));
        list.add(new Interval(-1, 10));
        list.add(new Interval(9, 11));
        Assert.assertEquals(4, new MaxIntersect().findMaxIntersect(list));
    }


    @Test
    public void testOneInterval() {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 5));
        Assert.assertEquals(1, new MaxIntersect().findMaxIntersect(list));
    }

    @Test
    public void testDeuxIntervallesDisjoints() {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 5));
        list.add(new Interval(10, 15));
        Assert.assertEquals(1, new MaxIntersect().findMaxIntersect(list));
    }

    @Test
    public void testDeuxIntervallesAvecIntersection() {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 5));
        list.add(new Interval(3, 15));
        Assert.assertEquals(2, new MaxIntersect().findMaxIntersect(list));
    }

    @Test
    public void testDeuxIntervallesEgaux() {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 5));
        list.add(new Interval(1, 5));
        Assert.assertEquals(2, new MaxIntersect().findMaxIntersect(list));
    }

    @Test
    public void testIntervalleInclusDansUnAutre() {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 5));
        list.add(new Interval(2, 4));
        Assert.assertEquals(2, new MaxIntersect().findMaxIntersect(list));
    }

    @Test
    public void testIntervalleQuiSeSuivent() {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 5));
        list.add(new Interval(5, 6));
        Assert.assertEquals(1, new MaxIntersect().findMaxIntersect(list));
    }

    @Test
    public void testIntervalleDegenere() {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 1));
        Assert.assertEquals(0, new MaxIntersect().findMaxIntersect(list));
    }

}
