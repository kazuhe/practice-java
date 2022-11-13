package projava;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcTest {

    @Test
    @DisplayName("正しく加算できていること")
    void add() {
        assertEquals(4, new Calc().add(2, 2), "2  + 2 = 4");
        assertEquals(6, new Calc().add(2, 4), "2  + 4 = 6");

        assertAll(() -> assertEquals(4, new Calc().add(2, 2), "2  + 2 = 4"),
                () -> assertEquals(6, new Calc().add(2, 4), "2  + 4 = 6")
        );
    }
}