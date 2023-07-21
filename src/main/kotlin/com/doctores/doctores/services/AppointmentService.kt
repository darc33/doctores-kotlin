package com.doctores.doctores.services

import com.doctores.doctores.domains.entity.Appointment
import com.doctores.doctores.domains.request.CreateAppointmentRequest
import com.doctores.doctores.domains.responses.CreateAppointmentResponse
import com.doctores.doctores.repositories.AppointmentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class AppointmentService {
    @Autowired
    private lateinit var appointmentRepository: AppointmentRepository
    fun createAppointment(request: CreateAppointmentRequest): CreateAppointmentResponse{
        val appointment =  appointmentRepository.save(
                Appointment(
                        especialidad = request.especialidad,
                        doctor = request.idDoctor,
                        idPaciente = request.idPaciente,
                        horario = request.horario,
                )
        )
        return CreateAppointmentResponse(
            idCita = 1,
            especialidad = request.especialidad,
            doctor = "Carlos",
            paciente = "56465",
            consultorio = 101,
            horario = "16"
        )
    }

    fun getAllAppointments(): List<CreateAppointmentResponse>{
        var response : List<CreateAppointmentResponse> = listOf(
            CreateAppointmentResponse(
                idCita = 1,
                especialidad = "Test",
                doctor = "Carlos",
                paciente = "56465",
                consultorio = 101,
                horario = "16"
            )
        )
        return response
    }

    fun getAppointmentById(id: Long): CreateAppointmentResponse{
        var appointment: Appointment? = appointmentRepository.getByAppointmentId(id)
        if (appointment!=null){
            return CreateAppointmentResponse(
                    idCita = appointment.idCita,
                    especialidad = "Test",
                    doctor = "Carlos",
                    paciente = "56465",
                    consultorio = 101,
                    horario = "16"
            )
        }else{
            return CreateAppointmentResponse(
                    idCita = 1,
                    especialidad = "Test",
                    doctor = "Carlos",
                    paciente = "56465",
                    consultorio = 101,
                    horario = "16"
            )
        }

    }

    fun updateAppointment(id: Long): CreateAppointmentResponse{
        return CreateAppointmentResponse(
            idCita = 1,
            especialidad = "Test",
            doctor = "Carlos",
            paciente = "56465",
            consultorio = 101,
            horario = "16"
        )
    }
}