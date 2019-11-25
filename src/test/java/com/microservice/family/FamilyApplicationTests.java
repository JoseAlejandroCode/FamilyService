package com.microservice.family;

import com.microservice.family.model.dto.FamilyDto;
import com.microservice.family.service.FamilyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class FamilyApplicationTests {

	@Autowired
	private WebTestClient testClient;

	@Autowired
	private FamilyService familyService;

	@Test
	public void getAllTest() {
		testClient.get()
						.uri("api/family")
						.accept(MediaType.APPLICATION_JSON)
						.exchange()
						.expectStatus().isOk()
						.expectHeader().contentType(MediaType.APPLICATION_JSON)
						.expectBodyList(FamilyDto.class)
						.consumeWith(response -> {
							List<FamilyDto> familys = response.getResponseBody();
							familys.forEach(family -> System.out.println(family.getFullName()));
						});
	}

}
