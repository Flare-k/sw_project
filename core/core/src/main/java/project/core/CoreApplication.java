package project.core;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class CoreApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(CoreApplication.class, args);

//		CrollingController crollingController=new CrollingController();
//		crollingController.getDataFromWeb();
	}

}
