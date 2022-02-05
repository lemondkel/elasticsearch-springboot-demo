package com.l2jong.esdemo.controller;

import com.l2jong.esdemo.common.AjaxResult;
import com.l2jong.esdemo.dto.BoardPutDTO;
import com.l2jong.esdemo.dto.BoardReadDTO;
import com.l2jong.esdemo.dto.BoardUpdateDTO;
import com.l2jong.esdemo.es.service.BoardEsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/board")
@RequiredArgsConstructor
@RestController
public class BoardController {

	private final BoardEsService boardEsService;

	@GetMapping("")
	public AjaxResult<List<BoardReadDTO>> getAllBoards() {
		AjaxResult<List<BoardReadDTO>> result;

		try {
			List<BoardReadDTO> boardList = boardEsService.getAllBoards();
			result = new AjaxResult<>(true, 200, "Success");
			result.setData(boardList);
		} catch (Exception e) {
			result = new AjaxResult<>(false, 500, "ES error");
		}

		return result;
	}

	@GetMapping("{id}")
	public AjaxResult<BoardReadDTO> getAllBoards(@PathVariable("id") String id) {
		AjaxResult<BoardReadDTO> result;

		try {
			BoardReadDTO board = boardEsService.getBoard(id);
			result = new AjaxResult<>(true, 200, "Success");
			result.setData(board);
		} catch (Exception e) {
			result = new AjaxResult<>(false, 500, "ES error");
		}

		return result;
	}

	@PutMapping("")
	public AjaxResult<Object> putBoard(@RequestBody BoardPutDTO paramDTO) {
		AjaxResult<Object> result;

		try {
			boardEsService.putBoard(paramDTO);
			result = new AjaxResult<>(true, 200, "Success");
		} catch (Exception e) {
			result = new AjaxResult<>(false, 500, "ES error");
		}

		return result;
	}

	@PostMapping("/{id}")
	public AjaxResult<Object> updateBoard(@PathVariable("id") String id, @RequestBody BoardUpdateDTO paramDTO) {
		AjaxResult<Object> result;

		try {
			paramDTO.setId(id);
			boardEsService.updateBoard(paramDTO);
			result = new AjaxResult<>(true, 200, "Success");
		} catch (Exception e) {
			result = new AjaxResult<>(false, 500, "ES error");
		}

		return result;
	}

	@DeleteMapping("/{id}")
	public AjaxResult<Object> deleteBoard(@PathVariable("id") String id) {
		AjaxResult<Object> result;

		try {
			boardEsService.deleteBoard(id);
			result = new AjaxResult<>(true, 200, "Success");
		} catch (Exception e) {
			result = new AjaxResult<>(false, 500, "ES error");
		}

		return result;
	}
}
