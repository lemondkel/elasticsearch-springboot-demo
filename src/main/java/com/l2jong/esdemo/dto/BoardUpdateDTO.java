package com.l2jong.esdemo.dto;

import com.l2jong.esdemo.es.document.Board;
import lombok.Data;

@Data
public class BoardUpdateDTO {
	private String id;
	private String title;
	private String content;

	public Board getBoard() {
		return Board.builder()
				.id(id)
				.title(title)
				.content(content)
				.build();
	}
}
