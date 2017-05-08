package controller;

import Domain.Question;
import Domain.Results;
import Domain.User;
import Service.QuestionService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Avsek on 4/9/2017.
 */
public class QuizServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String page = request.getParameter("page");
        if(page.equalsIgnoreCase("quizList")){
            //redirects to the quizList page

            List<Question> questionList = new QuestionService().getAllQuestions();
            request.setAttribute("questionList", questionList);
            RequestDispatcher rd = request.getRequestDispatcher("Quiz/quizList.jsp");
            rd.forward(request, response);
        }
        else if(page.equalsIgnoreCase("addQuestion")){
            //redirects to the page where questions can be added

            RequestDispatcher rd = request.getRequestDispatcher("Quiz/addQuestion.jsp");
            rd.forward(request, response);
        }
        else if(page.equalsIgnoreCase("addTheseQuestions")){
            // adds the questions to the database

            String question = request.getParameter("question");
            String option1 = request.getParameter("option1");
            String option2 = request.getParameter("option2");
            String option3 = request.getParameter("option3");
            String option4 = request.getParameter("option4");
            String correctAns = request.getParameter("correctAns");
            String category = request.getParameter("category");

            new QuestionService().addQuestions(question, option1, option2, option3, option4, correctAns, category);
            List<Question> questionList = new QuestionService().getAllQuestions();
            request.setAttribute("questionList", questionList);
            RequestDispatcher rd = request.getRequestDispatcher("Quiz/quizList.jsp");
            rd.forward(request, response);
        }
        else if(page.equalsIgnoreCase("editTheseQuestion")){
            //gets the id and redirects to the update page

            int id = Integer.parseInt(request.getParameter("id"));
            Question newQuestion = new QuestionService().edit(id);
            request.setAttribute("newQuestion", newQuestion);

            RequestDispatcher rd = request.getRequestDispatcher("Quiz/editQuestion.jsp");
            rd.forward(request, response);
        }
        else if(page.equalsIgnoreCase("updateTheseQuestions")){
            // updates the questions as taken by the users

            int id = Integer.parseInt(request.getParameter("id"));
            String question = request.getParameter("question");
            String option1 = request.getParameter("option1");
            String option2 = request.getParameter("option2");
            String option3 = request.getParameter("option3");
            String option4 = request.getParameter("option4");
            String correctAns = request.getParameter("correctAns");
            String category = request.getParameter("category");

            new QuestionService().updateQuestion(id, question, option1, option2, option3, option4, correctAns, category);
            List<Question> questionList = new QuestionService().getAllQuestions();
            request.setAttribute("questionList", questionList);
            RequestDispatcher rd = request.getRequestDispatcher("Quiz/quizList.jsp");
            rd.forward(request, response);
        }
        else if(page.equalsIgnoreCase("deleteTheseQuestions")){
            // deletes the question from the database

            int id = Integer.parseInt(request.getParameter("id"));
            new QuestionService().deleteQuestion(id);
            List<Question> questionList = new QuestionService().getAllQuestions();
            request.setAttribute("questionList", questionList);
            RequestDispatcher rd = request.getRequestDispatcher("Quiz/quizList.jsp");
            rd.forward(request, response);
        }

        else if(page.equalsIgnoreCase("takeQuiz")) {
            HttpSession session = request.getSession(false);
            User user =(User) session.getAttribute("user");
            int u_id = user.getId();

            new QuestionService().deleteOldQuestions(u_id);

            List<Integer> ids = new ArrayList<Integer>();
            System.out.println(ids);
            ids.add(0);

            Question newQuestion = new QuestionService().getQuestion(ids);
            request.setAttribute("newQuestion", newQuestion);
            RequestDispatcher rd = request.getRequestDispatcher("Quiz/takeQuiz.jsp");
            rd.forward(request, response);
        }
        else if(page.equalsIgnoreCase("nextQuestion")) {
            //question id
            // clicked
            // correct_ans
            //
            int question_id = Integer.parseInt(request.getParameter("id"));
            String clicked = request.getParameter("choice");
            String correctAns = request.getParameter("correctAns");
            HttpSession session = request.getSession(false);
            User user = (User)session.getAttribute("user");
            int user_id = user.getId();
            int marks =0;
            if (clicked.equalsIgnoreCase(correctAns)) {
                marks = 5;
            }

            new QuestionService().saveResult(question_id,user_id, marks);
            List<Integer> ids = new QuestionService().getPlayedQuestion(user_id);

            System.out.println(ids);

            //condition check garna paryo

           /* List <Integer> numberOfQuestions = new QuestionService().getTotalNumberOfQuestions();
            System.out.println(numberOfQuestions);
            if(ids.size()>=numberOfQuestions.size()){
                ids.clear();
                ids.add(question_id);

            }*/
            Question newQuestion = new QuestionService().getQuestion(ids);
            request.setAttribute("newQuestion", newQuestion);
            RequestDispatcher rd = request.getRequestDispatcher("Quiz/takeQuiz.jsp");
            rd.forward(request, response);
        }
        else if(page.equalsIgnoreCase("showResults")){
            HttpSession session = request.getSession(false);
            User user =(User) session.getAttribute("user");
            int u_id = user.getId();
            List<Results> resultList = new QuestionService().getResults(u_id);
            request.setAttribute("resultList", resultList);

            RequestDispatcher rd = request.getRequestDispatcher("Quiz/results.jsp");
            rd.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
