package eu.alfo.adas;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<QuestionAnswe> listQA = new ArrayList<>();
    private ArrayList<Answer> listA = new ArrayList<>();

    private QuestionAnswe jaut1 = new QuestionAnswe(0.01,0.1);
    private QuestionAnswe jaut2 = new QuestionAnswe(0.8,0.1);
    private QuestionAnswe jaut3 = new QuestionAnswe(0.12,0.1);
    private QuestionAnswe jaut4 = new QuestionAnswe(0.2,0.1);
    private QuestionAnswe jaut5 = new QuestionAnswe(0.5,0.1);
    private QuestionAnswe jaut6 = new QuestionAnswe(0.18,0.1);
    private QuestionAnswe jaut7 = new QuestionAnswe(0.1,0.1);
    private QuestionAnswe jaut8 = new QuestionAnswe(0.1,0.1);

    private Button But1add;
    private Button But1dec;
    private Button But2add;
    private Button But2dec;
    private Button But3add;
    private Button But3dec;
    private Button But4add;
    private Button But4dec;
    private Button But5add;
    private Button But5dec;
    private Button But6add;
    private Button But6dec;
    private Button But7add;
    private Button But7dec;
    private Button But8add;
    private Button But8dec;

    private Button buttonRun;
    private TextView TextViewAns;
    private TextView TextViewPKAns;
    private TextView TextViewPK1;
    private TextView TextViewPK2;
    private TextView TextViewPK3;
    private TextView TextViewPK4;
    private TextView TextViewPK5;
    private TextView TextViewPK6;
    private TextView TextViewPK7;
    private TextView TextViewPK8;

    static double PK_Const = 0.2;

    private Answer ans1 = new Answer(0.5, "Dosies");
    private Answer ans2 = new Answer(0.2,"Nedosies");
    private Answer ans3 = new Answer(0.01, "Čilos");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jaut1.setCheckBox((CheckBox) findViewById(R.id.checkbox1));
        jaut2.setCheckBox((CheckBox) findViewById(R.id.checkbox2));
        jaut3.setCheckBox((CheckBox) findViewById(R.id.checkbox3));
        jaut4.setCheckBox((CheckBox) findViewById(R.id.checkbox4));
        jaut5.setCheckBox((CheckBox) findViewById(R.id.checkbox5));
        jaut6.setCheckBox((CheckBox) findViewById(R.id.checkbox6));
        jaut7.setCheckBox((CheckBox) findViewById(R.id.checkbox7));
        jaut8.setCheckBox((CheckBox) findViewById(R.id.checkbox8));

        jaut1.setTextView((TextView) findViewById(R.id.textViewPK1));
        jaut2.setTextView((TextView) findViewById(R.id.textViewPK2));
        jaut3.setTextView((TextView) findViewById(R.id.textViewPK3));
        jaut4.setTextView((TextView) findViewById(R.id.textViewPK4));
        jaut5.setTextView((TextView) findViewById(R.id.textViewPK5));
        jaut6.setTextView((TextView) findViewById(R.id.textViewPK6));
        jaut7.setTextView((TextView) findViewById(R.id.textViewPK7));
        jaut8.setTextView((TextView) findViewById(R.id.textViewPK8));

        TextViewPK1 = findViewById(R.id.textViewPK1);
        TextViewPK2 = findViewById(R.id.textViewPK2);
        TextViewPK3 = findViewById(R.id.textViewPK3);
        TextViewPK4 = findViewById(R.id.textViewPK4);
        TextViewPK5 = findViewById(R.id.textViewPK5);
        TextViewPK6 = findViewById(R.id.textViewPK6);
        TextViewPK7 = findViewById(R.id.textViewPK7);
        TextViewPK8 = findViewById(R.id.textViewPK8);

        But1add = findViewById(R.id.buttonInc1);
        But1dec = findViewById(R.id.buttonDec1);
        But2add = findViewById(R.id.buttonInc2);
        But2dec = findViewById(R.id.buttonDec2);
        But3add = findViewById(R.id.buttonInc3);
        But3dec = findViewById(R.id.buttonDec3);
        But4add = findViewById(R.id.buttonInc4);
        But4dec = findViewById(R.id.buttonDec4);
        But5add = findViewById(R.id.buttonInc5);
        But5dec = findViewById(R.id.buttonDec5);
        But6add = findViewById(R.id.buttonInc6);
        But6dec = findViewById(R.id.buttonDec6);
        But7add = findViewById(R.id.buttonInc7);
        But7dec = findViewById(R.id.buttonDec7);
        But8add = findViewById(R.id.buttonInc8);
        But8dec = findViewById(R.id.buttonDec8);



        TextViewAns = findViewById(R.id.Result);
        buttonRun = findViewById(R.id.buttonRun);

        TextViewPKAns = findViewById(R.id.textView1);

