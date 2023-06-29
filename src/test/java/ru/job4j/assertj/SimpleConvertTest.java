package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.MAP;

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
    void checkMap() {
        Map<String, Integer> map = Map.of(
                "1", 1, "2", 2, "3", 3, "4", 4, "5", 5);
                assertThat(map).hasSize(5)
                        .containsKeys("1", "3", "5")
                        .containsValues(2, 1, 4)
                        .doesNotContainKeys("0")
                        .doesNotContainValue(0)
                        .containsEntry("5", 5);
    }
    @Test
    void checkList() {
        SimpleCollection<String> simpleCollection = new SimpleCollection<>(
                "first", "second", "three", "four", "five");
        assertThat(simpleCollection).first().isEqualTo("first");
        assertThat(simpleCollection).element(0).isNotNull()
                .isEqualTo("first");
        assertThat(simpleCollection).last().isNotNull()
                .isEqualTo("five");
    }
    @Test
    void checkSet() {
        SimpleCollection<String> simpleCollection = new SimpleCollection<>(
                "first", "second", "three", "four", "five");
        assertThat(simpleCollection).isNotNull();
        assertThat(simpleCollection).filteredOnAssertions(e -> assertThat(e).isLessThan("three"));
    }
}