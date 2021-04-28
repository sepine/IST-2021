package cn.zitsong.whu.bean;

import cn.zitsong.whu.utils.Measure;

public class AlgorithmResultOnce {

    public String algorithm;
    public Measure measure;

    public AlgorithmResultOnce() {
    }

    public AlgorithmResultOnce(String algorithm, Measure measure) {
        this.algorithm = algorithm;
        this.measure = measure;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public Measure getMeasure() {
        return measure;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }
}
