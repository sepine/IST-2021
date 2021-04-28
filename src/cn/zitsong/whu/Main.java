package cn.zitsong.whu;

import cn.zitsong.whu.bean.AlgorithmResultAll;
import cn.zitsong.whu.bean.AlgorithmResultOnce;
import cn.zitsong.whu.bean.TrainTestDataSet;
import cn.zitsong.whu.constant.SuperParameter;
import cn.zitsong.whu.utils.JsonUtil;
import weka.core.Instances;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static cn.zitsong.whu.algorithm.Algorithm.*;
import static cn.zitsong.whu.algorithm.DataProcess.*;
import static cn.zitsong.whu.constant.SuperParameter.STEPS;

public class Main {

	public static void main(String[] args) throws Exception {

		// String rootPath = args[0];

		System.out.println("start time is " + new Date().toString());

		// load data
		List<Instances> dataList = loadDataAll();

		int step = 0;
		while (step != STEPS) {

			try {
				List<AlgorithmResultAll> algorithmResultAllList = new ArrayList<>();

				for(Instances data: dataList) {

					// precessing the data
					List<Instances> instancesList = filterSpecificInstances(data, SuperParameter.positiveClassValue);

					TrainTestDataSet trainTestDataSet = splitDataSet(instancesList);

					Instances train = normalizeAndNominalData(trainTestDataSet.getTrain());
					Instances test = normalizeAndNominalData(trainTestDataSet.getTest());

					String prefix = data.relationName() + "-" + (step + 1) + "-";

					// call the algorithm
					List<AlgorithmResultOnce> nfcList = applyNoneFeatureClassifier(train, test, prefix);
					List<AlgorithmResultOnce> frcList = applyFeatureRankingClassifier(train, test, prefix);
					List<AlgorithmResultOnce> sscList = applySubSetSelectionClassifier(train, test, prefix);
					List<AlgorithmResultOnce> wscList = applyWrapperSubSetSelectionClassifier(train, test, prefix);

					List<AlgorithmResultOnce> allList = new ArrayList<>();
					allList.addAll(nfcList);
					allList.addAll(frcList);
					allList.addAll(sscList);
					allList.addAll(wscList);

					AlgorithmResultAll algorithmResultAll = new AlgorithmResultAll();
					algorithmResultAll.setDataSet(data.relationName());
					algorithmResultAll.setAlgorithmResultOnceList(allList);

					algorithmResultAllList.add(algorithmResultAll);

				}

				// save result to json
				System.out.println("save json file start");
				String json = JsonUtil.object2String(algorithmResultAllList);
				File file = new File("step-" + step + ".json");
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));

				try {
					writer.write(json);
					System.out.println("save json file success");
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("save json file fail");
				} finally {
					writer.close();
				}

				System.out.println("end time is " + new Date().toString());
			} catch (Exception e) {
				e.printStackTrace();
				step--;
				break;
			} finally {
				step++;
			}

		}

//		for(Instances data: dataList) {
//
//			ResultVo result = new ResultVo();
//			result.setDataSet(data.relationName());
//
//			List<AlgorithmResultAll> algorithmResultAllList = new ArrayList<>();
//
//			for(int step = 0; step < STEPS; step++) {
//
//				// precessing the data
//				List<Instances> instancesList = filterSpecificInstances(data, SuperParameter.positiveClassValue);
//
//				TrainTestDataSet trainTestDataSet = splitDataSet(instancesList);
//
//				Instances train = normalizeAndNominalData(trainTestDataSet.getTrain());
//				Instances test = normalizeAndNominalData(trainTestDataSet.getTest());
//
//				String prefix = data.relationName() + "-" + (step + 1) + "-";
//
//				// call the algorithm
//				List<AlgorithmResultOnce> nfcList = applyNoneFeatureClassifier(train, test, prefix);
//				List<AlgorithmResultOnce> frcList = applyFeatureRankingClassifier(train, test, prefix);
//				List<AlgorithmResultOnce> sscList = applySubSetSelectionClassifier(train, test, prefix);
//				List<AlgorithmResultOnce> wscList = applyWrapperSubSetSelectionClassifier(train, test, prefix);
//
//				List<AlgorithmResultOnce> allList = new ArrayList<>();
//				allList.addAll(nfcList);
//				allList.addAll(frcList);
//				allList.addAll(sscList);
//				allList.addAll(wscList);
//
//				AlgorithmResultAll algorithmResultAll = new AlgorithmResultAll();
//				algorithmResultAll.setIndex(step);
//				algorithmResultAll.setAlgorithmResultOnceList(allList);
//
//				algorithmResultAllList.add(algorithmResultAll);
//			}
//
//			result.setData(algorithmResultAllList);
//
//			resultList.add(result);
//		}

		// save result to json
//		System.out.println("save json file start");
//		String json = JsonUtil.object2String(resultList);
//		File file = new File(SuperParameter.RESULT_PATH);
//		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));

//		try {
//			writer.write(json);
//			System.out.println("save json file success");
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("save json file fail");
//		} finally {
//			writer.close();
//		}
//
//		System.out.println("end time is " + new Date().toString());
	}

}
