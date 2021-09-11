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

import ec.edu.espe.distribuidas.ExamenMongo.service.CajeroService;
import ec.edu.espe.distribuidas.ExamenMongoBautista.model.Cajero;
import ec.edu.espe.distribuidas.ExamenMongoBautista.model.Transaccion;
import java.math.BigDecimal;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author valen
 */
@RestController
@RequestMapping("/api/cajero")
@Slf4j
public class CajeroController {

    public CajeroController(CajeroService service) {
        this.service = service;
    }
    private final CajeroService service;
    
    @GetMapping(value = "monto/{monto}")
    public ResponseEntity listarCajerosSegunMonto(@PathVariable("monto") BigDecimal monto) {
        List<Cajero> cajero = this.service.listarPorMontoMenorA(monto);
        return ResponseEntity.ok(cajero);
    }
    
}
