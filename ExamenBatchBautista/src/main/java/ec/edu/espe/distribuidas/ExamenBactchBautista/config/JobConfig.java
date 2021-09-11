/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.ExamenBactchBautista.config;


import ec.edu.espe.distribuidas.ExamenBatchBautista.tasks.GeneracionConsolidado;
import ec.edu.espe.distribuidas.ExamenBatchBautista.tasks.LeerTransacciones;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 *
 * @author Hendrix
 */
@Configuration
@EnableAutoConfiguration
@EnableBatchProcessing
public class JobConfig {
    
    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private ApplicationValues applicationValues;
    
    @Bean
    protected Step leerTransacciones() {
        return steps
                .get("leerTrama")
                .tasklet(new LeerTransacciones(this.applicationValues))
                .build();
    }
    
    @Bean
    protected Step generacionConsolidado() {
        return steps
                .get("generacionConsolidado")
                .tasklet(new GeneracionConsolidado(this.applicationValues, this.mongoTemplate))
                .build();
    }
    
    @Bean
    public Job generarConsolidado() {
        return jobs
                .get("generarConsolidado")
                .start(leerTransacciones())
                .next(generacionConsolidado())
                .build();
    }
    
}
