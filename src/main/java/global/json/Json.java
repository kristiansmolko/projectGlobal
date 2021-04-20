package global.json;

import global.entity.Sensor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Json {

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public JSONObject getBySensorType(List<Sensor> list){
        JSONObject object = new JSONObject();
        object.put("actual_date", format.format(new Date()));
        JSONArray array = new JSONArray();
        for(Sensor s : list){
            JSONObject sensor = new JSONObject();
            sensor.put("sensor_type", s.getType());
            sensor.put("sensor_unit", s.getUnit());
            sensor.put("sensor_value", s.getValue());
            sensor.put("date_time", s.getDate());
            array.add(sensor);
        }
        object.put("data", array);
        return object;
    }

    public JSONObject getGeneralData(Map<String, Float> map){
        JSONObject object = new JSONObject();
        for (Map.Entry<String, Float> entry : map.entrySet()){
            object.put(entry.getKey(), entry.getValue());
        }
        object.put("actual_date", format.format(new Date()));
        return object;
    }
}
