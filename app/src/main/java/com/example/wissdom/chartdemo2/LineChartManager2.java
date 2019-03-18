package com.example.wissdom.chartdemo2;

import android.content.Context;
import android.graphics.Color;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.XAxisValueFormatter;
import com.github.mikephil.charting.formatter.YAxisValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.ArrayList;

/**
 *
 * @author：Coco
 * date：2019/3/18
 * version：1.0
 * description:LineChartManager2.java
 *
 */
public class LineChartManager2 {

    private static String lineName = null;
    private static String lineName1 = null;

    /**
     * 创建一条折线
     * @param context 上下文
     * @param mLineChart 对象
     * @param count X轴的数据
     * @param datas Y轴的数据
     * @return LineData
     */
    public static LineData initSingleLineChart(Context context, LineChart mLineChart, int count, float[] datas) {

        ArrayList<String> xValues = new ArrayList<String>();
        for (int i = 0; i < count; i++) {
            // x轴显示的数据，这里默认使用数字下标显示
            xValues.add((i) + ":00");
        }

        // y轴的数据
        ArrayList<Entry> yValues = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            yValues.add(new Entry(datas[i], i));
        }
        //设置折线的样式
        LineDataSet dataSet = new LineDataSet(yValues, lineName);
        //用y轴的集合来设置参数
        // 线宽
        dataSet.setLineWidth(1.75f);
        // 显示的圆形大小
        dataSet.setCircleSize(2f);
        // 折线显示颜色
        dataSet.setColor(Color.rgb(89, 194, 230));
        // 圆形折点的颜色
        dataSet.setCircleColor(Color.rgb(89, 194, 230));
        // 高亮的线的颜色
        dataSet.setHighLightColor(Color.GREEN);
        dataSet.setHighlightEnabled(true);
        //数值显示的颜色
        dataSet.setValueTextColor(Color.rgb(89, 194, 230));
        //数值显示的大小
        dataSet.setValueTextSize(8f);

        ArrayList<LineDataSet> dataSets = new ArrayList<>();
        dataSets.add(dataSet);

