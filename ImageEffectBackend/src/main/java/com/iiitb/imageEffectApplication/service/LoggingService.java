package com.iiitb.imageEffectApplication.service;
import com.iiitb.imageEffectApplication.model.LogModel;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoggingService {

    public void addLog(String fileName, String effectName, String optionValues) {
        return;
    }

    public List<LogModel> getAllLogs() {
        return new ArrayList<LogModel>();
    }

    public List<LogModel> getLogsByEffect(String effectName) {
        return new ArrayList<LogModel>();
    }

    public void clearLogs() {
        return;
    }
}
