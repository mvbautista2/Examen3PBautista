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
import ec.edu.espe.distribuidas.ExamenMongo.exception.CreateException;
import ec.edu.espe.distribuidas.ExamenMongoBautista.model.Cajero;
import ec.edu.espe.distribuidas.ExamenMongoBautista.model.Transaccion;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 * @author valen
 */
@Service
@Slf4j
public class TransaccionService {

    public TransaccionService(CajeroRepository cajeroRepo) {
        this.cajeroRepo = cajeroRepo;
    }
    
    private final CajeroRepository cajeroRepo;
    
    public void agregarTransaccion(Transaccion transaccion){
        Optional<Cajero> cajeroOpt = this.cajeroRepo.findById(transaccion.getIdCajero());
        if(cajeroOpt.isPresent()){
            transaccion.setFecha(LocalDate.now());
            transaccion.setEstado("PEN");
        }else{
            throw new CreateException("No existe cajero: "
                    + transaccion.getIdCajero());
        }
    }
}
