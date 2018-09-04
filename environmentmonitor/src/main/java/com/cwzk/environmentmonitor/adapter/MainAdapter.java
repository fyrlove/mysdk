package com.cwzk.environmentmonitor.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

import com.cwzk.environmentmonitor.MainActivity;
import com.cwzk.environmentmonitor.R;
import com.cwzk.environmentmonitor.activity.CommonLinearChartActivity;
import com.cwzk.environmentmonitor.activity.LinearChartActivity;
import com.cwzk.environmentmonitor.entity.ItemListEntity;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {
    private Context mContext;
    private List<ItemListEntity> mList = new ArrayList<>();

    public MainAdapter(Context context) {
        this.mContext = context;
    }

    public void addList(List<ItemListEntity> list){
        mList.addAll(list);
    }
    public void clearList(){
        mList.clear();
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.main_item_list_layout,parent,false);
        return new MainViewHolder(view,mContext);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, final int position) {
        holder.BindView(mList.get(position));
//        ScaleAnimation sato0 = new ScaleAnimation(1,0,1,1, Animation.RELATIVE_TO_PARENT,0.5f,Animation.RELATIVE_TO_PARENT,0.5f);
//        sato0.setDuration(500);
//        holder.itemView.setAnimation(sato0);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                mContext.startActivity(new Intent(mContext, LinearChartActivity.class));
                switch (mList.get(position).title){
                    case "温度":
                        toTempratureChart(position);
                        break;
                    case "风速":
                        toWindSpeedChart(position);
                        break;
                    case "气压":
                        toPressureChart(position);
                        break;
                    case "二氧化碳":
                        toCO2Chart(position);
                        break;
                    case "光照度":
                        toIlluminanceChart(position);
                        break;
                    case "粉尘":
                        toDustChart(position);
                        break;
                    case "紫外线":
                        toUltravioletChart(position);
                        break;
                    case "地面温度":
                        toGroundTemperatureChart(position);
                        break;
                    case "声音":
                        toVoiceChart(position);
                        break;
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    /**
     * 温度走势图
     * @param position
     */
    private void toTempratureChart(int position){
        ArrayList<String> listX = new ArrayList<>();
        String[] date = {"0","1","2","3","4","5","6","7","8","9",
                "10","11","12","13","14","15","16","17",
                "18","19","20","21","22","23"};//X轴的标注
        for (int i = 0; i < date.length; i++) {
            listX.add(date[i]+"时");
        }
        int[] scorey= {26,25,27,28,29,26,25,27,28,29,26,25,27,35,34,36,25,27,28,29,26,25,22,20};//图表的数据点
        int[] scorex= {0,1,2,3,4,5,6,7,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};//图表的数据点

        ArrayList<String> listY = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            listY.add(i+"");
        }
        ArrayList<Integer> listScoreX = new ArrayList<>();
        for (int i = 0; i < scorex.length; i++) {
            listScoreX.add(scorex[i]);
        }
        ArrayList<Integer> listScoreY = new ArrayList<>();
        for (int i = 0; i < scorey.length; i++) {
            listScoreY.add(scorey[i]);
        }

        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("title",mList.get(position).title+"走势");
        bundle.putString("min","26℃");
        bundle.putString("avg","28℃");
        bundle.putString("max","30℃");
        bundle.putStringArrayList("x",listX);
        bundle.putStringArrayList("y",listY);
        bundle.putIntegerArrayList("scorex",listScoreX);
        bundle.putIntegerArrayList("scorey",listScoreY);
        intent.putExtra("params",bundle);
        intent.setClass(mContext,CommonLinearChartActivity.class);
        mContext.startActivity(intent);
    }
    /**
     * 风速走势图
     * @param position
     */
    private void toWindSpeedChart(int position){
        ArrayList<String> listX = new ArrayList<>();
        String[] date = {"0","1","2","3","4","5","6","7","8","9",
                "10","11","12","13","14","15","16","17",
                "18","19","20","21","22","23"};//X轴的标注
        for (int i = 0; i < date.length; i++) {
            listX.add(date[i]+"时");
        }
        int[] scorey= {1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4};//图表的数据点
        int[] scorex= {0,1,2,3,4,5,6,7,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};//图表的数据点

        ArrayList<String> listY = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            listY.add(i+"");
        }
        ArrayList<Integer> listScoreX = new ArrayList<>();
        for (int i = 0; i < scorex.length; i++) {
            listScoreX.add(scorex[i]);
        }
        ArrayList<Integer> listScoreY = new ArrayList<>();
        for (int i = 0; i < scorey.length; i++) {
            listScoreY.add(scorey[i]);
        }

        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("title",mList.get(position).title+"走势");
        bundle.putString("min","1 m/s");
        bundle.putString("avg","5 m/s");
        bundle.putString("max","10 m/s");
        bundle.putStringArrayList("x",listX);
        bundle.putStringArrayList("y",listY);
        bundle.putIntegerArrayList("scorex",listScoreX);
        bundle.putIntegerArrayList("scorey",listScoreY);
        intent.putExtra("params",bundle);
        intent.setClass(mContext,CommonLinearChartActivity.class);
        mContext.startActivity(intent);
    }

    /**
     * 气压走势图
     * @param position
     */
    private void toPressureChart(int position){
        ArrayList<String> listX = new ArrayList<>();
        String[] date = {"0","1","2","3","4","5","6","7","8","9",
                "10","11","12","13","14","15","16","17",
                "18","19","20","21","22","23"};//X轴的标注
        for (int i = 0; i < date.length; i++) {
            listX.add(date[i]+"时");
        }
        int[] scorey= {98,98,98,99,98,98,99,100,100,100,99,99,98,99,99,100,101,101,101,98,98,98,98,98};//图表的数据点
        int[] scorex= {0,1,2,3,4,5,6,7,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};//图表的数据点

        ArrayList<String> listY = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            listY.add(i+"");
        }
        ArrayList<Integer> listScoreX = new ArrayList<>();
        for (int i = 0; i < scorex.length; i++) {
            listScoreX.add(scorex[i]);
        }
        ArrayList<Integer> listScoreY = new ArrayList<>();
        for (int i = 0; i < scorey.length; i++) {
            listScoreY.add(scorey[i]);
        }

        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("title",mList.get(position).title+"走势");
        bundle.putString("min","98 kPa");
        bundle.putString("avg","99.9 kPa");
        bundle.putString("max","101 kPa");
        bundle.putStringArrayList("x",listX);
        bundle.putStringArrayList("y",listY);
        bundle.putIntegerArrayList("scorex",listScoreX);
        bundle.putIntegerArrayList("scorey",listScoreY);
        intent.putExtra("params",bundle);
        intent.setClass(mContext,CommonLinearChartActivity.class);
        mContext.startActivity(intent);
    }

    /**
     * 二氧化碳走势图
     * @param position
     */
    private void toCO2Chart(int position){
        ArrayList<String> listX = new ArrayList<>();
        String[] date = {"0","1","2","3","4","5","6","7","8","9",
                "10","11","12","13","14","15","16","17",
                "18","19","20","21","22","23"};//X轴的标注
        for (int i = 0; i < date.length; i++) {
            listX.add(date[i]+"时");
        }
        int[] scorey= {368,367,368,368,368,340,350,370,380,378,
                        368,367,368,368,368,340,350,370,380,378,
                         368,367,368,368};//图表的数据点
        int[] scorex= {0,1,2,3,4,5,6,7,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};//图表的数据点

        ArrayList<String> listY = new ArrayList<>();
        for (int i = 0; i < 400; i++) {
            listY.add(i+"");
        }
        ArrayList<Integer> listScoreX = new ArrayList<>();
        for (int i = 0; i < scorex.length; i++) {
            listScoreX.add(scorex[i]);
        }
        ArrayList<Integer> listScoreY = new ArrayList<>();
        for (int i = 0; i < scorey.length; i++) {
            listScoreY.add(scorey[i]);
        }

        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("title",mList.get(position).title+"走势");
        bundle.putString("min","340 ppm");
        bundle.putString("avg","369 ppm");
        bundle.putString("max","380 ppm");
        bundle.putStringArrayList("x",listX);
        bundle.putStringArrayList("y",listY);
        bundle.putIntegerArrayList("scorex",listScoreX);
        bundle.putIntegerArrayList("scorey",listScoreY);
        intent.putExtra("params",bundle);
        intent.setClass(mContext,CommonLinearChartActivity.class);
        mContext.startActivity(intent);
    }

    /**
     * 光照度走势图
     * @param position
     */
    private void toIlluminanceChart(int position){
        ArrayList<String> listX = new ArrayList<>();
        String[] date = {"0","1","2","3","4","5","6","7","8","9",
                "10","11","12","13","14","15","16","17",
                "18","19","20","21","22","23"};//X轴的标注
        for (int i = 0; i < date.length; i++) {
            listX.add(date[i]+"时");
        }
        int[] scorey= {368,367,368,368,368,340,400,500,600,680,
                        700,800,368,1000,900,900,900,900,800,700,
                         600,500,300,100};//图表的数据点
        int[] scorex= {0,1,2,3,4,5,6,7,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};//图表的数据点

        ArrayList<String> listY = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            listY.add(i+"");
        }
        ArrayList<Integer> listScoreX = new ArrayList<>();
        for (int i = 0; i < scorex.length; i++) {
            listScoreX.add(scorex[i]);
        }
        ArrayList<Integer> listScoreY = new ArrayList<>();
        for (int i = 0; i < scorey.length; i++) {
            listScoreY.add(scorey[i]);
        }

        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("title",mList.get(position).title+"走势");
        bundle.putString("min","100 lux");
        bundle.putString("avg","600 lux");
        bundle.putString("max","1000 lux");
        bundle.putStringArrayList("x",listX);
        bundle.putStringArrayList("y",listY);
        bundle.putIntegerArrayList("scorex",listScoreX);
        bundle.putIntegerArrayList("scorey",listScoreY);
        intent.putExtra("params",bundle);
        intent.setClass(mContext,CommonLinearChartActivity.class);
        mContext.startActivity(intent);
    }

    /**
     * 粉尘走势图
     * @param position
     */
    private void toDustChart(int position){
        ArrayList<String> listX = new ArrayList<>();
        String[] date = {"0","1","2","3","4","5","6","7","8","9",
                "10","11","12","13","14","15","16","17",
                "18","19","20","21","22","23"};//X轴的标注
        for (int i = 0; i < date.length; i++) {
            listX.add(date[i]+"时");
        }
        int[] scorey= {5,6,7,6,5,5,5,5,6,6,
                6,6,7,8,9,9,9,10,9,9,
                6,6,5,6};//图表的数据点
        int[] scorex= {0,1,2,3,4,5,6,7,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};//图表的数据点

        ArrayList<String> listY = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            listY.add(i+"");
        }
        ArrayList<Integer> listScoreX = new ArrayList<>();
        for (int i = 0; i < scorex.length; i++) {
            listScoreX.add(scorex[i]);
        }
        ArrayList<Integer> listScoreY = new ArrayList<>();
        for (int i = 0; i < scorey.length; i++) {
            listScoreY.add(scorey[i]);
        }

        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("title",mList.get(position).title+"走势");
        bundle.putString("min","5 mg/cm³");
        bundle.putString("avg","7.5 mg/cm³");
        bundle.putString("max","10 mg/cm³");
        bundle.putStringArrayList("x",listX);
        bundle.putStringArrayList("y",listY);
        bundle.putIntegerArrayList("scorex",listScoreX);
        bundle.putIntegerArrayList("scorey",listScoreY);
        intent.putExtra("params",bundle);
        intent.setClass(mContext,CommonLinearChartActivity.class);
        mContext.startActivity(intent);
    }
    /**
     * 紫外线走势图
     * @param position
     */
    private void toUltravioletChart(int position){
        ArrayList<String> listX = new ArrayList<>();
        String[] date = {"0","1","2","3","4","5","6","7","8","9",
                "10","11","12","13","14","15","16","17",
                "18","19","20","21","22","23"};//X轴的标注
        for (int i = 0; i < date.length; i++) {
            listX.add(date[i]+"时");
        }
        int[] scorey= {35,36,37,36,35,35,35,35,36,36,
                36,36,37,38,39,39,39,30,38,39,
                36,36,35,36};//图表的数据点
        int[] scorex= {0,1,2,3,4,5,6,7,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};//图表的数据点

        ArrayList<String> listY = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            listY.add(i+"");
        }
        ArrayList<Integer> listScoreX = new ArrayList<>();
        for (int i = 0; i < scorex.length; i++) {
            listScoreX.add(scorex[i]);
        }
        ArrayList<Integer> listScoreY = new ArrayList<>();
        for (int i = 0; i < scorey.length; i++) {
            listScoreY.add(scorey[i]);
        }

        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("title",mList.get(position).title+"走势");
        bundle.putString("min","5 mg/㎡");
        bundle.putString("avg","7.5 mg/㎡");
        bundle.putString("max","10 mg/㎡");
        bundle.putStringArrayList("x",listX);
        bundle.putStringArrayList("y",listY);
        bundle.putIntegerArrayList("scorex",listScoreX);
        bundle.putIntegerArrayList("scorey",listScoreY);
        intent.putExtra("params",bundle);
        intent.setClass(mContext,CommonLinearChartActivity.class);
        mContext.startActivity(intent);
    }

    /**
     * 地面温度走势图
     * @param position
     */
    private void toGroundTemperatureChart(int position){
        ArrayList<String> listX = new ArrayList<>();
        String[] date = {"0","1","2","3","4","5","6","7","8","9",
                "10","11","12","13","14","15","16","17",
                "18","19","20","21","22","23"};//X轴的标注
        for (int i = 0; i < date.length; i++) {
            listX.add(date[i]+"时");
        }
        int[] scorey= {10,8,9,10,10,10,8,9,9,9,
                11,11,12,12,13,13,13,14,14,13,
                12,10,10,10};//图表的数据点
        int[] scorex= {0,1,2,3,4,5,6,7,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};//图表的数据点

        ArrayList<String> listY = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            listY.add(i+"");
        }
        ArrayList<Integer> listScoreX = new ArrayList<>();
        for (int i = 0; i < scorex.length; i++) {
            listScoreX.add(scorex[i]);
        }
        ArrayList<Integer> listScoreY = new ArrayList<>();
        for (int i = 0; i < scorey.length; i++) {
            listScoreY.add(scorey[i]);
        }

        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("title",mList.get(position).title+"走势");
        bundle.putString("min","8 ℃");
        bundle.putString("avg","11 ℃");
        bundle.putString("max","14 ℃");
        bundle.putStringArrayList("x",listX);
        bundle.putStringArrayList("y",listY);
        bundle.putIntegerArrayList("scorex",listScoreX);
        bundle.putIntegerArrayList("scorey",listScoreY);
        intent.putExtra("params",bundle);
        intent.setClass(mContext,CommonLinearChartActivity.class);
        mContext.startActivity(intent);
    }
    /**
     * 声音走势图
     * @param position
     */
    private void toVoiceChart(int position){
        ArrayList<String> listX = new ArrayList<>();
        String[] date = {"0","1","2","3","4","5","6","7","8","9",
                "10","11","12","13","14","15","16","17",
                "18","19","20","21","22","23"};//X轴的标注
        for (int i = 0; i < date.length; i++) {
            listX.add(date[i]+"时");
        }
        int[] scorey= {57,56,56,55,55,56,57,58,58,59,
                57,57,56,54,53,53,54,55,56,56,
                54,55,56,57};//图表的数据点
        int[] scorex= {0,1,2,3,4,5,6,7,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};//图表的数据点

        ArrayList<String> listY = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            listY.add(i+"");
        }
        ArrayList<Integer> listScoreX = new ArrayList<>();
        for (int i = 0; i < scorex.length; i++) {
            listScoreX.add(scorex[i]);
        }
        ArrayList<Integer> listScoreY = new ArrayList<>();
        for (int i = 0; i < scorey.length; i++) {
            listScoreY.add(scorey[i]);
        }

        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("title",mList.get(position).title+"走势");
        bundle.putString("min","54 dB");
        bundle.putString("avg","56 dB");
        bundle.putString("max","59 dB");
        bundle.putStringArrayList("x",listX);
        bundle.putStringArrayList("y",listY);
        bundle.putIntegerArrayList("scorex",listScoreX);
        bundle.putIntegerArrayList("scorey",listScoreY);
        intent.putExtra("params",bundle);
        intent.setClass(mContext,CommonLinearChartActivity.class);
        mContext.startActivity(intent);
    }
}
