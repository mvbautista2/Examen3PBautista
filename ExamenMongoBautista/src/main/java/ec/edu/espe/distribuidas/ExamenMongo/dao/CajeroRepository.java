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
package ec.edu.espe.distribuidas.ExamenMongo.dao;

import ec.edu.espe.distribuidas.ExamenMongoBautista.model.Cajero;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author valen
 */
public interface CajeroRepository extends MongoRepository<Cajero, String> {
    
    List<Cajero> findByMontoLessThan(BigDecimal monto);
}
    

