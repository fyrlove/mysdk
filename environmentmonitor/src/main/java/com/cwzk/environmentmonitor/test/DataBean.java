package com.cwzk.environmentmonitor.test;

import java.util.ArrayList;
import java.util.List;

import fj.dropdownmenu.lib.pojo.DropdownItemObject;

/**
 * @author FengTong
 * @date 2017/8/22
 */
public class DataBean {

    /**
     * 获取分类数据
     * @return itemType
     */
    public static List<DropdownItemObject> getType(){
        List<DropdownItemObject> itemType = new ArrayList<>();//分类
        DropdownItemObject typeObj = new DropdownItemObject(-1, "全部分类", "全部分类");
        itemType.add(typeObj);
        for (int i = 0; i < 10; i++) {
            typeObj = new DropdownItemObject(i, "分类" + i, "分类" + i);
            itemType.add(typeObj);
        }
        return itemType;
    }

    /**
     * 获取动物一级数据
     * @return itemType
     */
    public static List<DropdownItemObject> getAnimalSingle(){
        List<DropdownItemObject> itemAnimal = new ArrayList<>();//动物
        DropdownItemObject animalObj = new DropdownItemObject(-1, "全部动物", "全部动物");
        itemAnimal.add(animalObj);
        animalObj = new DropdownItemObject(1, "狗", "狗");
        itemAnimal.add(animalObj);
        animalObj = new DropdownItemObject(2, "猫", "猫");
        itemAnimal.add(animalObj);
        return itemAnimal;
    }

    /**
     * 获取动物二级数据
     * @return itemType
     */
    public static List<DropdownItemObject> getAnimalDouble(){
        List<DropdownItemObject> itemAnimalDouble = new ArrayList<>();//所有动物子分类
        DropdownItemObject animalObj = new DropdownItemObject(-1, -1, "全部动物", "全部动物");
        itemAnimalDouble.add(animalObj);

        animalObj = new DropdownItemObject(1, -1, "全部狗", "全部狗");
        itemAnimalDouble.add(animalObj);
        animalObj = new DropdownItemObject(1, 1, "藏獒", "藏獒");
        itemAnimalDouble.add(animalObj);
        animalObj = new DropdownItemObject(1, 2, "二哈", "二哈");
        itemAnimalDouble.add(animalObj);
        animalObj = new DropdownItemObject(1, 3, "土狗", "土狗");
        itemAnimalDouble.add(animalObj);

        animalObj = new DropdownItemObject(2, -1, "全部猫", "全部猫");
        itemAnimalDouble.add(animalObj);
        animalObj = new DropdownItemObject(2, 1, "暹罗", "暹罗");
        itemAnimalDouble.add(animalObj);
        animalObj = new DropdownItemObject(2, 2, "波斯", "波斯");
        itemAnimalDouble.add(animalObj);
        return itemAnimalDouble;
    }


    /**
     * 获取地区省数据
     * @return itemType
     */
    public static List<DropdownItemObject> getRegionProvince(){
        List<DropdownItemObject> regionProvinceList = new ArrayList<>();//地区
        DropdownItemObject regionProvinceObj = new DropdownItemObject(-1, "全部宿舍", "全部宿舍");
        regionProvinceList.add(regionProvinceObj);
        regionProvinceObj = new DropdownItemObject(1, "男生宿舍", "男生宿舍");
        regionProvinceList.add(regionProvinceObj);
        regionProvinceObj = new DropdownItemObject(2, "女生宿舍", "女生宿舍");
        regionProvinceList.add(regionProvinceObj);
        regionProvinceObj = new DropdownItemObject(3, "", "");
        regionProvinceList.add(regionProvinceObj);
        regionProvinceObj = new DropdownItemObject(3, "", "");
        regionProvinceList.add(regionProvinceObj);
        regionProvinceObj = new DropdownItemObject(3, "", "");
        regionProvinceList.add(regionProvinceObj);
        regionProvinceObj = new DropdownItemObject(3, "", "");
        regionProvinceList.add(regionProvinceObj);
        regionProvinceObj = new DropdownItemObject(3, "", "");
        regionProvinceList.add(regionProvinceObj);
        regionProvinceObj = new DropdownItemObject(3, "", "");
        regionProvinceList.add(regionProvinceObj);
//        regionProvinceObj = new DropdownItemObject(3, "江苏", "江苏");
//        regionProvinceList.add(regionProvinceObj);
        return regionProvinceList;
    }

