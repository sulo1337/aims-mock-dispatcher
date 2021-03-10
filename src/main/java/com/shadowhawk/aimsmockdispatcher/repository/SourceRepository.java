package com.shadowhawk.aimsmockdispatcher.repository;

import com.shadowhawk.aimsmockdispatcher.entity.Source;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SourceRepository extends JpaRepository<Source, Long> {

}
