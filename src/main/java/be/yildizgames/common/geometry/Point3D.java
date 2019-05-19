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

/**
 * Simple class to hold 3d coordinates, immutable.
 *
 * @author Gregory Van den Borre
 */
public final class Point3D {


    private static final float EPSILON = 0.00001f;

    public static final Point3D X_NEGATIVE = valueOfX(-1);

    /**
     * Constant with Y = -1.
     */
    public static final Point3D Y_NEGATIVE = valueOfY(-1);

    /**
     * Constant with Z = -1.
     */
    public static final Point3D Z_NEGATIVE = valueOfZ(-1);

    public static final Point3D X_POSITIVE = valueOfX(1);

    /**
     * Constant with Y = 1.
     */
    public static final Point3D Y_POSITIVE = valueOfY(1);

    /**
     * Constant with Z = -1.
     */
    public static final Point3D Z_POSITIVE = valueOfZ(1);

    /**
     * Constant with all values as 0.
     */
    public static final Point3D ZERO = valueOf(0);

    /**
     * Initial direction for all built object, axis is -Z.
     */
    public static final Point3D BASE_DIRECTION = Z_NEGATIVE;


    /**
     * Value for the x axis.
     */
    public final float x;

    /**
     * Value for the y axis.
     */
    public final float y;

    /**
     * Value for the z axis.
     */
    public final float z;

    /**
     * Full constructor.
     *
     * @param xValue Value for the x axis.
     * @param yValue Value for the y axis.
     * @param zValue Value for the z axis.
     */
    private Point3D(final float xValue, final float yValue, final float zValue) {
        super();
        this.x = xValue;
        this.y = yValue;
        this.z = zValue;
    }

    public static Point3D valueOf(final float x, final float y, final float z) {
        return new Point3D(x, y, z);
    }

    public static Point3D valueOf(final float xyz) {
        return valueOf(xyz, xyz, xyz);
    }

    public static Point3D valueOfX(final float x) {
        return valueOf(x, 0, 0);
    }

    public static Point3D valueOfY(final float y) {
        return valueOf(0, y, 0);
    }

    public static Point3D valueOfZ(final float z) {
        return valueOf(0, 0, z);
    }

    public static Point3D valueOfXY(final float x, final float y) {
        return valueOf(x, y, 0);
    }

    public static Point3D valueOfXY(final float xy) {
        return valueOfXY(xy, xy);
    }

    public static Point3D valueOfXZ(final float x, final float z) {
        return valueOf(x, 0, z);
    }

    public static Point3D valueOfXZ(final float xz) {
        return valueOfXZ(xz, xz);
    }

    public static Point3D valueOfYZ(final float y, final float z) {
        return valueOf(0, y, z);
    }

    public static Point3D valueOfYZ(final float yz) {
        return valueOfYZ(yz, yz);
    }


    /**
     * Create a new point from the addition of other points.
     *
     * @param points Point3D to add to compute the result.
     * @return A Point3D resulting from the addition of the given points.
     */
    public static Point3D addPoints(final Point3D... points) {
        float x = 0;
        float y = 0;
        float z = 0;
        for (Point3D point : points) {
            x += point.x;
            y += point.y;
            z += point.z;
        }
        return valueOf(x, y, z);
    }

    /**
     * Normalize a point.
     *
     * @param p Point to normalize.
     * @return A new normalized point.
     */
    public static Point3D normalize(final Point3D p) {
        return Point3D.normalizeAndMultiply(p, 1);
    }

    /**
     * Normalize a point and multiply the values.
     *
     * @param p      Point to normalize.
     * @param scalar Value to multiply.
     * @return A new point normalized and multiplied.
     */
    public static Point3D normalizeAndMultiply(final Point3D p, final float scalar) {
        float length = (float) Math.sqrt(p.x * p.x + p.y * p.y + p.z * p.z);
        if (Math.abs(length) > 0.000001f){
            return valueOf(scalar * (p.x / length), scalar * (p.y / length), scalar * (p.z / length));
        }
        return p;
    }

    /**
     * Compute squared distance between 2 points.
     *
     * @param p1 First point.
     * @param p2 Second point.
     * @return The squared distance between the 2 points.
     */
    public static float squaredDistance(final Point3D p1, final Point3D p2) {
        final float valueX = p1.x - p2.x;
        final float valueY = p1.y - p2.y;
        final float valueZ = p1.z - p2.z;
        return valueX * valueX + valueY * valueY + valueZ * valueZ;
    }

