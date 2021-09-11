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
package ec.edu.espe.distribuidas.ExamenMongo.controller;

import ec.edu.espe.distribuidas.ExamenMongo.service.TransaccionService;
import ec.edu.espe.distribuidas.ExamenMongoBautista.model.Transaccion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author valen
 */
@RestController
@RequestMapping("/api/transaccion")
@Slf4j
public class TransaccionController {

    public TransaccionController(TransaccionService service) {
        this.service = service;
    }
    
    private final TransaccionService service;
    @PostMapping
    public ResponseEntity agregarTransaccion(@RequestBody Transaccion transaccion) {
        try {
            log.info("Va a crear la transaccion con la siguiente informacion: {}", transaccion);
            this.service.agregarTransaccion(transaccion);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error("Ocurrio un error al crear la enfermedad. {} - retorna badrequest", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
