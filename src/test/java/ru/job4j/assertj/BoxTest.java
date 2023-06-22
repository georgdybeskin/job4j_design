package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        boolean result = box.isExist();
        int number = box.getNumberOfVertices();
        double area = box.getArea();
        assertThat(name).isEqualTo("Sphere")
                .isNotEmpty();
        assertThat(result).isTrue();
        assertThat(number).isEqualTo(0)
                .isLessThan(8);
        assertThat(area).isGreaterThan(0)
                .isLessThan(1258);

    }

}