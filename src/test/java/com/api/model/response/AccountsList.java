package com.api.model.response;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class AccountsList {

	public static List<AccountResponse> parseAccounts(String jsonString) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule()); // Handles LocalDateTime

		return mapper.readValue(jsonString, new TypeReference<List<AccountResponse>>() {
		});
	}

}
