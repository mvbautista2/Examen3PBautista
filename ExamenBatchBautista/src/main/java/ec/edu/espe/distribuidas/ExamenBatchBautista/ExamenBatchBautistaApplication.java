package ec.edu.espe.distribuidas.ExamenBatchBautista;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExamenBatchBautistaApplication {
    
    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    @Qualifier("generacionConsolidado")
    Job job1;

	public static void main(String[] args) {
		SpringApplication.run(ExamenBatchBautistaApplication.class, args);
	}

}
