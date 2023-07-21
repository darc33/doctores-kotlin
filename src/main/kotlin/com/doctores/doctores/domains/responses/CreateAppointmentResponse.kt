package com.doctores.doctores.domains.responses

import java.time.Instant
data class CreateAppointmentResponse(
    val idCita: Long,
    val especialidad: String,
    val doctor: String,
    val paciente: String,
    val consultorio: Long,
    val horario: String
)
