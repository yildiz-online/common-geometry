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
 * This class represent a quaternion.
 *
 * @author Grégory Van den Borre
 */
public final class Quaternion {

    /**
     * W value.
     */
    public final float w;
    /**
     * X value.
     */
    public final float x;
    /**
     * Y value.
     */
    public final float y;
    /**
     * Z value.
     */
    public final float z;

    /**
     * Full constructor.
     *
     * @param wValue initialize W attribute.
     * @param xValue initialize X attribute.
     * @param yValue initialize Y attribute.
     * @param zValue initialize Z attribute.
     */
    public Quaternion(final float wValue, final float xValue, final float yValue, final float zValue) {
        super();
        this.w = wValue;
        this.x = xValue;
        this.y = yValue;
        this.z = zValue;
    }

    /**
     * Build a new Quaternion resulting from the multiplication of 2 other
     * quaternions.
     *
     * @param q1 1st quaternion to use.
     * @param q2 2nd quaternion to use.
     * @return the newly build Quaternion.
     */
    public static Quaternion multiply2Quaternions(final Quaternion q1, final Quaternion q2) {
        return new Quaternion(q1.w * q2.w - q1.x * q2.x - q1.y * q2.y - q1.z * q2.z, q1.w * q2.x + q1.x * q2.w + q1.y * q2.z - q1.z * q2.y,
                q1.w * q2.y + q1.y * q2.w + q1.z * q2.x - q1.x * q2.z, q1.w * q2.z + q1.z * q2.w + q1.x * q2.y - q1.y * q2.x);
    }
}
