package ir.proprog.enrollassist.domain.enrollmentList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class EnrollmentListTest {

	@Parameterized.Parameters
	public Collection<Object[]> parameters() {
		return Arrays.asList(new Object[][] {
				{},
		});
	}

	@Test
	public void checkEnrollmentRulesTest() {

	}
}
