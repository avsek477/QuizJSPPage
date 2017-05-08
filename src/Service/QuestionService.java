package Service;

import DatabaseConnection.DatabaseConnection;
import Domain.Question;
import Domain.Results;

import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Avsek on 4/9/2017.
 */
public class QuestionService {

    public void deleteOldQuestions(int user_id){
        String query = "delete from result where u_id=?";
        PreparedStatement stmt = new DatabaseConnection().getPreparedStatement(query);
        try {
            stmt.setInt(1, user_id);
            stmt.executeUpdate();
            System.out.println("DEleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Results> getResults(int user_id){
        List<Results> resultList = new ArrayList<Results>();

        String query = "select * from result where u_id=?";
        PreparedStatement stmt = new DatabaseConnection().getPreparedStatement(query);
        try {
            stmt.setInt(1, user_id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Results result = new Results();
                result.setUser_id(rs.getInt("u_id"));
                result.setQ_id(rs.getInt("q_id"));
                result.setMarks(rs.getInt("marks"));
                resultList.add(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public List<Integer> getTotalNumberOfQuestions(){
        List<Integer> numberQuestion = new ArrayList<Integer>();
        String query = "select id from quiz";
        PreparedStatement stmt = new DatabaseConnection().getPreparedStatement(query);
        try {
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int q_number = rs.getInt("id");
                numberQuestion.add(q_number);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numberQuestion;
    }

    public List<Integer> getPlayedQuestion(int u_id) {

        List<Integer> ids = new ArrayList<Integer>();
        String query = "select q_id from result where u_id=?";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        try {
            pstm.setInt(1, u_id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("q_id");
                ids.add(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ids;
    }
    public void saveResult(int q_id, int u_id, int marks) {
        String query = "insert into result (q_id,u_id, marks) values(?,?,?)";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);

        try {
            pstm.setInt(1, q_id);
            pstm.setInt(2, u_id);
            pstm.setInt(3, marks);
            pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Question> getAllQuestions(){
        List<Question> questionList = new ArrayList<Question>();
        String query = "select * from quiz";
        PreparedStatement stmt = new DatabaseConnection().getPreparedStatement(query);
        try {
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Question newQuestion = new Question();
                newQuestion.setId(rs.getInt("id"));
                newQuestion.setQuestion(rs.getString("question"));
                newQuestion.setOption1(rs.getString("option1"));
                newQuestion.setOption2(rs.getString("option2"));
                newQuestion.setOption3(rs.getString("option3"));
                newQuestion.setOption4(rs.getString("option4"));
                newQuestion.setCorrectAns(rs.getString("correctAns"));
                newQuestion.setCategory(rs.getString("category"));
                questionList.add(newQuestion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questionList;
    }

    public void addQuestions(String question, String option1, String option2, String option3, String option4, String correctAns, String category){
        Question newQuestion = new Question();
        String query = "insert into quiz(question, option1, option2, option3, option4, correctAns, category)values(?,?,?,?,?,?,?)";
        PreparedStatement stmt = new DatabaseConnection().getPreparedStatement(query);
        try {
            stmt.setString(1, question);
            stmt.setString(2, option1);
            stmt.setString(3, option2);
            stmt.setString(4, option3);
            stmt.setString(5, option4);
            stmt.setString(6, correctAns);
            stmt.setString(7, category);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Question edit(int id){
        Question newQuestion = null;
        String query = "select * from quiz where id=?";
        PreparedStatement stmt = new DatabaseConnection().getPreparedStatement(query);
        try {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                newQuestion = new Question();
                newQuestion.setId(rs.getInt("id"));
                newQuestion.setQuestion(rs.getString("question"));
                newQuestion.setOption1(rs.getString("option1"));
                newQuestion.setOption2(rs.getString("option2"));
                newQuestion.setOption3(rs.getString("option3"));
                newQuestion.setOption4(rs.getString("option4"));
                newQuestion.setCorrectAns(rs.getString("correctAns"));
                newQuestion.setCategory(rs.getString("category"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newQuestion;
    }

    public void updateQuestion(int id, String question, String option1, String option2, String option3, String option4, String correctAns, String category){
        String query = "update quiz set question=?, option1=?, option2=?, option3=?, option4=?, correctAns=?, category=? where id=?";
        PreparedStatement stmt = new DatabaseConnection().getPreparedStatement(query);
        try {
            stmt.setString(1, question);
            stmt.setString(2, option1);
            stmt.setString(3, option2);
            stmt.setString(4, option3);
            stmt.setString(5, option4);
            stmt.setString(6, correctAns);
            stmt.setString(7, category);
            stmt.setInt(8, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteQuestion(int id){
        String query = "delete from question where id=?";
        PreparedStatement stmt = new DatabaseConnection().getPreparedStatement(query);
        try {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Question getQuestion(List<Integer> ids){
        Question newQuestion = null;
        String query = "select * from quiz where id not in(";
        String values = "";
        for (int id : ids) {
            values+= id+",";//0,1,2,3,
        }
        query = query + values;
        int ind = query.lastIndexOf(",");
        query = query.substring(0, ind);
        query = query+") limit 1";

        System.out.println(query);

        PreparedStatement stmt = new DatabaseConnection().getPreparedStatement(query);
        try {
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                newQuestion = new Question();
                newQuestion.setId(rs.getInt("id"));
                newQuestion.setQuestion(rs.getString("question"));
                newQuestion.setOption1(rs.getString("option1"));
                newQuestion.setOption2(rs.getString("option2"));
                newQuestion.setOption3(rs.getString("option3"));
                newQuestion.setOption4(rs.getString("option4"));
                newQuestion.setCorrectAns(rs.getString("correctAns"));
                newQuestion.setCategory(rs.getString("category"));
            }
     //       stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newQuestion;
    }
}
