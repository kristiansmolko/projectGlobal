package global.controller;

import global.database.Database;
import global.log.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    Database dat = new Database();
    Log log = new Log();

    private final ResponseEntity.BodyBuilder ok = ResponseEntity.status(200);
    private final ResponseEntity.BodyBuilder badRequest = ResponseEntity.status(400);
    private final ResponseEntity.BodyBuilder notFound = ResponseEntity.status(404);

    @GetMapping("/v1/get_general_stats")
    public ResponseEntity<String> getGeneral(){
        //dat.getGeneralData();

        return null;
    }

    @GetMapping(value = "/v1/get_latest", params = "sensor")
    public ResponseEntity<String> getDataBySensor(@RequestParam(value = "sensor") String sensorType){
        //dat.getDataBySensorType(sensorType);

        return null;
    }
}
