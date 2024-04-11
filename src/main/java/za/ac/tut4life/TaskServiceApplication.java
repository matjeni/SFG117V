package za.ac.tut4life;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;


@SpringBootApplication()
@EnableJpaRepositories(basePackages = "za.ac.tut4life.repository")
public class TaskServiceApplication extends SpringBootServletInitializer {


	public static void main(String[] args) {
		SpringApplication.run(TaskServiceApplication.class, args);
	}
	@Bean
	public static CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("###################################################");
			System.out.println("#### Let's check the beans provided by Spring #####");
			System.out.println("###################################################");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}
}
