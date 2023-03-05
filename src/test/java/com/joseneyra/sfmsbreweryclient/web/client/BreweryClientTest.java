package com.joseneyra.sfmsbreweryclient.web.client;

import com.joseneyra.sfmsbreweryclient.web.model.BeerDto;
import com.joseneyra.sfmsbreweryclient.web.model.CustomerDto;
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
        BeerDto beerDto = BeerDto.builder().beerName("Test Beer").beerStyle("Test Style").build();

        // When
        URI uri = client.saveNewBeer(beerDto);

        // Then
        assertNotNull(uri);
    }

    @Test
    void testUpdateBeer() {
        // Given
        BeerDto beerDto = BeerDto.builder().beerName("Test Beer").beerStyle("Test Style").build();

        // When
        client.updateBeer(UUID.randomUUID(), beerDto);
    }

    @Test
    void testDeleteBeer() {
        // When
        client.deleteBeer(UUID.randomUUID());
    }

    @Test
    void getCustomerById() {
        CustomerDto customerDto = client.getCustomerById(UUID.randomUUID());

        assertNotNull(customerDto);
    }

    @Test
    void saveNewCustomer() {
        // Given
        CustomerDto customerDto = CustomerDto.builder().name("Test Customer").build();

        // When
        URI uri = client.saveNewCustomer(customerDto);

        // Then
        assertNotNull(uri);
    }

    @Test
    void updateCustomer() {
        // Given
        CustomerDto customerDto = CustomerDto.builder().name("Test Customer").build();

        // When
        client.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    void deleteCustomer() {
        // When
        client.deleteCustomer(UUID.randomUUID());
    }
}