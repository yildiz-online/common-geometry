/*
 * This file is part of the Yildiz-Engine project, licenced under the MIT License  (MIT)
 *
 *  Copyright (c) 2018 Grégory Van den Borre
 *
 *  More infos available: https://www.yildiz-games.be
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 *  documentation files (the "Software"), to deal in the Software without restriction, including without
 *  limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 *  of the Software, and to permit persons to whom the Software is furnished to do so,
 *  subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all copies or substantial
 *  portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 *  WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
 *  OR COPYRIGHT  HOLDERS BE LIABLE FOR ANY CLAIM,
 *  DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE  SOFTWARE.
 *
 */

package be.yildizgames.common.geometry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Class test for Point2D.
 *
 * @author Grégory Van den Borre
 */
class PointTest {

    /***/
    private static final int X = 10;
    /***/
    private static final int Y = 5;
    /***/
    private Point2D point;

    /***/
    @Test
    void testAddIntInt() {
        this.point = new Point2D(PointTest.X, PointTest.Y);
        final int x2 = 3;
        final int y2 = -20;
        this.point.add(x2, y2);
        assertTrue(this.point.getX() == PointTest.X + x2);
        assertTrue(this.point.getY() == PointTest.Y + y2);
    }

    /***/
    @Test
    void testAddPoint() {
        this.point = new Point2D(PointTest.X, PointTest.Y);
        final int x2 = 3;
        final int y2 = 20;
        Point2D point2 = new Point2D(x2, y2);
        this.point.add(point2);
        assertTrue(this.point.getX() == PointTest.X + x2);
        assertTrue(this.point.getY() == PointTest.Y + y2);
    }

    /***/
    @Test
    void testEquals() {
        this.point = new Point2D(PointTest.X, PointTest.Y);
        assertFalse(this.point.equals(null));
        assertFalse(this.point.equals(new Rectangle()));
        assertTrue(this.point.equals(this.point));
        Point2D point2 = new Point2D();
        point2.setValues(this.point);
        assertTrue(this.point.equals(point2));
        point2.setX(PointTest.X + 5);
        assertFalse(this.point.equals(point2));
        point2.setValues(this.point);
        point2.setY(PointTest.Y + 5);
        assertFalse(this.point.equals(point2));
    }

    /***/
    @Test
    void testGetAngle() {
        this.point = new Point2D();
        assertEquals(this.point.getAngle(), 0.0f, 1e-15);
        this.point = new Point2D(1, 1);
        assertEquals(this.point.getAngle(), (float) Math.PI * 45f / 180f, 1e-15);
        this.point = new Point2D(100, 100);
        assertEquals(this.point.getAngle(), (float) Math.PI * 45f / 180f, 1e-15);
        this.point = new Point2D(-1, 1);
        assertEquals(this.point.getAngle(), (float) Math.PI * 135f / 180f, 1e-15);
        this.point = new Point2D(0, 1);
        assertEquals(this.point.getAngle(), (float) Math.PI * 90f / 180f, 1e-15);
    }

    /***/
    @Test
    void testGetX() {
        this.point = new Point2D(PointTest.X, PointTest.Y);
        assertTrue(this.point.getX() == PointTest.X);
    }

    /***/
    @Test
    void testGetY() {
        this.point = new Point2D(PointTest.X, PointTest.Y);
        assertTrue(this.point.getY() == PointTest.Y);
    }

    /***/
    @Test
    void testHashCode() {
        this.point = new Point2D();
        Point2D point2 = new Point2D();
        point2.setValues(this.point);
        assertTrue(this.point.hashCode() == point2.hashCode());
    }

    /***/
    @Test
    void testMultiplyByScalar() {
        this.point = new Point2D(1, 1);
        this.point.multiplyByScalar(10);
        assertEquals(this.point, new Point2D(10, 10));
        this.point.multiplyByScalar(0);
        assertEquals(this.point, new Point2D());
    }

    /***/
    @Test
    void testPoint() {
        this.point = new Point2D();
        assertTrue(this.point.getX() == 0);
        assertTrue(this.point.getY() == 0);
    }

    /***/
    @Test
    void testPointIntInt() {
        this.point = new Point2D(PointTest.X, PointTest.Y);
        assertTrue(this.point.getX() == PointTest.X);
        assertTrue(this.point.getY() == PointTest.Y);
    }

    /***/
    @Test
    void testSetValuesIntInt() {
        this.point = new Point2D(PointTest.X, PointTest.Y);
        final int x2 = 3;
        final int y2 = -20;
        this.point.setValues(x2, y2);
        assertTrue(this.point.getX() == x2);
        assertTrue(this.point.getY() == y2);

    }

    /***/
    @Test
    void testSetValuesYzPoint() {
        this.point = new Point2D(PointTest.X, PointTest.Y);
        final int x2 = 3;
        final int y2 = -20;
        Point2D point2 = new Point2D(x2, y2);
        this.point.setValues(point2);
        assertTrue(this.point.getX() == x2);
        assertTrue(this.point.getY() == y2);
    }

    /***/
    @Test
    void testSetX() {
        this.point = new Point2D(PointTest.X, PointTest.Y);
        final int x2 = 8;
        this.point.setX(x2);
        assertTrue(this.point.getX() == x2);
    }

    /***/
    @Test
    void testSetY() {
        this.point = new Point2D(PointTest.X, PointTest.Y);
        final int y2 = -43;
        this.point.setY(y2);
        assertTrue(this.point.getY() == y2);

    }

    /***/
    @Test
    void testSubstractIntInt() {
        this.point = new Point2D(PointTest.X, PointTest.Y);
        final int x2 = 3;
        final int y2 = -20;
        this.point.substract(x2, y2);
        assertTrue(this.point.getX() == PointTest.X - x2);
        assertTrue(this.point.getY() == PointTest.Y - y2);
    }

    /***/
    @Test
    void testSubstractPoint() {
        this.point = new Point2D(PointTest.X, PointTest.Y);
        final int x2 = 3;
        final int y2 = 20;
        Point2D point2 = new Point2D(x2, y2);
        this.point.substract(point2);
        assertTrue(this.point.getX() == PointTest.X - x2);
        assertTrue(this.point.getY() == PointTest.Y - y2);
    }

    /***/
    @Test
    void testToString() {
        this.point = new Point2D(PointTest.X, PointTest.Y);
        String s = PointTest.X + "," + PointTest.Y;
        assertNotNull(this.point.toString());
        assertTrue(s.equals(this.point.toString()));
    }
}
