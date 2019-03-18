package com.example.wissdom.chartdemo2;

import android.content.Context;
import android.graphics.Color;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/3/22 0022.
 *
 * mpandroidchart 的折线图的工具类
 */
public class LineChartUtils {
    //给LineChart设置数据
    public static void showChart(LineChart lineChart, LineData lineData1, int color) {
        lineChart.setDrawBorders(false); //在折线图上添加边框
        lineChart.setDescription(""); //数据描述
        lineChart.setNoDataTextDescription("You need to provide data for the chart.");
        lineChart.setDrawGridBackground(false); //表格颜色
        lineChart.setGridBackgroundColor(Color.GRAY & 0x70FFFFFF); //表格的颜色，设置一个透明度
        lineChart.setTouchEnabled(true); //可点击
        lineChart.setDragEnabled(true);  //可拖拽
        lineChart.setScaleEnabled(true);  //可缩放
        lineChart.setPinchZoom(false);
        lineChart.setBackgroundColor(color); //设置背景颜色

        lineChart.setData(lineData1);  //填充数据

        Legend mLegend = lineChart.getLegend(); //设置标示，就是那个一组y的value的
        mLegend.setForm(Legend.LegendForm.CIRCLE); //样式
        mLegend.setFormSize(6f); //字体
        mLegend.setTextColor(Color.GRAY); //颜色
        lineChart.setVisibleXRange(0, 4);   //x轴可显示的坐标范围
        XAxis xAxis = lineChart.getXAxis();  //x轴的标示
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM); //x轴位置
        xAxis.setTextColor(Color.GRAY);    //字体的颜色
        xAxis.setTextSize(10f); //字体大小
        xAxis.setGridColor(Color.GRAY);//网格线颜色
        xAxis.setDrawGridLines(false); //不显示网格线
        YAxis axisLeft = lineChart.getAxisLeft(); //y轴左边标示
        YAxis axisRight = lineChart.getAxisRight(); //y轴右边标示
        axisLeft.setTextColor(Color.GRAY); //字体颜色
        axisLeft.setTextSize(10f); //字体大小
        axisLeft.setAxisMaxValue(800f); //最大值
        axisLeft.setLabelCount(5, true); //显示格数
        axisLeft.setGridColor(Color.GRAY); //网格线颜色
        //axisLeft.setTypeface(mTf);

        axisRight.setDrawAxisLine(false);
        axisRight.setDrawGridLines(false);
        axisRight.setDrawLabels(false);

        lineChart.animateX(2500);  //立即执行动画
    }

    /**
     * 绘制一条折线
     * @param count
     * @param datas
     * @return
     */
    //给LineChart设置横纵坐标的坐标值
    public static LineData getOneLineData(int count, float [] datas) {
        ArrayList<String> xValues = new ArrayList<String>();
        for (int i = 0; i < count; i++) {
            // x轴显示的数据，这里默认使用数字下标显示
            xValues.add((i)+":00");
        }
        // y轴的数据
        ArrayList<Entry> yValues = new ArrayList<Entry>();
        for (int i = 0; i < count; i++) {
            yValues.add(new Entry(datas[i], i));
        }
        // create a dataset and give it a type
        // y轴的数据集合
        LineDataSet lineDataSet = new LineDataSet(yValues, "使用次数/时间");
        //用y轴的集合来设置参数
        lineDataSet.setLineWidth(1.75f); // 线宽
        lineDataSet.setCircleSize(2f);// 显示的圆形大小
        lineDataSet.setColor(Color.rgb(89,194,230));// 折线显示颜色
        lineDataSet.setCircleColor(Color.rgb(89,194,230));// 圆形折点的颜色
        lineDataSet.setHighLightColor(Color.GREEN); // 高亮的线的颜色
        lineDataSet.setHighlightEnabled(true);
        lineDataSet.setValueTextColor(Color.rgb(89,194,230)); //数值显示的颜色
        lineDataSet.setValueTextSize(8f);     //数值显示的大小
        ArrayList<LineDataSet> lineDataSets = new ArrayList<LineDataSet>();
        lineDataSets.add(lineDataSet); // 添加数据集合
        //创建lineData
        LineData lineData = new LineData(xValues, lineDataSets);
        return lineData;
    }

    /**
     * 绘制多条折线
     * @param count
     * @param datas
     * @return
     */
    //给LineChart设置横纵坐标的坐标值
    public static LineData getTwoLineData(int count, float [] datas) {
        ArrayList<String> xValues = new ArrayList<String>();
        for (int i = 0; i < count; i++) {
            // x轴显示的数据，这里默认使用数字下标显示
            xValues.add((i)+":00");
        }
        // y轴的数据
        ArrayList<Entry> yValues = new ArrayList<Entry>();
        for (int i = 0; i < count; i++) {
            yValues.add(new Entry(datas[i], i));
        }
        // create a dataset and give it a type
        // y轴的数据集合
        LineDataSet lineDataSet = new LineDataSet(yValues, "使用次数/时间");
        //用y轴的集合来设置参数
        lineDataSet.setLineWidth(1.75f); // 线宽
        lineDataSet.setCircleSize(2f);// 显示的圆形大小
        lineDataSet.setColor(Color.rgb(252,76,122));// 折线显示颜色
        lineDataSet.setCircleColor(Color.rgb(252,76,122));// 圆形折点的颜色
        lineDataSet.setHighLightColor(Color.GREEN); // 高亮的线的颜色
        lineDataSet.setHighlightEnabled(true);
        lineDataSet.setValueTextColor(Color.rgb(252,76,122)); //数值显示的颜色
        lineDataSet.setValueTextSize(8f);     //数值显示的大小
        ArrayList<LineDataSet> lineDataSets = new ArrayList<LineDataSet>();
        lineDataSets.add(lineDataSet); // 添加数据集合
        //创建lineData
        LineData lineData = new LineData(xValues, lineDataSets);
        return lineData;
    }

    public static LineData getThreeLineData(int count, float[][] datas) {
        ArrayList<String> xValues = new ArrayList<String>();
        for (int i = 0; i < count; i++) {
            // x轴显示的数据，这里默认使用数字下标显示
            xValues.add((i)+":00");
        }
        // y轴的数据
        ArrayList<Entry> yValues = new ArrayList<Entry>();
        // y轴的数据集合
        LineDataSet lineDataSet = new LineDataSet(yValues, "使用次数/时间");
        ArrayList<LineDataSet> lineDataSets = null;
        LineData lineData = null;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < datas.length; j++) {
                yValues.add(new Entry(datas[i][j], i));
            }
            //用y轴的集合来设置参数
            lineDataSet.setLineWidth(1.75f); // 线宽
            lineDataSet.setCircleSize(2f);// 显示的圆形大小
            lineDataSet.setColor(Color.rgb(252,76,122));// 折线显示颜色
            lineDataSet.setCircleColor(Color.rgb(252,76,122));// 圆形折点的颜色
            lineDataSet.setHighLightColor(Color.GREEN); // 高亮的线的颜色
            lineDataSet.setHighlightEnabled(true);
            lineDataSet.setValueTextColor(Color.rgb(252,76,122)); //数值显示的颜色
            lineDataSet.setValueTextSize(8f);     //数值显示的大小
            lineDataSets = new ArrayList<LineDataSet>();
            lineDataSets.add(lineDataSet); // 添加数据集合
        }
        //创建lineData
        lineData = new LineData(xValues, lineDataSets);
        return lineData;
    }

}
