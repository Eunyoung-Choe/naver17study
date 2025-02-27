package data.service;

import java.util.List;

import org.springframework.stereotype.Service;

import data.dto.BoardFileDto;
import data.mapper.BoardFileMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BoardFileService {	
	BoardFileMapper fileMapper;
	
	public void insertBoardFile(BoardFileDto dto)
	{
		fileMapper.insertBoardFile(dto);
	}
	
	public List<BoardFileDto> getFiles(int idx)
	{
		return fileMapper.getFiles(idx);
	}
	
	public void deleteFile(int num) // void로 선언하는 건 무슨 경우지
	{
		fileMapper.deleteFile(num);
	}
	
	public String getFilename(int num)
	{
		return fileMapper.getFilename(num);
	}
}
