package repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileRepo {

    private String fileName;
    private double minimum;
    ArrayList<Double> values;

    public FileRepo(String fileName){
        this.fileName = fileName;
        minimum = Double.MAX_VALUE;
        values = new ArrayList<>();
        readFromFile();
    }

    private void readFromFile(){
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource(fileName).getFile());
            Scanner sc = new Scanner(file);
            int elems = Integer.parseInt(sc.nextLine());
            String[] vectorAsString = sc.nextLine().split(" ");
            for(int i=0;i<elems;i++){
                Double value = Double.parseDouble(vectorAsString[i]);
                if(value<minimum)
                    minimum = value;
                values.add(value);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public double get(Integer position){
        if(position == -1)
            return Double.MAX_VALUE;
        return values.get(position);
    }

    public Integer getSize(){
        return values.size();
    }

    public Double getMinimum(){
        return minimum;
    }
}
