package com.gdu.app11.batch;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gdu.app11.domain.AttachDTO;
import com.gdu.app11.mapper.UploadMapper;
import com.gdu.app11.util.MyFileUtil;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@EnableScheduling
@Component
public class RemoveWrongfileScheduler {

	//field
	private MyFileUtil myFileUtil;
	private UploadMapper uploadMapper;
	
	@Scheduled(cron="0 54 17 1/1 * ?") 
	public void execute() {
		// 어제 업로드 된 첨부 파일들의 정보 
		List<AttachDTO> attachList = uploadMapper.getAttachListInYesterday();
		
		//List<AttachDTO> -> List<Path> 로 변환하기 )(Path : 경로
		List<Path> pathList = null;
		if(attachList != null && attachList.isEmpty() == false) {
			pathList = new ArrayList<Path>();
			for(AttachDTO attachDTO : attachList) {
				pathList.add(new File(attachDTO.getPath(), attachDTO.getFilesystemName()).toPath());
				
				if(attachDTO.getHasThumbnail() == 1) {
					pathList.add(new File(attachDTO.getPath(), "s_" + attachDTO.getFilesystemName()).toPath());
				}
			}
		}
		
		//어제 업로드 된 경로 
		String yesterdayPath = myFileUtil.getYesterdayPath();
		
		//어제 업로드 된 파일 목록(HDD에서 확인)
		File dir = new File(yesterdayPath);
		File[] wrongFiles = dir.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				
				return pathList.contains(new File(dir, name).toPath()) == false;
			}
		});
		
		//File[] wrongFiles 모두삭제
		if(wrongFiles != null && wrongFiles.length != 0) {
			for(File wrongFile : wrongFiles) {
				wrongFile.delete();
			}
		}
		
		
	}
}
