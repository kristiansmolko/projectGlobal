package global.json;

import global.entity.Sensor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
}
