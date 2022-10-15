package com.example.learn.load;

import cn.hutool.system.oshi.CpuInfo;
import cn.hutool.system.oshi.OshiUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @description: 负载工具类
 * @author: 程凯
 * @create: 2022-10-14 15:56
 **/
public class LoadUtil {

    /**
     * 获取cpu占用率，数值为百分比的分子
     */
    public static BigDecimal getCPUUsed() {
        CpuInfo cpuInfo = OshiUtil.getCpuInfo();
        double free = cpuInfo.getFree();
        BigDecimal used = new BigDecimal(100).subtract(new BigDecimal(free));
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        return new BigDecimal(decimalFormat.format(used));
    }

    /**
     * CPU占用率是否超过某值
     */
    public static Boolean isGreaterThanSystemCPU(Double cpuLoad) {
        return new BigDecimal(cpuLoad).compareTo(getCPUUsed()) > 0;
    }

    /**
     * 获取内存占用率，数值为百分比的分子
     */
    public static BigDecimal getMemoryUsed() {
        long total = OshiUtil.getMemory().getTotal();
        long available = OshiUtil.getMemory().getAvailable();
        long used = total - available;
        BigDecimal ratio = new BigDecimal(used).multiply(new BigDecimal(100)).divide(new BigDecimal(total), RoundingMode.HALF_UP);
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        return new BigDecimal(decimalFormat.format(ratio));
    }

    public static Boolean isGreaterThanSystemMemory(Double memory) {
        return new BigDecimal(memory).compareTo(getMemoryUsed()) > 0;
    }

    public static void main(String[] args) {
        System.out.println("CPU Load Used = " + getCPUUsed());
        System.out.println("Memory Used  = " + getMemoryUsed());

        System.out.println("compareCPU  = " + isGreaterThanSystemCPU(25.0));
        System.out.println("compareMemory  = " + isGreaterThanSystemMemory(45.0));
    }
}
