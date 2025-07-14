package com.joga10.api_joga10.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joga10.api_joga10.model.Establishment;
import com.joga10.api_joga10.model.Court;
import com.joga10.api_joga10.repository.EstablishmentRepository;
import com.joga10.api_joga10.repository.CourtRepository;

@RestController
@RequestMapping("/api/establishments")
public class EstablishmentController {
    @Autowired
    private EstablishmentRepository establishmentRepository;
    @Autowired
    private CourtRepository courtRepository;


    @GetMapping
    public List<Establishment> getAllEstablishments() {
        return establishmentRepository.findAll();
    }

    // Endpoint: lista todos os estabelecimentos com suas quadras
    @GetMapping("/with-courts")
    public List<EstablishmentWithCourts> getAllEstablishmentsWithCourts() {
        List<Establishment> establishments = establishmentRepository.findAll();
        return establishments.stream().map(est -> {
            List<Court> courts = courtRepository.findByEstablishmentId(est.getId());
            return new EstablishmentWithCourts(est, courts);
        }).toList();
    }

    // Endpoint: lista quadras de um estabelecimento específico
    @GetMapping("/{id}/courts")
    public List<Court> getCourtsByEstablishment(@PathVariable String id) {
        return courtRepository.findByEstablishmentId(id);
    }
// DTO para resposta customizada
class EstablishmentWithCourts {
    private Establishment establishment;
    private List<Court> courts;

    public EstablishmentWithCourts(Establishment establishment, List<Court> courts) {
        this.establishment = establishment;
        this.courts = courts;
    }
    public Establishment getEstablishment() { return establishment; }
    public void setEstablishment(Establishment establishment) { this.establishment = establishment; }
    public List<Court> getCourts() { return courts; }
    public void setCourts(List<Court> courts) { this.courts = courts; }
}

    @GetMapping("/{id}")
    public Optional<Establishment> getEstablishmentById(@PathVariable String id) {
        return establishmentRepository.findById(id);
    }

    @PostMapping
    public Establishment createEstablishment(@RequestBody Establishment establishment) {
        return establishmentRepository.save(establishment);
    }

    @PutMapping("/{id}")
    public Establishment updateEstablishment(@PathVariable String id, @RequestBody Establishment establishment) {
        establishment.setId(id);
        return establishmentRepository.save(establishment);
    }

    @DeleteMapping("/{id}")
    public void deleteEstablishment(@PathVariable String id) {
        establishmentRepository.deleteById(id);
    }
}
