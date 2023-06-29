package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("first", "first", "first", "four", "five");
        assertThat(list).hasSize(5)
                .contains("four")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "five", "six")
                .doesNotContain("first", Index.atIndex(3));
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("first", "first", "first", "four", "five");
        assertThat(set).hasSize(3)
                .contains("five")
                .contains("first")
                .containsAnyOf("zero", "first", "six")
                .doesNotContain("six")
                .filteredOn(e -> e.contains("o"))
                .first()
                .isEqualTo("four");
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("first", "second", "three", "four", "five");
        assertThat(map).hasSize(5)
                .containsValue(0)
                .containsKey("first")
                .doesNotContainValue(5)
                .doesNotContainKey("six");
    }
}