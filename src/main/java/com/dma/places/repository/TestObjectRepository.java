package com.dma.places.repository;

import com.dma.places.domain.TestObject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestObjectRepository extends JpaRepository<TestObject, Integer> {
}
