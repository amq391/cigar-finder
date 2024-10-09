package com.cf.cigar_finder.cigar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface CigarRepository extends JpaRepository<Cigar, Integer> {
    void deleteByGse(Integer gse);

    Optional<Cigar> findByGse(Integer gse);
}
