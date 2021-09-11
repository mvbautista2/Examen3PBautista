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

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import java.math.BigDecimal;
import java.util.Arrays;
import org.bson.types.Decimal128;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Autowired
    private ApplicationValues appValues; 
    
    @Override
    protected String getDatabaseName() {
        return appValues.getMongoDB();
    }

    @Override
    public MongoClient mongoClient() {
        if ("1".equals(appValues.getMongoAut())) {
            return MongoClients.create("mongodb://" + appValues.getMongoUsr() + ":" + appValues.getMongoPwd() + "@" 
                    + appValues.getMongoHost() + "/" + appValues.getMongoDB() + "?authSource=admin");
        } else {
            return MongoClients.create("mongodb://" + appValues.getMongoHost() + "/" + appValues.getMongoDB());
        }
    }

    @Override
    public boolean autoIndexCreation() {
        return true;
    }

    @Bean
    @Override
    public MappingMongoConverter mappingMongoConverter(MongoDatabaseFactory databaseFactory, MongoCustomConversions customConversions, MongoMappingContext mappingContext) {
        MappingMongoConverter converter = super.mappingMongoConverter(databaseFactory, customConversions, mappingContext);
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
        return converter;
    }
    
    /**
     * Inject a CustomConversions bean to overwrite the default mapping
     * of BigDecimal.
     * 
     * @return a new instance of CustomConversons
     */
    @Bean
    @Override
    public MongoCustomConversions customConversions() {
        Converter<Decimal128, BigDecimal> decimal128ToBigDecimal = (Decimal128 s) -> s==null ? null : s.bigDecimalValue();
        
        Converter<BigDecimal, Decimal128> bigDecimalToDecimal128 = (BigDecimal s) -> s==null ? null : new Decimal128(s);
        
        return new MongoCustomConversions(Arrays.asList(decimal128ToBigDecimal, bigDecimalToDecimal128));
    }
}
