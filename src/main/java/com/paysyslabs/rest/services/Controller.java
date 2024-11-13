package com.paysyslabs.rest.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.paysyslabs.rest.entity.Customers;
import com.paysyslabs.rest.models.request.Request;
import com.paysyslabs.rest.repo.CustomersRepository;
import com.paysyslabs.rest.utils.Constants;

@RestController
@RequestMapping(path = Constants.BASI_PATH)
public class Controller {

	private static final Logger LOG = LoggerFactory.getLogger(Controller.class);

	@Autowired
	private CustomersRepository customersRepository;

	@RequestMapping(value = "/prevalidation", method = RequestMethod.POST)
	public ResponseEntity<Object> prevalidation(HttpServletRequest httpRequestData,
			@RequestBody Request preValidRequest) throws InterruptedException {

		LOG.info("prevalidation Request URI: {}", httpRequestData.getRequestURI());
		LOG.info("prevalidation Request Body: {}", preValidRequest);

		Customers customers = customersRepository.findByIban(preValidRequest.getIban());

		if (customers != null) {

			if (!customers.isCreditAllow()) {
				throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Credit Not Allowed");
			}

			else {

				Double creditLimit = Double.parseDouble(customers.getCreditLimit());
				LOG.info("creditLimit: {}", creditLimit);
				Double requestAmount = Double.parseDouble(preValidRequest.getAmount());
				LOG.info("requestAmount: {}", requestAmount);

				if (requestAmount > creditLimit) {
					throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "Credit Limit Exceeds");
				}

				return new ResponseEntity<>(customers, HttpStatus.OK);
			}

		} else {

			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Iban");

		}

	}

	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public ResponseEntity<Object> payment(HttpServletRequest httpRequestData, @RequestBody Request paymentRequest) {

		LOG.info("payment Request URI: {}", httpRequestData.getRequestURI());
		LOG.info("payment Request Body: {}", paymentRequest);

		Customers customers = customersRepository.findByIban(paymentRequest.getIban());

		if (customers != null) {

			if (!customers.isCreditAllow()) {
				throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Credit Not Allowed");
			}

			else {

				Double creditLimit = Double.parseDouble(customers.getCreditLimit());
				LOG.info("creditLimit: {}", creditLimit);
				Double requestAmount = Double.parseDouble(paymentRequest.getAmount());
				LOG.info("requestAmount: {}", requestAmount);

				if (requestAmount > creditLimit) {
					throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "Credit Limit Exceeds");
				}

				if (!customers.isCreditSuccess()) {
					throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Exception");
				}
				
				if (customers.isCreditTimeout()) {
					throw new ResponseStatusException(HttpStatus.REQUEST_TIMEOUT, "Timeout");
				}

				return new ResponseEntity<>(customers, HttpStatus.OK);
			}

		} else {

			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Iban");

		}

	}

	@RequestMapping(value = "/paymentInquiry", method = RequestMethod.POST)
	public ResponseEntity<Object> paymentInquiry(HttpServletRequest httpRequestData,
			@RequestBody Request paymentInquiryRequest) {

		LOG.info("payment Request URI: {}", httpRequestData.getRequestURI());
		LOG.info("payment Request Body: {}", paymentInquiryRequest);

		Customers customers = customersRepository.findByIban(paymentInquiryRequest.getIban());

		if (customers != null) {

			if (!customers.isCreditInquirySuccess()) {
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Exception");
			}
			
			if (customers.isCreditInquiryTimeout()) {
				throw new ResponseStatusException(HttpStatus.REQUEST_TIMEOUT, "Timeout");
			}

			return new ResponseEntity<>(customers, HttpStatus.OK);

		} else {

			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Iban");

		}

	}

	public static String isoDateTime() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		String strDate = df.format(date);
		return strDate;

	}
}
