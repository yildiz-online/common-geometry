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
import static org.junit.jupiter.api.Assertions.assertNotSame;

/**
 * @author Gregory Van den Borre
 */
public final class Point3DTest {


    @Nested
    public class SquaredDistance {

        @Test
        public void happyFlow() {
            Point3D p = Point3D.valueOf(4, 6, 8);
            Point3D p2 = Point3D.valueOf(6, -1, 0.5f);
            float result = Point3D.squaredDistance(p, p2);
            assertEquals(109.25, result, 0.00001f);
        }
    }

    @Nested
    public class Add {

        @Test
        public void happyFlow() {
            Point3D p = Point3D.valueOf(1, 2, 3);
            Point3D result = p.add(1, 2, 3);
            assertNotSame(p, result);
            assertEquals(Point3D.valueOf(2, 4, 6), result);
        }
    }

    @Nested
    public class AddPoint {

        @Test
        public void happyFlow() {
            Point3D p = Point3D.valueOf(1, 2, 3);
            Point3D result = p.add(Point3D.valueOf(1, 2, 3));
            assertNotSame(p, result);
            assertEquals(Point3D.valueOf(2, 4, 6), result);
        }
    }

    @Nested
    public class AddX {

        @Test
        public void happyFlow() {
            Point3D p = Point3D.valueOf(1, 2, 3);
            Point3D p2 = p.addX(4);
            assertEquals(p.x + 4, p2.x, 0.001f);
            assertEquals(p.y, p2.y, 0.001f);
            assertEquals(p.z, p2.z, 0.001f);
        }
    }

    @Nested
    public class AddY {

        @Test
        public void happyFlow() {
            Point3D p = Point3D.valueOf(1, 2, 3);
            Point3D p2 = p.addY(4);
            assertEquals(p.x, p2.x, 0.001f);
            assertEquals(p.y + 4, p2.y, 0.001f);
            assertEquals(p.z, p2.z, 0.001f);
        }
    }

    @Nested
    public class AddZ {

        @Test
        public void happyFlow() {
            Point3D p = Point3D.valueOf(1, 2, 3);
            Point3D p2 = p.addZ(4);
            assertEquals(p.x, p2.x, 0.001f);
            assertEquals(p.y, p2.y, 0.001f);
            assertEquals(p.z + 4, p2.z, 0.001f);
        }
    }

    @Nested
    public class GetAngle {

        @Test
        public void happyFlowXy() {
            assertEquals(Math.atan2(2, 1), Point3D.valueOf(1, 2, 3).getAngle(Axis.XY), 0.001f);
        }

        @Test
        public void happyFlowXZ() {
            assertEquals(Math.atan2(3, 1), Point3D.valueOf(1, 2, 3).getAngle(Axis.XZ), 0.001f);
        }

        @Test
        public void happyFlowZY() {
            assertEquals(Math.atan2(2, 3), Point3D.valueOf(1, 2, 3).getAngle(Axis.ZY), 0.001f);
        }
    }

    @Nested
    public class GetInverse {

        @Test
        public void happyFlow() {
            assertEquals(Point3D.valueOf(-1, -2, -3), Point3D.valueOf(1, 2, 3).getInverse());
        }

        @Test
        public void zero() {
            assertEquals(Point3D.ZERO, Point3D.ZERO.getInverse());
        }
    }

    @Nested
    public class Multiply {

        @Test
        public void happyFlow() {
            assertEquals(Point3D.valueOf(2.5f, 5, 7.5f), Point3D.valueOf(1, 2, 3).multiply(2.5f));
        }

        @Test
        public void zero() {
            assertEquals(Point3D.ZERO, Point3D.valueOf(-1, 2, 3).multiply(0));
        }
    }

    @Nested
    public class Rounded {

        @Test
        public void half() {
            assertEquals(Point3D.valueOf(3, 6, 8), Point3D.valueOf(2.5f, 5.5f, 7.5f).rounded());
        }

        @Test
        public void floor() {
            assertEquals(Point3D.valueOf(2, 5, 7), Point3D.valueOf(2.1f, 5.1f, 7.1f).rounded());
        }

        @Test
        public void ceil() {
            assertEquals(Point3D.valueOf(3, 6, 8), Point3D.valueOf(2.9f, 5.9f, 7.9f).rounded());
        }

        @Test
        public void zero() {
            assertEquals(Point3D.ZERO, Point3D.valueOf(0.4f, 0.3f, 0.1f).rounded());
        }

    }

    @Nested
    public class Subtract {

        @Test
        public void happyFlow() {
            Point3D p = Point3D.valueOf(2, 4, 6);
            Point3D result = p.subtract(Point3D.valueOf(1, 2, 3));
            assertNotSame(p, result);
            assertEquals(Point3D.valueOf(1, 2, 3), result);
        }
    }

    @Nested
    public class To {

        @Test
        public void xy() {
            assertEquals(Point3D.valueOf(2, 4, 0), Point3D.valueOf(2, 4, 6).toXY());
        }

        @Test
        public void xz() {
            assertEquals(Point3D.valueOf(2, 0, 6), Point3D.valueOf(2, 4, 6).toXZ());
        }

