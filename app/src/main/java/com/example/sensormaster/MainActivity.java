package com.example.sensormaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView text_show; //创建文字展示
    private SensorManager sensorManager; //创建传感器管理器

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //展示页面布局，加载指定资源的xml文件
        sensorManager=(SensorManager) getSystemService(Context.SENSOR_SERVICE); //获取SensorManager实例
        text_show=(TextView) findViewById(R.id.text_show); //通过id绑定文字展示控件

        List<Sensor> allSensors=sensorManager.getSensorList(Sensor.TYPE_ALL); //获取当前设备支持的传感器列表
        StringBuilder stringBuilder=new StringBuilder(); //管理字符串对象

        stringBuilder.append("此设备有"+allSensors.size()+"个传感器，分别是：\n\n");
        for(Sensor sensor:allSensors){
            //获取各种传感器
            switch (sensor.getType()){
                case Sensor.TYPE_ACCELEROMETER:
                    stringBuilder.append(sensor.getType()+" 加速度传感器(Accelerometer sensor)"+"\n");
                    break;
                case Sensor.TYPE_GYROSCOPE:
                    stringBuilder.append(sensor.getType()+" 陀螺仪传感器(Gyroscope sensor)"+"\n");
                    break;
                case Sensor.TYPE_LIGHT:
                    stringBuilder.append(sensor.getType()+" 光线传感器(Light sensor)"+"\n");
                    break;
                case Sensor.TYPE_MAGNETIC_FIELD:
                    stringBuilder.append(sensor.getType()+" 磁场传感器(Magnetic field sensor)"+"\n");
                    break;
                case Sensor.TYPE_ORIENTATION:
                    stringBuilder.append(sensor.getType()+" 方向传感器(Orientation sensor)"+"\n");
                    break;
                case Sensor.TYPE_PRESSURE:
                    stringBuilder.append(sensor.getType()+" 气压传感器(Pressure sensor)"+"\n");
                    break;
                case Sensor.TYPE_PROXIMITY:
                    stringBuilder.append(sensor.getType()+" 距离传感器(Proximity sensor)"+"\n");
                    break;
                case Sensor.TYPE_TEMPERATURE:
                    stringBuilder.append(sensor.getType()+" 温度传感器(Proximity sensor)"+"\n");
                    break;
                case Sensor.TYPE_GRAVITY:
                    stringBuilder.append(sensor.getType()+" 重力传感器(Proximity sensor)"+"\n");
                    break;
                default:
                    stringBuilder.append(sensor.getType()+" 其他传感器"+"\n");
                    break;
            }
            stringBuilder.append("设备名称："+sensor.getName()+"\n 设备版本："+sensor.getVersion()+"\n 供应商："+sensor.getVendor()+"\n\n");
        }
        text_show.setText(stringBuilder.toString()); //展示传感器信息
    }
}