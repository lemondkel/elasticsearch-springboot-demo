package com.l2jong.esdemo.es.service;

import com.l2jong.esdemo.dto.BoardPutDTO;
import com.l2jong.esdemo.dto.BoardReadDTO;
import com.l2jong.esdemo.dto.BoardUpdateDTO;
import com.l2jong.esdemo.es.document.Board;
import com.l2jong.esdemo.es.repo.BoardEsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class BoardEsService {

	private final BoardEsRepository boardEsRepository;

	public List<BoardReadDTO> getAllBoards() {
		Iterator<Board> iterator = boardEsRepository.findAll().iterator();
		List<BoardReadDTO> result = new ArrayList<>();

		while (iterator.hasNext()) {
			Board item = iterator.next();
			result.add(new BoardReadDTO(item));
		}

		return result;
	}

	public void putBoard(BoardPutDTO paramDTO) {
		Board document = paramDTO.getBoard();
		boardEsRepository.save(document);
	}

	public void updateBoard(BoardUpdateDTO paramDTO) {
		Board document = paramDTO.getBoard();
		boardEsRepository.save(document);
	}

	public BoardReadDTO getBoard(String id) {
		Board document = boardEsRepository.findById(id).orElse(null);
		return new BoardReadDTO(Objects.requireNonNull(document));
	}

	public void deleteBoard(String id) {
		Board document = Board.builder().id(id).build();
		boardEsRepository.delete(document);
	}
}
