package id.ac.ui.cs.advprog.eshop;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EshopApplicationTests {

	@Test
	public void mainMethodRunsWithoutException() {
		try {
			EshopApplication.main(new String[]{});
		} catch (Exception e) {
			fail("The main method should not throw any exceptions");
		}
	}
}
