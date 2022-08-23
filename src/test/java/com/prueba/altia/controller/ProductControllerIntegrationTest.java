package com.prueba.altia.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prueba.altia.model.ProductResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MimeTypeUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class ProductControllerIntegrationTest {

    public static final String BRAND_ID = "1";
    public static final String PRODUCT_ID = "35455";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetProducts1() throws Exception {
        LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        requestParams.add("applicationDate", "2020-06-14 10:00:00");
        requestParams.add("productId", PRODUCT_ID);
        requestParams.add("brandId", BRAND_ID);

        ProductResponse response = callMock(requestParams);

        assertEquals(response.getRate(), "1");
        assertEquals(response.getPrice().setScale(2, RoundingMode.HALF_UP), BigDecimal.valueOf(35.50).setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void testGetProducts2() throws Exception {
        LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        requestParams.add("applicationDate", "2020-06-14 16:00:00");
        requestParams.add("productId", PRODUCT_ID);
        requestParams.add("brandId", BRAND_ID);

        ProductResponse response = callMock(requestParams);

        assertEquals(response.getRate(), "2");
        assertEquals(response.getPrice().setScale(2, RoundingMode.HALF_UP), BigDecimal.valueOf(25.45).setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void testGetProducts3() throws Exception {
        LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        requestParams.add("applicationDate", "2020-06-14 21:00:00");
        requestParams.add("productId", PRODUCT_ID);
        requestParams.add("brandId", BRAND_ID);

        ProductResponse response = callMock(requestParams);

        assertEquals(response.getRate(), "1");
        assertEquals(response.getPrice().setScale(2, RoundingMode.HALF_UP), BigDecimal.valueOf(35.50).setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void testGetProducts4() throws Exception {
        LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        requestParams.add("applicationDate", "2020-06-15 10:00:00");
        requestParams.add("productId", PRODUCT_ID);
        requestParams.add("brandId", BRAND_ID);

        ProductResponse response = callMock(requestParams);

        assertEquals(response.getRate(), "3");
        assertEquals(response.getPrice().setScale(2, RoundingMode.HALF_UP), BigDecimal.valueOf(30.50).setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void testGetProducts5() throws Exception {
        LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        requestParams.add("applicationDate", "2020-06-16 21:00:00");
        requestParams.add("productId", PRODUCT_ID);
        requestParams.add("brandId", BRAND_ID);

        ProductResponse response = callMock(requestParams);

        assertEquals(response.getRate(), "4");
        assertEquals(response.getPrice().setScale(2, RoundingMode.HALF_UP), BigDecimal.valueOf(38.95).setScale(2, RoundingMode.HALF_UP));
    }

    /**
     * Method to call mock with params
     *
     * @param requestParams
     * @return
     * @throws Exception
     */
    private ProductResponse callMock(LinkedMultiValueMap<String, String> requestParams) throws Exception {
        MvcResult getProducts = mockMvc.perform(MockMvcRequestBuilders.get("/products")
                        .params(requestParams)
                        .accept(MimeTypeUtils.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();

        return objectMapper.readValue(getProducts.getResponse().getContentAsString(), ProductResponse.class);
    }


}