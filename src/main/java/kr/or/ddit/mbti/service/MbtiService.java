package kr.or.ddit.mbti.service;

import kr.or.ddit.commons.enumpkg.ServiceResult;
import kr.or.ddit.vo.MbtiVO;

import java.util.List;

public interface MbtiService {
    public void createMbti(MbtiVO mbti);

    public MbtiVO readMbti(String MbtiType);
    public List<MbtiVO> readMbtiList();

    public void modifyMbti(MbtiVO mbtiVO);


    public void removeMbti(String MbtiType);
}
