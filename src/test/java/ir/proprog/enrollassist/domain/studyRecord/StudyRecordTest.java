package ir.proprog.enrollassist.domain.studyRecord;

import ir.proprog.enrollassist.Exception.ExceptionList;
import ir.proprog.enrollassist.domain.GraduateLevel;
import ir.proprog.enrollassist.domain.course.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class StudyRecordTest {

	public GraduateLevel courseGraduateLevel;
	public GraduateLevel graduateLevel;
	public double grade;
	public boolean expectedResult;

	public StudyRecordTest(GraduateLevel courseGraduateLevel, double grade, GraduateLevel graduateLevel, boolean expectedResult) {
		this.courseGraduateLevel = courseGraduateLevel;
		this.grade = grade;
		this.graduateLevel = graduateLevel;
		this.expectedResult = expectedResult;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> parameters() {
		return Arrays.asList(new Object[][] {
				{GraduateLevel.Undergraduate, 0, GraduateLevel.Undergraduate, false},
				{GraduateLevel.Undergraduate, 5, GraduateLevel.Undergraduate, false},
				{GraduateLevel.Undergraduate, 10, GraduateLevel.Undergraduate, true},
				{GraduateLevel.Undergraduate, 11, GraduateLevel.Undergraduate, true},
				{GraduateLevel.Undergraduate, 12, GraduateLevel.Undergraduate, true},
				{GraduateLevel.Undergraduate, 13, GraduateLevel.Undergraduate, true},
				{GraduateLevel.Undergraduate, 14, GraduateLevel.Undergraduate, true},
				{GraduateLevel.Undergraduate, 16, GraduateLevel.Undergraduate, true},
				{GraduateLevel.Undergraduate, 20, GraduateLevel.Undergraduate, true},

				{GraduateLevel.Masters, 0, GraduateLevel.Undergraduate, false},
				{GraduateLevel.Masters, 5, GraduateLevel.Undergraduate, false},
				{GraduateLevel.Masters, 10, GraduateLevel.Undergraduate, true},
				{GraduateLevel.Masters, 11, GraduateLevel.Undergraduate, true},
				{GraduateLevel.Masters, 12, GraduateLevel.Undergraduate, true},
				{GraduateLevel.Masters, 13, GraduateLevel.Undergraduate, true},
				{GraduateLevel.Masters, 14, GraduateLevel.Undergraduate, true},
				{GraduateLevel.Masters, 16, GraduateLevel.Undergraduate, true},
				{GraduateLevel.Masters, 20, GraduateLevel.Undergraduate, true},

				{GraduateLevel.PHD, 0, GraduateLevel.Undergraduate, false},
				{GraduateLevel.PHD, 5, GraduateLevel.Undergraduate, false},
				{GraduateLevel.PHD, 10, GraduateLevel.Undergraduate, true},
				{GraduateLevel.PHD, 11, GraduateLevel.Undergraduate, true},
				{GraduateLevel.PHD, 12, GraduateLevel.Undergraduate, true},
				{GraduateLevel.PHD, 13, GraduateLevel.Undergraduate, true},
				{GraduateLevel.PHD, 14, GraduateLevel.Undergraduate, true},
				{GraduateLevel.PHD, 16, GraduateLevel.Undergraduate, true},
				{GraduateLevel.PHD, 20, GraduateLevel.Undergraduate, true},

				{GraduateLevel.Masters, 0, GraduateLevel.Masters, false},
				{GraduateLevel.Masters, 5, GraduateLevel.Masters, false},
				{GraduateLevel.Masters, 10, GraduateLevel.Masters, false},
				{GraduateLevel.Masters, 11, GraduateLevel.Masters, false},
				{GraduateLevel.Masters, 12, GraduateLevel.Masters, true},
				{GraduateLevel.Masters, 13, GraduateLevel.Masters, true},
				{GraduateLevel.Masters, 14, GraduateLevel.Masters, true},
				{GraduateLevel.Masters, 16, GraduateLevel.Masters, true},
				{GraduateLevel.Masters, 20, GraduateLevel.Masters, true},

				{GraduateLevel.PHD, 0, GraduateLevel.Masters, false},
				{GraduateLevel.PHD, 5, GraduateLevel.Masters, false},
				{GraduateLevel.PHD, 10, GraduateLevel.Masters, false},
				{GraduateLevel.PHD, 11, GraduateLevel.Masters, false},
				{GraduateLevel.PHD, 12, GraduateLevel.Masters, true},
				{GraduateLevel.PHD, 13, GraduateLevel.Masters, true},
				{GraduateLevel.PHD, 14, GraduateLevel.Masters, true},
				{GraduateLevel.PHD, 16, GraduateLevel.Masters, true},
				{GraduateLevel.PHD, 20, GraduateLevel.Masters, true},

				{GraduateLevel.PHD, 0, GraduateLevel.PHD, false},
				{GraduateLevel.PHD, 5, GraduateLevel.PHD, false},
				{GraduateLevel.PHD, 10, GraduateLevel.PHD, false},
				{GraduateLevel.PHD, 11, GraduateLevel.PHD, false},
				{GraduateLevel.PHD, 12, GraduateLevel.PHD, false},
				{GraduateLevel.PHD, 13, GraduateLevel.PHD, false},
				{GraduateLevel.PHD, 14, GraduateLevel.PHD, true},
				{GraduateLevel.PHD, 16, GraduateLevel.PHD, true},
				{GraduateLevel.PHD, 20, GraduateLevel.PHD, true},
		});
	}

	@Test
	public void isPassedTest() throws ExceptionList {
		StudyRecord studyRecord = new StudyRecord("00001", new Course("1234567", "SampleCourse", 3, courseGraduateLevel.name()), grade);
		assertEquals(studyRecord.isPassed(graduateLevel), this.expectedResult);
	}
}
