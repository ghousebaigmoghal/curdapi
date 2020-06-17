package com.people10.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.people10.exceptionhandler.ExceptionResponse;
import com.people10.model.Customer;
import com.people10.model.CustomerEntity;
import com.people10.service.ReservationService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
class ReservationControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private ReservationService reservationService;

	private String exampleCustomer = "{" + "    \"firstName\": \"GhouseBeig\","
			+ "    \"lastName\": \"Moghal\"," + "    \"birthDate\": \"2020-06-17\","
			+ "    \"email\": \"ghousebegmogal@gmail.com\"," + "    \"password\": \"gouse@8365\"" + "}";

	@Before
	void before() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@Order(1)
	void test_for_user_creation() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/customers").accept(MediaType.APPLICATION_JSON)
				.content(exampleCustomer).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println("Result : " + result.getResponse().getStatus());
		assertEquals(HttpStatus.CREATED.value(), result.getResponse().getStatus());
	}

	@Test
	@Order(2)
	void test_for_user_email_already_exists() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/customers").accept(MediaType.APPLICATION_JSON)
				.content(exampleCustomer).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(HttpStatus.BAD_REQUEST.value(), result.getResponse().getStatus());
	}

	@Test
	@Order(3)
	void test_for_password_validation() throws Exception {
		String customerPasswordFails = exampleCustomer.replace("gouse@8365", "gouse@83651");
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/customers").accept(MediaType.APPLICATION_JSON)
				.content(customerPasswordFails).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(HttpStatus.BAD_REQUEST.value(), result.getResponse().getStatus());
	}

	@Test
	@Order(4)
	public void retrieveDetailsOfExistingCustomer() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/customers/1")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
	}

	@Test
	@Order(5)
	public void retrieveDetailsOfNonExistingCustomer() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/customers/99999")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(HttpStatus.NOT_FOUND.value(), result.getResponse().getStatus());
	}

	@Test
	public void customerPOJOTest() {
		Customer customer = new Customer();
		customer.setFirstName("GhouseBeig");
		customer.setLastName("Moghal");
		customer.setBirthDate(LocalDate.now());
		customer.setEmail("ghousebegmogal@gmail.com");
		customer.setPassword("ghouse_beig_password");
		assertEquals("GhouseBeig", customer.getFirstName());
		assertEquals("Moghal", customer.getLastName());
		assertEquals(LocalDate.now(), customer.getBirthDate());
		assertEquals("ghousebegmogal@gmail.com", customer.getEmail());
		assertEquals("ghouse_beig_password", customer.getPassword());
	}
	
	@Test
	public void customerEntitiyPOJOTest() {
		CustomerEntity customer = new CustomerEntity();
		customer.setId(1l);
		customer.setFirstName("GhouseBeig");
		customer.setLastName("Moghal");
		customer.setBirthDate(LocalDate.now());
		customer.setEmail("ghousebegmogal@gmail.com");
		customer.setPassword("ghouse_beig_password");
		assertEquals(1l, customer.getId());
		assertEquals("GhouseBeig", customer.getFirstName());
		assertEquals("Moghal", customer.getLastName());
		assertEquals(LocalDate.now(), customer.getBirthDate());
		assertEquals("ghousebegmogal@gmail.com", customer.getEmail());
		assertEquals("ghouse_beig_password", customer.getPassword());
	}
	
	@Test
	public void exceptionResponsePojoTest() {
		ExceptionResponse exceptionResponse =  new ExceptionResponse("Dummy_Message", "200");
		assertEquals("Dummy_Message", exceptionResponse.getMessage());
		assertEquals("200", exceptionResponse.getStatusCode());
		exceptionResponse.setMessage("Dummy_Message1");
		exceptionResponse.setStatusCode("404");
		assertEquals("Dummy_Message1", exceptionResponse.getMessage());
		assertEquals("404", exceptionResponse.getStatusCode());
	}
	
	

}
