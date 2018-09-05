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

/**
 * Class representing a 2d coordinate.
 *
 * @author Grégory Van den Borre
 */
public final class Point2D {
    /**
     * 0,0 coordinate point.
     */
    public static final Point2D ZERO = new Point2D(0, 0);

    /**
     * X coordinate.
     */
    public final float x;

    /**
     * Y coordinate.
     */
    public final float y;

    /**
     * Full constructor, convert double into float.
     *
     * @param xValue Initialize The point x value.
     * @param yValue Initialize The point y value.
     */
    private Point2D(final float xValue, final float yValue) {
        super();
        this.x = xValue;
        this.y = yValue;
    }

    public static Point2D valueOf(float x, float y) {
        return new Point2D(x, y);
    }

    /**
     * Add this point values by the parameter x,y values.
     *
     * @param xValue Values to add to this point X value.
     * @param yValue Values to add to this point Y value.
     * @return The newly created point.
     */
    public Point2D add(final float xValue, final float yValue) {
        return new Point2D(this.x + xValue, this.y + yValue);
    }

    /**
     * Add this point values by the parameter point values.
     *
     * @param point Values to use.
     * @return The newly created point.
     */
    public Point2D add(final Point2D point) {
        return this.add(point.x, point.y);
    }

    /**
     * @param obj Other object to test for equality.
     * @return <code>true</code> only if the other object is a not
     * <code>null</code> Point2D with the same coordinates.
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Point2D)) {
            return false;
        }
        Point2D other = (Point2D) obj;
        return this.x == other.x && this.y == other.y;
    }

    /**
     * @return A hash code computed from the x and y values.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int)this.x;
        result = prime * result + (int)this.y;
        return result;
    }

    /**
     * Multiply the point x and y by the scalar value.
     *
     * @param scalar Value to multiply.
     * @return The newly created point.
     */
    public Point2D multiplyByScalar(final float scalar) {
        return new Point2D(this.x * scalar, this.y * scalar);
    }

    /**
     * Subtract this point values by the parameter x,y values.
     *
     * @param xValue Values to remove from this point X value.
     * @param yValue Values to remove from this point Y value.
     * @return The newly created point.
     */
    public Point2D subtract(final float xValue, final float yValue) {
        return new Point2D(this.x - xValue, this.y - yValue);
    }

    /**
     * Subtract this point values by the parameter point values.
     *
     * @param point Values to use.
     * @return The newly created point.
     */
    public Point2D subtract(final Point2D point) {
        return this.subtract(point.x, point.y);
    }

    /**
     * @return X and Y values.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.x);
        sb.append(',');
        sb.append(this.y);
        return sb.toString();
    }
}
