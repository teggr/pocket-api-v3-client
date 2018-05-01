package com.robintegg.pocket.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PocketItem {

	@JsonProperty("item_id")
	private String itemId;
	@JsonProperty("resolved_id")
	private String resolvedId;
	@JsonProperty("given_url")
	private String givenUrl;
	@JsonProperty("given_title")
	private String givenTitle;
	@JsonProperty("favorite")
	private String favorite;
	@JsonProperty("status")
	private String status;
	@JsonProperty("time_added")
	private String timeAdded;
	@JsonProperty("time_updated")
	private String timeUpdated;
	@JsonProperty("time_read")
	private String timeRead;
	@JsonProperty("time_favorited")
	private String timeFavorited;
	@JsonProperty("sort_id")
	private int sortId;
	@JsonProperty("resolved_title")
	private String resolvedTitle;
	@JsonProperty("resolved_url")
	private String resolvedUrl;
	@JsonProperty("excerpt")
	private String excerpt;
	@JsonProperty("is_article")
	private String article;
	@JsonProperty("is_index")
	private String index;
	@JsonProperty("has_video")
	private String video;
	@JsonProperty("has_image")
	private String image;
	@JsonProperty("word_count")
	private String wordCount;
	@JsonProperty("top_image_url")
	private String topImageUrl;

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getResolvedId() {
		return resolvedId;
	}

	public void setResolvedId(String resolvedId) {
		this.resolvedId = resolvedId;
	}

	public String getGivenUrl() {
		return givenUrl;
	}

	public void setGivenUrl(String givenUrl) {
		this.givenUrl = givenUrl;
	}

	public String getGivenTitle() {
		return givenTitle;
	}

	public void setGivenTitle(String givenTitle) {
		this.givenTitle = givenTitle;
	}

	public String getFavorite() {
		return favorite;
	}

	public void setFavorite(String favorite) {
		this.favorite = favorite;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTimeAdded() {
		return timeAdded;
	}

	public void setTimeAdded(String timeAdded) {
		this.timeAdded = timeAdded;
	}

	public String getTimeUpdated() {
		return timeUpdated;
	}

	public void setTimeUpdated(String timeUpdated) {
		this.timeUpdated = timeUpdated;
	}

	public String getTimeRead() {
		return timeRead;
	}

	public void setTimeRead(String timeRead) {
		this.timeRead = timeRead;
	}

	public String getTimeFavorited() {
		return timeFavorited;
	}

	public void setTimeFavorited(String timeFavorited) {
		this.timeFavorited = timeFavorited;
	}

	public int getSortId() {
		return sortId;
	}

	public void setSortId(int sortId) {
		this.sortId = sortId;
	}

	public String getResolvedTitle() {
		return resolvedTitle;
	}

	public void setResolvedTitle(String resolvedTitle) {
		this.resolvedTitle = resolvedTitle;
	}

	public String getResolvedUrl() {
		return resolvedUrl;
	}

	public void setResolvedUrl(String resolvedUrl) {
		this.resolvedUrl = resolvedUrl;
	}

	public String getExcerpt() {
		return excerpt;
	}

	public void setExcerpt(String excerpt) {
		this.excerpt = excerpt;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getWordCount() {
		return wordCount;
	}

	public void setWordCount(String wordCount) {
		this.wordCount = wordCount;
	}

	public String getTopImageUrl() {
		return topImageUrl;
	}

	public void setTopImageUrl(String topImageUrl) {
		this.topImageUrl = topImageUrl;
	}

}