    /**
     * 获取地区市级数据
     * @return itemType
     */
    public static List<DropdownItemObject> getRegionCity(){
        List<DropdownItemObject> regionCityList = new ArrayList<>();//所有二级
        DropdownItemObject regionCityObj  = new DropdownItemObject(-1, -1, "所在楼", "所在楼");
        regionCityList.add(regionCityObj);

        regionCityObj = new DropdownItemObject(1, -1, "全部楼", "全部楼");
        regionCityList.add(regionCityObj);
        regionCityObj = new DropdownItemObject(1, 1, "1栋", "1栋");
        regionCityList.add(regionCityObj);
        regionCityObj = new DropdownItemObject(1, 2, "2栋", "2栋");
        regionCityList.add(regionCityObj);
        regionCityObj = new DropdownItemObject(1, 3, "3栋", "3栋");
        regionCityList.add(regionCityObj);
        regionCityObj = new DropdownItemObject(1, 4, "4栋", "4栋");
        regionCityList.add(regionCityObj);
        regionCityObj = new DropdownItemObject(1, 5, "5栋", "5栋");
        regionCityList.add(regionCityObj);

        regionCityObj = new DropdownItemObject(2, -1, "全部楼", "全部楼");
        regionCityList.add(regionCityObj);
        regionCityObj = new DropdownItemObject(2, 1, "1栋", "1栋");
        regionCityList.add(regionCityObj);
        regionCityObj = new DropdownItemObject(2, 2, "2栋", "2栋");
        regionCityList.add(regionCityObj);
        regionCityObj = new DropdownItemObject(2, 3, "3栋", "3栋");
        regionCityList.add(regionCityObj);
        regionCityObj = new DropdownItemObject(2, 4, "4栋", "4栋");
        regionCityList.add(regionCityObj);
        regionCityObj = new DropdownItemObject(2, 5, "5栋", "5栋");
        regionCityList.add(regionCityObj);
        regionCityObj = new DropdownItemObject(2, 6, "6栋", "6栋");
        regionCityList.add(regionCityObj);

//        regionCityObj = new DropdownItemObject(3, -1, "全部市", "全部市");
//        regionCityList.add(regionCityObj);
//        regionCityObj = new DropdownItemObject(3, 1, "南京", "南京");
//        regionCityList.add(regionCityObj);
//        regionCityObj = new DropdownItemObject(3, 2, "无锡", "无锡");
//        regionCityList.add(regionCityObj);
//        regionCityObj = new DropdownItemObject(3, 3, "徐州", "徐州");
//        regionCityList.add(regionCityObj);
        return regionCityList;
    }

