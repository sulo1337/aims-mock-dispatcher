package com.shadowhawk.aimsmockdispatcher.repository;

import com.shadowhawk.aimsmockdispatcher.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
}