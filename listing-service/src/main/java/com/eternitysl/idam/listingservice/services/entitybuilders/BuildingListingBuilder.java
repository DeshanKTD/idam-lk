package com.eternitysl.idam.listingservice.services.entitybuilders;

import com.eternitysl.idam.listingservice.dto.availability.AvailabilitySummaryDTO;
import com.eternitysl.idam.listingservice.dto.listing.building.BuildingListingInboundDTO;
import com.eternitysl.idam.listingservice.dto.listing.building.BuildingListingOutboundDTO;
import com.eternitysl.idam.listingservice.dto.listing.building.BuildingRentalInboundDTO;
import com.eternitysl.idam.listingservice.dto.listing.building.BuildingRentalOutboundDTO;
import com.eternitysl.idam.listingservice.entities.listings.BuildingListing;
import com.eternitysl.idam.listingservice.entities.listings.buildinglisting.BuildingFeature;
import com.eternitysl.idam.listingservice.entities.listings.buildinglisting.BuildingRental;
import com.eternitysl.idam.listingservice.entities.listings.buildinglisting.BuildingSellingType;
import com.eternitysl.idam.listingservice.services.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingListingBuilder {

    @Autowired
    private AvailabilityService availabilityService;

    public BuildingRental createBuildingRentalFromInboundDTO(BuildingRentalInboundDTO buildingRentalInboundDTO) {
        BuildingRental buildingRental = new BuildingRental();
        buildingRental.setBillsIncluded(buildingRentalInboundDTO.isBillsIncluded());
        buildingRental.setMinimumTerm(buildingRentalInboundDTO.getMinimumTerm());
        buildingRental.setMinTermUnit(buildingRentalInboundDTO.getMinTermUnit());
        buildingRental.setDepositCount(buildingRentalInboundDTO.getDepositCount());
        buildingRental.setDepositUnit(buildingRentalInboundDTO.getDepositUnit());

        return buildingRental;
    }

    public BuildingListing createBuildingListingFromInboundDTO(BuildingListingInboundDTO buildingListingInboundDTO) {
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
        buildingListing.setBuildingSellingType(BuildingSellingType.fromValue(buildingListingInboundDTO.getBuildingSellingType()));

        BuildingFeature buildingFeature = buildingListingInboundDTO.getBuildingFeature();
        buildingFeature.setBuildingListing(buildingListing);
        buildingListing.setBuildingFeature(buildingFeature);


        if (buildingListingInboundDTO.getBuildingRental() != null) {
            BuildingRental buildingRental = createBuildingRentalFromInboundDTO(buildingListingInboundDTO.getBuildingRental());
            buildingRental.setBuildingListing(buildingListing);
            buildingListing.setBuildingRental(buildingRental);
        }

        return buildingListing;

    }

    public BuildingRentalOutboundDTO createOutboundDTOFromBuildingRental(BuildingRental buildingRental){
        BuildingRentalOutboundDTO buildingRentalOutboundDTO = new BuildingRentalOutboundDTO();
        buildingRentalOutboundDTO.setMinimumTerm(buildingRental.getMinimumTerm());
        buildingRentalOutboundDTO.setMinTermUnit(buildingRental.getMinTermUnit());
        buildingRentalOutboundDTO.setBillsIncluded(buildingRental.isBillsIncluded());
        buildingRentalOutboundDTO.setDepositCount(buildingRental.getDepositCount());
        buildingRentalOutboundDTO.setDepositUnit(buildingRental.getDepositUnit());

        return buildingRentalOutboundDTO;

    }

    public BuildingListingOutboundDTO createOutboundDTOFromBuidingListing(BuildingListing buildingListing){
        BuildingListingOutboundDTO buildingListingOutboundDTO = new BuildingListingOutboundDTO();
        buildingListingOutboundDTO.setRoomCount(buildingListing.getRoomCount());
        buildingListingOutboundDTO.setBathroomCount(buildingListing.getBathroomCount());
        buildingListingOutboundDTO.setFloorArea(buildingListing.getFloorArea());
        buildingListingOutboundDTO.setFloorAreaUnit(buildingListing.getFloorAreaUnit());
        buildingListingOutboundDTO.setFloorCount(buildingListing.getFloorCount());
        buildingListingOutboundDTO.setLandArea(buildingListing.getLandArea());
        buildingListingOutboundDTO.setLandAreaUnit(buildingListing.getLandAreaUnit());
        buildingListingOutboundDTO.setTrainDistance(buildingListing.getTrainDistance());
        buildingListingOutboundDTO.setTrainDistanceUnit(buildingListing.getTrainDistanceUnit());
        buildingListingOutboundDTO.setBusStopDistance(buildingListing.getBusStopDistance());
        buildingListingOutboundDTO.setTrainDistanceUnit(buildingListing.getTrainDistanceUnit());
        buildingListingOutboundDTO.setCreatedAt(buildingListing.getCreatedAt());
        buildingListingOutboundDTO.setAvailability(AvailabilitySummaryDTO.populate(buildingListing.getAvailability()));
        buildingListingOutboundDTO.setBuildingSellingType(buildingListing.getBuildingSellingType());
        buildingListingOutboundDTO.setBuildingFeature(buildingListing.getBuildingFeature());
        if(buildingListing.getBuildingRental()!=null){
            buildingListingOutboundDTO.setBuildingRental(
                    createOutboundDTOFromBuildingRental(buildingListing.getBuildingRental())
            );
        }

        return buildingListingOutboundDTO;
    }
}