    /**
     * Add values to the values of this point.
     *
     * @param x Value to add to this point X value.
     * @param y Value to add to this point Y value.
     * @param z Value to add to this point Z value.
     * @return A new point with added values.
     */
    public Point3D add(final float x, final float y, final float z) {
        return valueOf(this.x + x, this.y + y, this.z + z);
    }

    /**
     * Add a point to this one.
     *
     * @param point Point to add.
     * @return A new point with added values.
     */
    public Point3D add(final Point3D point) {
        return valueOf(this.x + point.x, this.y + point.y, this.z + point.z);
    }

    /**
     * Add a value to the X value of this point.
     *
     * @param value Value to add to this point X value.
     * @return A new point with added value.
     */
    public Point3D addX(final float value) {
        return valueOf(this.x + value, this.y, this.z);
    }

    /**
     * Add a value to the Y value of this point.
     *
     * @param value value to add to this point Y value.
     * @return A new point with added value.
     */
    public Point3D addY(final float value) {
        return valueOf(this.x, this.y + value, this.z);
    }

    /**
     * Add a value to the Z value of this point.
     *
     * @param value value to add to this point Z value.
     * @return A new point with added value.
     */
    public Point3D addZ(final float value) {
        return valueOf(this.x, this.y, this.z + value);
    }

    /**
     * Get this point angle.
     *
     * @param axis Axis to use.
     * @return The point angle.
     */
    public float getAngle(final Axis axis) {
        switch (axis) {
            case XY:
                return (float) Math.atan2(this.y, this.x);
            case XZ:
                return (float) Math.atan2(this.z, this.x);
            case ZY:
                return (float) Math.atan2(this.y, this.z);
            default:
                throw new IllegalArgumentException(axis + " is unknown.");
        }
    }

    /**
     * @return This point with all values inverted(5,10,-8 will be -5,-10,8).
     */
    public Point3D getInverse() {
        return valueOf(-this.x, -this.y, -this.z);
    }

    /**
     * Multiply this point values by a given value.
     *
     * @param scalar Value to multiply.
     * @return A new point with the multiplied values.
     */
    public Point3D multiply(final float scalar) {
        return valueOf(this.x * scalar, this.y * scalar, this.z * scalar);
    }

    /**
     * @return This point with rounded values.
     */
    public Point3D rounded() {
        return valueOf(Math.round(this.x), Math.round(this.y), Math.round(this.z));
    }

    /**
     * Subtract this point values by the other point values.
     *
     * @param point Other point to use.
     * @return A new Point3D with the computed values.
     */
    public Point3D subtract(final Point3D point) {
        return valueOf(this.x - point.x, this.y - point.y, this.z - point.z);
    }

    /**
     * @return A copy of this point with 0 as Y coordinate.
     */
    public Point3D toXZ() {
        return valueOf(this.x, 0, this.z);
    }

    public Point3D toXY() { return valueOf(this.x, this.y, 0);}

    public Point3D toYZ() {
        return valueOf(0, this.y, this.z);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Float.floatToIntBits(this.x);
        result = prime * result + Float.floatToIntBits(this.y);
        result = prime * result + Float.floatToIntBits(this.z);
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Point3D)) {
            return false;
        }
        Point3D other = (Point3D) obj;
        boolean zeroX = this.x < EPSILON && this.x > -EPSILON && other.x < EPSILON && other.x > -EPSILON;
        boolean zeroY = this.y < EPSILON && this.y > -EPSILON && other.y < EPSILON && other.y > -EPSILON;
        boolean zeroZ = this.z < EPSILON && this.z > -EPSILON && other.z < EPSILON && other.z > -EPSILON;
        return
                (zeroX || Float.floatToIntBits(this.x) == Float.floatToIntBits(other.x)) &&
                (zeroY || Float.floatToIntBits(this.y) == Float.floatToIntBits(other.y)) &&
                (zeroZ || Float.floatToIntBits(this.z) == Float.floatToIntBits(other.z));
    }

    @Override
    public String toString() {
        return this.x + "," + this.y + "," + this.z;
    }
}

