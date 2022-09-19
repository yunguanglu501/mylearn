package com.example.learn.lamdar.neibulei;

/**
 * StudyWarp
 *
 * @author wcy
 * @date 2022/8/10
 */
public interface StudyWarp {

    static interface XiaoMing {
        public String getToSchool();
    }

    static interface GOSchool {
        public boolean hasCar();
    }

    public static void study(XiaoMing xiaoMing, GOSchool goSchool) {
        if (goSchool.hasCar()) {
            System.out.println(xiaoMing.getToSchool());
        } else {
            System.out.println("没车送小明上学。");
        }
    }

}
