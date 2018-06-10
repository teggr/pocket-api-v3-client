package com.robintegg.pocket.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tag {

	@JsonProperty("item_id")
	private String itemId;
	@JsonProperty("tag")
	private String tag;

	public String getItemId() {
		return itemId;
	}

	public String getTag() {
		return tag;
	}

}
