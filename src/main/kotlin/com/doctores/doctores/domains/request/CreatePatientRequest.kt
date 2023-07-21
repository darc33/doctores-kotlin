package com.doctores.doctores.domains.request

class CreatePatientRequest (
        val nombre: String,
        val apellido: String,
        val identificacion: String,
        val telefono: Long,
)