        @Test
        public void yz() {
            assertEquals(Point3D.valueOf(0, 4, 6), Point3D.valueOf(2, 4, 6).toYZ());
        }
    }

    @Nested
    public class HashCode {

        @Test
        public void happyFlow() {
            assertEquals(Point3D.valueOf(2, 0, 6).hashCode(), Point3D.valueOf(2, 0, 6).hashCode());
        }

    }

    @Nested
    public class Equals {

        @Test
        public void base() {
            Point3D base = Point3D.valueOf(2, 0, 6);
            Point3D same = Point3D.valueOf(2, 0, 6);
            Point3D diff = Point3D.valueOf(2, 1, 6);
            new BaseTest<>(base, same, diff).all();
        }
    }

    @Nested
    public class ValueOf {

        @Test
        public void xyz() {
            Point3D p = Point3D.valueOf(4, 6, 8);
            assertEquals(4, p.x, 0.0001);
            assertEquals(6, p.y, 0.0001);
            assertEquals(8, p.z, 0.0001);
        }

        @Test
        public void xyzSame() {
            Point3D p = Point3D.valueOf(3);
            assertEquals(3, p.x, 0.0001);
            assertEquals(3, p.y, 0.0001);
            assertEquals(3, p.z, 0.0001);
        }

        @Test
        public void x() {
            Point3D p = Point3D.valueOfX(5);
            assertEquals(5, p.x, 0.0001);
            assertEquals(0, p.y, 0.0001);
            assertEquals(0, p.z, 0.0001);
        }

        @Test
        public void y() {
            Point3D p = Point3D.valueOfY(5);
            assertEquals(0, p.x, 0.0001);
            assertEquals(5, p.y, 0.0001);
            assertEquals(0, p.z, 0.0001);
        }

        @Test
        public void z() {
            Point3D p = Point3D.valueOfZ(5);
            assertEquals(0, p.x, 0.0001);
            assertEquals(0, p.y, 0.0001);
            assertEquals(5, p.z, 0.0001);
        }

        @Test
        public void xy() {
            Point3D p = Point3D.valueOfXY(7, 5);
            assertEquals(7, p.x, 0.0001);
            assertEquals(5, p.y, 0.0001);
            assertEquals(0, p.z, 0.0001);
        }

        @Test
        public void xz() {
            Point3D p = Point3D.valueOfXZ(7, 5);
            assertEquals(7, p.x, 0.0001);
            assertEquals(0, p.y, 0.0001);
            assertEquals(5, p.z, 0.0001);
        }

        @Test
        public void yz() {
            Point3D p = Point3D.valueOfYZ(7, 5);
            assertEquals(0, p.x, 0.0001);
            assertEquals(7, p.y, 0.0001);
            assertEquals(5, p.z, 0.0001);
        }

        @Test
        public void xySame() {
            Point3D p = Point3D.valueOfXY(5);
            assertEquals(5, p.x, 0.0001);
            assertEquals(5, p.y, 0.0001);
            assertEquals(0, p.z, 0.0001);
        }

        @Test
        public void xzSame() {
            Point3D p = Point3D.valueOfXZ(5);
            assertEquals(5, p.x, 0.0001);
            assertEquals(0, p.y, 0.0001);
            assertEquals(5, p.z, 0.0001);
        }

        @Test
        public void yzSame() {
            Point3D p = Point3D.valueOfYZ(5);
            assertEquals(0, p.x, 0.0001);
            assertEquals(5, p.y, 0.0001);
            assertEquals(5, p.z, 0.0001);
        }
    }

    @Nested
    public class AddPoints {

        @Test
        public void happyFlow() {
            Point3D p = Point3D.valueOf(4, 6, 8);
            Point3D p2 = Point3D.valueOf(6, -1, 0.5f);
            Point3D p3 = Point3D.valueOf(4, 6, 8);
            Point3D result = Point3D.addPoints(p, p2, p3);
            assertEquals(14, result.x, 0.0001);
            assertEquals(11, result.y, 0.0001);
            assertEquals(16.5, result.z, 0.0001);
        }
    }

    @Nested
    public class Normalize {

        @Test
        public void happyFlow() {
            Point3D p = Point3D.valueOf(4, 6, 8);
            Point3D result = Point3D.normalize(p);
            assertEquals(0.37139, result.x, 0.0001);
            assertEquals(0.55708, result.y, 0.0001);
            assertEquals(0.74278, result.z, 0.0001);
        }
    }

    @Nested
    public class NormalizeAnMultiply {

        @Test
        public void happyFlow() {
            Point3D p = Point3D.valueOf(4, 6, 8);
            Point3D result = Point3D.normalizeAndMultiply(p, 2);
            assertEquals(0.74278, result.x, 0.0001);
            assertEquals(1.11417, result.y, 0.0001);
            assertEquals(1.48556, result.z, 0.0001);
        }

        @Test
        public void withZero() {
            Point3D p = Point3D.ZERO;
            Point3D result = Point3D.normalizeAndMultiply(p, 2);
            assertEquals(p.x, result.x, 0.0001);
            assertEquals(p.y, result.y, 0.0001);
            assertEquals(p.z, result.z, 0.0001);
        }
    }

}
