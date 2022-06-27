package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.WikimediaData;

public interface WikimediaDataRepository extends JpaRepository<WikimediaData, Long> {
    
}
