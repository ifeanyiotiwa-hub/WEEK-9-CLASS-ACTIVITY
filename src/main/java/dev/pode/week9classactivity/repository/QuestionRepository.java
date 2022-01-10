package dev.pode.week9classactivity.repository;

import dev.pode.week9classactivity.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionRepository {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public QuestionRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int saveQuestion(Question question) {
        String sql = "INSERT INTO question (title, description) " +
                "VALUES (?, ?)";
        return jdbcTemplate.update( sql, question.getTitle(), question.getDescription());
    }

    public Question getQuestionById(int id){
        String sql = "SELECT * FROM question WHERE id=?";
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Question.class),id);
    }
}


