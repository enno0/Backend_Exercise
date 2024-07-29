package banquemisr.challenege05.taskmangmentsystem;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@SpringBootTest
public class TaskmanagementsystemApplicationTests {

	@Autowired
	private Environment environment;

	@Test
	public void contextLoads() {
		System.out.println("Active profiles: " + Arrays.toString(environment.getActiveProfiles()));
		// Add more logging as needed
	}
}