        //构建一个LineData  将dataSets放入
        return new LineData(xValues, dataSets);
    }

    /**
     * @param context    上下文
     * @param mLineChart 折线图控件
     * @param count      折线在x轴的值
     * @param datas1     折线在y轴的值
     * @param datas2     另一条折线在y轴的值
     * @Description:创建两条折线
     */
    public static LineData initDoubleLineChart(Context context, LineChart mLineChart, int count, float[] datas1, float[] datas2) {

        ArrayList<String> xValues = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            // x轴显示的数据，这里默认使用数字下标显示
            xValues.add((i) + ":00");
        }

        // y轴的数据
        ArrayList<Entry> yValues1 = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            yValues1.add(new Entry(datas1[i], i));
        }

        // y轴的数据
        ArrayList<Entry> yValues2 = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            yValues2.add(new Entry(datas2[i], i));
        }

        LineDataSet dataSet = new LineDataSet(yValues1, lineName);
        //dataSet.enableDashedLine(10f, 10f, 0f);//将折线设置为曲线(即设置为虚线)
        //用y轴的集合来设置参数
        // 线宽
        dataSet.setLineWidth(1.75f);
        // 显示的圆形大小
        dataSet.setCircleSize(2f);
        // 折线显示颜色
        dataSet.setColor(Color.rgb(89, 194, 230));
        // 圆形折点的颜色
        dataSet.setCircleColor(Color.rgb(89, 194, 230));
        // 高亮的线的颜色
        dataSet.setHighLightColor(Color.GREEN);
        dataSet.setHighlightEnabled(true);
        //数值显示的颜色
        dataSet.setValueTextColor(Color.rgb(89, 194, 230));
        //数值显示的大小
        dataSet.setValueTextSize(8f);

        LineDataSet dataSet1 = new LineDataSet(yValues2, lineName1);

        //用y轴的集合来设置参数
        dataSet1.setLineWidth(1.75f);
        dataSet1.setCircleSize(2f);
        dataSet1.setColor(Color.rgb(252, 76, 122));
        dataSet1.setCircleColor(Color.rgb(252, 76, 122));
        dataSet1.setHighLightColor(Color.GREEN);
        dataSet1.setHighlightEnabled(true);
        dataSet1.setValueTextColor(Color.rgb(252, 76, 122));
        dataSet1.setValueTextSize(8f);

        //构建一个类型为LineDataSet的ArrayList 用来存放所有 y的LineDataSet   他是构建最终加入LineChart数据集所需要的参数
        ArrayList<LineDataSet> dataSets = new ArrayList<>();

        //将数据加入dataSets
        dataSets.add(dataSet);
        dataSets.add(dataSet1);

        //构建一个LineData  将dataSets放入
        return new LineData(xValues, dataSets);
    }

    /**
     * @Description:初始化图表的样式
     */
    public static void initDataStyle(LineChart lineChart, LineData lineData, Context context) {
        //设置点击折线点时，显示其数值
//        MyMakerView mv = new MyMakerView(context, R.layout.item_mark_layout);
//        mLineChart.setMarkerView(mv);
        //在折线图上添加边框
        lineChart.setDrawBorders(false);
        // 数据描述
        lineChart.setDescription("时间/数据");
        //表格颜色
        lineChart.setDrawGridBackground(false);
        //表格的颜色，设置一个透明度
        lineChart.setGridBackgroundColor(Color.GRAY & 0x70FFFFFF);
        //可点击
        lineChart.setTouchEnabled(true);
        //可拖拽
        lineChart.setDragEnabled(true);
        //可缩放
        lineChart.setScaleEnabled(true);
        //是否启用双指缩放
        lineChart.setPinchZoom(false);
        //设置背景颜色
        lineChart.setBackgroundColor(Color.WHITE);

        lineChart.setData(lineData);

        //设置标示，就是那个一组y的value的
        Legend mLegend = lineChart.getLegend();
        //样式
        mLegend.setForm(Legend.LegendForm.SQUARE);
        //字体
        mLegend.setFormSize(6f);
        //颜色
        mLegend.setTextColor(Color.GRAY);
        //x轴可显示的坐标范围
        lineChart.setVisibleXRange(0, 4);
        //x轴的标示
        XAxis xAxis = lineChart.getXAxis();
        //x轴位置
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        //字体的颜色
        xAxis.setTextColor(Color.GRAY);
        //字体大小
        xAxis.setTextSize(10f);
        //网格线颜色
        xAxis.setGridColor(Color.GRAY);
        //不显示网格线
        xAxis.setDrawGridLines(false);

        xAxis.setValueFormatter(new XAxisValueFormatter() {
            @Override
            public String getXValue(String s, int i, ViewPortHandler viewPortHandler) {
                return String.valueOf(i);
            }
        });

        //y轴左边标示
        YAxis axisLeft = lineChart.getAxisLeft();
        //y轴右边标示
        YAxis axisRight = lineChart.getAxisRight();

        //设置y轴最大值
        axisLeft.setAxisMaxValue(100);
        axisRight.setAxisMaxValue(100);
        //设置y轴最小值
        axisLeft.setAxisMinValue(0);
        axisRight.setAxisMinValue(0);

        LimitLine hightLimit = new LimitLine(80, "最高限制线");
        hightLimit.setLineColor(Color.RED);
        hightLimit.setLineWidth(2);
        hightLimit.setTextColor(Color.BLACK);
        hightLimit.setTextSize(12);
        axisLeft.addLimitLine(hightLimit);

        LimitLine lowerLimit = new LimitLine(20, "最低限制线");
        lowerLimit.setLineColor(Color.BLUE);
        lowerLimit.setLineWidth(2);
        lowerLimit.setTextColor(Color.BLACK);
        lowerLimit.setTextSize(12);
        axisLeft.addLimitLine(lowerLimit);

        axisLeft.setValueFormatter(new YAxisValueFormatter() {
            @Override
            public String getFormattedValue(float v, YAxis yAxis) {
                return String.valueOf(v);
            }
        });

        axisRight.setValueFormatter(new YAxisValueFormatter() {
            @Override
            public String getFormattedValue(float v, YAxis yAxis) {
                return String.valueOf(v);
            }
        });

        //字体颜色
        axisLeft.setTextColor(Color.GRAY);
        //字体大小
        axisLeft.setTextSize(10f);
        // 最大值
        //axisLeft.setAxisMaxValue(800f);
        //显示格数
        axisLeft.setLabelCount(5, true);
        //网格线颜色
        axisLeft.setGridColor(Color.GRAY);

        axisRight.setDrawAxisLine(false);
        axisRight.setDrawGridLines(false);
        axisRight.setDrawLabels(false);

        //设置动画效果
        lineChart.animateY(2000, Easing.EasingOption.Linear);
        lineChart.animateX(2000, Easing.EasingOption.Linear);
        lineChart.invalidate();
        // 立即执行动画
        //lineChart.animateX(2500);
    }

    /**
     * @param name 设置折线代表值
     * @Description:设置折线的名称
     */
    public static void setLineName(String name) {
        lineName = name;
    }

    /**
     * @param name 设置折线代表值
     * @Description:设置另一条折线的名称
     */
    public static void setLineName1(String name) {
        lineName1 = name;
    }

}
