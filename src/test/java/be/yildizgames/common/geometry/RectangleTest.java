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

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Gregory Van den Borre
 */
public final class RectangleTest {

    private static final int LEFT = 5;

    private static final int RIGHT = 15;

    private static final int TOP = 12;

    private static final int BOTTOM = 28;

    private static final int BETWEEN_LEFT_AND_RIGHT = 7;

    private static final int BETWEEN_TOP_AND_BOTTOM = 14;

    /***/
    @Test
    public void containsTest() {

        Point2D p = Point2D.valueOf(BETWEEN_LEFT_AND_RIGHT, BETWEEN_TOP_AND_BOTTOM);
        Rectangle r = new Rectangle(LEFT, TOP, RIGHT, BOTTOM);
        assertTrue(r.contain(LEFT, TOP));
        assertTrue(r.contain(RIGHT, BOTTOM));
        assertTrue(r.contain(p));
        assertTrue(r.contain(BETWEEN_LEFT_AND_RIGHT, TOP));
        assertFalse(r.contain(RIGHT + 1, BETWEEN_TOP_AND_BOTTOM));
        assertFalse(r.contain(LEFT - 1, BETWEEN_TOP_AND_BOTTOM));
        assertFalse(r.contain(BETWEEN_LEFT_AND_RIGHT, TOP - 1));
        assertFalse(r.contain(BETWEEN_LEFT_AND_RIGHT, BOTTOM + 1));
        r.setValues(RIGHT, BOTTOM, LEFT, TOP);
        assertTrue(r.contain(p));
        assertTrue(r.contain(LEFT, TOP));
        assertFalse(r.contain(16, 16));
        assertFalse(r.contain(4, 12));
    }

    /***/
    @Test
    public void moveTest() {
        Rectangle r = new Rectangle(LEFT, TOP, RIGHT, BOTTOM);
        r.move(0, 0);
        Rectangle r2 = new Rectangle(LEFT, TOP, RIGHT, BOTTOM);
        assertEquals(r, r2);
        final int xMove = 10;
        final int yMove = 5;
        r.move(xMove, yMove);
        assertEquals(LEFT + xMove, r.getLeft());
        assertEquals(RIGHT + xMove, r.getRight());
        assertEquals(TOP + yMove, r.getTop());
        assertEquals(BOTTOM + yMove, r.getBottom());
    }

    @Test
    public void resetTest() {
        Rectangle r = new Rectangle(10, 10, 20, 20);
        r.reset();
        assertEquals(0, r.getLeft());
        assertEquals(0, r.getRight());
        assertEquals(0, r.getTop());
        assertEquals(0, r.getBottom());
        assertEquals(0, r.getWidth());
        assertEquals(0, r.getHeight());
    }

    @Test
    public void testEqualsNull() {
        Rectangle r1 = new Rectangle(LEFT, TOP, RIGHT, BOTTOM);
        assertFalse(r1.equals(null));
    }

    @Test
    public void testEqualsOtherType() {
        Rectangle r1 = new Rectangle(LEFT, TOP, RIGHT, BOTTOM);
        assertFalse(r1.equals(Boolean.TRUE));
    }

    @Test
    public void testEqualsSameInstance() {
        Rectangle r1 = new Rectangle(LEFT, TOP, RIGHT, BOTTOM);
        assertTrue(r1.equals(r1));
    }

    @Test
    public void testEqualsSameValue() {
        Rectangle r1 = new Rectangle(LEFT, TOP, RIGHT, BOTTOM);
        Rectangle r2 = new Rectangle(LEFT, TOP, RIGHT, BOTTOM);
        assertTrue(r1.equals(r2));
    }

    @Test
    public void testEqualsNotSameLeft() {
        Rectangle r1 = new Rectangle(LEFT, TOP, RIGHT, BOTTOM);
        Rectangle r2 = new Rectangle(LEFT + 1, TOP, RIGHT, BOTTOM);
        assertFalse(r1.equals(r2));
    }

    @Test
    public void testEqualsNotSameRight() {
        Rectangle r1 = new Rectangle(LEFT, TOP, RIGHT, BOTTOM);
        Rectangle r2 = new Rectangle(LEFT, TOP, RIGHT + 1, BOTTOM);
        assertFalse(r1.equals(r2));
    }

    @Test
    public void testEqualsNotSameTop() {
        Rectangle r1 = new Rectangle(LEFT, TOP, RIGHT, BOTTOM);
        Rectangle r2 = new Rectangle(LEFT, TOP + 1, RIGHT, BOTTOM);
        assertFalse(r1.equals(r2));
    }

    @Test
    public void testEqualsNotSameBottom() {
        Rectangle r1 = new Rectangle(LEFT, TOP, RIGHT, BOTTOM);
        Rectangle r2 = new Rectangle(LEFT, TOP, RIGHT, BOTTOM + 1);
        assertFalse(r1.equals(r2));
    }

