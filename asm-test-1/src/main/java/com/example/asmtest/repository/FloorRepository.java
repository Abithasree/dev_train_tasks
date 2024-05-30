package com.example.asmtest.repository;

import com.example.asmtest.entity.Floor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloorRepository extends JpaRepository<Floor, Long> {
    Floor findByCategory_Name(String categoryName);
}
