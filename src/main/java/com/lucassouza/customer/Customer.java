package com.lucassouza.customer;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer implements Comparable<Customer> {

    @JsonProperty("user_id")
    public Integer id;

    @JsonProperty
    public String name;

    @JsonProperty
    public double latitude;

    @JsonProperty
    public double longitude;

    public double distance;

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Customer other) {
        return this.id.compareTo(other.id);
    }
}


