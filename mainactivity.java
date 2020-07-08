/**

 *

 * Creative Commons (CC) 2019 Marcos Vinícius da Silva Santos and Marcos Antonio dos Santos

 *

 * Licensed under the Creative Commons, Version 4.0;

 * you may not use this file except in compliance with the License.

 * You may obtain a copy of the License at

 *

 *    https://creativecommons.org/licenses/by-nc-sa/4.0/

 *    https://creativecommons.org/licenses/by-nc-sa/4.0/legalcode

 *    Attribution-NonCommercial-ShareAlike 4.0 International (CC BY-NC-SA 4.0)

 *

 *    https://creativecommons.org/licenses/by-nc-sa/4.0/deed.pt_BR

 *    https://creativecommons.org/licenses/by-nc-sa/4.0/legalcode.pt

 *    Atribuição-NãoComercial-CompartilhaIgual 4.0 Internacional (CC BY-NC-SA 4.0)

 *

 * Unless required by applicable law or agreed to in writing, software

 * distributed under the License is distributed on an "AS IS" BASIS,

 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.

 * See the License for the specific language governing permissions and

 * limitations under the License.

 *

 *

 */
 
 package com.example.cartelabingopra2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView mCard_r0_c0, mCard_r0_c1, mCard_r0_c2, mCard_r0_c3, mCard_r0_c4, mCard_r1_c0, mCard_r1_c1, mCard_r1_c2, mCard_r1_c3, mCard_r1_c4, mCard_r2_c0, mCard_r2_c1, mCard_r2_c2, mCard_r2_c3, mCard_r2_c4, mCard_r3_c0, mCard_r3_c1, mCard_r3_c2, mCard_r3_c3, mCard_r3_c4, mCard_r4_c0, mCard_r4_c1, mCard_r4_c2, mCard_r4_c3, mCard_r4_c4;

    private TextView mText_r0_c0, mText_r0_c1, mText_r0_c2, mText_r0_c3, mText_r0_c4, mText_r1_c0, mText_r1_c1, mText_r1_c2, mText_r1_c3, mText_r1_c4, mText_r2_c0, mText_r2_c1, mText_r2_c2, mText_r2_c3, mText_r2_c4, mText_r3_c0, mText_r3_c1, mText_r3_c2, mText_r3_c3, mText_r3_c4, mText_r4_c0, mText_r4_c1, mText_r4_c2, mText_r4_c3, mText_r4_c4;

    private int mRow0Win = 0,mRow1Win = 0, mRow3Win = 0,  mRow4Win = 0, mCol0Win = 0, mCol1Win = 0, mCol3Win = 0, mCol4Win = 0;

    private int mRow2Win = 1, mCol2Win = 1, mDiagonal0Win = 1, mDiagonal1Win = 1;

    private int mTotalWin = 0;

    private Random rnd = new Random();

    private List<Integer> mListBalls = new ArrayList<Integer>();

    private List<Integer> mListBallsB = new ArrayList<Integer>();

    private List<Integer> mListBallsI = new ArrayList<Integer>();

    private List<Integer> mListBallsN = new ArrayList<Integer>();

    private List<Integer> mListBallsG = new ArrayList<Integer>();

    private List<Integer> mListBallsO = new ArrayList<Integer>();

    private void initializeListBalls(){

        for(int j = 0; j < 75; j++){
            mListBalls.add(0);
        }

        for(int i = 0; i < 5; i++){
            mListBallsB.add(0);
            mListBallsI.add(0);
            mListBallsN.add(0);
            mListBallsG.add(0);
            mListBallsO.add(0);
        }

    }

    private void createColumn(){
        int randomNumber = rnd.nextInt(15);
        int min = 1;
        int max = 15;

        for(int row = 0; row < 5; row++){
            for(int col = 0; col < 5; col++){
                while( !checkNumber(randomNumber) ){
                    randomNumber = rnd.nextInt(max - min + 1) + min;
                }
                mListBalls.set(randomNumber,1);
                switch (row){
                    case 0: mListBallsB.set(col, randomNumber+1); break;
                    case 1: mListBallsI.set(col, randomNumber+1); break;
                    case 2: mListBallsN.set(col, randomNumber+1); break;
                    case 3: mListBallsG.set(col, randomNumber+1); break;
                    case 4: mListBallsO.set(col, randomNumber+1); break;
                }
            }
            min = max + 1;
            max = min + 14;
        }

    }

    public boolean checkNumber(int number){
        boolean result = true;
        if( mListBalls.get(number).equals(1) ){
            result = false;
        }
        return result;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCard_r0_c0 = findViewById(R.id.card_row0_col0);
        mCard_r0_c1 = findViewById(R.id.card_row0_col1);
        mCard_r0_c2 = findViewById(R.id.card_row0_col2);
        mCard_r0_c3 = findViewById(R.id.card_row0_col3);
        mCard_r0_c4 = findViewById(R.id.card_row0_col4);

        mCard_r1_c0 = findViewById(R.id.card_row1_col0);
        mCard_r1_c1 = findViewById(R.id.card_row1_col1);
        mCard_r1_c2 = findViewById(R.id.card_row1_col2);
        mCard_r1_c3 = findViewById(R.id.card_row1_col3);
        mCard_r1_c4 = findViewById(R.id.card_row1_col4);

        mCard_r2_c0 = findViewById(R.id.card_row2_col0);
        mCard_r2_c1 = findViewById(R.id.card_row2_col1);
        mCard_r2_c2 = findViewById(R.id.card_row2_col2);
        mCard_r2_c3 = findViewById(R.id.card_row2_col3);
        mCard_r2_c4 = findViewById(R.id.card_row2_col4);

        mCard_r3_c0 = findViewById(R.id.card_row3_col0);
        mCard_r3_c1 = findViewById(R.id.card_row3_col1);
        mCard_r3_c2 = findViewById(R.id.card_row3_col2);
        mCard_r3_c3 = findViewById(R.id.card_row3_col3);
        mCard_r3_c4 = findViewById(R.id.card_row3_col4);

        mCard_r4_c0 = findViewById(R.id.card_row4_col0);
        mCard_r4_c1 = findViewById(R.id.card_row4_col1);
        mCard_r4_c2 = findViewById(R.id.card_row4_col2);
        mCard_r4_c3 = findViewById(R.id.card_row4_col3);
        mCard_r4_c4 = findViewById(R.id.card_row4_col4);

        mCard_r0_c0.setOnClickListener(this);
        mCard_r0_c1.setOnClickListener(this);
        mCard_r0_c2.setOnClickListener(this);
        mCard_r0_c3.setOnClickListener(this);
        mCard_r0_c4.setOnClickListener(this);

        mCard_r1_c0.setOnClickListener(this);
        mCard_r1_c1.setOnClickListener(this);
        mCard_r1_c2.setOnClickListener(this);
        mCard_r1_c3.setOnClickListener(this);
        mCard_r1_c4.setOnClickListener(this);

        mCard_r2_c0.setOnClickListener(this);
        mCard_r2_c1.setOnClickListener(this);
        mCard_r2_c2.setOnClickListener(this);
        mCard_r2_c3.setOnClickListener(this);
        mCard_r2_c4.setOnClickListener(this);

        mCard_r3_c0.setOnClickListener(this);
        mCard_r3_c1.setOnClickListener(this);
        mCard_r3_c2.setOnClickListener(this);
        mCard_r3_c3.setOnClickListener(this);
        mCard_r3_c4.setOnClickListener(this);

        mCard_r4_c0.setOnClickListener(this);
        mCard_r4_c1.setOnClickListener(this);
        mCard_r4_c2.setOnClickListener(this);
        mCard_r4_c3.setOnClickListener(this);
        mCard_r4_c4.setOnClickListener(this);

        mText_r0_c0 = findViewById(R.id.text_row0_col0);
        mText_r0_c1 = findViewById(R.id.text_row0_col1);
        mText_r0_c2 = findViewById(R.id.text_row0_col2);
        mText_r0_c3 = findViewById(R.id.text_row0_col3);
        mText_r0_c4 = findViewById(R.id.text_row0_col4);

        mText_r1_c0 = findViewById(R.id.text_row1_col0);
        mText_r1_c1 = findViewById(R.id.text_row1_col1);
        mText_r1_c2 = findViewById(R.id.text_row1_col2);
        mText_r1_c3 = findViewById(R.id.text_row1_col3);
        mText_r1_c4 = findViewById(R.id.text_row1_col4);

        mText_r2_c0 = findViewById(R.id.text_row2_col0);
        mText_r2_c1 = findViewById(R.id.text_row2_col1);
        mText_r2_c2 = findViewById(R.id.text_row2_col2);
        mText_r2_c3 = findViewById(R.id.text_row2_col3);
        mText_r2_c4 = findViewById(R.id.text_row2_col4);

        mText_r3_c0 = findViewById(R.id.text_row3_col0);
        mText_r3_c1 = findViewById(R.id.text_row3_col1);
        mText_r3_c2 = findViewById(R.id.text_row3_col2);
        mText_r3_c3 = findViewById(R.id.text_row3_col3);
        mText_r3_c4 = findViewById(R.id.text_row3_col4);

        mText_r4_c0 = findViewById(R.id.text_row4_col0);
        mText_r4_c1 = findViewById(R.id.text_row4_col1);
        mText_r4_c2 = findViewById(R.id.text_row4_col2);
        mText_r4_c3 = findViewById(R.id.text_row4_col3);
        mText_r4_c4 = findViewById(R.id.text_row4_col4);

        initializeListBalls();
        createColumn();
        showCard();

    }


    public void showCard(){
        mText_r0_c0.setText(String.valueOf(mListBallsB.get(0).intValue()));
        mText_r1_c0.setText(String.valueOf(mListBallsB.get(1).intValue()));
        mText_r2_c0.setText(String.valueOf(mListBallsB.get(2).intValue()));
        mText_r3_c0.setText(String.valueOf(mListBallsB.get(3).intValue()));
        mText_r4_c0.setText(String.valueOf(mListBallsB.get(4).intValue()));

        mText_r0_c1.setText(String.valueOf(mListBallsI.get(0).intValue()));
        mText_r1_c1.setText(String.valueOf(mListBallsI.get(1).intValue()));
        mText_r2_c1.setText(String.valueOf(mListBallsI.get(2).intValue()));
        mText_r3_c1.setText(String.valueOf(mListBallsI.get(3).intValue()));
        mText_r4_c1.setText(String.valueOf(mListBallsI.get(4).intValue()));

        mText_r0_c2.setText(String.valueOf(mListBallsN.get(0).intValue()));
        mText_r1_c2.setText(String.valueOf(mListBallsN.get(1).intValue()));
        //mText_r2_c2.setText(String.valueOf(mListBallsN.get(2).intValue()));
        mText_r3_c2.setText(String.valueOf(mListBallsN.get(3).intValue()));
        mText_r4_c2.setText(String.valueOf(mListBallsN.get(4).intValue()));

        mText_r0_c3.setText(String.valueOf(mListBallsG.get(0).intValue()));
        mText_r1_c3.setText(String.valueOf(mListBallsG.get(1).intValue()));
        mText_r2_c3.setText(String.valueOf(mListBallsG.get(2).intValue()));
        mText_r3_c3.setText(String.valueOf(mListBallsG.get(3).intValue()));
        mText_r4_c3.setText(String.valueOf(mListBallsG.get(4).intValue()));

        mText_r0_c4.setText(String.valueOf(mListBallsO.get(0).intValue()));
        mText_r1_c4.setText(String.valueOf(mListBallsO.get(1).intValue()));
        mText_r2_c4.setText(String.valueOf(mListBallsO.get(2).intValue()));
        mText_r3_c4.setText(String.valueOf(mListBallsO.get(3).intValue()));
        mText_r4_c4.setText(String.valueOf(mListBallsO.get(4).intValue()));
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.card_row0_col0:
                mCard_r0_c0.setCardBackgroundColor(0x2ecc71);
                checkWinnerFull();
                mRow0Win++;
                checkWinnerFive(mRow0Win);
                mCol0Win++;
                checkWinnerFive(mCol0Win);
                mDiagonal0Win++;
                checkWinnerFive(mDiagonal0Win);

                break;
            case R.id.card_row0_col1: mCard_r0_c1.setCardBackgroundColor(0x2ecc71);     checkWinnerFull();mRow0Win++; checkWinnerFive(mRow0Win); mCol1Win++; checkWinnerFive(mCol1Win); break;
            case R.id.card_row0_col2: mCard_r0_c2.setCardBackgroundColor(0x2ecc71);     checkWinnerFull();mRow0Win++; checkWinnerFive(mRow0Win); mCol2Win++; checkWinnerFive(mCol2Win); break;
            case R.id.card_row0_col3: mCard_r0_c3.setCardBackgroundColor(0x2ecc71);     checkWinnerFull();mRow0Win++; checkWinnerFive(mRow0Win); mCol3Win++; checkWinnerFive(mCol3Win); break;
            case R.id.card_row0_col4: mCard_r0_c4.setCardBackgroundColor(0x2ecc71);     checkWinnerFull();mRow0Win++; checkWinnerFive(mRow0Win); mCol4Win++; checkWinnerFive(mCol4Win); mDiagonal1Win++; checkWinnerFive(mDiagonal1Win); break;

            case R.id.card_row1_col0: mCard_r1_c0.setCardBackgroundColor(0x2ecc71);     checkWinnerFull();mRow1Win++; checkWinnerFive(mRow1Win); mCol0Win++; checkWinnerFive(mCol0Win); break;
            case R.id.card_row1_col1: mCard_r1_c1.setCardBackgroundColor(0x2ecc71);     checkWinnerFull();mRow1Win++; checkWinnerFive(mRow1Win); mCol1Win++; checkWinnerFive(mCol1Win); mDiagonal0Win++; checkWinnerFive(mDiagonal0Win); break;
            case R.id.card_row1_col2: mCard_r1_c2.setCardBackgroundColor(0x2ecc71);     checkWinnerFull();mRow1Win++; checkWinnerFive(mRow1Win); mCol2Win++; checkWinnerFive(mCol2Win); break;
            case R.id.card_row1_col3: mCard_r1_c3.setCardBackgroundColor(0x2ecc71);     checkWinnerFull();mRow1Win++; checkWinnerFive(mRow1Win); mCol3Win++; checkWinnerFive(mCol3Win); mDiagonal1Win++; checkWinnerFive(mDiagonal1Win); break;
            case R.id.card_row1_col4: mCard_r1_c4.setCardBackgroundColor(0x2ecc71);     checkWinnerFull();mRow1Win++; checkWinnerFive(mRow1Win); mCol4Win++; checkWinnerFive(mCol4Win); break;

            case R.id.card_row2_col0: mCard_r2_c0.setCardBackgroundColor(0x2ecc71);     checkWinnerFull();mRow2Win++; checkWinnerFive(mRow2Win); mCol0Win++; checkWinnerFive(mCol0Win); break;
            case R.id.card_row2_col1: mCard_r2_c1.setCardBackgroundColor(0x2ecc71);     checkWinnerFull();mRow2Win++; checkWinnerFive(mRow2Win); mCol1Win++; checkWinnerFive(mCol1Win); break;
            //case R.id.card_row2_col2: mCard_r2_c2.setCardBackgroundColor(0x2ecc71); break;
            case R.id.card_row2_col3: mCard_r2_c3.setCardBackgroundColor(0x2ecc71);     checkWinnerFull();mRow2Win++; checkWinnerFive(mRow2Win); mCol3Win++; checkWinnerFive(mCol3Win); break;
            case R.id.card_row2_col4: mCard_r2_c4.setCardBackgroundColor(0x2ecc71);     checkWinnerFull();mRow2Win++; checkWinnerFive(mRow2Win); mCol4Win++; checkWinnerFive(mCol4Win); break;

            case R.id.card_row3_col0: mCard_r3_c0.setCardBackgroundColor(0x2ecc71);     checkWinnerFull();mRow3Win++; checkWinnerFive(mRow3Win); mCol0Win++; checkWinnerFive(mCol0Win); break;
            case R.id.card_row3_col1: mCard_r3_c1.setCardBackgroundColor(0x2ecc71);     checkWinnerFull();mRow3Win++; checkWinnerFive(mRow3Win); mCol1Win++; checkWinnerFive(mCol1Win); mDiagonal1Win++; checkWinnerFive(mDiagonal1Win); break;
            case R.id.card_row3_col2: mCard_r3_c2.setCardBackgroundColor(0x2ecc71);     checkWinnerFull();mRow3Win++; checkWinnerFive(mRow3Win); mCol2Win++; checkWinnerFive(mCol2Win); break;
            case R.id.card_row3_col3: mCard_r3_c3.setCardBackgroundColor(0x2ecc71);     checkWinnerFull();mRow3Win++; checkWinnerFive(mRow3Win); mCol3Win++; checkWinnerFive(mCol3Win); mDiagonal0Win++; checkWinnerFive(mDiagonal0Win); break;
            case R.id.card_row3_col4: mCard_r3_c4.setCardBackgroundColor(0x2ecc71);     checkWinnerFull();mRow3Win++; checkWinnerFive(mRow3Win); mCol4Win++; checkWinnerFive(mCol4Win); break;

            case R.id.card_row4_col0: mCard_r4_c0.setCardBackgroundColor(0x2ecc71);     checkWinnerFull();mRow4Win++; checkWinnerFive(mRow4Win); mCol0Win++; checkWinnerFive(mCol0Win); mDiagonal1Win++; checkWinnerFive(mDiagonal1Win);break;
            case R.id.card_row4_col1: mCard_r4_c1.setCardBackgroundColor(0x2ecc71);     checkWinnerFull();mRow4Win++; checkWinnerFive(mRow4Win); mCol1Win++; checkWinnerFive(mCol1Win); break;
            case R.id.card_row4_col2: mCard_r4_c2.setCardBackgroundColor(0x2ecc71);     checkWinnerFull();mRow4Win++; checkWinnerFive(mRow4Win); mCol2Win++; checkWinnerFive(mCol2Win); break;
            case R.id.card_row4_col3: mCard_r4_c3.setCardBackgroundColor(0x2ecc71);     checkWinnerFull();mRow4Win++; checkWinnerFive(mRow4Win); mCol3Win++; checkWinnerFive(mCol3Win); break;
            case R.id.card_row4_col4: mCard_r4_c4.setCardBackgroundColor(0x2ecc71);     checkWinnerFull();mRow4Win++; checkWinnerFive(mRow4Win); mCol4Win++; checkWinnerFive(mCol4Win); mDiagonal0Win++; checkWinnerFive(mDiagonal0Win); break;


        }
    }

    private void checkWinnerFive(int value){

        if( value == 5 && mTotalWin < 24 ){
            Toast.makeText(this, "Vencedor cinquina", Toast.LENGTH_SHORT).show();
            mCard_r2_c2.setCardBackgroundColor(Color.GREEN);
        }

    }

    private void checkWinnerFull(){
        mTotalWin++;
        if( mTotalWin == 24){
            Toast.makeText(this,"Vencedor Cartela Completa", Toast.LENGTH_LONG).show();
            mCard_r2_c2.setCardBackgroundColor(Color.MAGENTA);
        }
    }

}
