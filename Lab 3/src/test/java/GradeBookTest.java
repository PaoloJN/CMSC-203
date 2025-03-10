import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

public class GradeBookTest {
    private GradeBook g1;
    private GradeBook g2;

    @Before
    public void setUp() {
        g1 = new GradeBook(5);  // Initialize GradeBook with capacity of 5
        g2 = new GradeBook(5);

        // Add scores to g1
        g1.addScore(50);
        g1.addScore(75);

        // Add scores to g2
        g2.addScore(30);
        g2.addScore(60);
        g2.addScore(90);
    }

    @Test
    public void addScore() {
        assertEquals("50.0 75.0 ", g1.toString(), "addScore method failed");
        assertEquals(2, g1.getScoreSize(), "Score size incorrect");
    }

    @Test
    public void sum() {
        assertEquals(125, g1.sum(), 0.0001, "Sum method incorrect");
        assertEquals(180, g2.sum(), 0.0001, "Sum method incorrect");
    }

    @Test
    public void minimum() {
        assertEquals(50, g1.minimum(), 0.001, "Minimum method incorrect");
        assertEquals(30, g2.minimum(), 0.001, "Minimum method incorrect");
    }

    @Test
    public void finalScore() {
        assertEquals(75, g1.finalScore(), 0.0001, "FinalScore method incorrect");
        assertEquals(150, g2.finalScore(), 0.0001, "FinalScore method incorrect");
    }
}
