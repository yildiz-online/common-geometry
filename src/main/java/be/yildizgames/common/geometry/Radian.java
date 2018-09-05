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
 * This class represent a radian angle.
 *
 * @author Grégory Van den Borre
 */
public class Radian {

    public static final double PI2 = Math.PI * 2d;

    /**
     * Value of the angle.
     */
    public final float angle;

    /**
     * Full constructor.
     *
     * @param radian initialize the radian value.
     */
    private Radian(final double radian) {
        super();
        this.angle = (float)radian;
    }

    public static Radian valueOf(final float radian) {
        assert radian >= -0.00001f && radian <= PI2 + 0.00001f;
        return new Radian(radian);
    }

    public static Radian fromDegree(final float degree) {
        assert degree >= 0.0f && degree <= 360.0f;
        return new Radian((degree * Math.PI) / 180.0f );
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Radian)) {
            return false;
        }
        Radian other = (Radian) obj;
        return Float.valueOf(this.angle).equals(other.angle);
    }

    @Override
    public final int hashCode() {
        final int prime = 31;
        int result = 1;
        int temp;
        temp = Float.floatToIntBits(this.angle);
        result = prime * result + temp;
        return result;
    }

    /**
     * @return The angle value.
     */
    @Override
    public final String toString() {
        return "Radian value: " + this.angle;
    }
}
