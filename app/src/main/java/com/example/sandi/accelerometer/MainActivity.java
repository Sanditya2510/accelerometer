package com.example.sandi.accelerometer;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private TextView accdisp;
    private Sensor sensor;
    private SensorManager sm;
    boolean accocc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        sensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);
        accdisp=(TextView)findViewById(R.id.accdisp);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        accdisp.setText("acc. along x "+event.values[0]+"\nacc. along y "+event.values[1]+"\nacc. along z "+event.values[2]);
        if(event.values[0]>=12||event.values[1]>=12||event.values[0]>=12||event.values[0]<=-12||event.values[1]<=-12||event.values[2]<=-12)
        {
            accocc=true;
        }


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {


    }
}
