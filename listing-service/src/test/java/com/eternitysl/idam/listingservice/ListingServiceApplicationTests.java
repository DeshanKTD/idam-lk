package com.eternitysl.idam.listingservice;

import com.eternitysl.idam.listingservice.controller.AvailabilityController;
import com.eternitysl.idam.listingservice.controller.ListingSubTypeController;
import com.eternitysl.idam.listingservice.controller.ListingTypeController;
import com.eternitysl.idam.listingservice.controller.PriceRateController;
import com.eternitysl.idam.listingservice.entities.Availability;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ListingServiceApplicationTests {


	@Autowired
	AvailabilityController availabilityController;

	@Autowired
	ListingSubTypeController listingSubTypeController;

	@Autowired
	ListingTypeController listingTypeController;

	@Autowired
	PriceRateController priceRateController;

	@Test
	public void contextLoads() {
		boolean notNull = availabilityController!=null &&
				listingSubTypeController!=null &&
				listingTypeController!=null &&
				priceRateController!=null;

		Assert.assertTrue(notNull);
	}

}
