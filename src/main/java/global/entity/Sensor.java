package global.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Sensor {
    private String type;
    private String unit;
    private float value;
    private Date date;
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public Sensor(String type, String unit, float value, Date date) {
        this.type = type;
        this.unit = unit;
        this.value = value;
        this.date = date;
    }

    public Sensor(String type, String unit, float value) {
        this.type = type;
        this.unit = unit;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public String getUnit() {
        return unit;
    }

    public float getValue() {
        return value;
    }

    public String getDate() {
        return format.format(date);
    }
}
