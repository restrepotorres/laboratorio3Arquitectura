package com.udea.parcialfinal.persistance.repository;

import com.udea.parcialfinal.domain.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface for accessing and managing Doctor entities in the database.
 * Extends JpaRepository interface to inherit CRUD methods.
 */
public interface IDoctorRepository  extends JpaRepository<Doctor,Integer> { }
