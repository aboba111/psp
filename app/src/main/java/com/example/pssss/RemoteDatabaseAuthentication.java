package com.example.zalypa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RemoteDatabaseAuthentication {


    public static boolean authenticateUser(String username, String password) {
        String DB_URL = "jdbc:postgresql://127.0.0.1:5433/psp";
        String DB_USER = "postgres";
        String DB_PASSWORD = "1082423";
        try {
            // Устанавливаем соединение с удаленной базой данных
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Подготавливаем SQL-запрос для проверки авторизации
            String query = "SELECT * FROM users WHERE username = ? AND passwords = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            // Выполняем запрос
            ResultSet resultSet = preparedStatement.executeQuery();

            // Если есть совпадение, пользователь авторизован
            if (resultSet.next()) {
                return true;
            }

            // Закрываем ресурсы
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
