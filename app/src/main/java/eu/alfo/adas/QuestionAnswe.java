package eu.alfo.adas;

import android.widget.CheckBox;

public class QuestionAnswe {

    public QuestionAnswe(double i, double j){
//        this.checkBox = new CheckBox();
        answerT = i;
        answerF = j;
    }

    public double findRow(){
        double max = 0;
        double v1 = 0;
        if(this.answer == null){


            if(roadT != null){
                 max = roadT.findRow();

            }
            if (roadF != null) {
                v1= roadF.findRow();

            }
            return Math.max(max, v1);
        }

        return answer.getPK();
    }

    public Answer  findAnswer(){
        Answer max = null;
        Answer v1 = null;
        if(this.answer == null){


            if(roadT != null){
                max = roadT.findAnswer();

            }
            if (roadF != null) {
                v1= roadF.findAnswer();

            }

            if(max == null)
                return v1;
             if(v1 == null)
                 return max;

            if((max.getPK() > v1.getPK())) {
                return max;
            }else {
                return v1;
            }
        }

        return answer;
    }




//

    private double answerT;
    private double answerF;
    private CheckBox checkBox;
    private QuestionAnswe roadT;
    private QuestionAnswe roadF;
    private Answer answer;
    private int count;

    public int getCount() {
        return count;
    }

    public void incCont() {
        count++;
    }

    public QuestionAnswe getRoadT() {
        return roadT;
    }

    public void setRoadT(QuestionAnswe roadT) {
        this.roadT = roadT;
        this.roadT.incCont();
    }

    public QuestionAnswe getRoadF() {
        return roadF;
    }

    public void setRoadF(QuestionAnswe roadF) {
        this.roadF = roadF;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
        this.answer.incCount();
    }


//    celš[atb1;jaut2F;jaut1F;jaut3T];

    public double getAnswerT() {
        return answerT;
    }

    public void setAnswerT(double answerT) {
        this.answerT = answerT;
    }

    public double getAnswerF() {
        return answerF;
    }

    public void setAnswerF(double answerF) {
        this.answerF = answerF;
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
    }
}
