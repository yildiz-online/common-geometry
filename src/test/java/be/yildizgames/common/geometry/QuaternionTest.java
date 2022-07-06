package be.yildizgames.common.geometry;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Grégory Van den Borre
 */
class QuaternionTest {


    @Test
    void constructor() {
        Quaternion q = Quaternion.valueOf(1, 2, 3, 4);
        Assertions.assertEquals(1, q.w);
        Assertions.assertEquals(2, q.x);
        Assertions.assertEquals(3, q.y);
        Assertions.assertEquals(4, q.z);
    }

    @Test
    void multiply() {
        Quaternion q = Quaternion.valueOf(1, 2, 3, 4);
        Quaternion q2 = Quaternion.valueOf(5, 6, 7, 8);
        Quaternion result = q.multiply(q2);
        Assertions.assertEquals(1, q.w);
        Assertions.assertEquals(2, q.x);
        Assertions.assertEquals(3, q.y);
        Assertions.assertEquals(4, q.z);
        Assertions.assertEquals(-60, result.w);
        Assertions.assertEquals(12, result.x);
        Assertions.assertEquals(30, result.y);
        Assertions.assertEquals(24, result.z);
    }
}
