package com.joseneyra.sfmsbreweryclient.web.client;

import com.joseneyra.sfmsbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerById() {
        BeerDto dto = client.getBeerById(UUID.randomUUID());

        assertNotNull(dto);
    }

    @Test
    void testSavedNewBeer() {
        // Given
        BeerDto beerDto = BeerDto.builder().beerName("Test Beer").build();

        // When
        URI uri = client.saveNewBeer(beerDto);

        // Then
        assertNotNull(uri);
    }
}