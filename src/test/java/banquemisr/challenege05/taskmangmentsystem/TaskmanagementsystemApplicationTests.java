package banquemisr.challenege05.taskmangmentsystem;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;

@SpringBootTest
@ActiveProfiles("test")
public class TaskmanagementsystemApplicationTests {

	@Autowired
	private Environment environment;

	@Test
	public void contextLoads() {
		System.out.println("Active profiles: " + Arrays.toString(environment.getActiveProfiles()));
		System.out.println("Spring DataSource URL: " + environment.getProperty("spring.datasource.url"));
		System.out.println("Spring DataSource Username: " + environment.getProperty("spring.datasource.username"));
		System.out.println("Spring DataSource Password: " + environment.getProperty("spring.datasource.password"));
		// Additional logging as needed
	}
}
