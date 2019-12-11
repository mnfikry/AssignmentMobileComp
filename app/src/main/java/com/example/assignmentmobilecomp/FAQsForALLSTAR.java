package com.example.assignmentmobilecomp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class FAQsForALLSTAR extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faqs_for_allstar);
        ArrayList<Question> questionsList = new ArrayList<>();
        questionsList.add(new Question("Why should I join STARCLUB?","You'll get to enjoy all these privileges when you become our ALLSTARS :\n" +
                "1. Free membership ! No monthly or annual fee.\n" +
                "2. Earn 10 Star Points for every RM1 spent through online purchases or at box office counters or at concession counters.\n" +
                "3. Redemption of Star Points for free movie tickets, snacks & drinks, limited movie merchandises or other promotional items.\n" +
                "4. RM 9 movie ticket on Wednesday* & earn 2x points on any purchase on Wednesday.\n" +
                "5. Birthday Complimentary ticket for 2 persons during your Birthday month.\n" +
                "7. Dedicated ALLSTAR member’s ticketing lane. "));
        questionsList.add(new Question("How to join STARCLUB membership?","•   You can register online at http://www.mbocinemas.com/SignUp.aspx , via MBO Cinemas Mobile App or walk in to any MBO Cinemas counters to register.\n" +
                "•   After registration you can collect your ALLSTAR card at any MBO Cinemas near you.\n" +
                "•   Online account enables you to check your balance/expiring StarPoints online, view transaction history and make online ticket purchase. "));
        questionsList.add(new Question("Is my membership card transferable? ","Sorry, your membership card is strictly non-transferable.  "));
        questionsList.add(new Question("Am I able to hold more than one membership card? ","1.  Each member are allowed to have multiple ALLSTAR card designs.\n" +
                "2.  But ONLY one ALLSTAR card are allowed to be active at for StarPoints collection.\n" +
                "3.  Each membership card is uniquely tagged to your account and identity "));
        questionsList.add(new Question("Will my membership expire?  ","Your membership will not expire.\n" +
                "However, Star Points remain valid and can be used for a period of up to 24 months after the date they were earned.  Star Points earned more than 24 months previously will automatically expire. "));
        questionsList.add(new Question("I have registered my ALLSTAR member card at the cinema, Do I still need to register my account online?","1.  We would love you to do so, in order for you to have a full ALLSTAR experience.\n" +
                "2.  If you already have an ALLSTAR card, you can create your online account here at http://www.mbocinemas.com/CreateUserID.aspx\n" +
                "3.  Online account enables you to check your balance/expiring StarPoints online, view transaction history and make online ticket purchase. "));
        questionsList.add(new Question("I have registered my ALLSTAR member card at the cinema, how to register my account online?","1.  To create an ALLSTAR online account, kindly click here : http://www.mbocinemas.com/CreateUserID.aspx\n" +
                "2.  Enter all the required details in the form. Please note that it must be the same as you had provided when your registered at the cinema.\n" +
                "3.  If your existing ALLSTAR account can be validated, your online account will be activated.\n" +
                "4.  You can log in with your email address (as your user ID) to access your account.\n" +
                "5.  If the email address entered does not match that on your original registration. You will not be able to create an online account "));
        questionsList.add(new Question("How do I update my new Mobile Number?","Simply log on to STARCLUB in MBO webpage and click 'Edit Detail' to update your new Mobile Number. "));
        questionsList.add(new Question("How do I change my password in my online account?","Simply log on to STARCLUB in MBO webpage and click 'Edit Detail' to update your password. "));
        questionsList.add(new Question("How do I update my new email address?","Simply inform us by emailing us from the original email address registered in order for us to verify the autheticity of the account & furnish us the following details : Name,mobile number, I.C no. or passport no & ALLSTAR membership number. Kindly email to customercare@mbocinemas.com. "));

        mRecyclerView = findViewById(R.id.rvFAQsForAllStar);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new QuestionAdapter(questionsList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
