package com.l2jong.esdemo.dto;

import com.l2jong.esdemo.es.document.Board;
import lombok.Data;

@Data
public class BoardReadDTO {
	private String id;
	private String title;
	private String content;

	public BoardReadDTO(Board item) {
		this.id = item.getId();
		this.title = item.getTitle();
		this.content = item.getContent();
	}
}
