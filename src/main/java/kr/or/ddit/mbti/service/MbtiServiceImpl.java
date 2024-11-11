package kr.or.ddit.mbti.service;

import kr.or.ddit.mbti.dao.MbtiMapper;
import kr.or.ddit.mbti.dao.MbtiMapperImpl;
import kr.or.ddit.vo.MbtiVO;

import java.util.List;

public class MbtiServiceImpl implements MbtiService {

    private MbtiMapper dao = new MbtiMapperImpl();
    @Override
    public void createMbti(MbtiVO mbti) {
        dao.insertMbti(mbti);
    }

    @Override
    public MbtiVO readMbti(String mbtiType) {
        return dao.selectMbti(mbtiType);
    }

    @Override
    public List<MbtiVO> readMbtiList() {
        return dao.selectMbtiList();
    }

    @Override
    public void modifyMbti(MbtiVO mbti) {
        dao.updateMbti(mbti);
    }

    @Override
    public void removeMbti(String MbtiType) {
        dao.deleteMbti(MbtiType);
    }
}
