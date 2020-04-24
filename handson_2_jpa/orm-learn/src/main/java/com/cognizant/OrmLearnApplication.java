package com.cognizant;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.model.Country;
import com.cognizant.model.Stock;
import com.cognizant.service.CountryNotFoundException;
import com.cognizant.service.CountryService;
import com.cognizant.service.StockService;

@SpringBootApplication
public class OrmLearnApplication {
	private static CountryService countryService;
	private static StockService stockService;
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	public static void main(String[] args) throws CountryNotFoundException {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		stockService = context.getBean(StockService.class);
		LOGGER.info("Inside main");
//		testGetAllCountries();
//		getAllCountriesTest();
//		testAddCountry();
//		testUpdateCountry();
//		testDeleteCountry();
		testFindByOrderBy();
		testFindByOrderByAlpha();
		testFindAllTillSep();
		testFindGoogle1250();
		testFindTop3ByOrderByVolumeDesc();
		testFindTop3ByCodeOrderByClose();
	}

	private static void testGetAllCountries() {
		LOGGER.info("Start");
		List<Country> countries = countryService.getAllCountries();
		LOGGER.debug("countries={}", countries);
		LOGGER.info("End");
	}

	private static void getAllCountriesTest() throws CountryNotFoundException {
		LOGGER.info("Start");
		Country country = countryService.findCountryByCode("AV");
		LOGGER.debug("Country:{}", country);
		LOGGER.info("End");
	}
	
	private static void testAddCountry() {
		LOGGER.info("Start");
		Country country = new Country();
		country.setCode("AV");
		country.setName("Avik Sarkar");
		countryService.addCountry(country);
		LOGGER.info("End");
	}
	
	private static void testUpdateCountry() throws CountryNotFoundException {
		LOGGER.info("Start");
		countryService.updateCountry("AV","AVIK");
		countryService.findCountryByCode("AV");
		LOGGER.info("End");
	}
	
	private static void testDeleteCountry() {
		LOGGER.info("Start");
		countryService.deleteCountry("AV");
		LOGGER.info("End");
	}
	
	private static void testFindByOrderBy() {
		LOGGER.info("Start");
		List<Country> countries = countryService.findByNameOrderBy("ou");
		LOGGER.debug("countries={}", countries);
		LOGGER.info("End");
	}
	
	private static void testFindByOrderByAlpha() {
		LOGGER.info("Start");
		List<Country> countries = countryService.findByAlphaOrderBy("Z");
		LOGGER.debug("countries={}", countries);
		LOGGER.info("End");
	}
	
	private static void testFindAllTillSep() {
		LOGGER.info("Start");
		List<Stock> findAllTillSep = stockService.findAllTillSep();
		LOGGER.debug("stocks={}", findAllTillSep);
		LOGGER.info("End");
	}
	private static void testFindGoogle1250() {
		LOGGER.info("Start");
		List<Stock> findGoogle1250 = stockService.findGoogle1250();
		LOGGER.debug("stocks={}", findGoogle1250);
		LOGGER.info("End");
	}
	private static void testFindTop3ByOrderByVolumeDesc() {
		LOGGER.info("Start");
		List<Stock> findTop3ByOrderByVolumeDesc = stockService.findTop3ByOrderByVolumeDesc();
		LOGGER.debug("stocks={}", findTop3ByOrderByVolumeDesc);
		LOGGER.info("End");
	}
	private static void testFindTop3ByCodeOrderByClose() {
		LOGGER.info("Start");
		List<Stock> findTop3ByCodeOrderByClose = stockService.findTop3ByCodeOrderByClose("FB");
		LOGGER.debug("stocks={}", findTop3ByCodeOrderByClose);
		LOGGER.info("End");
	}
}
