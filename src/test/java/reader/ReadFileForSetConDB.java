package reader;

import ru.project.main.utils.db.SettingsDataBase.SettingsConnectDatabase;

import java.io.*;
import java.util.HashMap;

public class ReadFileForSetConDB {

    public static void main(String[] args) throws IOException {

        HashMap hashMap = SettingsConnectDatabase.getSetConnectDB();

        System.out.println(hashMap.get("password"));
        System.out.println(hashMap.get("userName"));
        System.out.println(hashMap.get("url"));


    }
}
