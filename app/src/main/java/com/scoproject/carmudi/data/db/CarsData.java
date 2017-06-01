package com.scoproject.carmudi.data.db;

import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by ibnumuzzakkir on 6/1/17.
 */
@Entity
public class CarsData {
    @SerializedName("fk_country")
    public String fkCountry;
    @SerializedName("status")
    public String status;
    @SerializedName("attribute_set_name")
    public String attributeSetName;
    @SerializedName("attribute_set_name_local")
    public String attributeSetNameLocal;
    @SerializedName("approved")
    public String approved;
    @SerializedName("status_supplier_config")
    public String statusSupplierConfig;
    @SerializedName("activated_at")
    public String activatedAt;
    @SerializedName("listing_start")
    public String listingStart;
    @SerializedName("listing_end")
    public String listingEnd;
    @SerializedName("fk_vertical")
    public String fkVertical;
    @SerializedName("fk_catalog_brand")
    public String fkCatalogBrand;
    @SerializedName("fk_catalog_brand_model")
    public String fkCatalogBrandModel;
    @SerializedName("brand_model_edition")
    public String brandModelEdition;
    @SerializedName("listing_type")
    public String listingType;
    @SerializedName("listing_country")
    public String listingCountry;
    @SerializedName("listing_area")
    public String listingArea;
    @SerializedName("condition")
    public String condition;
    @SerializedName("condition_position")
    public String conditionPosition;
    @SerializedName("condition_id")
    public String conditionId;
    @SerializedName("color_family_position")
    public String colorFamilyPosition;
    @SerializedName("color_family_id")
    public String colorFamilyId;
    @SerializedName("doors_position")
    public String doorsPosition;
    @SerializedName("doors_id")
    public String doorsId;
    @SerializedName("power")
    public String power;
    @SerializedName("drive_type_position")
    public String driveTypePosition;
    @SerializedName("drive_type_id")
    public String driveTypeId;
    @SerializedName("interior")
    public String interior;
    @SerializedName("exterior")
    public String exterior;
    @SerializedName("equipment")
    public String equipment;
    @SerializedName("warranty_type_position")
    public String warrantyTypePosition;
    @SerializedName("warranty_type_id")
    public String warrantyTypeId;
    @SerializedName("warranty_years_position")
    public String warrantyYearsPosition;
    @SerializedName("warranty_years_id")
    public String warrantyYearsId;
    @SerializedName("price_conditions_position")
    public String priceConditionsPosition;
    @SerializedName("price_conditions_id")
    public String priceConditionsId;
    @SerializedName("premium_listing")
    public String premiumListing;
    @SerializedName("alternate_sku")
    public String alternateSku;
    @SerializedName("original_name")
    public String originalName;
    @SerializedName("root_category")
    public String rootCategory;
    @SerializedName("agency_logo")
    public String agencyLogo;
    @SerializedName("new-product")
    public Boolean newProduct;
    @SerializedName("url")
    public String url;
    @SerializedName("id")
    public String id;
    @SerializedName("location_latitude")
    public String locationLatitude;
    @SerializedName("location_longitude")
    public String locationLongitude;
    @SerializedName("google_formatted_address")
    public String googleFormattedAddress;
    @SerializedName("google_place_id")
    public String googlePlaceId;
    @SerializedName("fk_customer_address")
    public String fkCustomerAddress;
    @SerializedName("listing_region")
    public String listingRegion;
    @SerializedName("listing_city")
    public String listingCity;
    @SerializedName("agency_address")
    public String agencyAddress;
    @SerializedName("agency_city")
    public String agencyCity;
    @SerializedName("fk_country_region")
    public String fkCountryRegion;
    @SerializedName("fk_country_region_city")
    public String fkCountryRegionCity;
    @SerializedName("fk_country_region_city_area")
    public String fkCountryRegionCityArea;
    @SerializedName("show_listing_address")
    public String showListingAddress;
    @SerializedName("item_contact_name")
    public String itemContactName;
    @SerializedName("item_contact_email")
    private String itemContactEmail;
    @SerializedName("item_contact_mobile")
    public String itemContactMobile;
    @SerializedName("item_contact_homephone")
    public String itemContactHomephone;
    @SerializedName("agency_name")
    public String agencyName;
    @SerializedName("product_owner_url_key")
    public String productOwnerUrlKey;
    @SerializedName("product_owner")
    public String productOwner;
    @SerializedName("fk_customer")
    public String fkCustomer;
    @SerializedName("is_agent")
    public String isAgent;
    @SerializedName("seller_is_trusted")
    public String sellerIsTrusted;
    @SerializedName("show_officephone")
    public String showOfficephone;
    @SerializedName("show_homephone")
    public String showHomephone;
    @SerializedName("show_mobile")
    public String showMobile;
    @SerializedName("sku")
    public String sku;
    @SerializedName("id_catalog_config")
    public String idCatalogConfig;
    @SerializedName("attribute_set_id")
    public String attributeSetId;
    @SerializedName("original_price_currency")
    public String originalPriceCurrency;
    @SerializedName("is_certified")
    public Integer isCertified;
    @SerializedName("name")
    public String name;
    @SerializedName("description")
    public String description;
    @SerializedName("urlkey_details")
    public String urlkeyDetails;
    @SerializedName("price_not_available")
    public String priceNotAvailable;
    @SerializedName("price")
    public String price;
    @SerializedName("original_price")
    public String originalPrice;
    @SerializedName("brand")
    public String brand;
    @SerializedName("brand_model")
    public String brandModel;
    @SerializedName("top_position")
    public String topPosition;
    @SerializedName("mileage_not_available")
    public String mileageNotAvailable;
    @SerializedName("mileage")
    public String mileage;
    @SerializedName("config_id")
    public String configId;
    @SerializedName("rejected_comment")
    public String rejectedComment;
    @SerializedName("transmission")
    public String transmission;
    @SerializedName("transmission_position")
    public String transmissionPosition;
    @SerializedName("transmission_id")
    public String transmissionId;
    @SerializedName("fuel")
    public String fuel;
    @SerializedName("fuel_position")
    public String fuelPosition;
    @SerializedName("fuel_id")
    public String fuelId;
    public String getFuelId() {
        return this.fuelId;
    }
    public void setFuelId(String fuelId) {
        this.fuelId = fuelId;
    }
    public String getFuelPosition() {
        return this.fuelPosition;
    }
    public void setFuelPosition(String fuelPosition) {
        this.fuelPosition = fuelPosition;
    }
    public String getFuel() {
        return this.fuel;
    }
    public void setFuel(String fuel) {
        this.fuel = fuel;
    }
    public String getTransmissionId() {
        return this.transmissionId;
    }
    public void setTransmissionId(String transmissionId) {
        this.transmissionId = transmissionId;
    }
    public String getTransmissionPosition() {
        return this.transmissionPosition;
    }
    public void setTransmissionPosition(String transmissionPosition) {
        this.transmissionPosition = transmissionPosition;
    }
    public String getTransmission() {
        return this.transmission;
    }
    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }
    public String getRejectedComment() {
        return this.rejectedComment;
    }
    public void setRejectedComment(String rejectedComment) {
        this.rejectedComment = rejectedComment;
    }
    public String getConfigId() {
        return this.configId;
    }
    public void setConfigId(String configId) {
        this.configId = configId;
    }
    public String getMileage() {
        return this.mileage;
    }
    public void setMileage(String mileage) {
        this.mileage = mileage;
    }
    public String getMileageNotAvailable() {
        return this.mileageNotAvailable;
    }
    public void setMileageNotAvailable(String mileageNotAvailable) {
        this.mileageNotAvailable = mileageNotAvailable;
    }
    public String getTopPosition() {
        return this.topPosition;
    }
    public void setTopPosition(String topPosition) {
        this.topPosition = topPosition;
    }
    public String getBrandModel() {
        return this.brandModel;
    }
    public void setBrandModel(String brandModel) {
        this.brandModel = brandModel;
    }
    public String getBrand() {
        return this.brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getOriginalPrice() {
        return this.originalPrice;
    }
    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }
    public String getPrice() {
        return this.price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getPriceNotAvailable() {
        return this.priceNotAvailable;
    }
    public void setPriceNotAvailable(String priceNotAvailable) {
        this.priceNotAvailable = priceNotAvailable;
    }
    public String getUrlkeyDetails() {
        return this.urlkeyDetails;
    }
    public void setUrlkeyDetails(String urlkeyDetails) {
        this.urlkeyDetails = urlkeyDetails;
    }
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getIsCertified() {
        return this.isCertified;
    }
    public void setIsCertified(Integer isCertified) {
        this.isCertified = isCertified;
    }
    public String getOriginalPriceCurrency() {
        return this.originalPriceCurrency;
    }
    public void setOriginalPriceCurrency(String originalPriceCurrency) {
        this.originalPriceCurrency = originalPriceCurrency;
    }
    public String getAttributeSetId() {
        return this.attributeSetId;
    }
    public void setAttributeSetId(String attributeSetId) {
        this.attributeSetId = attributeSetId;
    }
    public String getIdCatalogConfig() {
        return this.idCatalogConfig;
    }
    public void setIdCatalogConfig(String idCatalogConfig) {
        this.idCatalogConfig = idCatalogConfig;
    }
    public String getSku() {
        return this.sku;
    }
    public void setSku(String sku) {
        this.sku = sku;
    }
    public String getShowMobile() {
        return this.showMobile;
    }
    public void setShowMobile(String showMobile) {
        this.showMobile = showMobile;
    }
    public String getShowHomephone() {
        return this.showHomephone;
    }
    public void setShowHomephone(String showHomephone) {
        this.showHomephone = showHomephone;
    }
    public String getShowOfficephone() {
        return this.showOfficephone;
    }
    public void setShowOfficephone(String showOfficephone) {
        this.showOfficephone = showOfficephone;
    }
    public String getSellerIsTrusted() {
        return this.sellerIsTrusted;
    }
    public void setSellerIsTrusted(String sellerIsTrusted) {
        this.sellerIsTrusted = sellerIsTrusted;
    }
    public String getIsAgent() {
        return this.isAgent;
    }
    public void setIsAgent(String isAgent) {
        this.isAgent = isAgent;
    }
    public String getFkCustomer() {
        return this.fkCustomer;
    }
    public void setFkCustomer(String fkCustomer) {
        this.fkCustomer = fkCustomer;
    }
    public String getProductOwner() {
        return this.productOwner;
    }
    public void setProductOwner(String productOwner) {
        this.productOwner = productOwner;
    }
    public String getProductOwnerUrlKey() {
        return this.productOwnerUrlKey;
    }
    public void setProductOwnerUrlKey(String productOwnerUrlKey) {
        this.productOwnerUrlKey = productOwnerUrlKey;
    }
    public String getAgencyName() {
        return this.agencyName;
    }
    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }
    public String getItemContactHomephone() {
        return this.itemContactHomephone;
    }
    public void setItemContactHomephone(String itemContactHomephone) {
        this.itemContactHomephone = itemContactHomephone;
    }
    public String getItemContactMobile() {
        return this.itemContactMobile;
    }
    public void setItemContactMobile(String itemContactMobile) {
        this.itemContactMobile = itemContactMobile;
    }
    public String getItemContactEmail() {
        return this.itemContactEmail;
    }
    public void setItemContactEmail(String itemContactEmail) {
        this.itemContactEmail = itemContactEmail;
    }
    public String getItemContactName() {
        return this.itemContactName;
    }
    public void setItemContactName(String itemContactName) {
        this.itemContactName = itemContactName;
    }
    public String getShowListingAddress() {
        return this.showListingAddress;
    }
    public void setShowListingAddress(String showListingAddress) {
        this.showListingAddress = showListingAddress;
    }
    public String getFkCountryRegionCityArea() {
        return this.fkCountryRegionCityArea;
    }
    public void setFkCountryRegionCityArea(String fkCountryRegionCityArea) {
        this.fkCountryRegionCityArea = fkCountryRegionCityArea;
    }
    public String getFkCountryRegionCity() {
        return this.fkCountryRegionCity;
    }
    public void setFkCountryRegionCity(String fkCountryRegionCity) {
        this.fkCountryRegionCity = fkCountryRegionCity;
    }
    public String getFkCountryRegion() {
        return this.fkCountryRegion;
    }
    public void setFkCountryRegion(String fkCountryRegion) {
        this.fkCountryRegion = fkCountryRegion;
    }
    public String getAgencyCity() {
        return this.agencyCity;
    }
    public void setAgencyCity(String agencyCity) {
        this.agencyCity = agencyCity;
    }
    public String getAgencyAddress() {
        return this.agencyAddress;
    }
    public void setAgencyAddress(String agencyAddress) {
        this.agencyAddress = agencyAddress;
    }
    public String getListingCity() {
        return this.listingCity;
    }
    public void setListingCity(String listingCity) {
        this.listingCity = listingCity;
    }
    public String getListingRegion() {
        return this.listingRegion;
    }
    public void setListingRegion(String listingRegion) {
        this.listingRegion = listingRegion;
    }
    public String getFkCustomerAddress() {
        return this.fkCustomerAddress;
    }
    public void setFkCustomerAddress(String fkCustomerAddress) {
        this.fkCustomerAddress = fkCustomerAddress;
    }
    public String getGooglePlaceId() {
        return this.googlePlaceId;
    }
    public void setGooglePlaceId(String googlePlaceId) {
        this.googlePlaceId = googlePlaceId;
    }
    public String getGoogleFormattedAddress() {
        return this.googleFormattedAddress;
    }
    public void setGoogleFormattedAddress(String googleFormattedAddress) {
        this.googleFormattedAddress = googleFormattedAddress;
    }
    public String getLocationLongitude() {
        return this.locationLongitude;
    }
    public void setLocationLongitude(String locationLongitude) {
        this.locationLongitude = locationLongitude;
    }
    public String getLocationLatitude() {
        return this.locationLatitude;
    }
    public void setLocationLatitude(String locationLatitude) {
        this.locationLatitude = locationLatitude;
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public Boolean getNewProduct() {
        return this.newProduct;
    }
    public void setNewProduct(Boolean newProduct) {
        this.newProduct = newProduct;
    }
    public String getAgencyLogo() {
        return this.agencyLogo;
    }
    public void setAgencyLogo(String agencyLogo) {
        this.agencyLogo = agencyLogo;
    }
    public String getRootCategory() {
        return this.rootCategory;
    }
    public void setRootCategory(String rootCategory) {
        this.rootCategory = rootCategory;
    }
    public String getOriginalName() {
        return this.originalName;
    }
    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }
    public String getAlternateSku() {
        return this.alternateSku;
    }
    public void setAlternateSku(String alternateSku) {
        this.alternateSku = alternateSku;
    }
    public String getPremiumListing() {
        return this.premiumListing;
    }
    public void setPremiumListing(String premiumListing) {
        this.premiumListing = premiumListing;
    }
    public String getPriceConditionsId() {
        return this.priceConditionsId;
    }
    public void setPriceConditionsId(String priceConditionsId) {
        this.priceConditionsId = priceConditionsId;
    }
    public String getPriceConditionsPosition() {
        return this.priceConditionsPosition;
    }
    public void setPriceConditionsPosition(String priceConditionsPosition) {
        this.priceConditionsPosition = priceConditionsPosition;
    }
    public String getWarrantyYearsId() {
        return this.warrantyYearsId;
    }
    public void setWarrantyYearsId(String warrantyYearsId) {
        this.warrantyYearsId = warrantyYearsId;
    }
    public String getWarrantyYearsPosition() {
        return this.warrantyYearsPosition;
    }
    public void setWarrantyYearsPosition(String warrantyYearsPosition) {
        this.warrantyYearsPosition = warrantyYearsPosition;
    }
    public String getWarrantyTypeId() {
        return this.warrantyTypeId;
    }
    public void setWarrantyTypeId(String warrantyTypeId) {
        this.warrantyTypeId = warrantyTypeId;
    }
    public String getWarrantyTypePosition() {
        return this.warrantyTypePosition;
    }
    public void setWarrantyTypePosition(String warrantyTypePosition) {
        this.warrantyTypePosition = warrantyTypePosition;
    }
    public String getEquipment() {
        return this.equipment;
    }
    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }
    public String getExterior() {
        return this.exterior;
    }
    public void setExterior(String exterior) {
        this.exterior = exterior;
    }
    public String getInterior() {
        return this.interior;
    }
    public void setInterior(String interior) {
        this.interior = interior;
    }
    public String getDriveTypeId() {
        return this.driveTypeId;
    }
    public void setDriveTypeId(String driveTypeId) {
        this.driveTypeId = driveTypeId;
    }
    public String getDriveTypePosition() {
        return this.driveTypePosition;
    }
    public void setDriveTypePosition(String driveTypePosition) {
        this.driveTypePosition = driveTypePosition;
    }
    public String getPower() {
        return this.power;
    }
    public void setPower(String power) {
        this.power = power;
    }
    public String getDoorsId() {
        return this.doorsId;
    }
    public void setDoorsId(String doorsId) {
        this.doorsId = doorsId;
    }
    public String getDoorsPosition() {
        return this.doorsPosition;
    }
    public void setDoorsPosition(String doorsPosition) {
        this.doorsPosition = doorsPosition;
    }
    public String getColorFamilyId() {
        return this.colorFamilyId;
    }
    public void setColorFamilyId(String colorFamilyId) {
        this.colorFamilyId = colorFamilyId;
    }
    public String getColorFamilyPosition() {
        return this.colorFamilyPosition;
    }
    public void setColorFamilyPosition(String colorFamilyPosition) {
        this.colorFamilyPosition = colorFamilyPosition;
    }
    public String getConditionId() {
        return this.conditionId;
    }
    public void setConditionId(String conditionId) {
        this.conditionId = conditionId;
    }
    public String getConditionPosition() {
        return this.conditionPosition;
    }
    public void setConditionPosition(String conditionPosition) {
        this.conditionPosition = conditionPosition;
    }
    public String getCondition() {
        return this.condition;
    }
    public void setCondition(String condition) {
        this.condition = condition;
    }
    public String getListingArea() {
        return this.listingArea;
    }
    public void setListingArea(String listingArea) {
        this.listingArea = listingArea;
    }
    public String getListingCountry() {
        return this.listingCountry;
    }
    public void setListingCountry(String listingCountry) {
        this.listingCountry = listingCountry;
    }
    public String getListingType() {
        return this.listingType;
    }
    public void setListingType(String listingType) {
        this.listingType = listingType;
    }
    public String getBrandModelEdition() {
        return this.brandModelEdition;
    }
    public void setBrandModelEdition(String brandModelEdition) {
        this.brandModelEdition = brandModelEdition;
    }
    public String getFkCatalogBrandModel() {
        return this.fkCatalogBrandModel;
    }
    public void setFkCatalogBrandModel(String fkCatalogBrandModel) {
        this.fkCatalogBrandModel = fkCatalogBrandModel;
    }
    public String getFkCatalogBrand() {
        return this.fkCatalogBrand;
    }
    public void setFkCatalogBrand(String fkCatalogBrand) {
        this.fkCatalogBrand = fkCatalogBrand;
    }
    public String getFkVertical() {
        return this.fkVertical;
    }
    public void setFkVertical(String fkVertical) {
        this.fkVertical = fkVertical;
    }
    public String getListingEnd() {
        return this.listingEnd;
    }
    public void setListingEnd(String listingEnd) {
        this.listingEnd = listingEnd;
    }
    public String getListingStart() {
        return this.listingStart;
    }
    public void setListingStart(String listingStart) {
        this.listingStart = listingStart;
    }
    public String getActivatedAt() {
        return this.activatedAt;
    }
    public void setActivatedAt(String activatedAt) {
        this.activatedAt = activatedAt;
    }
    public String getStatusSupplierConfig() {
        return this.statusSupplierConfig;
    }
    public void setStatusSupplierConfig(String statusSupplierConfig) {
        this.statusSupplierConfig = statusSupplierConfig;
    }
    public String getApproved() {
        return this.approved;
    }
    public void setApproved(String approved) {
        this.approved = approved;
    }
    public String getAttributeSetNameLocal() {
        return this.attributeSetNameLocal;
    }
    public void setAttributeSetNameLocal(String attributeSetNameLocal) {
        this.attributeSetNameLocal = attributeSetNameLocal;
    }
    public String getAttributeSetName() {
        return this.attributeSetName;
    }
    public void setAttributeSetName(String attributeSetName) {
        this.attributeSetName = attributeSetName;
    }
    public String getStatus() {
        return this.status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getFkCountry() {
        return this.fkCountry;
    }
    public void setFkCountry(String fkCountry) {
        this.fkCountry = fkCountry;
    }
    @Generated(hash = 830863811)
    public CarsData(String fkCountry, String status, String attributeSetName,
            String attributeSetNameLocal, String approved,
            String statusSupplierConfig, String activatedAt, String listingStart,
            String listingEnd, String fkVertical, String fkCatalogBrand,
            String fkCatalogBrandModel, String brandModelEdition,
            String listingType, String listingCountry, String listingArea,
            String condition, String conditionPosition, String conditionId,
            String colorFamilyPosition, String colorFamilyId, String doorsPosition,
            String doorsId, String power, String driveTypePosition,
            String driveTypeId, String interior, String exterior, String equipment,
            String warrantyTypePosition, String warrantyTypeId,
            String warrantyYearsPosition, String warrantyYearsId,
            String priceConditionsPosition, String priceConditionsId,
            String premiumListing, String alternateSku, String originalName,
            String rootCategory, String agencyLogo, Boolean newProduct, String url,
            String id, String locationLatitude, String locationLongitude,
            String googleFormattedAddress, String googlePlaceId,
            String fkCustomerAddress, String listingRegion, String listingCity,
            String agencyAddress, String agencyCity, String fkCountryRegion,
            String fkCountryRegionCity, String fkCountryRegionCityArea,
            String showListingAddress, String itemContactName,
            String itemContactEmail, String itemContactMobile,
            String itemContactHomephone, String agencyName,
            String productOwnerUrlKey, String productOwner, String fkCustomer,
            String isAgent, String sellerIsTrusted, String showOfficephone,
            String showHomephone, String showMobile, String sku,
            String idCatalogConfig, String attributeSetId,
            String originalPriceCurrency, Integer isCertified, String name,
            String description, String urlkeyDetails, String priceNotAvailable,
            String price, String originalPrice, String brand, String brandModel,
            String topPosition, String mileageNotAvailable, String mileage,
            String configId, String rejectedComment, String transmission,
            String transmissionPosition, String transmissionId, String fuel,
            String fuelPosition, String fuelId) {
        this.fkCountry = fkCountry;
        this.status = status;
        this.attributeSetName = attributeSetName;
        this.attributeSetNameLocal = attributeSetNameLocal;
        this.approved = approved;
        this.statusSupplierConfig = statusSupplierConfig;
        this.activatedAt = activatedAt;
        this.listingStart = listingStart;
        this.listingEnd = listingEnd;
        this.fkVertical = fkVertical;
        this.fkCatalogBrand = fkCatalogBrand;
        this.fkCatalogBrandModel = fkCatalogBrandModel;
        this.brandModelEdition = brandModelEdition;
        this.listingType = listingType;
        this.listingCountry = listingCountry;
        this.listingArea = listingArea;
        this.condition = condition;
        this.conditionPosition = conditionPosition;
        this.conditionId = conditionId;
        this.colorFamilyPosition = colorFamilyPosition;
        this.colorFamilyId = colorFamilyId;
        this.doorsPosition = doorsPosition;
        this.doorsId = doorsId;
        this.power = power;
        this.driveTypePosition = driveTypePosition;
        this.driveTypeId = driveTypeId;
        this.interior = interior;
        this.exterior = exterior;
        this.equipment = equipment;
        this.warrantyTypePosition = warrantyTypePosition;
        this.warrantyTypeId = warrantyTypeId;
        this.warrantyYearsPosition = warrantyYearsPosition;
        this.warrantyYearsId = warrantyYearsId;
        this.priceConditionsPosition = priceConditionsPosition;
        this.priceConditionsId = priceConditionsId;
        this.premiumListing = premiumListing;
        this.alternateSku = alternateSku;
        this.originalName = originalName;
        this.rootCategory = rootCategory;
        this.agencyLogo = agencyLogo;
        this.newProduct = newProduct;
        this.url = url;
        this.id = id;
        this.locationLatitude = locationLatitude;
        this.locationLongitude = locationLongitude;
        this.googleFormattedAddress = googleFormattedAddress;
        this.googlePlaceId = googlePlaceId;
        this.fkCustomerAddress = fkCustomerAddress;
        this.listingRegion = listingRegion;
        this.listingCity = listingCity;
        this.agencyAddress = agencyAddress;
        this.agencyCity = agencyCity;
        this.fkCountryRegion = fkCountryRegion;
        this.fkCountryRegionCity = fkCountryRegionCity;
        this.fkCountryRegionCityArea = fkCountryRegionCityArea;
        this.showListingAddress = showListingAddress;
        this.itemContactName = itemContactName;
        this.itemContactEmail = itemContactEmail;
        this.itemContactMobile = itemContactMobile;
        this.itemContactHomephone = itemContactHomephone;
        this.agencyName = agencyName;
        this.productOwnerUrlKey = productOwnerUrlKey;
        this.productOwner = productOwner;
        this.fkCustomer = fkCustomer;
        this.isAgent = isAgent;
        this.sellerIsTrusted = sellerIsTrusted;
        this.showOfficephone = showOfficephone;
        this.showHomephone = showHomephone;
        this.showMobile = showMobile;
        this.sku = sku;
        this.idCatalogConfig = idCatalogConfig;
        this.attributeSetId = attributeSetId;
        this.originalPriceCurrency = originalPriceCurrency;
        this.isCertified = isCertified;
        this.name = name;
        this.description = description;
        this.urlkeyDetails = urlkeyDetails;
        this.priceNotAvailable = priceNotAvailable;
        this.price = price;
        this.originalPrice = originalPrice;
        this.brand = brand;
        this.brandModel = brandModel;
        this.topPosition = topPosition;
        this.mileageNotAvailable = mileageNotAvailable;
        this.mileage = mileage;
        this.configId = configId;
        this.rejectedComment = rejectedComment;
        this.transmission = transmission;
        this.transmissionPosition = transmissionPosition;
        this.transmissionId = transmissionId;
        this.fuel = fuel;
        this.fuelPosition = fuelPosition;
        this.fuelId = fuelId;
    }
    @Generated(hash = 316270755)
    public CarsData() {
    }
}