    /***/
    @Test
    public void testGetBottom() {
        Rectangle r = new Rectangle(LEFT, TOP, RIGHT, BOTTOM);
        assertTrue(equalFloat(r.getBottom(), BOTTOM));
    }

    /***/
    @Test
    public void testGetHeight() {
        Rectangle r = new Rectangle(LEFT, TOP, RIGHT, BOTTOM);
        assertTrue(equalFloat(r.getHeight(), BOTTOM - TOP));
        r = new Rectangle(RIGHT, BOTTOM, LEFT, TOP);
        assertTrue(equalFloat(r.getHeight(), BOTTOM - TOP));
    }

    /***/
    @Test
    public void testGetLeft() {
        Rectangle r = new Rectangle(LEFT, TOP, RIGHT, BOTTOM);
        assertTrue(equalFloat(r.getLeft(), LEFT));
    }

    /***/
    @Test
    public void testGetRight() {
        Rectangle r = new Rectangle(LEFT, TOP, RIGHT, BOTTOM);
        assertTrue(equalFloat(r.getRight(), RIGHT));
    }

    /***/
    @Test
    public void testGetTop() {
        Rectangle r = new Rectangle(LEFT, TOP, RIGHT, BOTTOM);
        assertTrue(equalFloat(r.getTop(), TOP));
    }

    /***/
    @Test
    public void testGetWidth() {
        Rectangle r = new Rectangle(LEFT, TOP, RIGHT, BOTTOM);
        assertTrue(equalFloat(r.getWidth(), RIGHT - LEFT));
        r = new Rectangle(RIGHT, TOP, LEFT, BOTTOM);
        assertTrue(equalFloat(r.getWidth(), RIGHT - LEFT));
    }

    /***/
    @Test
    public void testHashCode() {
        Rectangle r = new Rectangle(LEFT, TOP, RIGHT, BOTTOM);
        Rectangle r2 = new Rectangle(LEFT, TOP, RIGHT, BOTTOM);
        assertEquals(r.hashCode(), r2.hashCode());
    }

    /***/
    @Test
    public void testNormalize() {
        final int left = 4;
        final int right = 2;
        final int top = 41;
        final int bottom = 2;
        Rectangle r = new Rectangle(left, top, right, bottom);
        assertTrue(r.getLeft() > r.getRight());
        assertTrue(r.getTop() > r.getBottom());
        r.normalize();
        assertTrue(r.getLeft() < r.getRight());
        assertTrue(r.getTop() < r.getBottom());
        r = new Rectangle(0, 0, 5, 5);
        r.normalize();
        assertTrue(r.getLeft() < r.getRight());
        assertTrue(r.getTop() < r.getBottom());
    }

    /***/
    @Test
    public void testSetValues() {
        final int left = 4;
        final int right = 9;
        final int top = 1;
        final int bottom = 55;
        Rectangle r = new Rectangle(LEFT, TOP, RIGHT, BOTTOM);
        assertTrue(equalFloat(r.getLeft(), LEFT));
        assertTrue(equalFloat(r.getRight(), RIGHT));
        assertTrue(equalFloat(r.getTop(), TOP));
        assertTrue(equalFloat(r.getBottom(), BOTTOM));

        r.setValues(left, top, right, bottom);
        assertTrue(equalFloat(r.getLeft(), left));
        assertTrue(equalFloat(r.getRight(), right));
        assertTrue(equalFloat(r.getTop(), top));
        assertTrue(equalFloat(r.getBottom(), bottom));

    }

    /***/
    @Test
    public void testYzRectangle() {
        Rectangle r = new Rectangle();
        assertTrue(r.getLeft() == 0.0f);
        assertTrue(r.getRight() == 0.0f);
        assertTrue(r.getTop() == 0.0f);
        assertTrue(r.getBottom() == 0.0f);
    }

    /***/
    @Test
    public void testYzRectangleFloatFloatFloatFloat() {
        Rectangle r = new Rectangle(LEFT, TOP, RIGHT, BOTTOM);
        assertTrue(equalFloat(r.getLeft(), LEFT));
        assertTrue(equalFloat(r.getRight(), RIGHT));
        assertTrue(equalFloat(r.getTop(), TOP));
        assertTrue(equalFloat(r.getBottom(), BOTTOM));
    }

    @Test
    public void testToString() {
        Rectangle r = new Rectangle(LEFT, TOP, RIGHT, BOTTOM);
        assertEquals("be.yildiz.common.Rectangle(left=" + LEFT + ", top=" + TOP + ", right=" + RIGHT + ", bottom=" + BOTTOM + ")", r.toString());
    }
    
    private static boolean equalFloat(float d1, float d2) {
        return Float.compare(d1, d2) == 0;
    }
}
