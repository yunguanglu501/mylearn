package com.example.learn.lamdar.neibulei;

/**
 * Study
 *
 * @author wcy
 * @date 2022/8/10
 */
public interface Study {

    public void study();

    class XiaoMing implements Study {

        public void study() {
            System.out.println("我爱学习！！");
        }
    }

    public static Study getInstance() {
        return new XiaoMing();
    }
}
