package com.shadowhawk.aimsmockdispatcher.repository;

import com.shadowhawk.aimsmockdispatcher.entity.Trucker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TruckerRepository extends JpaRepository<Trucker, Long> {
}
