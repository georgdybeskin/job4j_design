package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void checkParseIsEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("is empty");
    }
    @Test
    void checkContainSymbol() {
        NameLoad nameLoad = new NameLoad();
        String map = "name:five";
        assertThatThrownBy(() -> nameLoad.parse(map))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("name:five")
                .hasMessageContaining("symbol '='")
                .hasMessageContaining(map);
    }
    @Test
    void checkContainKey() {
        NameLoad nameLoad = new NameLoad();
        String map = "=name:five";
        assertThatThrownBy(() -> nameLoad.parse(map))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("=name:five")
                .hasMessageContaining("not contain a key")
                .hasMessageContaining(map);
    }
    @Test
    void checkContainValue() {
        NameLoad nameLoad = new NameLoad();
        String map = "name:five=";
        assertThatThrownBy(() -> nameLoad.parse(map))
                .hasMessageContaining("name:five=")
                .hasMessageContaining(map)
                .hasMessageContaining("not contain a value");
    }

}