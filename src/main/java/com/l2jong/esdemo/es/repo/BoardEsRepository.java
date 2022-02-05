package com.l2jong.esdemo.es.repo;

import com.l2jong.esdemo.es.document.Board;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BoardEsRepository extends ElasticsearchRepository<Board, String> {

}
