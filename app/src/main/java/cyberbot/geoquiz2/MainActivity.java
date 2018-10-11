package cyberbot.geoquiz2;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity
{
    private static final String KEY = "index";
    private static final String TAG = "geo";
    private Button mTrueB;
    private Button mFalseB;
    private Button mNextB;
    private Button mPreB;
    private TextView mbutton;
    int c=0;
    private True[] mqbank=new True[]
            {

                    new True(R.string.delhi, true),
                    new True(R.string.Dehradun, true),
                    new True(R.string.DIT, true),

            };
    private int mCurrentIndex = 0;
    //private Button mtrueques;

    public void updateQuestion() {
        int question = mqbank[mCurrentIndex].getmQuestion();
        mbutton.setText(question);}
    private void checkAnswer ( boolean userPressedTrue){
        boolean answerIsTrue = mqbank[mCurrentIndex].ismTrueQuestion();

        int messageResId = 0;


        if (userPressedTrue == answerIsTrue) {
            messageResId = R.string.correct;
           c++;
//           showAnswer();
        }
         else {
            messageResId = R.string.False;
            c--;
//            showAnswer();
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
                .show();

        showAnswer();
    }

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle) called");
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            mCurrentIndex = savedInstanceState.getInt(KEY, 0);
        }
        mbutton = (TextView) findViewById(R.id.questions);
        //int question = mqbank[mCurrentIndex].getQuestion();
        // mbutton.setText(question);
        mFalseB = (Button) findViewById(R.id.FalseB);
        mTrueB = (Button) findViewById(R.id.TrueB);
        mTrueB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast t = Toast.makeText(geo.this, R.string.correct, Toast.LENGTH_SHORT);
                //t.show();
                //t.LENGTH_SHORT).show();
                checkAnswer(true);
            }
        });
//        mFalseB = (Button) findViewById(R.id.FalseB);
        mFalseB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(geo.this, R.string.False, Toast.LENGTH_SHORT).show();
                //t.LENGTH_SHORT).show();
                checkAnswer(false);
            }


        });
        mNextB = (Button) findViewById(R.id.NextB);
        mNextB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mCurrentIndex = (mCurrentIndex + 1);
                //int question = mqbank[mCurrentIndex].getQuestion();
                // mbutton.setText(question);
                if(mCurrentIndex==mqbank.length)
                    mCurrentIndex=mqbank.length-1;
               updateQuestion();
            }
        });
        updateQuestion();

        mPreB=(Button) findViewById(R.id.PreB);
        mPreB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                mCurrentIndex = (mCurrentIndex - 1);
                if(mCurrentIndex==-1)
                    mCurrentIndex= mqbank.length-1;
                if(mCurrentIndex==0&mCurrentIndex==1&mCurrentIndex==2) {
                    updateQuestion();
                }
                }

        });
    }
    public void showAnswer()
    {
        String msg1=("Your grade is "+ c);
        Toast.makeText(this,msg1, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putInt(KEY, mCurrentIndex);
    }
    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }
    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }
}