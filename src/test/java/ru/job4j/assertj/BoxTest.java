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
    void isThisCube() {
        Box box = new Box(8, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Cube")
                .isNotEmpty()
                .isNotBlank()
                .isNotNull();
    }

    @Test
    void whenNumberOfVerticesFour() {
        Box box = new Box(4, 10);
        int numberOfVertices = box.getNumberOfVertices();
        assertThat(numberOfVertices).isEqualTo(4)
                .isPositive()
                .isNotZero()
                .isBetween(0, 5)
                .isNotNull();
    }

    @Test
    void whenNumberOfVerticesEight() {
        Box box = new Box(8, 10);
        int numberOfVertices = box.getNumberOfVertices();
        assertThat(numberOfVertices).isEqualTo(8)
                .isPositive()
                .isNotZero()
                .isBetween(0, 10)
                .isNotNull();
    }

    @Test
    void whenNumberOfVerticesIsExist() {
        Box box = new Box(8, 10);
        boolean exist = box.isExist();
        assertThat(exist).isTrue()
                .isNotNull();
    }

    @Test
    void whenNumberOfVerticesIsNotExist() {
        Box box = new Box(-1, 10);
        boolean exist = box.isExist();
        assertThat(exist).isFalse()
                .isNotNull();
    }

    @Test
    void whenAreaOfCubeIsSix() {
        Box box = new Box(8, 1);
        double area = box.getArea();
        assertThat(area).isEqualTo(6)
                .isNotNull()
                .isPositive()
                .isGreaterThan(5)
                .isNotNaN();
    }

    @Test
    void whenAreaOfCubeIsFourPi() {
        Box box = new Box(0, 1);
        double area = box.getArea();
        assertThat(area).isEqualTo(4 * Math.PI)
                .isNotNull()
                .isPositive()
                .isGreaterThan(5)
                .isNotNaN();
    }
}