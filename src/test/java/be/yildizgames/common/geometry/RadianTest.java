/*
 * This file is part of the Yildiz-Engine project, licenced under the MIT License  (MIT)
 *
 * Copyright (c) 2018 Gregory Van den Borre
 *
 * More infos available: https://www.yildiz-games.be
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this
 * software and associated documentation files (the "Software"), to deal in the Software
 * without restriction, including without limitation the rights to use, copy, modify, merge,
 * publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons
 * to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS  OR COPYRIGHT  HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE  SOFTWARE.
 */

package be.yildizgames.common.geometry;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static be.yildizgames.common.geometry.Radian.PI2;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class RadianTest {

    @Nested
    class ValueOf {

        @Test
        void happyFlow() {
            Radian r = Radian.valueOf(1);
            assertEquals(r.angle, 1.0f);
        }

        @Test
        void lowLimit() {
            Radian r = Radian.valueOf(0.0f);
            assertEquals(r.angle, 0.0f);
        }

        @Test
        void highLimit() {
            Radian r = Radian.valueOf((float)PI2);
            assertEquals(r.angle, (float)PI2);
        }

    }

    @Nested
    class FromDegree {

        @Test
        void happyFlow() {
            Radian r = Radian.valueOf(Degree.HALF);
            assertEquals(r.angle, (float)Math.PI);
        }

        @Test
        void lowLimit() {
            Radian r = Radian.valueOf(Degree.ZERO);
            assertEquals(r.angle, 0.0f);
        }

        @Test
        void highLimit() {
            Radian r = Radian.valueOf(Degree.FULL);
            assertEquals(r.angle, (float)PI2);
        }

        @Test
        void tooLow() {
            assertEquals(Radian.valueOf(Degree.valueOf(359)), Radian.valueOf(Degree.valueOf(-1)));
        }

        @Test
        void tooHigh() {
            assertEquals(Radian.valueOf(Degree.valueOf(1)), Radian.valueOf(Degree.valueOf(361)));
        }
    }

    @Nested
    class HashCode {

        @Test
        void test() {
            Radian r = Radian.valueOf(Degree.HALF);
            assertEquals(1078530042, r.hashCode());
        }

    }

    @Nested
    class Equals {

        @Test
        void withNull() {
            assertNotEquals(null, Radian.valueOf(Degree.HALF));
        }

        @Test
        void differentType() {
            assertNotEquals("", Radian.valueOf(Degree.HALF));
        }

        @Test
        void sameObject() {
            Radian r = Radian.valueOf(Degree.HALF);
            assertEquals(r, r);
        }

        @Test
        void sameValue() {
            assertEquals(Radian.valueOf(Degree.HALF), Radian.valueOf(Degree.HALF));
        }

        @Test
        void differentValue() {
            assertNotEquals(Radian.valueOf(Degree.valueOf(181.0f)), Radian.valueOf(Degree.HALF));
        }

        @Test
        void differentObject() {
            assertNotEquals("180", Radian.valueOf(Degree.HALF));
        }

    }

    @Nested
    class ToString {

        @Test
        void test() {
            assertEquals("Radian value: 3.1415927", Radian.valueOf(Degree.HALF).toString());
        }
    }

}