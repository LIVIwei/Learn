package org.example.CheckedException;

import org.example.CheckedException.DAO.Student;

/**
 * @Author: LIVI
 * @Time: 2022/09/23  15:54
 * @Description: 自定义可查异常
 */
public class CheckedException1 {
    public static boolean containsStudent(String studentID){
        Student student = new Student();
        if (student.getStudentID().equals(studentID)) {
            return true;
        }
        return false;
    }

    private static String queryScore(String studentID) {
        Student student = new Student();
        if (student.getStudentID().equals(studentID)) {
            System.out.println(student.getScore());
            String score = student.getScore();
            return score;
        }
        return null;
    }

    public static class StudentNotExistException extends Error {
        public StudentNotExistException(String studentID) {
            super(String.format("Student ID %s not found!", studentID));
        }
    }

    private static String getScoreByStudentID(String studentID) throws StudentNotExistException {
        if (containsStudent(studentID)) {
            return queryScore(studentID);
        } else {
            throw new StudentNotExistException(studentID);
        }
    }

    public static void main(String[] args) {
        String studentID = "1211401";
        try {
            String score = getScoreByStudentID(studentID);
            System.out.printf("Student ID : %s%n", studentID);
            System.out.printf("Score : %s%n", score);
        }catch (StudentNotExistException e) {
            System.out.printf("Student ID %s not found!%n", studentID);
        }
    }
}


