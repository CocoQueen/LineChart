package com.example.wissdom.chartdemo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.LineData;

/**
 *
 * @author：Coco
 * date：2019/3/18
 * version：1.0
 * description:MainActivity.java
 *
 */
public class MainActivity extends AppCompatActivity {
    private LineChart lineChart1;
    private LineData lineData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initChart1();
        initChart2();
    }
    private void initChart2() {
        LineChart lineChart2 = findViewById(R.id.line_chart);
        //设置图表的描述
        lineChart2.setDescription("双曲线");
        lineChart2.setDoubleTapToZoomEnabled(false);
        //设置x轴的数据
        int numX = 24;
        //设置y轴的数据
        //数据
        float[] datas1 = {36, 23, 69, 32, 2, 26, 94, 85, 36, 23, 69, 32, 2, 26, 94, 85, 36, 23, 69, 32, 2, 26, 94, 85};
        //数据
        float[] datas2 = {36, 23, 69, 32, 82, 26, 94, 85, 36, 23, 69,32, 2, 26, 94, 85, 36, 23, 69, 32, 2, 26, 94, 85};
        //设置折线的名称
        LineChartManager2.setLineName("当月值");
        //设置第二条折线y轴的数据
        LineChartManager2.setLineName1("上月值");
        //创建两条折线的图表
        lineData = LineChartManager2.initDoubleLineChart(this, lineChart1, numX, datas1, datas2);
        LineChartManager2.initDataStyle(lineChart2, lineData, this);
    }
    private void initChart1() {
        lineChart1 = findViewById(R.id.spread_line_chart);
        //设置图表的描述

        lineChart1.setDescription("单曲线");
        lineChart1.setDoubleTapToZoomEnabled(false);
        //设置x轴的数据
        int numX = 24;


        //设置y轴的数据
        //数据
        float[] datas1 = {36, 23, 69, 32, 2, 26, 94, 85, 36, 23, 69, 32, 2, 26, 94, 85, 36, 23, 69, 32, 2, 6, 94, 85};
        //设置折线的名称
        LineChartManager2.setLineName("当月值");
        //设置第二条折线y轴的数据
        LineChartManager2.setLineName1("上月值");
        //创建两条折线的图表
        lineData = LineChartManager2.initSingleLineChart(this, lineChart1, numX, datas1);
        LineChartManager2.initDataStyle(lineChart1, lineData, this);
    }
}
