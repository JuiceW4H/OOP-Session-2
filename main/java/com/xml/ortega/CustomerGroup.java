package com.xml.ortega;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "customerGroup")
@XmlAccessorType(XmlAccessType.FIELD)
class CustomerGroup {

    @XmlElement(name = "customer")
    private List<Customer> customerList = null;

    public List<Customer> getCustomers() {
        return customerList;
    }

    public void setCustomerList(List<Customer> c) {
        this.customerList = c;
    }
}
