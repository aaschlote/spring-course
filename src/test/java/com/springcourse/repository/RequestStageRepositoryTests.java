package com.springcourse.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springcourse.domain.Request;
import com.springcourse.domain.RequestStage;
import com.springcourse.domain.User;
import com.springcourse.domain.enums.RequestState;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class RequestStageRepositoryTests {

	@Autowired
	private RequestStageRepository requestStageRepository;

	@Test
	public void AsaveTest() {
		User owner = new User();
		owner.setId(1l);

		Request request = new Request();
		request.setId(1l);

		RequestStage requestStage = new RequestStage(null, "Foi comprado um novo laptop", new Date(),
				RequestState.CLOSED, request, owner);

		RequestStage createdRequestStage = requestStageRepository.save(requestStage);

		assertThat(createdRequestStage.getId()).isEqualTo(1l);
	}

	@Test
	public void getByIdTest() {
		
		Optional<RequestStage> result = requestStageRepository.findById(1l);
		
		RequestStage requestStage = result.get();
		
		assertThat(requestStage.getDescription()).isEqualTo("Foi comprado um novo laptop");

	}

	@Test
	public void listByRequestIdTest() {

		List<RequestStage> stages = requestStageRepository.findAllByRequestId(1l);
		assertThat(stages.size()).isEqualTo(1);
		
	}

}
