package com.robintegg.pocket.data;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PocketData {

	@JsonProperty("status")
	private int status;
	@JsonProperty("complete")
	private int complete;
	@JsonProperty("list")
	private Map<String, PocketItem> list = new HashMap<>();
	@JsonProperty("error")
	private String error;
	@JsonProperty("search_meta")
	private Search searchMeta;
	@JsonProperty("since")
	private long since;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getComplete() {
		return complete;
	}

	public void setComplete(int complete) {
		this.complete = complete;
	}

	public Map<String, PocketItem> getList() {
		return list;
	}

	public void setList(Map<String, PocketItem> list) {
		this.list = list;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Search getSearchMeta() {
		return searchMeta;
	}

	public void setSearchMeta(Search searchMeta) {
		this.searchMeta = searchMeta;
	}

	public long getSince() {
		return since;
	}

	public void setSince(long since) {
		this.since = since;
	}

}
