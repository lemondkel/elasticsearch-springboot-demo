package com.l2jong.esdemo.es.document;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Builder
@Data
@Document(indexName = "board")
public class Board {
	@Id
	@Field(type = FieldType.Text)
	private String id;
	@Field(type = FieldType.Text)
	private String title;
	@Field(type = FieldType.Text)
	private String content;
}
