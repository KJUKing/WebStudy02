package kr.or.ddit.mbti.dao;

import kr.or.ddit.vo.MbtiVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MbtiMapper {

    /**
     *
     * @param mbti
     * @return
     */
    public int insertMbti(MbtiVO mbti);

    public MbtiVO selectMbti(@Param("mtType") String mbtiType);
    public List<MbtiVO> selectMbtiList();

    public int updateMbti(MbtiVO mbti);

    public int deleteMbti(String mbtiType);
}
