package mutants;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class SurvivedTest {

    @Test
    void equivalencePartitioning() {
        var result = Survived.check(-100, -100, false);
        assertEquals("Scorul nu este valid", result);

        result = Survived.check(1000, 500, true);
        assertEquals("Scorul nu este valid", result);

        result = Survived.check(250, -250, false);
        assertEquals("Numărul de jocuri nu este valid", result);

        result = Survived.check(250, 250, true);
        assertEquals("Numărul de jocuri nu este valid", result);

        result = Survived.check(7, 2, true);
        assertEquals("Da", result);

        result = Survived.check(6, 2, false);
        assertEquals("Da", result);

        result = Survived.check(11, 1, true);
        assertEquals("Nu", result);

        result = Survived.check(7, 2, false);
        assertEquals("Nu", result);
    }
}
