package kr.or.ddit.props.dao;

import kr.or.ddit.props.PersonVO;

import java.util.List;

public class PersonDAOImpl implements PersonDAO {
    @Override
    public int insertPerson(PersonVO person) {
        return 0;
    }

    @Override
    public PersonVO selectPerson(String id) {
        return null;
    }

    @Override
    public List<PersonVO> selectPersonList() {
        return List.of();
    }

    @Override
    public int updatePerson(PersonVO person) {
        return 0;
    }

    @Override
    public int deletePerson(String id) {
        return 0;
    }
}
