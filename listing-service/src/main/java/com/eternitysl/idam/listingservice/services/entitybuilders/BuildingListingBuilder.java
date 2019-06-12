package com.eternitysl.idam.listingservice.services.entitybuilders;

import com.eternitysl.idam.listingservice.dto.listing.building.BuildingListingInboundDTO;
import com.eternitysl.idam.listingservice.dto.listing.building.BuildingRentalInboundDTO;
import com.eternitysl.idam.listingservice.entities.listings.BuildingListing;
import com.eternitysl.idam.listingservice.entities.listings.buildinglisting.BuildingRental;
import com.eternitysl.idam.listingservice.entities.listings.buildinglisting.BuildingSellingType;
import com.eternitysl.idam.listingservice.services.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingListingBuilder {

    @Autowired
    private  AvailabilityService availabilityService;

    public BuildingRental createBuildingRental(BuildingRentalInboundDTO buildingRentalInboundDTO){
        BuildingRental buildingRental = new BuildingRental();
        buildingRental.setBillsIncluded(buildingRentalInboundDTO.isBillsIncluded());
        buildingRental.setMinimumTerm(buildingRentalInboundDTO.getMinimumTerm());
        buildingRental.setMinTermUnit(buildingRentalInboundDTO.getMinTermUnit());
        buildingRental.setDepositCount(buildingRentalInboundDTO.getDepositCount());
        buildingRental.setDepositUnit(buildingRentalInboundDTO.getDepositUnit());

        return buildingRental;
    }

    public BuildingListing createBuildingListing(BuildingListingInboundDTO buildingListingInboundDTO){
        BuildingListing buildingListing = new BuildingListing();
        buildingListing.setRoomCount(buildingListingInboundDTO.getRoomCount());
        buildingListing.setBathroomCount(buildingListingInboundDTO.getBathroomCount());
        buildingListing.setFloorArea(buildingListing.getFloorArea());
        buildingListing.setFloorAreaUnit(buildingListingInboundDTO.getFloorAreaUnit());
        buildingListing.setFloorCount(buildingListingInboundDTO.getFloorCount());
        buildingListing.setLandArea(buildingListingInboundDTO.getLandArea());
        buildingListing.setLandAreaUnit(buildingListingInboundDTO.getLandAreaUnit());
        buildingListing.setFloorAreaUnit(buildingListingInboundDTO.getFloorAreaUnit());
        buildingListing.setTrainDistance(buildingListingInboundDTO.getTrainDistance());
        buildingListing.setTrainDistanceUnit(buildingListingInboundDTO.getTrainDistanceUnit());
        buildingListing.setBusStopDistance(buildingListingInboundDTO.getBusStopDistance());
        buildingListing.setBusStopDistanceUnit(buildingListingInboundDTO.getBusStopDistanceUnit());
        buildingListing.setTrainDistanceUnit(buildingListingInboundDTO.getBusStopDistanceUnit());
        buildingListing.setAvailability(availabilityService.getAvailabilityType(buildingListingInboundDTO.getAvailability()));
        buildingListing.setBuildingFeature(buildingListingInboundDTO.getBuildingFeature());
        buildingListing.setBuildingSellingType(BuildingSellingType.fromValue(buildingListingInboundDTO.getBuildingSellingType()));
        if(buildingListingInboundDTO.getBuildingRental()!=null) {
            buildingListing.setBuildingRental(createBuildingRental(buildingListingInboundDTO.getBuildingRental()));
        }

        return buildingListing;

    }
}
