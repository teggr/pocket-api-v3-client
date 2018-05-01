package com.robintegg.pocket.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Search {

	@JsonProperty("search_type")
	private String searchType;

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

}
