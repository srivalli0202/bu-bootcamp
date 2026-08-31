import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;


public class GradeAnalyzerTest {
    
    @Test
    public void testCalculateAverageWithValidScores() {
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(90, 80, 70));
        double result = GradeAnalyzer.calculateAverage(scores);
        assertEquals(80.0, result, 0.01);
    }
    
    @Test
    public void testCalculateAverageWithSingleScore() {
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(85));
        double result = GradeAnalyzer.calculateAverage(scores);
        assertEquals(85.0, result, 0.01);
    }
    
    @Test
    public void testCalculateAverageWithEmptyList() {
        ArrayList<Integer> scores = new ArrayList<>();
        double result = GradeAnalyzer.calculateAverage(scores);
        assertEquals(0.0, result, 0.01);
    }
    
    @Test
    public void testCalculateAverageWithNull() {
        double result = GradeAnalyzer.calculateAverage(null);
        assertEquals(0.0, result, 0.01);
    }
    
    @Test
    public void testCalculateAverageWithPerfectScores() {
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(100, 100, 100));
        double result = GradeAnalyzer.calculateAverage(scores);
        assertEquals(100.0, result, 0.01);
    }
    
    @Test
    public void testCalculateAverageWithZeroScores() {
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(0, 0, 0));
        double result = GradeAnalyzer.calculateAverage(scores);
        assertEquals(0.0, result, 0.01);
    }
    
    @Test
    public void testCalculateAverageWithMixedScores() {
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(100, 0, 50));
        double result = GradeAnalyzer.calculateAverage(scores);
        assertEquals(50.0, result, 0.01);
    }
}
