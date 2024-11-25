package com.xml.ortega;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.util.List;

public class JAXBExample {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setId(99);
        customer.setName("JC Diamante");
        customer.setAge(29);

        Customer customer2 = new Customer();
        customer2.setId(100);
        customer2.setName("Kyle Megino");
        customer2.setAge(39);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

//            jaxbMarshaller.marshal(customer, System.out);

            generateMulti(List.of(customer, customer2));
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        // Unmarshaller

        String xmlFilePath = "src/main/resources/sample.xml";
        Customer cs1 = unmarshalFromXML(xmlFilePath);

        if (cs1 != null) {
            System.out.println("Unmarshalled Object: " + cs1);
            System.out.println("Customer Details:");
            System.out.println("ID: " + cs1.getId());
            System.out.println("Name: " + cs1.getName());
            System.out.println("Age: " + cs1.getAge());

        } else {
            System.out.println("Failed to unmarshal the XML file.");
        }
    }

    private static void generateMulti(List<Customer> list) throws JAXBException {
        CustomerGroup cg = new CustomerGroup();
        cg.setCustomerList(list);

        //Write to XML
        JAXBContext jaxbContext2 = JAXBContext.newInstance(CustomerGroup.class);
        Marshaller jaxbMarshaller2 = jaxbContext2.createMarshaller();

        jaxbMarshaller2.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        //Marshal the employees list in console
        jaxbMarshaller2.marshal(cg, System.out);
    }

    public static Customer unmarshalFromXML(String xmlFilePath) {
        try {
            // Create JAXB context
            JAXBContext context = JAXBContext.newInstance(Customer.class);

            // Create Unmarshaller
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // Unmarshal XML file into Java object
            return (Customer) unmarshaller.unmarshal(new File(xmlFilePath));
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }
}
