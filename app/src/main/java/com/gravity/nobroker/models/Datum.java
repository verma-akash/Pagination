
package com.gravity.nobroker.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("propertyAge")
    @Expose
    private Integer propertyAge;
    @SerializedName("parking")
    @Expose
    private String parking;
    @SerializedName("parkingDesc")
    @Expose
    private String parkingDesc;
    @SerializedName("shortlistedByLoggedInUser")
    @Expose
    private Boolean shortlistedByLoggedInUser;
    @SerializedName("lastUpdateDate")
    @Expose
    private String lastUpdateDate;
    @SerializedName("balconies")
    @Expose
    private Integer balconies;
    @SerializedName("furnishingDesc")
    @Expose
    private String furnishingDesc;
    @SerializedName("cupBoard")
    @Expose
    private Integer cupBoard;
    @SerializedName("negotiable")
    @Expose
    private Boolean negotiable;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("ownerId")
    @Expose
    private String ownerId;
    @SerializedName("rent")
    @Expose
    private String rent;
    @SerializedName("availableFrom")
    @Expose
    private String availableFrom;
    @SerializedName("photos")
    @Expose
    private List<Photo> photos = null;
    @SerializedName("propertySize")
    @Expose
    private Integer propertySize;
    @SerializedName("loanAvailable")
    @Expose
    private Boolean loanAvailable;
    @SerializedName("score")
    @Expose
    private Score score;
    @SerializedName("accomodationTypeDesc")
    @Expose
    private String accomodationTypeDesc;
    @SerializedName("propertyCode")
    @Expose
    private String propertyCode;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("localityId")
    @Expose
    private String localityId;
    @SerializedName("adminEvent")
    @Expose
    private String adminEvent;
    @SerializedName("bathroom")
    @Expose
    private Integer bathroom;
    @SerializedName("propertyTitle")
    @Expose
    private String propertyTitle;
    @SerializedName("longitude")
    @Expose
    private Double longitude;
    @SerializedName("powerBackup")
    @Expose
    private Object powerBackup;
    @SerializedName("dateOnly")
    @Expose
    private String dateOnly;
    @SerializedName("inactiveReason")
    @Expose
    private Object inactiveReason;
    @SerializedName("locality")
    @Expose
    private String locality;
    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("creationDate")
    @Expose
    private String creationDate;
    @SerializedName("swimmingPool")
    @Expose
    private Boolean swimmingPool;
    @SerializedName("accomodationType")
    @Expose
    private Object accomodationType;
    @SerializedName("waterSupply")
    @Expose
    private String waterSupply;
    @SerializedName("accurateLocation")
    @Expose
    private Boolean accurateLocation;
    @SerializedName("pinCode")
    @Expose
    private Object pinCode;
    @SerializedName("totalFloor")
    @Expose
    private Integer totalFloor;
    @SerializedName("lift")
    @Expose
    private Boolean lift;
    @SerializedName("deposit")
    @Expose
    private Integer deposit;
    @SerializedName("gym")
    @Expose
    private Boolean gym;
    @SerializedName("detailUrl")
    @Expose
    private String detailUrl;
    @SerializedName("activationDate")
    @Expose
    private String activationDate;
    @SerializedName("facingDesc")
    @Expose
    private String facingDesc;
    @SerializedName("furnishing")
    @Expose
    private String furnishing;
    @SerializedName("amenities")
    @Expose
    private String amenities;
    @SerializedName("photoAvailable")
    @Expose
    private Boolean photoAvailable;
    @SerializedName("typeDesc")
    @Expose
    private String typeDesc;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("shortUrl")
    @Expose
    private String shortUrl;
    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("facing")
    @Expose
    private String facing;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("nbLocality")
    @Expose
    private String nbLocality;
    @SerializedName("leaseType")
    @Expose
    private String leaseType;
    @SerializedName("society")
    @Expose
    private String society;
    @SerializedName("ownerName")
    @Expose
    private String ownerName;
    @SerializedName("street")
    @Expose
    private String street;
    @SerializedName("managed")
    @Expose
    private Object managed;
    @SerializedName("propertyType")
    @Expose
    private String propertyType;
    @SerializedName("secondaryTitle")
    @Expose
    private String secondaryTitle;
    @SerializedName("floor")
    @Expose
    private Integer floor;
    @SerializedName("lastActivationDate")
    @Expose
    private Object lastActivationDate;
    @SerializedName("forLease")
    @Expose
    private Boolean forLease;
    @SerializedName("inactiveReasonDesc")
    @Expose
    private Object inactiveReasonDesc;
    @SerializedName("sponsored")
    @Expose
    private Boolean sponsored;
    @SerializedName("buildingId")
    @Expose
    private String buildingId;
    @SerializedName("tenantTypeDesc")
    @Expose
    private String tenantTypeDesc;
    @SerializedName("amenitiesMap")
    @Expose
    private AmenitiesMap amenitiesMap;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("sharedAccomodation")
    @Expose
    private Boolean sharedAccomodation;
    @SerializedName("buildingType")
    @Expose
    private String buildingType;

    private boolean isFavourite;

    public Integer getPropertyAge() {
        return propertyAge;
    }

    public void setPropertyAge(Integer propertyAge) {
        this.propertyAge = propertyAge;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }

    public String getParkingDesc() {
        return parkingDesc;
    }

    public void setParkingDesc(String parkingDesc) {
        this.parkingDesc = parkingDesc;
    }

    public Boolean getShortlistedByLoggedInUser() {
        return shortlistedByLoggedInUser;
    }

    public void setShortlistedByLoggedInUser(Boolean shortlistedByLoggedInUser) {
        this.shortlistedByLoggedInUser = shortlistedByLoggedInUser;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getBalconies() {
        return balconies;
    }

    public void setBalconies(Integer balconies) {
        this.balconies = balconies;
    }

    public String getFurnishingDesc() {
        return furnishingDesc;
    }

    public void setFurnishingDesc(String furnishingDesc) {
        this.furnishingDesc = furnishingDesc;
    }

    public Integer getCupBoard() {
        return cupBoard;
    }

    public void setCupBoard(Integer cupBoard) {
        this.cupBoard = cupBoard;
    }

    public Boolean getNegotiable() {
        return negotiable;
    }

    public void setNegotiable(Boolean negotiable) {
        this.negotiable = negotiable;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getRent() {
        return rent;
    }

    public void setRent(String rent) {
        this.rent = rent;
    }

    public String getAvailableFrom() {
        return availableFrom;
    }

    public void setAvailableFrom(String availableFrom) {
        this.availableFrom = availableFrom;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public Integer getPropertySize() {
        return propertySize;
    }

    public void setPropertySize(Integer propertySize) {
        this.propertySize = propertySize;
    }

    public Boolean getLoanAvailable() {
        return loanAvailable;
    }

    public void setLoanAvailable(Boolean loanAvailable) {
        this.loanAvailable = loanAvailable;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public String getAccomodationTypeDesc() {
        return accomodationTypeDesc;
    }

    public void setAccomodationTypeDesc(String accomodationTypeDesc) {
        this.accomodationTypeDesc = accomodationTypeDesc;
    }

    public String getPropertyCode() {
        return propertyCode;
    }

    public void setPropertyCode(String propertyCode) {
        this.propertyCode = propertyCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocalityId() {
        return localityId;
    }

    public void setLocalityId(String localityId) {
        this.localityId = localityId;
    }

    public String getAdminEvent() {
        return adminEvent;
    }

    public void setAdminEvent(String adminEvent) {
        this.adminEvent = adminEvent;
    }

    public Integer getBathroom() {
        return bathroom;
    }

    public void setBathroom(Integer bathroom) {
        this.bathroom = bathroom;
    }

    public String getPropertyTitle() {
        return propertyTitle;
    }

    public void setPropertyTitle(String propertyTitle) {
        this.propertyTitle = propertyTitle;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Object getPowerBackup() {
        return powerBackup;
    }

    public void setPowerBackup(Object powerBackup) {
        this.powerBackup = powerBackup;
    }

    public String getDateOnly() {
        return dateOnly;
    }

    public void setDateOnly(String dateOnly) {
        this.dateOnly = dateOnly;
    }

    public Object getInactiveReason() {
        return inactiveReason;
    }

    public void setInactiveReason(Object inactiveReason) {
        this.inactiveReason = inactiveReason;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Boolean getSwimmingPool() {
        return swimmingPool;
    }

    public void setSwimmingPool(Boolean swimmingPool) {
        this.swimmingPool = swimmingPool;
    }

    public Object getAccomodationType() {
        return accomodationType;
    }

    public void setAccomodationType(Object accomodationType) {
        this.accomodationType = accomodationType;
    }

    public String getWaterSupply() {
        return waterSupply;
    }

    public void setWaterSupply(String waterSupply) {
        this.waterSupply = waterSupply;
    }

    public Boolean getAccurateLocation() {
        return accurateLocation;
    }

    public void setAccurateLocation(Boolean accurateLocation) {
        this.accurateLocation = accurateLocation;
    }

    public Object getPinCode() {
        return pinCode;
    }

    public void setPinCode(Object pinCode) {
        this.pinCode = pinCode;
    }

    public Integer getTotalFloor() {
        return totalFloor;
    }

    public void setTotalFloor(Integer totalFloor) {
        this.totalFloor = totalFloor;
    }

    public Boolean getLift() {
        return lift;
    }

    public void setLift(Boolean lift) {
        this.lift = lift;
    }

    public Integer getDeposit() {
        return deposit;
    }

    public void setDeposit(Integer deposit) {
        this.deposit = deposit;
    }

    public Boolean getGym() {
        return gym;
    }

    public void setGym(Boolean gym) {
        this.gym = gym;
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }

    public String getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(String activationDate) {
        this.activationDate = activationDate;
    }

    public String getFacingDesc() {
        return facingDesc;
    }

    public void setFacingDesc(String facingDesc) {
        this.facingDesc = facingDesc;
    }

    public String getFurnishing() {
        return furnishing;
    }

    public void setFurnishing(String furnishing) {
        this.furnishing = furnishing;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public Boolean getPhotoAvailable() {
        return photoAvailable;
    }

    public void setPhotoAvailable(Boolean photoAvailable) {
        this.photoAvailable = photoAvailable;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFacing() {
        return facing;
    }

    public void setFacing(String facing) {
        this.facing = facing;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNbLocality() {
        return nbLocality;
    }

    public void setNbLocality(String nbLocality) {
        this.nbLocality = nbLocality;
    }

    public String getLeaseType() {
        return leaseType;
    }

    public void setLeaseType(String leaseType) {
        this.leaseType = leaseType;
    }

    public String getSociety() {
        return society;
    }

    public void setSociety(String society) {
        this.society = society;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Object getManaged() {
        return managed;
    }

    public void setManaged(Object managed) {
        this.managed = managed;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getSecondaryTitle() {
        return secondaryTitle;
    }

    public void setSecondaryTitle(String secondaryTitle) {
        this.secondaryTitle = secondaryTitle;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Object getLastActivationDate() {
        return lastActivationDate;
    }

    public void setLastActivationDate(Object lastActivationDate) {
        this.lastActivationDate = lastActivationDate;
    }

    public Boolean getForLease() {
        return forLease;
    }

    public void setForLease(Boolean forLease) {
        this.forLease = forLease;
    }

    public Object getInactiveReasonDesc() {
        return inactiveReasonDesc;
    }

    public void setInactiveReasonDesc(Object inactiveReasonDesc) {
        this.inactiveReasonDesc = inactiveReasonDesc;
    }

    public Boolean getSponsored() {
        return sponsored;
    }

    public void setSponsored(Boolean sponsored) {
        this.sponsored = sponsored;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public String getTenantTypeDesc() {
        return tenantTypeDesc;
    }

    public void setTenantTypeDesc(String tenantTypeDesc) {
        this.tenantTypeDesc = tenantTypeDesc;
    }

    public AmenitiesMap getAmenitiesMap() {
        return amenitiesMap;
    }

    public void setAmenitiesMap(AmenitiesMap amenitiesMap) {
        this.amenitiesMap = amenitiesMap;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getSharedAccomodation() {
        return sharedAccomodation;
    }

    public void setSharedAccomodation(Boolean sharedAccomodation) {
        this.sharedAccomodation = sharedAccomodation;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }
}
