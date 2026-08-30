import java.io.*;
import java.util.*;

public class GradeAnalyzer {

    private static int invalidLines = 0;

    public static void main(String[] args) {
        String inputFile = "scores.txt";
        String outputFile = "report.txt";

        // Quick test for calculateAverage with a hardcoded list
        ArrayList<Integer> testScores = new ArrayList<>(Arrays.asList(90, 80, 70));
        System.out.println(String.format("Test average (expected 80.00): %.2f", calculateAverage(testScores)));

        // Step 1: read scores from file
        ArrayList<Integer> scores = readScores(inputFile);

        // Step 2: calculate statistics
        double avg = calculateAverage(scores);

        // Find highest and lowest manually and count grade bands
        int high = Integer.MIN_VALUE;
        int low = Integer.MAX_VALUE;
        int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;
        for (int s : scores) {
            if (s > high) high = s;
            if (s < low) low = s;

            if (s >= 90) countA++;
            else if (s >= 80) countB++;
            else if (s >= 70) countC++;
            else if (s >= 60) countD++;
            else countF++;
        }
        if (scores.isEmpty()) {
            high = 0;
            low = 0;
        }

        // Step 3: write and print report
        writeReport(scores, avg, high, low, outputFile, countA, countB, countC, countD, countF);
    }

    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        ArrayList<Integer> scores = new ArrayList<>();
        File f = new File(filename);
        if (!f.exists()) {
            System.err.println("Input file not found: " + filename);
            return scores;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            int lineNum = 0;
            while ((line = br.readLine()) != null) {
                lineNum++;
                String trimmed = line.trim();
                if (trimmed.isEmpty()) continue;
                try {
                    int val = Integer.parseInt(trimmed);
                    if (val >= 0 && val <= 100) {
                        scores.add(val);
                    } else {
                        System.err.println("Warning: score out of range at line " + lineNum + ": " + trimmed);
                        invalidLines++;
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Warning: invalid integer at line " + lineNum + ": " + trimmed);
                    invalidLines++;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return scores;
    }

    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        if (scores == null || scores.isEmpty()) return 0.0;
        double sum = 0.0;
        for (int s : scores) sum += s;
        return sum / scores.size();
    }

    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low,
                                   String outputFile,
                                   int countA, int countB, int countC, int countD, int countF) {
        List<String> lines = new ArrayList<>();
        lines.add("=== Grade Analysis Report ===");
        lines.add(String.format("Total scores processed: %3d", scores.size()));
        lines.add(String.format("Invalid lines skipped:   %3d", invalidLines));
        lines.add("");
        lines.add(String.format("Average score:   %6.2f", avg));
        lines.add(String.format("Highest score:   %3d", high));
        lines.add(String.format("Lowest score:     %3d", low));
        lines.add("");
        lines.add("Grade distribution:");
        lines.add(String.format("  A (90-100):   %3d", countA));
        lines.add(String.format("  B (80-89):    %3d", countB));
        lines.add(String.format("  C (70-79):    %3d", countC));
        lines.add(String.format("  D (60-69):    %3d", countD));
        lines.add(String.format("  F (below 60): %3d", countF));
        lines.add("");
        lines.add("Scores:");
        for (int s : scores) lines.add(String.format("  %d", s));

        // Print to console
        for (String l : lines) System.out.println(l);

        // Write to file using BufferedWriter
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            for (String l : lines) {
                bw.write(l);
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Unable to write report: " + e.getMessage());
        }
    }
}
