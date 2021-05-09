package kr.co.mlec.login.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import kr.co.mlec.login.dao.LoginDAO;
import kr.co.mlec.member.vo.MemberVO;

@Service
public class LoginServiceInter implements LoginService{
	
	@Autowired
	private LoginDAO dao;
	private String SAVE_FOLDER = "C:\\Users\\bit\\Desktop\\SP_1.2\\SP\\src\\main\\webapp\\resources\\assets\\profileImg";
	private String SAVE_PATH = "C:\\Users\\bit\\Desktop\\SP_1.2\\SP\\src\\main\\webapp\\resources\\assets\\profileImg\\";
	
	@Override
	@Transactional
	public void addMember(MemberVO vo, MultipartFile file){
		System.out.println("서비스넘어옴");
		if(file.getOriginalFilename()!="") {	
			System.out.println("if문 걸림");
		try {
			System.out.println("트라이크캐치문 진입");
			String originalFileName=file.getOriginalFilename(); //오리지날 파일이름
			System.out.println("확장자 찾기전");
			String extName =originalFileName.substring(originalFileName.lastIndexOf("."),originalFileName.length()); //확장자명 찾기
			System.out.println("확장자 찾기후");

			Long size = file.getSize();
			String saveFileName = genSaveFileName(extName,vo.getId());
			System.out.println("세이브파일 함수 끝");	
			writeFile(file,saveFileName);
			System.out.println("라이트 함수 끝");
			vo.setThum(saveFileName);
		
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
		dao.addmember(vo);

}
	public int searchId(String id) {
		int num=dao.searchId(id);
		return num;
	}
	
	@Override
	public int searchPwd(Map<String, String> map) {
		int num= dao.searchPwd(map);
		return num;
	}
	@Override
	public int searchName(String name) {
		int num=dao.searchName(name);
		return num;
	}
	public MemberVO login(MemberVO vo) {
		MemberVO result = dao.login(vo);		
		return result;
	}
	
	@Override
	public void changePwd(Map<String, String> map) {
		dao.updatePwd(map);
		
	}
	
	@Override
	public void changeMyinfo(MemberVO vo) {
		dao.updateMyinfo(vo);
		
	}
	private void writeFile(MultipartFile file,String saveFileName) throws IOException{
		File Folder = new File(SAVE_FOLDER);
		if(!Folder.exists()) {
			try {
				Folder.mkdir();
				System.out.println("폴더생성완료");
			}catch (Exception e) {
				e.getStackTrace();
			}
		}else {
			System.out.println("이미 폴더가 생성되었습니다.");
		}
		
		byte[] data = file.getBytes();
		FileOutputStream fos = new FileOutputStream(SAVE_PATH+saveFileName);
		fos.write(data);
		fos.close();
	}
	
	private String genSaveFileName(String extName ,String id) {
		Calendar calendar = Calendar.getInstance();
		String fileName="";
		fileName=id+",";
		fileName += calendar.get(Calendar.YEAR);
		fileName += calendar.get(Calendar.MONTH);
		fileName += calendar.get(Calendar.DATE);
		fileName += calendar.get(Calendar.HOUR);
		fileName += calendar.get(Calendar.MINUTE);
		fileName += calendar.get(Calendar.SECOND);
		fileName += calendar.get(Calendar.MILLISECOND);
		fileName += extName;
		System.out.println(fileName);
		return fileName;
	}	
	
	
}
