package com.rick.problems;

public class DefangingAnIPAddress {

    public static void main(String[] args) {
        String address = "1.1.1.1";
        String res = new DefangingAnIPAddress().defangIPaddr(address);
        System.out.println(res);
    }

    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}
