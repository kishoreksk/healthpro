package com.healthpro.model;

import java.util.Objects;

public class PharmacyDetail {
    private Long id;
    private String name;
    private String gst;
    private String city;
    private String Website;
    private String address;
    private String country;
    private String contact;

    public PharmacyDetail(Long id, String name, String city, String website) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.Website = website;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGst() {
        return gst;
    }

    public void setGst(String gst) {
        this.gst = gst;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String website) {
        Website = website;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PharmacyDetail that = (PharmacyDetail) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(gst, that.gst) &&
                Objects.equals(city, that.city) &&
                Objects.equals(Website, that.Website) &&
                Objects.equals(address, that.address) &&
                Objects.equals(country, that.country) &&
                Objects.equals(contact, that.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gst, city, Website, address, country, contact);
    }
}

