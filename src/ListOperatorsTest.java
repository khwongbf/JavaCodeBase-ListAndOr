import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListOperatorsTest {

    @BeforeEach
    void setUp() {
        var listOperator = new ListOperators();
    }

    @Test
    void and() {
        List<Integer> a = List.of(1,2,3);
        List<Integer> b = List.of(3,4);
        assertEquals(List.of(3),ListOperators.and(a,b));
    }

    @Test
    void or() {
        List<Integer> a = List.of(1,2,3);
        List<Integer> b = List.of(3,4);
        assertEquals(List.of(1,2,3,4),ListOperators.or(a,b));
    }
}