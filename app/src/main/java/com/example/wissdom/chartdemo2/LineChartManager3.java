package com.example.wissdom.chartdemo2;

import android.content.Context;
import android.graphics.Color;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

/**
 *
 * @author：Coco
 * date：2019/3/18
 * version：1.0
 * description:LineChartManager3.java
 *
 */
public class LineChartManager3 {

    private static String lineName = null;
    private static String lineName1 = null;

    /**
     * @Description:创建两条折线
     * @param context 上下文
     * @param mLineChart 折线图控件
     * @param xValues 折线在x轴的值
     * @param yValue 折线在y轴的值
     * @param yValue1 另一条折线在y轴的值
     */
    public static void initDoubleLineChart(Context context, LineChart mLineChart, ArrayList<String> xValues,
                                           ArrayList<Entry> yValue, ArrayList<Entry> yValue1) {
        initDataStyle(mLineChart,context);

        //Color.rgb(89,194,230)蓝色  Color.rgb(252,76,122)玫红

        LineDataSet dataSet = new LineDataSet(yValue, lineName);
        //dataSet.enableDashedLine(10f, 10f, 0f);//将折线设置为曲线(即设置为虚线)
        dataSet.setColor(Color.rgb(89,194,230));
        dataSet.setCircleColor(Color.rgb(89,194,230));
        dataSet.setDrawValues(false);

        LineDataSet dataSet1 = new LineDataSet(yValue1, lineName1);
        dataSet1.setColor(Color.rgb(252,76,122));
        dataSet1.setCircleColor(Color.rgb(252,76,122));
        dataSet1.setDrawValues(false);

        //构建一个类型为LineDataSet的ArrayList 用来存放所有 y的LineDataSet   他是构建最终加入LineChart数据集所需要的参数
        ArrayList<LineDataSet> dataSets = new ArrayList<>();

        //将数据加入dataSets
        dataSets.add(dataSet);
        dataSets.add(dataSet1);

        //构建一个LineData  将dataSets放入
        LineData lineData = new LineData(xValues, dataSets);
        //将数据插入
        mLineChart.setData(lineData);
        //设置动画效果
        mLineChart.animateX(2500);  //立即执行动画
    }

    /**
     *  @Description:初始化图表的样式
     */
    public static void initDataStyle(LineChart lineChart,Context context) {
        //设置点击折线点时，显示其数值
//        MyMakerView mv = new MyMakerView(context, R.layout.item_mark_layout);
//        mLineChart.setMarkerView(mv);
        lineChart.setDrawBorders(false); //在折线图上添加边框
        lineChart.setDescription(""); //数据描述
        lineChart.setNoDataTextDescription("You need to provide data for the chart.");
        lineChart.setDrawGridBackground(false); //表格颜色
        lineChart.setGridBackgroundColor(Color.GRAY & 0x70FFFFFF); //表格的颜色，设置一个透明度
        lineChart.setTouchEnabled(true); //可点击
        lineChart.setDragEnabled(true);  //可拖拽
        lineChart.setScaleEnabled(true);  //可缩放
        lineChart.setPinchZoom(false);
        lineChart.setBackgroundColor(Color.WHITE); //设置背景颜色

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
        //axisLeft.setAxisMaxValue(800f); //最大值
        axisLeft.setLabelCount(5, true); //显示格数
        axisLeft.setGridColor(Color.GRAY); //网格线颜色
        //axisLeft.setTypeface(mTf);

        axisRight.setDrawAxisLine(false);
        axisRight.setDrawGridLines(false);
        axisRight.setDrawLabels(false);

        //lineChart.animateX(2500);  //立即执行动画
    }

    /**
     * @Description:设置折线的名称
     * @param name
     */
    public static void setLineName(String name){
        lineName = name;
    }

    /**
     * @Description:设置另一条折线的名称
     * @param name
     */
    public static void setLineName1(String name){
        lineName1 = name;
    }

}
