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
    private int x;

    /**
     * Y coordinate.
     */
    private int y;

    /**
     * Simple constructor.
     */
    public Point2D() {
        super();
    }

    /**
     * Full constructor.
     *
     * @param xValue Initialize The point x value.
     * @param yValue Initialize The point y value.
     */
    public Point2D(final int xValue, final int yValue) {
        this();
        this.x = xValue;
        this.y = yValue;
    }

    /**
     * Full constructor, convert double into int.
     *
     * @param xValue Initialize The point x value.
     * @param yValue Initialize The point y value.
     */
    public Point2D(final double xValue, final double yValue) {
        this();
        this.x = (int) xValue;
        this.y = (int) yValue;
    }

    /**
     * Add this point values by the parameter x,y values.
     *
     * @param xValue Values to add to this point X value.
     * @param yValue Values to add to this point Y value.
     */
    public void add(final int xValue, final int yValue) {
        this.setX(this.x + xValue);
        this.setY(this.y + yValue);
    }

    /**
     * Add this point values by the parameter point values.
     *
     * @param point Values to use.
     */
    public void add(final Point2D point) {
        this.add(point.x, point.y);
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
     * Compute the angle formed by this point.
     *
     * @return The computed angle.
     */
    public float getAngle() {
        return (float) Math.atan2(this.y, this.x);
    }

    /**
     * @return The x value.
     */
    public int getX() {
        return this.x;
    }

    /**
     * Update the Point x value.
     *
     * @param xValue New value for the point x value.
     */
    public void setX(final int xValue) {
        this.x = xValue;
    }

    /**
     * @return The y value.
     */
    public int getY() {
        return this.y;
    }

    /**
     * Update the Point y value.
     *
     * @param yValue New value for the point y value.
     */
    public void setY(final int yValue) {
        this.y = yValue;
    }

    /**
     * @return A hash code computed from the x and y values.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.x;
        result = prime * result + this.y;
        return result;
    }

    /**
     * Multiply the point x and y by the scalar value.
     *
     * @param scalar Value to multiply.
     */
    public void multiplyByScalar(final int scalar) {
        this.setX(this.x * scalar);
        this.setY(this.y * scalar);
    }

    /**
     * Set new values.
     *
     * @param xValue x new value to set.
     * @param yValue y new value to set.
     */
    public void setValues(final int xValue, final int yValue) {
        this.setX(xValue);
        this.setY(yValue);
    }

    /**
     * Set the values from an other YzPoint.
     *
     * @param value Point to copy.
     */
    public void setValues(final Point2D value) {
        this.setValues(value.x, value.y);
    }

    /**
     * Subtract this point values by the parameter x,y values.
     *
     * @param xValue Values to remove from this point X value.
     * @param yValue Values to remove from this point Y value.
     */
    public void substract(final int xValue, final int yValue) {
        this.setX(this.x - xValue);
        this.setY(this.y - yValue);
    }

    /**
     * Subtract this point values by the parameter point values.
     *
     * @param point Values to use.
     */
    public void substract(final Point2D point) {
        this.substract(point.x, point.y);
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
