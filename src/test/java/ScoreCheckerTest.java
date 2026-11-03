import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public final class ScoreCheckerTest {

    @Test
    void equivalencePartitioning() {
        var result = ScoreChecker.check(-100, -100, false);
        assertEquals("Scorul nu este valid", result);

        result = ScoreChecker.check(1000, 500, true);
        assertEquals("Scorul nu este valid", result);

        result = ScoreChecker.check(250, -250, false);
        assertEquals("Numărul de jocuri nu este valid", result);

        result = ScoreChecker.check(250, 250, true);
        assertEquals("Numărul de jocuri nu este valid", result);

        result = ScoreChecker.check(7, 2, true);
        assertEquals("Da", result);

        result = ScoreChecker.check(6, 2, false);
        assertEquals("Da", result);

        result = ScoreChecker.check(11, 1, true);
        assertEquals("Nu", result);

        result = ScoreChecker.check(7, 2, false);
        assertEquals("Nu", result);
    }

    @Test
    void boundaryValueAnalysis() {
        /* targetScore */
        var result = ScoreChecker.check(0, 10, false);
        assertEquals("Scorul nu este valid", result);

        result = ScoreChecker.check(1, 10, false);
        assertEquals("Nu", result);

        result = ScoreChecker.check(2, 10, true);
        assertEquals("Da", result);

        result = ScoreChecker.check(498, 100, false);
        assertEquals("Da", result);

        result = ScoreChecker.check(500, 10, false);
        assertEquals("Nu", result);

        result = ScoreChecker.check(501, 10, false);
        assertEquals("Scorul nu este valid", result);

        /* maxPlays */

        result = ScoreChecker.check(7, 0, false);
        assertEquals("Numărul de jocuri nu este valid", result);

        result = ScoreChecker.check(7, 1, false);
        assertEquals("Nu", result);

        result = ScoreChecker.check(6, 2, false);
        assertEquals("Da", result);

        result = ScoreChecker.check(7, 100, false);
        assertEquals("Nu", result);

        result = ScoreChecker.check(7, 101, false);
        assertEquals("Numărul de jocuri nu este valid", result);

        /* allow */

        result = ScoreChecker.check(2, 1, false);
        assertEquals("Nu", result);

        result = ScoreChecker.check(2, 1, true);
        assertEquals("Da", result);
    }

    @Test
    void causeEffectGraphing() {
        var result = ScoreChecker.check(-100, -100, false);
        assertEquals("Scorul nu este valid", result);

        result = ScoreChecker.check(50, -100, false);
        assertEquals("Numărul de jocuri nu este valid", result);

        result = ScoreChecker.check(6, 2, false);
        assertEquals("Da", result);

        result = ScoreChecker.check(1, 1, false);
        assertEquals("Nu", result);
    }

    @Test
    void linearCircuits() {
        var result = ScoreChecker.check(0, 10, false);
        assertEquals("Scorul nu este valid", result);

        result = ScoreChecker.check(77, 0, false);
        assertEquals("Numărul de jocuri nu este valid", result);

        result = ScoreChecker.check(1, 1, true);
        assertEquals("Nu", result);

        result = ScoreChecker.check(1, 1, false);
        assertEquals("Nu", result);

        result = ScoreChecker.check(498, 100, false);
        assertEquals("Da", result);

        result = ScoreChecker.check(199, 65, true);
        assertEquals("Da", result);

        result = ScoreChecker.check(201, 66, true);
        assertEquals("Da", result);

        result = ScoreChecker.check(203, 66, true);
        assertEquals("Da", result);

        result = ScoreChecker.check(223, 40, true);
        assertEquals("Nu", result);

        result = ScoreChecker.check(203, 68, true);
        assertEquals("Da", result);

        result = ScoreChecker.check(243, 39, false);
        assertEquals("Nu", result);
    }

    @Test
    void modifiedConditionDecisionCoverage() {
        /* T1 */
        var result = ScoreChecker.check(12, 3, true);
        assertEquals("Da", result);

        /* T2 */
        result = ScoreChecker.check(-10, 10, false);
        assertEquals("Scorul nu este valid", result);

        /* T3 */
        result = ScoreChecker.check(1345, 32, true);
        assertEquals("Scorul nu este valid", result);

        /* T6 */
        result = ScoreChecker.check(12, -23, false);
        assertEquals("Numărul de jocuri nu este valid", result);

        /* T7 */
        result = ScoreChecker.check(12, 254, true);
        assertEquals("Numărul de jocuri nu este valid", result);

        /* T13 */
        result = ScoreChecker.check(4, 3, false);
        assertEquals("Nu", result);
    }
}
