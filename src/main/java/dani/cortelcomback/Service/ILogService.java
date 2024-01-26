package dani.cortelcomback.Service;

import dani.cortelcomback.model.ServiceActivationToggledLog;

import java.util.List;

public interface ILogService {
    public List<ServiceActivationToggledLog> findAllLogs();
    public ServiceActivationToggledLog findLogById(Integer logId);
    public ServiceActivationToggledLog saveLog(ServiceActivationToggledLog log);
    public void deleteLog(ServiceActivationToggledLog log);
}
