package ru.project.main.utils.db.SettingsDataBase;

import java.io.*;
import java.util.HashMap;

/*
    Создаем коллекцию для обращения к данным по ключю.
        1.Создаем коллекцию
        2.Считываем файл
        3.Пишем в коллекцию
        4.Возвращаем коллекцию

    Для подключения к базе необходимо создать файл с настройками формата ->
    url (пример -> jdbc:postgresql://localhost:5432/nameDB)
    userName
    password


    Задачи:
        Сообщение тип исключения
 */

public class SettingsConnectDatabase {

    public static HashMap getSetConnectDB() throws IOException {

        //1
        HashMap<String,Object> getSetConnectDBList = new HashMap<>();
        //2
        File file = new File("C:\\JavaProject\\MyProject\\src\\main\\java\\ru\\project\\main\\utils\\db\\SettingsDataBase\\SetConnectDatabase.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        //3
        getSetConnectDBList.put("url",bufferedReader.readLine());
        getSetConnectDBList.put("userName",bufferedReader.readLine());
        getSetConnectDBList.put("password",bufferedReader.readLine());
        //4
        return getSetConnectDBList;
    }
}
