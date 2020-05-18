package ru.geekbrains.SCV.lesson_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class AppData {
    private String[] header;
    private int[][] data;

    public AppData(String fileName) {
        this.readFromCSVFile(fileName);
    }

    public void readFromCSVFile(String fileName) {
        List<String[]> dataList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String str = reader.readLine();
            this.header = str.split(";");

            while ((str = reader.readLine()) != null) {
                if (str.split(";").length !=header.length){
                    throw new IOException("Не корректные данные в этом файле");
                    //System.out.println("Не корректные данные");// разобраться с исключением, передалать!!!!
                }
                dataList.add(str.split(";"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.data = new int[dataList.size()][header.length];
        for (int j =0; j < dataList.size(); j++){
            for (int i=0; i < header.length; i++ ){

                data[j][i]= Integer.parseInt(dataList.get(j)[i]);
            }
        }
    }
}
