package com.cf.cigar_finder.cigar;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CigarService {
    private final CigarRepository cigarRepository;

    @Autowired
    public CigarService(CigarRepository cigarRepository) {
        this.cigarRepository = cigarRepository;
    }

    public List<Cigar> getCigars() {
        return cigarRepository.findAll();
    }

    public List<Cigar> getCigarsByGse(Integer gse) {
        return cigarRepository.findAll().stream().filter(cigar -> cigar.getGse().equals(gse)).collect(Collectors.toList());
    }

    public List<Cigar> getCigarsFromOrigin(String origin) {
        return cigarRepository.findAll().stream().filter(cigar -> cigar.getOrigin().toLowerCase().contains(origin.toLowerCase())).collect(Collectors.toList());
    }

    public List<Cigar> getCigarsByBody(String body) {
        return cigarRepository.findAll().stream().filter(cigar -> cigar.getBody().toLowerCase().contains(body.toLowerCase())).collect(Collectors.toList());
    }

    public List<Cigar> getCigarsByWrapper(String wrapper) {
        return cigarRepository.findAll().stream().filter(cigar -> cigar.getWrapper().toLowerCase().contains(wrapper.toLowerCase())).collect(Collectors.toList());
    }

    public List<Cigar> getCigarsByBodyAndNotes(String body, String notes) {
        return cigarRepository.findAll().stream().filter(cigar -> cigar.getBody().toLowerCase().contains(body.toLowerCase()) && cigar.getNotes().toLowerCase().contains(notes.toLowerCase())).collect(Collectors.toList());
    }

    public Cigar addCigar(Cigar cigar) {
        cigarRepository.save(cigar);
        return cigar;
    }

    public Cigar updateCigar(Cigar  updatedCigar) {
        Optional<Cigar> existingCigar = cigarRepository.findByGse(updatedCigar.getGse());
        if (existingCigar.isPresent()) {
            Cigar cigarToUpdate = existingCigar.get();
            cigarToUpdate.setNotes(updatedCigar.getNotes());
            cigarToUpdate.setPairings(updatedCigar.getPairings());
            cigarToUpdate.setSimilar_cigars(updatedCigar.getSimilar_cigars());
            cigarRepository.save(cigarToUpdate);
            return cigarToUpdate;
        }
        return null;
    }

    @Transactional
    public void deleteCigarByGse(Integer gse) {
        cigarRepository.deleteByGse(gse);
    }
}
