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
 * @author Grégory Van den Borre
 */
public class Degree {


    public static final Degree ZERO = new Degree(0.0f);

    public static final Degree HALF = new Degree(180.0f);

    public static final Degree FULL = new Degree(360.0f);

    public final float angle;

    private Degree(final float value) {
        super();
        this.angle = value;
    }

    public static Degree valueOf(final float value) {
        return new Degree(value);
    }

    private static float computeUniformValue(float v) {
        if(v < 0) {
            return computeUniformValue(v + 360);
        } else if (v > 360) {
            return computeUniformValue(v - 360);
        }
        return v;
    }

    public final float getUniformValue() {
        return computeUniformValue(this.angle);
    }
}
