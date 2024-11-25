package com.xml.ortega;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
class UnitTest {

    private boolean isValidXML(File xmlFile) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            unmarshaller.unmarshal(xmlFile);
            return true; // Valid XML
        } catch (JAXBException e) {
            return false; // Invalid XML
        }
    }

    private Customer parseXML(File xmlFile) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (Customer) unmarshaller.unmarshal(xmlFile);
        } catch (JAXBException e) {
            return null; // Return null for invalid XML
        }
    }

    @Test
    void testValidXMLFile() {
        File validXMLFile = new File("src/main/resources/Sample.xml");
        Assertions.assertTrue(isValidXML(validXMLFile), "The XML file should be valid.");
    }

    @Test
    void testContent() {
        File validXMLFile = new File("src/main/resources/Sample.xml");
        Customer customer = parseXML(validXMLFile);
        Assertions.assertNotNull(customer, "The XML file should be valid.");
        Assertions.assertEquals(214388, customer.getId(), "Customer ID: 214388");
        Assertions.assertEquals(17, customer.getAge(), "Customer Age: 17");
        Assertions.assertEquals("Joshua Ortega", customer.getName(), "Customer Name: Joshua Ortega");
    }
}
