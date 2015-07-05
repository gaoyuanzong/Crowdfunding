package com.crowdfunding.core.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目状态
 */
public enum ProjectStatus {

    /** 已保存*/
    SAVED(0),

    /**待审核*/
    UNCHECK(100),

    /**审核通过*/
    CHECK_PASSED(200),

    /**审核驳回*/
    CHECK_REJECTED(300),

    /**审核否决*/
    CHECK_OVER(400),

//    /**融资中*/
//    FUNDING(700),

    /**募集失败*/
     FAILURE(800),

    /**募集成功*/
    SUCCESS(900),

    /**融资失败未退款*/
    FINANCEFAILUREREFUNDWAIT(1000),

    /**融资失败退款中待审核*/
    FINANCEFAILUREREFUND(1025),

    /**融资失败退款中审核通过*/
    FINANCEFAILUREREFUNDSTART(1050),

    /**融资失败退款中审核驳回*/
    FINANCEFAILUREREFUNDSTOP(1075),

    /**融资成功*/
    FINANCEFASUCCESS(1100),

    /**融资失败*/
    FINANCEFAILURE(1200);

    public static Map<Integer, String> projectStatus = new HashMap<Integer, String>();
    static {
        projectStatus.put(SAVED.value(), "已保存");
        projectStatus.put(UNCHECK.value(), "待审核");
        projectStatus.put(CHECK_PASSED.value(), "审核通过");
        projectStatus.put(CHECK_REJECTED.value(), "审核驳回");
        projectStatus.put(CHECK_OVER.value(), "审核否决");
        //projectStatus.put(FUNDING.value(), "融资中");
        projectStatus.put(FAILURE.value(), "募集失败");
        projectStatus.put(SUCCESS.value(), "募集成功");
        projectStatus.put(FINANCEFAILUREREFUNDWAIT.value(), "融资失败未退款");
        projectStatus.put(FINANCEFAILUREREFUND.value(), "融资失败退款待审核");
        projectStatus.put(FINANCEFAILUREREFUNDSTART.value(), "融资失败退款中审核通过");
        projectStatus.put(FINANCEFAILUREREFUNDSTOP.value(), "融资失败退款中审核驳回");
        projectStatus.put(FINANCEFASUCCESS.value(), "融资成功");
        projectStatus.put(FINANCEFAILURE.value(), "融资失败");
    }

    private final Integer value;
    ProjectStatus(Integer value){
        this.value = value;
    }
    public Integer value(){
        return this.value;
    }

}
