package up.edu.dimcalc;

import static org.junit.Assert.*;

import android.graphics.Point;

import org.junit.Test;

public class TwoPointsTest {

    /** when created, getPoint() should show both points at the origin */
    @Test
    public void getPoint() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(0, p1.x);
        assertEquals(0, p1.y);
        assertEquals(0, p2.x);
        assertEquals(0, p2.y);
    }


    /** verify that arbitrary values are properly stored via setPoint() */
    @Test
    public void setPoint() throws Exception {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 5, -3);
        testPoints.setPoint(1, -3, 5);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(5, p1.x);
        assertEquals(-3, p1.y);
        assertEquals(-3, p2.x);
        assertEquals(5, p2.y);

    }

    @Test
    public void randomValue() {
        TwoPoints testPoints = new TwoPoints();
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(0, p1.x);
        assertEquals(0, p1.y);
        assertEquals(0, p2.x);
        assertEquals(0, p2.y);

        for (int i = 0; i < 100; i++) {
            testPoints.randomValue(0);
            p1 = testPoints.getPoint(0);
            assertTrue(p1.x >= -10);
            assertTrue(p1.x < 10);
            assertTrue(p1.y >= -10);
            assertTrue(p1.y < 10);
        }
    }

    @Test
    public void setOrigin() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 5, -3);
        Point p1 = testPoints.getPoint(0);
        assertEquals(5, p1.x);
        assertEquals(-3, p1.y);
        testPoints.setOrigin(0);
        assertEquals(0, p1.x);
        assertEquals(0, p1.y);
    }

    @Test
    public void copy() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 5, -3);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(5, p1.x);
        assertEquals(-3, p1.y);
        assertEquals(0, p2.x);
        assertEquals(0, p2.y);


        testPoints.copy(0, 1);
        p1 = testPoints.getPoint(0);
        p2 = testPoints.getPoint(1);
        assertEquals(5, p1.x);
        assertEquals(-3, p1.y);
        assertEquals(5, p2.x);
        assertEquals(-3, p2.y);

        testPoints.setPoint(0, 0, 0);
        p1 = testPoints.getPoint(0);
        p2 = testPoints.getPoint(1);
        assertEquals(0, p1.x);
        assertEquals(0, p1.y);
        assertEquals(5, p2.x);
        assertEquals(-3, p2.y);
    }

    @Test
    public void distance() {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 4, -3);
        assertEquals(5.0, testPoints.distance(), 0.001);

        testPoints.setPoint(1, 4, -6);
        assertEquals(3.0, testPoints.distance(), 0.001);
    }

    @Test
    public void slope() {
        TwoPoints testPoints = new TwoPoints();
        assertEquals(0, testPoints.slope(), 0.001);

        testPoints.setPoint(0, 4, 4);
        assertEquals(1, testPoints.slope(), 0.001);

        testPoints.setPoint(0, 1, 4);
        assertEquals(4, testPoints.slope(), 0.001);

        testPoints.setPoint(0, 0, 4);
        assertEquals(Double.POSITIVE_INFINITY, testPoints.slope(), 0.001);
    }
}