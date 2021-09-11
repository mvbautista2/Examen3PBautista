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
package ec.edu.espe.distribuidas.ExamenMongo.service;

import ec.edu.espe.distribuidas.ExamenMongo.dao.CajeroRepository;
import ec.edu.espe.distribuidas.ExamenMongoBautista.model.Cajero;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 * @author valen
 */
@Service
@Slf4j
public class CajeroService {

    public CajeroService(CajeroRepository cajeroRepo) {
        this.cajeroRepo = cajeroRepo;
    }
    private final CajeroRepository cajeroRepo;
    
    public List<Cajero> listarPorMontoMenorA(BigDecimal monto) {
        Cajero cajero = new Cajero();
        log.info("Va a buscar cajeros cuyo monto es menor a: {} ", monto);
        if (cajero.getMonto().compareTo(monto)== -1) {
            return this.cajeroRepo.findByMontoLessThan(monto);
        } else {
            log.error("Error con el monto recibido");
            throw new RuntimeException("Fechas invalidas");
        }
    }
}
