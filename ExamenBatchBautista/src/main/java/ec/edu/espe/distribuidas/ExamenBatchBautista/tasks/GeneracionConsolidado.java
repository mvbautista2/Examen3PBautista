/*
 * Copyright (c) 2021 valen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    valen - initial API and implementation and/or initial documentation
 */
package ec.edu.espe.distribuidas.ExamenBatchBautista.tasks;

import ec.edu.espe.distribuidas.ExamenBactchBautista.config.ApplicationValues;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 *
 * @author valen
 */
public class GeneracionConsolidado implements Tasklet, StepExecutionListener{

    public GeneracionConsolidado(ApplicationValues applicationValues, MongoTemplate mongoTemplate, ExecutionContext jobContext) {
        this.applicationValues = applicationValues;
        this.mongoTemplate = mongoTemplate;
        this.jobContext = jobContext;
    }
    private final ApplicationValues applicationValues;
    private final MongoTemplate mongoTemplate;
    private ExecutionContext jobContext;


    @Override
    public RepeatStatus execute(StepContribution sc, ChunkContext cc) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void beforeStep(StepExecution se) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ExitStatus afterStep(StepExecution se) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
