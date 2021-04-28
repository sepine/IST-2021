package cn.zitsong.whu.bean;

import java.util.List;

public class AlgorithmResultAll {

    public String dataSet;
    List<AlgorithmResultOnce> algorithmResultOnceList;

    public AlgorithmResultAll() {
    }

    public AlgorithmResultAll(String dataSet, List<AlgorithmResultOnce> algorithmResultOnceList) {
        this.dataSet = dataSet;
        this.algorithmResultOnceList = algorithmResultOnceList;
    }

    public String getDataSet() {
        return dataSet;
    }

    public void setDataSet(String dataSet) {
        this.dataSet = dataSet;
    }

    public List<AlgorithmResultOnce> getAlgorithmResultOnceList() {
        return algorithmResultOnceList;
    }

    public void setAlgorithmResultOnceList(List<AlgorithmResultOnce> algorithmResultOnceList) {
        this.algorithmResultOnceList = algorithmResultOnceList;
    }
}
