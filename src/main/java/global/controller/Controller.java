package global.controller;

import global.database.Database;
import global.entity.Sensor;
import global.json.Json;
import global.log.Log;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class Controller {
    Database dat = new Database();
    Log log = new Log();
    Json j = new Json();

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
        List<Sensor> list = dat.getDataBySensorType(sensorType);
        if (list.isEmpty()){
            log.error("Empty database");
            return badRequest.body("Empty database");
        }
        JSONObject object = j.getBySensorType(list);
        log.ok("Completed");
        return ok.contentType(MediaType.APPLICATION_JSON).body(object.toJSONString());
    }
}
