package com.funliving.info;

import com.funliving.info.common.FacilityMap;
import com.funliving.info.common.FileHelper;
import com.google.gson.Gson;

/**
 * Created by Administrator on 2016/8/2.
 */
public class Test {

    public static void main(String[] args) {
//        Map<Integer,FacilityJson> facilityJsonMap = new HashMap<>();
//        facilityJsonMap.put(1,new FacilityJson(1,"wifi1"));
//        facilityJsonMap.put(2,new FacilityJson(2,"wifi2"));
//        facilityJsonMap.put(3,new FacilityJson(3,"wifi3"));
//        facilityJsonMap.put(4,new FacilityJson(4,"wifi4"));
//        facilityJsonMap.put(5,new FacilityJson(5,"wifi5"));
//        facilityJsonMap.put(6,new FacilityJson(6,"wifi6"));
//        facilityJsonMap.put(7,new FacilityJson(7,"wifi7"));
//        facilityJsonMap.put(8,new FacilityJson(8,"wifi8"));
//        facilityJsonMap.put(9,new FacilityJson(9,"wifi9"));
//
//
//        Class<?> type = facilityJsonMap.getClass();
//        Gson gson = new Gson();
//        String content=gson.toJson(facilityJsonMap, type);
//        String localPath=covertToLocal("/facilities");
//
//        FileHelper.save(localPath, content);


//        try {
////            String path = FacilityMap.class.getResource("/").getPath()+"facility.json";
//            String path = "D:\\zhaopin\\mygit\\other\\funliving\\api\\src\\main\\resources\\facility.json";
//            String content= FileHelper.read(path);
//            Class<?> type = Class.forName("com.funliving.info.common.FacilityMap");
//            Gson gson = new Gson();
//            FacilityMap facilityMap=(FacilityMap)gson.fromJson(content, type);
//            System.out.println(facilityMap);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        String path = FileHelper.class.getClass().getResource("/").getPath() + "facility.json";
//        if(path.contains("build")){
//            path=path.replace("classes","resources");
//        }
////        String aa =  FileHelper.class.getResource("/").toString();
////        System.out.println(path);
//        int size=FacilityMap.instance.getSize();
//        System.out.println(size);
    }
    public static synchronized String covertToLocal(String path){
//		String root=System.getProperty("user.dir");
        String root = path.getClass().getResource("/").getPath();
        //System.out.println(root);
        //String root = AppProperties.LOCAL_DIR;
        String dir=root+"/conf";
        //System.out.println(dir);
        if(!FileHelper.exists(dir))  {
            FileHelper.createDir(dir);
        }

        String fileName=path.substring(path.lastIndexOf("/"))+".json";
        System.out.println(dir+fileName);
        return dir+fileName;
    }

}
