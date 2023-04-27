package com.dma.places.service;

import com.dma.places.domain.TestObject;
import com.dma.places.boundary.dto.TestObjectDTO;

import java.util.List;

public interface TestService {

    void addObject(TestObjectDTO dto);
    List<TestObject> getAllObjects();
}
