package ir.proprog.enrollassist.domain.section;

import ir.proprog.enrollassist.Exception.ExceptionList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PresentationScheduleTest {
	PresentationSchedule presentationSchedule;

	@Before
	public void setup() throws ExceptionList {
		presentationSchedule = new PresentationSchedule("Monday", "15:30", "17:00");
	}

	@Test
	public void hasConflictWithSameDaySameTimeTest() throws ExceptionList {
		PresentationSchedule otherPresentationSchedule = new PresentationSchedule("Monday", "15:30", "17:00");
		assertTrue("Conflict Detection Failed", presentationSchedule.hasConflict(otherPresentationSchedule));
	}

	@Test
	public void hasConflictWithSameDaySoonerTimeTest() throws ExceptionList {
		PresentationSchedule otherPresentationSchedule = new PresentationSchedule("Monday", "13:30", "16:00");
		assertTrue("Conflict Detection Failed", presentationSchedule.hasConflict(otherPresentationSchedule));
	}

	@Test
	public void hasConflictWithSameDayLaterTimeTest() throws ExceptionList {
		PresentationSchedule otherPresentationSchedule = new PresentationSchedule("Monday", "16:30", "19:00");
		assertTrue("Conflict Detection Failed", presentationSchedule.hasConflict(otherPresentationSchedule));
	}

	@Test
	public void hasConflictWithSameDayNoConflictTest() throws ExceptionList {
		PresentationSchedule otherPresentationSchedule = new PresentationSchedule("Monday", "13:30", "15:00");
		assertTrue("Conflict Detection Failed", presentationSchedule.hasConflict(otherPresentationSchedule));
	}

	@Test
	public void hasConflictWithDifferentDaySameTimeTest() throws ExceptionList {
		PresentationSchedule otherPresentationSchedule = new PresentationSchedule("Sunday", "15:30", "17:00");
		assertTrue("Conflict Detection Failed", presentationSchedule.hasConflict(otherPresentationSchedule));
	}

	@Test
	public void hasConflictWithDifferentDaySoonerTimeTest() throws ExceptionList {
		PresentationSchedule otherPresentationSchedule = new PresentationSchedule("Sunday", "13:30", "16:00");
		assertTrue("Conflict Detection Failed", presentationSchedule.hasConflict(otherPresentationSchedule));
	}

	@Test
	public void hasConflictWithSDifferentDayLaterTimeTest() throws ExceptionList {
		PresentationSchedule otherPresentationSchedule = new PresentationSchedule("Sunday", "16:30", "19:00");
		assertTrue("Conflict Detection Failed", presentationSchedule.hasConflict(otherPresentationSchedule));
	}

	@Test
	public void hasConflictWithDifferentDayNoConflictTest() throws ExceptionList {
		PresentationSchedule otherPresentationSchedule = new PresentationSchedule("Sunday", "13:30", "15:00");
		assertTrue("Conflict Detection Failed", presentationSchedule.hasConflict(otherPresentationSchedule));
	}
}
