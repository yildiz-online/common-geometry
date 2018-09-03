/*
 * This file is part of the Yildiz-Engine project, licenced under the MIT License  (MIT)
 *
 * Copyright (c) 2018 Grégory Van den Borre
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
import static org.junit.jupiter.api.Assertions.*;

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

        @Test
        void tooLow() {
            assertThrows(AssertionError.class, () -> Radian.valueOf(-1));
        }

        @Test
        void tooHigh() {
            assertThrows(AssertionError.class, () -> Radian.valueOf(6.5f));
        }

    }

    @Nested
    class FromDegree {

        @Test
        void happyFlow() {
            Radian r = Radian.fromDegree(180.0f);
            assertEquals(r.angle, (float)Math.PI);
        }

        @Test
        void lowLimit() {
            Radian r = Radian.fromDegree(0.0f);
            assertEquals(r.angle, 0.0f);
        }

        @Test
        void highLimit() {
            Radian r = Radian.fromDegree(360.0f);
            assertEquals(r.angle, (float)PI2);
        }

        @Test
        void tooLow() {
            assertThrows(AssertionError.class, () -> Radian.fromDegree(-1));
        }

        @Test
        void tooHigh() {
            assertThrows(AssertionError.class, () -> Radian.fromDegree(361f));
        }
    }

    @Nested
    class HashCode {

    }

    @Nested
    class Equals {

    }

    @Nested
    class ToString {

    }

}