    /**
     * 获取地区区数据
     * @return itemType
     */
    public static List<DropdownItemObject> getRegionArea(){
        List<DropdownItemObject> regionAreaList = new ArrayList<>();//所有区
        DropdownItemObject regionAreaObj = new DropdownItemObject(-1, -1, -1, "全部楼层", "全部楼层");
        regionAreaList.add(regionAreaObj);

        regionAreaObj = new DropdownItemObject(1, -1, -1, "全部楼层", "全部楼层");
        regionAreaList.add(regionAreaObj);

        //-------------云南---------
        regionAreaObj = new DropdownItemObject(1, 1, -1, "全部楼层", "全部楼层");
        regionAreaList.add(regionAreaObj);
        regionAreaObj = new DropdownItemObject(1, 1, 1, "1楼", "1楼");
        regionAreaList.add(regionAreaObj);
        regionAreaObj = new DropdownItemObject(1, 1, 2, "2楼", "2楼");
        regionAreaList.add(regionAreaObj);
        regionAreaObj = new DropdownItemObject(1, 1, 3, "3楼", "3楼");
        regionAreaList.add(regionAreaObj);
        regionAreaObj = new DropdownItemObject(1, 1, 4, "4楼", "4楼");
        regionAreaList.add(regionAreaObj);

        regionAreaObj = new DropdownItemObject(1, 2, -1, "全部楼层", "全部楼层");
        regionAreaList.add(regionAreaObj);
        regionAreaObj = new DropdownItemObject(1, 2, 1, "1楼", "1楼");
        regionAreaList.add(regionAreaObj);
        regionAreaObj = new DropdownItemObject(1, 2, 2, "2楼", "2楼");
        regionAreaList.add(regionAreaObj);
        regionAreaObj = new DropdownItemObject(1, 2, 3, "3楼", "3楼");
        regionAreaList.add(regionAreaObj);
        regionAreaObj = new DropdownItemObject(1, 2, 4, "4楼", "4楼");
        regionAreaList.add(regionAreaObj);

        regionAreaObj = new DropdownItemObject(1, 3, -1, "全部楼层", "全部楼层");
        regionAreaList.add(regionAreaObj);
        regionAreaObj = new DropdownItemObject(1, 3, 1, "1楼", "1楼");
        regionAreaList.add(regionAreaObj);
        regionAreaObj = new DropdownItemObject(1, 3, 2, "2楼", "2楼");
        regionAreaList.add(regionAreaObj);
        regionAreaObj = new DropdownItemObject(1, 3, 3, "3楼", "3楼");
        regionAreaList.add(regionAreaObj);
        regionAreaObj = new DropdownItemObject(1, 3, 4, "4楼", "4楼");
        regionAreaList.add(regionAreaObj);



        //--------------四川-------
        regionAreaObj = new DropdownItemObject(2, 1, -1, "全部楼层", "全部楼层");
        regionAreaList.add(regionAreaObj);
        regionAreaObj = new DropdownItemObject(2, 1, 1, "1楼", "1楼");
        regionAreaList.add(regionAreaObj);
        regionAreaObj = new DropdownItemObject(2, 1, 2, "2楼", "2楼");
        regionAreaList.add(regionAreaObj);
        regionAreaObj = new DropdownItemObject(2, 1, 3, "3楼", "3楼");
        regionAreaList.add(regionAreaObj);
        regionAreaObj = new DropdownItemObject(2, 1, 4, "4楼", "4楼");
        regionAreaList.add(regionAreaObj);

        regionAreaObj = new DropdownItemObject(2, 2, -1, "全部楼层", "全部楼层");
        regionAreaList.add(regionAreaObj);
        regionAreaObj = new DropdownItemObject(2, 2, 1, "1楼", "1楼");
        regionAreaList.add(regionAreaObj);
        regionAreaObj = new DropdownItemObject(2, 2, 2, "2楼", "2楼");
        regionAreaList.add(regionAreaObj);
        regionAreaObj = new DropdownItemObject(2, 2, 3, "3楼", "3楼");
        regionAreaList.add(regionAreaObj);
        regionAreaObj = new DropdownItemObject(2, 2, 4, "4楼", "4楼");
        regionAreaList.add(regionAreaObj);

        regionAreaObj = new DropdownItemObject(2, 3, -1, "全部楼层", "全部楼层");
        regionAreaList.add(regionAreaObj);
        regionAreaObj = new DropdownItemObject(2, 3, 1, "1楼", "1楼");
        regionAreaList.add(regionAreaObj);
        regionAreaObj = new DropdownItemObject(2, 3, 2, "2楼", "2楼");
        regionAreaList.add(regionAreaObj);
        regionAreaObj = new DropdownItemObject(2, 3, 3, "3楼", "3楼");
        regionAreaList.add(regionAreaObj);
        regionAreaObj = new DropdownItemObject(2, 1, 4, "4楼", "4楼");
        regionAreaList.add(regionAreaObj);


        //------------------江苏--------------
//        regionAreaObj = new DropdownItemObject(3, -1, -1, "全部区", "全部区");
//        regionAreaList.add(regionAreaObj);
//
//        regionAreaObj = new DropdownItemObject(3, 1, -1, "全部区", "全部区");
//        regionAreaList.add(regionAreaObj);
//        regionAreaObj = new DropdownItemObject(3, 1, 1, "玄武区", "玄武区");
//        regionAreaList.add(regionAreaObj);
//        regionAreaObj = new DropdownItemObject(3, 1, 2, "秦淮区", "秦淮区");
//        regionAreaList.add(regionAreaObj);
//
//        regionAreaObj = new DropdownItemObject(3, 2, -1, "全部区", "全部区");
//        regionAreaList.add(regionAreaObj);
//        regionAreaObj = new DropdownItemObject(3, 2, 1, "锡山区", "锡山区");
//        regionAreaList.add(regionAreaObj);
//        regionAreaObj = new DropdownItemObject(3, 2, 2, "惠山区", "惠山区");
//        regionAreaList.add(regionAreaObj);
//
//        regionAreaObj = new DropdownItemObject(3, 3, -1, "全部区", "全部区");
//        regionAreaList.add(regionAreaObj);
//        regionAreaObj = new DropdownItemObject(3, 3, 1, "鼓楼区", "鼓楼区");
//        regionAreaList.add(regionAreaObj);
//        regionAreaObj = new DropdownItemObject(3, 3, 2, "云龙区", "云龙区");
//        regionAreaList.add(regionAreaObj);
        return regionAreaList;
    }
}
