
package com.iiitb.imageEffectApplication.service;
import com.iiitb.imageEffectApplication.model.LogModel;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.*;
@Service
public class LoggingService{
    private File obj;//file having the logs
    private ArrayList<LogModel> allLogs; //required for getting all logs
    public LoggingService(){
        obj = new File("logs.txt");
        if(!obj.exists()){ //creating the file if not present
            try{
                obj.createNewFile();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        allLogs = new ArrayList<>();
    }
    //adding the logs
    public void addLog(String fileName, String effectName, String optionValues) throws IOException{
        FileWriter fw = new FileWriter(this.obj, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fw);
        LocalDateTime current_date_time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd,HH:mm");
        String formattedDateTime = current_date_time.format(formatter);
        String str = fileName + "@" + effectName + "@" + optionValues + "@" + formattedDateTime;
        bufferedWriter.write(str + "\n");
        bufferedWriter.close();
        return;
    }
    //Getting all logs
    public List<LogModel> getAllLogs() throws FileNotFoundException{
        try {
            if(!obj.exists()){
                throw new FileNotFoundException("File does not exist");
            }
            Scanner s = new Scanner(obj);
            ArrayList<String> list = new ArrayList<String>();
            this.allLogs.clear();
            while (s.hasNextLine()){
                list.add(s.nextLine());
                String sr = list.get(list.size()-1);
                String[] brk = sr.split("@");
                LogModel lm = new LogModel(brk[3], brk[0], brk[1], brk[2]);
                this.allLogs.add(lm);
            }
            s.close();
            return this.allLogs;
        }
        catch (FileNotFoundException e) {
            System.out.println(e);
        }
        return this.allLogs;
           
    } 
    //applying the filter by effect
    public List<LogModel> getLogsByEffect(String effectName) throws FileNotFoundException{
        ArrayList<LogModel> lst = new ArrayList<>();
        try {
            if(!obj.exists()){
            throw new FileNotFoundException("File does not exist");
            }
            Scanner s = new Scanner(obj);
            ArrayList<String> list = new ArrayList<String>();
            while (s.hasNextLine()){
                list.add(s.nextLine());
                String sr = list.get(list.size()-1);
                String[] brk = sr.split("@");
                if(effectName.compareTo(brk[1]) == 0){
                    lst.add(new LogModel(brk[3], brk[0], brk[1], brk[2]));
                }
            }
            s.close();
            return lst;
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        return lst;
    }
    //clearing the logs
    public void clearLogs() throws IOException{
        this.allLogs.clear();
        FileWriter fw = new FileWriter(this.obj, false);
        BufferedWriter bufferedWriter = new BufferedWriter(fw);
        bufferedWriter.write("");
        bufferedWriter.close();
        fw.close();
        return;
    }
    //getting between the time stamps.
    public List<LogModel> getLogsBetweenTimestamps(LocalDateTime startTime, LocalDateTime endTime) {
        ArrayList<LogModel> lst = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd,HH:mm");
        for(int i = 0; i<this.allLogs.size(); i++){
            String date = this.allLogs.get(i).getTimestamp();
            LocalDateTime temp = LocalDateTime.parse(date, formatter);
            if(temp.isAfter(startTime) && temp.isBefore(endTime))
            {
                lst.add(this.allLogs.get(i));
            }
        }   
        return lst;
    }
}