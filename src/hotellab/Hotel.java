package hotellab;

import java.util.Objects;

/**
 *
 * @author Daniel
 */
public class Hotel {
    private Long hotelId;
    private String hotelName;
    private String streetAddress;
    private String city;
    private String state;
    private String zip;
    private String notes;

    public Hotel() {
    }

    public Hotel(Long hotelId, String hotelName, String streetAddress, String city, String state, String zip, String notes) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.notes = notes;
    }

    
    
    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.hotelId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Hotel other = (Hotel) obj;
        if (!Objects.equals(this.hotelId, other.hotelId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Hotel Data:" + "Id: " + hotelId + ", Name: " + hotelName + ", Address: " + streetAddress + ", city: " + city 
                + ", state: " + state + ", zip: " + zip + ", notes: " + notes;
    }
    
    
    
    
}
