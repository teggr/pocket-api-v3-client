package com.robintegg.pocket.web;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.robintegg.pocket.data.PocketData;

public class PocketDataTest {

	@Test
	public void shouldBeDeserialisedFromJSON() throws JsonParseException, JsonMappingException, IOException {
		
		// given
		ClassPathResource exampleJson = new ClassPathResource("/example.json");
		ObjectMapper objectMapper = new ObjectMapper();
		
		// when
		PocketData pocketData = objectMapper.readValue(exampleJson.getInputStream(), PocketData.class);

		// then
		assertEquals(1, pocketData.getStatus());
		assertEquals("1524746426", pocketData.getList().get("1517871677").getTimeAdded());

	}

}
