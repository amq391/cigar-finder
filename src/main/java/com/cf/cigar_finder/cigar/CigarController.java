package com.cf.cigar_finder.cigar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/cigar")
public class CigarController {
    private final CigarService cigarService;

    @Autowired
    public CigarController(CigarService cigarService) {
        this.cigarService = cigarService;
    }

    @GetMapping
    public List<Cigar> getCigars(
            @RequestParam(required = false) Integer gse,
            @RequestParam(required = false) String origin,
            @RequestParam(required = false) String body,
            @RequestParam(required = false) String wrapper,
            @RequestParam(required = false) String notes) {
        if (body != null && notes != null) {
            return cigarService.getCigarsByBodyAndNotes(body, notes);
        } else if (body != null) {
            return cigarService.getCigarsByBody(body);
        } else if (origin != null) {
            return cigarService.getCigarsFromOrigin(origin);
        } else if (wrapper != null) {
            return cigarService.getCigarsByWrapper(wrapper);
        } else if (gse != null) {
            return cigarService.getCigarsByGse(gse);
        } else {
            return cigarService.getCigars();
        }
    }

    @PostMapping
    public ResponseEntity<Cigar> addCigar(@RequestBody Cigar cigar) {
        Cigar createdCigar = cigarService.addCigar(cigar);
        return new ResponseEntity<>(createdCigar, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Cigar> updateCigar(@RequestBody Cigar cigar) {
        Cigar resultCigar = cigarService.updateCigar(cigar);
        if (resultCigar != null) {
            return new ResponseEntity<>(resultCigar, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{cigarGse}")
    public ResponseEntity<String> deleteCigar(@PathVariable Integer cigarGse) {
        cigarService.deleteCigarByGse(cigarGse);
        return new ResponseEntity<>("Cigar deleted successfully", HttpStatus.OK);
    }

    /*
    INSERT INTO cigar_table VALUES
    (873469, 'Arturo Fuente Double Chateau Maduro 6.75x50', 'Arturo Fuente', '6.75x50', 'Double Chateau', 'Dominican Republic', 'US Connecticut Broadleaf', ),
    (2, 'Bread', 1.99),
    (3, 'Milk', 2.99);
    "C:\Users\amq39\OneDrive\Desktop\cigars_to_load.csv"
     */
}
