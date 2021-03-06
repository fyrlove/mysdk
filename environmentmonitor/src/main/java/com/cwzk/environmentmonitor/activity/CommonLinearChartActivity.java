package com.cwzk.environmentmonitor.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.cwzk.environmentmonitor.R;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.gesture.ContainerScrollType;
import lecho.lib.hellocharts.gesture.ZoomType;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;

public class CommonLinearChartActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView mTvTitle;
    private TextView mTvMIN;
    private TextView mTvAVG;
    private TextView mTvMAX;
    private LineChartView lineChart;
    private List<PointValue> mPointValues = new ArrayList<PointValue>();
    private List<AxisValue> mAxisXValues = new ArrayList<AxisValue>();
    private List<AxisValue> mAxisYValues = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_chart_layout);
        initViews();
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("params");

        String title = bundle.getString("title");
        setTitle(title);
        String min = bundle.getString("min");
        String avg = bundle.getString("avg");
        String max = bundle.getString("max");
        mTvMIN.setText(min);
        mTvAVG.setText(avg);
        mTvMAX.setText(max);
        List<String> listX = bundle.getStringArrayList("x");
        List<String> listY = bundle.getStringArrayList("y");
        List<Integer> listScoreX = bundle.getIntegerArrayList("scorex");
        List<Integer> listScoreY =  bundle.getIntegerArrayList("scorey");
        setXLable(listX);
        setYLable(listY);
        setPonits(listScoreX,listScoreY);
        initLineChart();//初始化
    }

    private void initViews() {
        lineChart = findViewById(R.id.lineChart);
        mTvTitle = findViewById(R.id.tvTitle);
        mTvMIN = findViewById(R.id.tvMin);
        mTvAVG = findViewById(R.id.tvAVG);
        mTvMAX = findViewById(R.id.tvMax);
        toolbar  = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
//            actionBar.setHomeAsUpIndicator(R.drawable.ic_back);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

    private void initLineChart() {
        Line line = new Line(mPointValues).setColor(Color.parseColor("#FFCD41"));  //折线的颜色（橙色）
        List<Line> lines = new ArrayList<Line>();
        line.setShape(ValueShape.CIRCLE);//折线图上每个数据点的形状  这里是圆形 （有三种 ：ValueShape.SQUARE  ValueShape.CIRCLE  ValueShape.DIAMOND）
        line.setCubic(false);//曲线是否平滑，即是曲线还是折线
        line.setFilled(false);//是否填充曲线的面积
        line.setHasLabels(true);//曲线的数据坐标是否加上备注
//      line.setHasLabelsOnlyForSelected(true);//点击数据坐标提示数据（设置了这个line.setHasLabels(true);就无效）
        line.setHasLines(true);//是否用线显示。如果为false 则没有曲线只有点显示
        line.setHasPoints(true);//是否显示圆点 如果为false 则没有原点只有点显示（每个数据点都是个大的圆点）
        lines.add(line);
        LineChartData data = new LineChartData();
        data.setLines(lines);

        //坐标轴
        Axis axisX = new Axis(); //X轴
        axisX.setHasTiltedLabels(true);  //X坐标轴字体是斜的显示还是直的，true是斜的显示
        axisX.setTextColor(Color.GRAY);  //设置字体颜色
        axisX.setName("时间");  //表格名称
        axisX.setTextSize(10);//设置字体大小
        //axisX.setMaxLabelChars(8); //最多几个X轴坐标，意思就是你的缩放让X轴上数据的个数7<=x<=mAxisXValues.length
        axisX.setValues(mAxisXValues);  //填充X轴的坐标名称
        data.setAxisXBottom(axisX); //x 轴在底部
        //data.setAxisXTop(axisX);  //x 轴在顶部
        axisX.setHasLines(true); //x 轴分割线

//        这两句话设置折线上点的背景颜色，默认是有一个小方块，而且背景色和点的颜色一样
//        如果想要原来的效果可以不用这两句话，我的显示的是透明的
//        data.setValueLabelBackgroundColor(Color.TRANSPARENT);
//        data.setValueLabelBackgroundEnabled(false);

        // Y轴是根据数据的大小自动设置Y轴上限(在下面我会给出固定Y轴数据个数的解决方案)
        Axis axisY = new Axis();  //Y轴
        axisY.setName("");//y轴标注
        axisY.setTextSize(10);//设置字体大小
        data.setAxisYLeft(axisY);  //Y轴设置在左边
        //data.setAxisYRight(axisY);  //y轴设置在右边

//        Axis axisY = new Axis().setHasLines(true);
        axisY.setHasLines(true);
//        axisY.setInside(true);//设置是否将轴坐标的值显示在图表内侧
//        axisY.setMaxLabelChars(30);//max label length, for example 60


        axisY.setValues(mAxisYValues);


        //设置行为属性，支持缩放、滑动以及平移
        lineChart.setInteractive(true);
        lineChart.setZoomType(ZoomType.HORIZONTAL);
        lineChart.setMaxZoom((float) 2);//最大方法比例
        lineChart.setContainerScrollEnabled(true, ContainerScrollType.HORIZONTAL);
        lineChart.setLineChartData(data);
        lineChart.setVisibility(View.VISIBLE);
        /**注：下面的7，10只是代表一个数字去类比而已
         * 当时是为了解决X轴固定数据个数。见（http://forum.xda-developers.com/tools/programming/library-hellocharts-charting-library-t2904456/page2）;
         */
//        Viewport v = new Viewport(lineChart.getMaximumViewport());
//        v.left = 0;
//        v.right = 2;
//        lineChart.setCurrentViewport(v);
    }

    /**
     * 设置界面标题名称
     * @param title
     */
    public void setTitle(String title){
            mTvTitle.setText(title);
    }

    /**
     * 设置X轴显示
     * @param listXLable
     */
    public void  setXLable(List<String> listXLable){
        for (int i = 0; i < listXLable.size(); i++) {
            mAxisXValues.add(new AxisValue(i).setLabel(listXLable.get(i)));
        }
    }

    /**
     * 设置Y轴显示
     * @param listYLable
     */
    public void setYLable(List<String> listYLable){
        for (int i = 0; i < listYLable.size(); i++) {
            mAxisYValues.add(new AxisValue(i).setLabel(listYLable.get(i)));
        }
    }

    /**
     * 设置坐标点
     * @param xPoint
     * @param yPoint
     */
//    public void setPonits(List<Float> xPoint,List<Float> yPoint){
//        for (int i = 0; i < xPoint.size(); i++) {
//            mPointValues.add(new PointValue(xPoint.get(i),yPoint.get(i)));
//        }
//    }
    public void setPonits(List<Integer> xPoint,List<Integer> yPoint){
        for (int i = 0; i < xPoint.size(); i++) {
            mPointValues.add(new PointValue(xPoint.get(i),yPoint.get(i)));
        }
    }
    /**
     * 完成所有初始化后显示图表
     */
    public void showCharts(){

    }
}
