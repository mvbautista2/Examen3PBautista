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
package ec.edu.espe.distribuidas.ExamenBatchBautista.model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author valen
 */
public class Transaccion {
    private String id;
    private String tipo;
    private BigDecimal monto;
    private Integer billetes10;
    private Integer billetes20;
    private String idCajero;
    private LocalDate fecha;
    private String estado;    
}
