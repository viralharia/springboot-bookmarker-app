package com.vharia.bookmarker_api;

import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
/*import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;*/

@TestConfiguration(proxyBeanMethods = false)
class TestcontainersConfiguration {

	/*@Bean
	@ServiceConnection
	PostgreSQLContainer<?> postgresContainer() {
		return new PostgreSQLContainer<>(DockerImageName.parse("postgres:latest"));
	}*/

}

//Execution default-cli of goal build-image failed: Connection to the Docker daemon failed with error "No such file or directory"; ensure the Docker daemon is running and accessible