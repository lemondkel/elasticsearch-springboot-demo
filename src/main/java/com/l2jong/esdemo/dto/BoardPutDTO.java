package com.l2jong.esdemo.dto;

import com.l2jong.esdemo.es.document.Board;
import lombok.Data;

@Data
public class BoardPutDTO {
	private String title;
	private String content;

	public Board getBoard() {
		return Board.builder()
				.title(this.title)
				.content(this.content)
				.build();
	}
}
