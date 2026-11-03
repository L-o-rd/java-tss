package mutants;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public final class EquivalentTest {

    @Test
    void equivalencePartitioning() {
        var result = Equivalent.check(-100, -100, false);
        assertEquals("Scorul nu este valid", result);

        result = Equivalent.check(1000, 500, true);
        assertEquals("Scorul nu este valid", result);

        result = Equivalent.check(250, -250, false);
        assertEquals("Numărul de jocuri nu este valid", result);

        result = Equivalent.check(250, 250, true);
        assertEquals("Numărul de jocuri nu este valid", result);

        result = Equivalent.check(7, 2, true);
        assertEquals("Da", result);

        result = Equivalent.check(6, 2, false);
        assertEquals("Da", result);

        result = Equivalent.check(11, 1, true);
        assertEquals("Nu", result);

        result = Equivalent.check(7, 2, false);
        assertEquals("Nu", result);
    }

    @Test
    void boundaryValueAnalysis() {
        /* targetScore */
        var result = Equivalent.check(0, 10, false);
        assertEquals("Scorul nu este valid", result);

        result = Equivalent.check(1, 10, false);
        assertEquals("Nu", result);

        result = Equivalent.check(2, 10, true);
        assertEquals("Da", result);

        result = Equivalent.check(498, 100, false);
        assertEquals("Da", result);

        result = Equivalent.check(500, 10, false);
        assertEquals("Nu", result);

        result = Equivalent.check(501, 10, false);
        assertEquals("Scorul nu este valid", result);

        /* maxPlays */

        result = Equivalent.check(7, 0, false);
        assertEquals("Numărul de jocuri nu este valid", result);

        result = Equivalent.check(7, 1, false);
        assertEquals("Nu", result);

        result = Equivalent.check(6, 2, false);
        assertEquals("Da", result);

        result = Equivalent.check(7, 100, false);
        assertEquals("Nu", result);

        result = Equivalent.check(7, 101, false);
        assertEquals("Numărul de jocuri nu este valid", result);

        /* allow */

        result = Equivalent.check(2, 1, false);
        assertEquals("Nu", result);

        result = Equivalent.check(2, 1, true);
        assertEquals("Da", result);
    }

    @Test
    void causeEffectGraphing() {
        var result = Equivalent.check(-100, -100, false);
        assertEquals("Scorul nu este valid", result);

        result = Equivalent.check(50, -100, false);
        assertEquals("Numărul de jocuri nu este valid", result);

        result = Equivalent.check(6, 2, false);
        assertEquals("Da", result);

        result = Equivalent.check(1, 1, false);
        assertEquals("Nu", result);
    }

    @Test
    void linearCircuits() {
        var result = Equivalent.check(0, 10, false);
        assertEquals("Scorul nu este valid", result);

        result = Equivalent.check(77, 0, false);
        assertEquals("Numărul de jocuri nu este valid", result);

        result = Equivalent.check(1, 1, true);
        assertEquals("Nu", result);

        result = Equivalent.check(1, 1, false);
        assertEquals("Nu", result);

        result = Equivalent.check(498, 100, false);
        assertEquals("Da", result);

        result = Equivalent.check(199, 65, true);
        assertEquals("Da", result);

        result = Equivalent.check(201, 66, true);
        assertEquals("Da", result);

        result = Equivalent.check(203, 66, true);
        assertEquals("Da", result);

        result = Equivalent.check(223, 40, true);
        assertEquals("Nu", result);

        result = Equivalent.check(203, 68, true);
        assertEquals("Da", result);

        result = Equivalent.check(243, 39, false);
        assertEquals("Nu", result);
    }

    @Test
    void modifiedConditionDecisionCoverage() {
        /* T1 */
        var result = Equivalent.check(12, 3, true);
        assertEquals("Da", result);

        /* T2 */
        result = Equivalent.check(-10, 10, false);
        assertEquals("Scorul nu este valid", result);

        /* T3 */
        result = Equivalent.check(1345, 32, true);
        assertEquals("Scorul nu este valid", result);

        /* T6 */
        result = Equivalent.check(12, -23, false);
        assertEquals("Numărul de jocuri nu este valid", result);

        /* T7 */
        result = Equivalent.check(12, 254, true);
        assertEquals("Numărul de jocuri nu este valid", result);

        /* T13 */
        result = Equivalent.check(4, 3, false);
        assertEquals("Nu", result);
    }
}

