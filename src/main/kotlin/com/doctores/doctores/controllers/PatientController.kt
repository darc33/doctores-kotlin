package com.doctores.doctores.controllers
import com.doctores.doctores.constants.*
import com.doctores.doctores.domains.request.CreatePatientRequest
import com.doctores.doctores.domains.responses.CreateDoctorResponse
import com.doctores.doctores.domains.responses.CreatePatientResponse
import com.doctores.doctores.domains.responses.HealthCheckResponse
import com.doctores.doctores.services.PatientService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import  org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody

@RestController
class PatientController {
    @Autowired
    private lateinit var patientService: PatientService
    @GetMapping(Patient)
    fun getAllPatients(): List<CreatePatientResponse> =patientService.getAllPatients()
    @PostMapping(CreatePatients)
    fun createPatient(
            @RequestBody request: CreatePatientRequest
    ): CreatePatientResponse = patientService.createPatient(request)
    @GetMapping(GetPatientById)
    fun getPatienttById(
            @PathVariable("id") id:Long
    ): CreatePatientResponse = patientService.getPatientById(id)
    @PutMapping(UpdatePatient)
    fun updatePatient(
            @PathVariable("id") id:Long
    ): CreatePatientResponse = patientService.updatePatient(id)
}