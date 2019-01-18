/*
 * This file is part of the Yildiz-Engine project, licenced under the MIT License  (MIT)
 *
 *  Copyright (c) 2019 Gregory Van den Borre
 *
 *  More infos available: https://engine.yildiz-games.be
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

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Class test for Point2D.
 *
 * @author Gregory Van den Borre
 */
class Point2DTest {

    private static final int X = 10;

    private static final int Y = 5;

    private final Point2D point = Point2D.valueOf(Point2DTest.X, Point2DTest.Y);

    /***/
    @Test
    void testAddIntInt() {
        final int x2 = 3;
        final int y2 = -20;
        Point2D computed = this.point.add(x2, y2);
        assertEquals(computed.x, Point2DTest.X + x2, 0.0001);
        assertEquals(computed.y, Point2DTest.Y + y2, 0.0001);
        assertEquals(this.point.x, Point2DTest.X, 0.0001);
        assertEquals(this.point.y, Point2DTest.Y, 0.0001);
    }

    /***/
    @Test
    void testAddPoint() {
        final int x2 = 3;
        final int y2 = 20;
        Point2D computed = this.point.add(Point2D.valueOf(x2, y2));
        assertEquals(computed.x, Point2DTest.X + x2, 0.0001);
        assertEquals(computed.y, Point2DTest.Y + y2, 0.0001);
        assertEquals(this.point.x, Point2DTest.X, 0.0001);
        assertEquals(this.point.y, Point2DTest.Y, 0.0001);
    }

    @Nested
    class Equals {

        @Test
        void withNull() {
            assertNotEquals(null, point);
        }

        @Test
        void withWrongType() {
            assertNotEquals(point, "");
        }

        @Test
        void sameObject() {
            assertEquals(point, point);
        }

        @Test
        void sameValue() {
            assertEquals(point, Point2D.valueOf(point.x, point.y));
        }

        @Test
        void differentX() {
            assertNotEquals(point, Point2D.valueOf(point.x + 1, point.y));
        }

        @Test
        void differentY() {
            assertNotEquals(point, Point2D.valueOf(point.x, point.y + 1));
        }
    }

    /***/
    @Test
    void testHashCode() {
        Point2D point2 = Point2D.valueOf(this.point.x, this.point.y);
        assertEquals(this.point.hashCode(), point2.hashCode());
    }

    /***/
    @Test
    void testMultiplyByScalar() {
        Point2D computed = this.point.multiplyByScalar(10);
        assertEquals(this.point.x, Point2DTest.X, 0.0001);
        assertEquals(this.point.y, Point2DTest.Y, 0.0001);
        assertEquals(computed.x, Point2DTest.X * 10, 0.0001);
        assertEquals(computed.y, Point2DTest.Y * 10, 0.0001);
    }

    /***/
    @Test
    void testPoint() {
        assertEquals(0, Point2D.ZERO.x, 0.0001);
        assertEquals(0, Point2D.ZERO.y, 0.0001);
    }

    /***/
    @Test
    void testPointIntInt() {
        assertEquals(this.point.x, Point2DTest.X, 0.0001);
        assertEquals(this.point.y, Point2DTest.Y, 0.0001);
    }


    /***/
    @Test
    void testSubtractIntInt() {
        final int x2 = 3;
        final int y2 = -20;
        Point2D computed = this.point.subtract(x2, y2);
        assertEquals(computed.x, Point2DTest.X - x2, 0.0001);
        assertEquals(computed.y, Point2DTest.Y - y2, 0.0001);
        assertEquals(this.point.x, Point2DTest.X, 0.0001);
        assertEquals(this.point.y, Point2DTest.Y, 0.0001);
    }

    /***/
    @Test
    void testSubtractPoint() {
        final int x2 = 3;
        final int y2 = 20;
        Point2D computed = this.point.subtract(Point2D.valueOf(x2, y2));
        assertEquals(computed.x, Point2DTest.X - x2, 0.0001);
        assertEquals(computed.y, Point2DTest.Y - y2, 0.0001);
        assertEquals(this.point.x, Point2DTest.X, 0.0001);
        assertEquals(this.point.y, Point2DTest.Y, 0.0001);
    }

    /***/
    @Test
    void testToString() {
        assertEquals("10.0,5.0", this.point.toString());
    }
}
