package cn.zitsong.whu.feature;

import weka.attributeSelection.ASEvaluation;
import weka.attributeSelection.WrapperSubsetEval;

/**
 * @Description: Wrapper-based Subset Selection techniques
 * @Source: JDK 1.8
 * @Author: ZhaoKunsong
 * @Date: 2020-01-08 12:07
 * @Since: version 1.0.0
 **/
public class WrapperSubsetSelectionTechnique {

    /**
     * KNN + AUC
     */
    public static ASEvaluation wrapperSubsetKNNAUC() {
        WrapperSubsetEval eval = new WrapperSubsetEval();
        eval.setClassifier(WrapperClassifierMeasure.knn());
        eval.setEvaluationMeasure(WrapperClassifierMeasure.AUC());
        return eval;
    }

//    /**
//     * KNN + PR-AUC
//     */
//    public static ASEvaluation wrapperSubsetKNNPRAUC() {
//        WrapperSubsetEval eval = new WrapperSubsetEval();
//        eval.setClassifier(WrapperClassifierMeasure.knn());
//        eval.setEvaluationMeasure(WrapperClassifierMeasure.prAUC());
//        return eval;
//    }
//
//    /**
//     * KNN + R-MSE
//     */
//    public static ASEvaluation wrapperSubsetKNNRMSE() {
//        WrapperSubsetEval eval = new WrapperSubsetEval();
//        eval.setClassifier(WrapperClassifierMeasure.knn());
//        eval.setEvaluationMeasure(WrapperClassifierMeasure.rMSE());
//        return eval;
//    }

    /**
     * Logistic Regression + AUC
     */
    public static ASEvaluation wrapperSubsetLRAUC() {
        WrapperSubsetEval eval = new WrapperSubsetEval();
        eval.setClassifier(WrapperClassifierMeasure.logisticRegression());
        eval.setEvaluationMeasure(WrapperClassifierMeasure.AUC());
        return eval;
    }

//    /**
//     * Logistic Regression + PR-AUC
//     */
//    public static ASEvaluation wrapperSubsetLRPRAUC() {
//        WrapperSubsetEval eval = new WrapperSubsetEval();
//        eval.setClassifier(WrapperClassifierMeasure.logisticRegression());
//        eval.setEvaluationMeasure(WrapperClassifierMeasure.prAUC());
//        return eval;
//    }
//
//    /**
//     * Logistic Regression + R-MSE
//     */
//    public static ASEvaluation wrapperSubsetLRRMSE() {
//        WrapperSubsetEval eval = new WrapperSubsetEval();
//        eval.setClassifier(WrapperClassifierMeasure.logisticRegression());
//        eval.setEvaluationMeasure(WrapperClassifierMeasure.rMSE());
//        return eval;
//    }

    /**
     * Naive Bayes + AUC
     */
    public static ASEvaluation wrapperSubsetNBAUC() {
        WrapperSubsetEval eval = new WrapperSubsetEval();
        eval.setClassifier(WrapperClassifierMeasure.naiveBayes());
        eval.setEvaluationMeasure(WrapperClassifierMeasure.AUC());
        return eval;
    }

//    /**
//     * Naive Bayes + PR-AUC
//     */
//    public static ASEvaluation wrapperSubsetNBPRAUC() {
//        WrapperSubsetEval eval = new WrapperSubsetEval();
//        eval.setClassifier(WrapperClassifierMeasure.naiveBayes());
//        eval.setEvaluationMeasure(WrapperClassifierMeasure.prAUC());
//        return eval;
//    }
//
//    /**
//     * Naive Bayes + R-MSE
//     */
//    public static ASEvaluation wrapperSubsetNBRMSE() {
//        WrapperSubsetEval eval = new WrapperSubsetEval();
//        eval.setClassifier(WrapperClassifierMeasure.naiveBayes());
//        eval.setEvaluationMeasure(WrapperClassifierMeasure.rMSE());
//        return eval;
//    }

    /**
     * Ripper + AUC
     */
    public static ASEvaluation wrapperSubsetRipperAUC() {
        WrapperSubsetEval eval = new WrapperSubsetEval();
        eval.setClassifier(WrapperClassifierMeasure.ripper());
        eval.setEvaluationMeasure(WrapperClassifierMeasure.AUC());
        return eval;
    }

//    /**
//     * Ripper + PR-AUC
//     */
//    public static ASEvaluation wrapperSubsetRipperPRAUC() {
//        WrapperSubsetEval eval = new WrapperSubsetEval();
//        eval.setClassifier(WrapperClassifierMeasure.ripper());
//        eval.setEvaluationMeasure(WrapperClassifierMeasure.prAUC());
//        return eval;
//    }
//
//    /**
//     * Ripper + R-MSE
//     */
//    public static ASEvaluation wrapperSubsetRipperRMSE() {
//        WrapperSubsetEval eval = new WrapperSubsetEval();
//        eval.setClassifier(WrapperClassifierMeasure.ripper());
//        eval.setEvaluationMeasure(WrapperClassifierMeasure.rMSE());
//        return eval;
//    }

}
