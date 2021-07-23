package com.qbang.emojidiary.implement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

import com.qbang.emojidiary.domain.DateVO;

@Service("TransformService")
public class TransformService {
	public final String[] img = {"resources/img/best.svg", "resources/img/happy.svg", "resources/img/soso.svg",
			"resources/img/sad.svg", "resources/img/angry.svg"};
	
	public Map<Integer, Object> numToURL(List<DateVO> list, int date){
		Map<Integer, Object> map = new HashMap<Integer, Object>();
		// map�� ������ �־��ֱ�
		for(DateVO o: list) {
			// DB���� ��ȸ�� ��¥�� map�� �־���
			map.put(o.getRegdate().getDate(), img[o.getEmoji()]);
		}
		return map;
	}
	
	public String numToString(int value) {
		return img[value];
	}
	
	public int srcToNum(String src) {
		int ret = 0;
		for(int i=0; i<img.length; i++) {
			if(src.equals(img[i])) {
				ret = i;
			}
		}
		return ret;
	}
}
