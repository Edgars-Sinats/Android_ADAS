package eu.alfo.adas;

public class Answer {

    private double PK;
    private String answer;
    private int count;

    public Answer(double PK, String text1) {
        this.PK = PK;
        this.answer = text1;
    }

    public int getCount(){
        return count;
    }
    public void incCount(){
        count++;

    }

    public double getPK() {
        return PK;
    }

    public void setPK(double PK) {
        this.PK = PK;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;

    }
}