//        Pievieno atbildes A sarakstam
        listA.add(ans1);
        listA.add(ans2);
        listA.add(ans3);


        listQA.add(jaut1);
        listQA.add(jaut2);
        listQA.add(jaut3);
        listQA.add(jaut4);
        listQA.add(jaut5);
        listQA.add(jaut6);
        listQA.add(jaut7);
        listQA.add(jaut8);

//        Ceļu veidošana (DB zināšanu izveide)
        jaut3.setAnswer(ans1);
//        jaut2.setRoadT(jaut3);
        jaut1.setRoadT(jaut2);
        jaut2.setRoadT(jaut3);

        jaut4.setRoadT(jaut5);
        jaut5.setRoadT(jaut6);
        jaut6.setAnswer(ans1);

        jaut7.setRoadT(jaut8);
        jaut8.setAnswer(ans3);


        for(QuestionAnswe qa : listQA){
            FirstPK(qa.getCount(), qa.getAnswerT());
        }

        for (Answer a : listA){
            FirstPK(a.getCount(), a.getPK());
        }


        buttonRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuestionAnswe answe = null;
                double max = 0.99; //robežvērtība

                for(QuestionAnswe qa : listQA) {
                    if(qa.getCheckBox().isChecked()) {

                        if(answe == null)
                            answe = qa;

                        if (qa.getAnswerT()>=max || qa.getAnswerF()>=max){
                            continue;
                        }

                        if (answe.getAnswerT()>qa.getAnswerT()){
                            answe = qa;
                        }


//                        Log.i("Test", ((St qa.findRow())));
//                        TextViewAns.setText (String.valueOf( qa.findRow()));
                    }
                }


                if (answe != null){

//
                    answe.findAnswer().setPK(PK_formula(answe.findAnswer().getPK()));

//                    getAnswerT == PK
                    answe.setAnswerT(PK_formula(answe.getAnswerT()));
                    answe.getCount();

                }



                TextViewAns.setText(answe.findAnswer().getAnswer());
                TextViewPKAns.setText(String.valueOf( answe.findAnswer().getPK()));


//                TextViewAns.setText (String.valueOf(answe.getAnswerT()));


            Log.i("Test","Done");

                for(QuestionAnswe qa : listQA) {
                    qa.getTextView().setText(String.valueOf(qa.getAnswerT()));

                }



            }


        });





//      1)  ZB aprēķināšana

//     2) Katra jaut apstiprināšana + rez sniegšana

//        pārbauda katru jaut
//        loop (jautN // AnsN)

// ievadam ans1F pārbaudes formulā, palielinam ans1F
        }


//    Atkarto "i" reize = cik reiz parādās IF-ELSE shēmā
//    IF atb1T AND atb2 THEN ans2; PK=0.2
//    IF atb2T AND atb3 THEN ans1; PK=0.3
//    IF atb1T AND atb3 THEN ans3; PK=0.15
//    IF atb1T THEN ans3;         PK=0.4



    private void FirstPK(int UseTime, double pk){

        for (int i = 0; i < UseTime; i++ ){
            PK_formula(pk);
        }
//        Log.i(TAG, FirstPK
    }

//    i=iepriekšējais PK
//    PK_New = jauniegūtais
    private static double PK_formula(double i){
        return  i + (1-i) * PK_Const;
    }




//    private void incAncPK(Button button){
//        switch (button.getId()){
//            case:R.id.buttonInc1:
//
//                ;
//}
//        }
}

