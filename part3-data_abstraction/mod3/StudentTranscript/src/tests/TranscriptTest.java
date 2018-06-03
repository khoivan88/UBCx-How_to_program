package tests;

import model.Transcript;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TranscriptTest {

    private Transcript testTranscript;

    @Before
    public void setUp(){
        testTranscript = new Transcript("Student Name", 1000);
        testTranscript.addGrade("CPSC-210", 3.5);
        testTranscript.addGrade("ENGL-201", 4.0);
        testTranscript.addGrade("CPSC-110", 3.1);

    }

    @Test
    public void testGetStudentName(){
        assertEquals("Student Name", testTranscript.getStudentName());
    }

    @Test
    public void testSetStudentName() {
        testTranscript.setStudentName("Student Name2");
        assertEquals("Student Name2", testTranscript.getStudentName() );
    }

    @Test
    public void testSetStudentID() {
        testTranscript.setStudentID(2000);
        assertEquals(2000, testTranscript.getStudentID());
    }

    @Test
    public void testAddGrade() {
        assertEquals("CPSC-210: 3.5", testTranscript.getCourseAndGrade("CPSC-210"));
        assertEquals("ENGL-201: 4.0", testTranscript.getCourseAndGrade("ENGL-201"));
        assertEquals("CPSC-110: 3.1", testTranscript.getCourseAndGrade("CPSC-110"));
    }

    @Test
    public void testGetGPA() {
        assertEquals(3.533333333333333, testTranscript.getGPA());
//        assertEquals("ENGL-201: 4.0", testTranscript.getGPA());
//        assertEquals("CPSC-110: 3.1", testTranscript.getGPA());
    }

    @Test
    public void testCalculateAverage() {
        assertEquals(4, testTranscript.getAverageOverSelectedCourses(Arrays.asList("ENGL-201")));
        assertEquals(3.75, testTranscript.getAverageOverSelectedCourses(Arrays.asList("CPSC-210", "ENGL-201")));
    }
}