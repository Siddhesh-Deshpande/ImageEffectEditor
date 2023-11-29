package com.iiitb.imageEffectApplication.service;
import com.iiitb.imageEffectApplication.model.LogModel;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<LogModel> getLogsBetweenTimestamps(LocalDateTime startTime, LocalDateTime endTime) {
        return new ArrayList<LogModel>();
    }
}
