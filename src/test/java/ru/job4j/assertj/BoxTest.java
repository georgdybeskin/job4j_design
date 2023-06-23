package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere")
                .isNotEmpty()
                .isNotBlank()
                .isNotNull();

    }
    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Tetrahedron")
                .isNotEmpty()
                .isNotBlank()
                .isNotNull();
    }
    @Test
    void whenNumberOfVerticesIsZero() {
        Box box = new Box(0, 10);
        int numberOfVertices = box.getNumberOfVertices();
        assertThat(numberOfVertices).isEqualTo(0)
                .isLessThan(8)
                .isNotNull();
    }
    @Test
    void whenNumberOfVerticesIsFour() {
        Box box = new Box(4, 10);
        int numberOfVertices = box.getNumberOfVertices();
        assertThat(numberOfVertices).isEqualTo(4)
                .isLessThan(8)
                .isPositive()
                .isNotNull();
    }
    @Test
    void whenNumberOfVerticesIsExist() {
        Box box = new Box(4, 10);
        boolean isExist = box.isExist();
        assertThat(isExist).isTrue()
                .isNotNull();
    }
    @Test
    void whenNumberOfVerticesIsNotExist() {
        Box box = new Box(-1, 10);
        boolean isExist = box.isExist();
        assertThat(isExist).isFalse()
                .isNotNull();
    }
    @Test
    void whenAreaOfTetrahedronIsZero() {
        Box box = new Box(0, 1);
        double area = box.getArea();
        assertThat(area).isGreaterThan(6)
                .isEqualTo(4 * Math.PI)
                .isPositive()
                .isNotNull();
    }
    @Test
    void whenAreaOfTetrahedronIsFour() {
        Box box = new Box(4, 1);
        double area = box.getArea();
        assertThat(area).isGreaterThan(1)
                .isEqualTo(Math.sqrt(3))
                .isPositive()
                .isNotNull();
    }

}