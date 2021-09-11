/*
 * Copyright (c) 2021
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Valentina Bautista
 */
package ec.edu.espe.distribuidas.ExamenBactchBautista.config;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 */
@Component
@Slf4j
@ToString
public class ApplicationValues {

    private final String mongoHost;
    private final String mongoDB;
    private final String mongoAut;
    private final String mongoUsr;
    private final String mongoPwd;
    private final String configFile;
    private final String dataPath;


    @Autowired
    public ApplicationValues(@Value("${examenmongo.mongo.host}") String mongoHost,
            @Value("${examenmongo.mongo.db}") String mongoDB,
            @Value("${examenmongo.mongo.aut}") String mongoAut,
            @Value("${examenmongo.mongo.usr}") String mongoUsr,
            @Value("${examenmongo.mongo.pwd}") String mongoPwd,
            @Value("${examenmongo.config.file}") String configFile,
            @Value("${examenmongo.config.dataPath}") String dataPath
    ) {
        this.mongoHost = mongoHost;
        this.mongoDB = mongoDB;
        this.mongoAut = mongoAut;
        this.mongoUsr = mongoUsr;
        this.mongoPwd = mongoPwd;
        this.configFile = configFile;
        this.dataPath = dataPath;
        log.info("Propiedades Cargadas: "+this.toString());
    }

    public String getConfigFile() {
        return configFile;
    }

    public String getMongoHost() {
        return mongoHost;
    }

    public String getMongoDB() {
        return mongoDB;
    }

    public String getMongoUsr() {
        return mongoUsr;
    }

    public String getMongoPwd() {
        return mongoPwd;
    }

    public String getMongoAut() {
        return mongoAut;
    }

    public String getDataPath() {
        return dataPath;
    }

}
