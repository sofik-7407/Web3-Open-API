package com.web.run.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Hotel {
	 @JsonProperty("hotelId")
    private String hotelId;
	 @JsonProperty("hotelName")
    private String hotelName;
	 @JsonProperty("rating")
    private String rating;
	 @JsonProperty("price")
    private String price;
    @JsonProperty("isAvailable")
    private boolean isAvailable;

    // Constructors
    public Hotel() {}

    public Hotel(String hotelId, String hotelName, String rating, String price, boolean isAvailable) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.rating = rating;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    // Getters and setters
    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

/*    @Override
    public String toString() {
        return "Hotel{" +
                "hotelId='" + hotelId + '\'' +
                ", hotelName='" + hotelName + '\'' +
                ", rating='" + rating + '\'' +
                ", price='" + price + '\'' +
                ", isAvailable=" + isAvailable +
                '}';*/
    
}
