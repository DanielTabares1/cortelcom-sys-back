package dani.cortelcomback.Service.impl;

import dani.cortelcomback.Service.ILogService;
import dani.cortelcomback.model.ServiceActivationToggledLog;
import dani.cortelcomback.repository.ServiceActivationToggledLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService implements ILogService {

    @Autowired
    private ServiceActivationToggledLogRepository logRepository;

    @Override
    public List<ServiceActivationToggledLog> findAllLogs() {
        return logRepository.findAll();
    }

    @Override
    public ServiceActivationToggledLog findLogById(Integer logId) {
        return logRepository.findById(logId).orElse(null);
    }

    @Override
    public ServiceActivationToggledLog saveLog(ServiceActivationToggledLog log) {
        return logRepository.save(log);
    }

    @Override
    public void deleteLog(ServiceActivationToggledLog log) {
        logRepository.delete(log);
    }
}
