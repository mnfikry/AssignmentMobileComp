package com.example.assignmentmobilecomp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class PrivacyPolicy extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);
        ArrayList<Question> questionsList = new ArrayList<>();
        questionsList.add(new Question(" Mcat Box Office Sdn. Bhd.’s Privacy Policy and Personal Data Notice\n" +
                "Updated: 3rd March 2017\n" +
                "\n" +
                "    The privacy and personal data policy and practices of Mcat Box Office Sdn Bhd (MBO Cinemas) set out in this Privacy Policy and Personal Data Notice apply to MBO’s services available under the domain www.mbocinemas.com and MBO Mobile App via any mobile device or computer of any kind.\n" +
                "    MBO Cinemas collection of your personal data is part of its normal operation of MBO Cinemas services. MBO Cinemas developed this Privacy Policy to inform you about MBO Cinemas policy and practices on personal data and privacy matters and because MBO Cinemas believes that you should know as much as possible about such matters so that you can make informed decisions.\n" +
                "    By visiting or using MBO Cinemas website/MBO Cinemas Mobile App, you agree to be bound by the terms and conditions of this Privacy Policy and Personal Data Notice. If you do not agree to such terms and conditions, please do not use or access MBO Cinemas website/MBO Cinemas Mobile App.\n" +
                "    SMS messaging, also known as text messaging, is an additional method of communication that MBO Cinemas will use to communicate with you. SMS messaging will be utilized to relay information for things such as announcement, promotions, contests, events, that are time sensitive in nature.\n" +
                "    This written notice serves to inform you that your personal data is being processed by or on behalf of MBO Cinemas. For the purpose of this written notice, the terms “personal data” and “processing” shall have the meaning assigned to them in the Personal Data Protection Act 2010 (hereinafter referred to as the “PDPA”).\n",""));
        questionsList.add(new Question("Collection of your personal data","Your personal data processed by MBO Cinemas includes:-\n" +
                "\n" +
                "    your personal details (such as name, gender, identification support documents (including NRIC or passport number), date of birth, nationality, country, marital status, occupation, credit card details) and contact details (such as mailing address, e-mail address, and phone numbers);\n" +
                "    movie ticket transaction details from e-ticketing (MBO Cinemas website/MBO Cinemas Mobile App/other platforms) and box-office counter at all MBO Cinemas locations;\n" +
                "    your feedback information gathered from multiple sources such as e-mail, phone (call or SMS), write-in (mail or official feedback form), and social media pages;\n" +
                "    your visit(s) to MBO Cinemas website/MBO Cinemas Mobile App - name of internet service provider, the website from which you visit MBO Cinemas website/MBO Cinemas Mobile App, the pages and content which you view, the date and duration of your visit, cookies to track usage patterns, etc from the analytics tools such as Google Analytics for Web and App and others;\n" +
                "    your personal interests and preferences to help MBO Cinemas design the offering of its services;\n" +
                "    recording of your image via CCTV cameras when you visit MBO Cinemas location;\n" +
                "    Information given voluntarily by you during any on-ground promotions or digital activities, tie-ups, contests, etc.; and\n" +
                "    Your curriculum vitae or resume when you register your interest in having a career in MBO Cinemas.\n"));
        questionsList.add(new Question("Purposes","MBO Cinemas may process your personal data collected from you or from any of the class of third parties stated in this Privacy Policy, for any one or more of the following purposes (hereinafter referred to as the “Purposes”) :-\n" +
                "\n" +
                "    To verify your identity;\n" +
                "        To communicate with you and deliver information that is requested by you to you and/or, in some cases, is targeted to your interests, such as targeted banner advertisements, administrative notices, product offerings, and communications relevant to your use of MBO Cinemas website/MBO Cinemas Mobile App;\n" +
                "        To process any communication you send to MBO Cinemas (for example, answering any queries, dealing with any complaints and/or feedbacks);\n" +
                "        To notify and/or invite you to events or activities organized by MBO Cinemas, its subsidiaries, partners or sponsors;\n" +
                "        To notify you about benefits, changes to the features, promotions, alerts, newsletter, updates, promotional materials and special privileges;\n" +
                "        To send you festive greetings and movie-related content;\n" +
                "        To run MBO Cinemas customer loyalty programmes where applicable;\n" +
                "        MBO Cinemas reserves the right to send SMS to users’ mobile phone numbers containing information, promotion, contest, and event, membership activity regarding MBO Cinemas or MBO STARCLUB. SMS may be sent using an automated system.\n" +
                "        To establish and better manage any business relationship MBO Cinemas may have with you;\n" +
                "        To help MBO Cinemas monitor and improve its services to you, the service of MBO Cinemas locations, MBO Cinemas overall service, MBO Cinemas staff training, MBO Cinemas quality assurance, MBO Cinemas customer service teams, MBO Cinemas website & MBO Cinemas Mobile App and other MBO Cinemas related assets;\n" +
                "        To conduct marketing activities (for example, market research and surveys);\n" +
                "        To maintain records required for auditing, security, claims and/or other legal purposes;\n" +
                "        To investigate and resolve any ticketing issues, queries, complaints or other enquiries that you may submit to MBO Cinemas regarding MBO Cinemas products and services through MBO Cinemas customer service team or cinema staff;\n" +
                "        To investigate, respond to, and/or defend claims made against, or involving MBO Cinemas and/or its relevant subsidiaries;\n" +
                "        For compliance with and/or any purposes required by any relevant law, directives, guidelines, orders, rules, regulations and requirements of any governmental or statutory authority or administrative or regulatory or supervisory body (including disclosure thereunder);\n"));
        questionsList.add(new Question("Source of your personal data","Your personal data is collected directly from you when you:-\n" +
                "\n" +
                "    interact and communicate with MBO Cinemas and/or its related subsidiaries at any of its events or activities;\n" +
                "    log in to www.mbocinemas.com or MBO mobile app to purchase tickets, view show times & promotions, locate our cinema, sign up as an ALLSTAR member or etc;\n" +
                "    communicate with MBO Cinemas by getting in touch with MBO Cinemas customer service through any available MBO Cinemas channels; including lodge a complaint through customer service or through staffs at any MBO Cinemas locations.\n" +
                "    communicate with MBO Cinemas by purchasing tickets at any MBO Cinemas locations or online through www.mbocinemas.com or MBO Mobile App\n" +
                "    Register as an MBO Starclub Member (ALLSTAR) online at www.mbocinemas.com/starclub, MBO Cinemas mobile app, on ground events, ALLSTAR roving team, or at any MBO Cinemas locations in Malaysia., on ground or at any MBO Cinemas locations in Malaysia.\n" +
                "    participate in any of MBO Cinemas surveys, polls or other similar vehicles used to improve the content of MBO Cinemas website, MBO Cinemas Mobile App, MBO Cinemas social pages;\n" +
                "    Enter or participate in any ALLSTAR Exclusive competitions, contests, programmes, or screening organized by MBO Cinemas in any platforms that MBO Cinemas owned.\n" +
                "    Enter or participate in any Non-ALLSTAR Exclusive competitions, contests, programmes, or screening organised by MBO Cinemas in any platforms that MBO Cinemas owned.\n" +
                "    Respond to any marketing materials including electronic direct mailer or SMS that MBO Cinemas sends out including social media posts in any social platform and digital advertising on social media pages, Google Search, YouTube or any other platforms that MBO Cinemas engage.\n" +
                "    visit or browse MBO Cinemas website, MBO Cinemas mobile app and any other MBO Cinemas owned social platforms;\n"));
        questionsList.add(new Question("Your rights of access and correction","You have the following rights in relation to your Personal Data:-\n" +
                "\n" +
                "    To make a data request in writing to MBO Cinemas for information of your personal data that is being processed by or on behalf of MBO Cinemas (Section 30(2) of PDPA);\n" +
                "    To correct any of your personal data which is inaccurate, incomplete, misleading or not upto-date at any time on MBO Cinemas website by clicking on Edit Profile button in Starclub Dashboard page after logging into MBO Cinemas’s website; and\n" +
                "    To limit the processing of your personal data including the personal data relating to other persons who may be identified from your personal data (Section 7(1)(f) of PDPA).\n" +
                "    To unsubscribe to our marketing materials and/or correspondence by clicking the unsubscribe link contained in the emails and/or newsletters MBO Cinemas sends to you and following the instructions therein\n" +
                "\n" +
                "To unsubscribe to our short messaging service (SMS), kindly contact our customer service via email at customercare@mbocinemas.com or contact us at 03-76642808\n" +
                "\n" +
                "To request for your personal data to be removed from MBO Cinemas database by writing in to our Customer Service via email - customercare@mbocinemas.com\n" +
                "\n" +
                "If you have any request in relation to the above mentioned rights under 4(a) or 7(c) above or any inquiries or complaints in respect of your personal data, please write to our Customer Service via email at customercare@mbocinemas.com\n" +
                "\n" +
                "MBO Cinemas may refuse to comply with your data access request under the circumstances specified in the PDPA and if MBO Cinemas does so, MBO Cinemas will inform you of its refusal and the reason(s) for its refusal. "));
        questionsList.add(new Question("Class of third parties to whom MBO Cinemas may disclose your personal data","This is the class of persons to whom MBO Cinemas may disclose your personal data:- Service provider(s) for:-\n" +
                "\n" +
                "    the management of communications on MBO Cinemas behalf;\n" +
                "    the arrangement and conduct of MBO Cinemas events, activities and services;\n" +
                "    Any third party or company that MBO Cinemas engages or appoints to conduct statistical analysis;\n" +
                "    our consultants, accountants, auditors, lawyers or other financial or professional advisers;\n" +
                "    Such other authorities, bodies or parties when required by law; and\n" +
                "    Payment channels including without limitation financial institutions for purpose of assessing, verifying, effectuating and facilitating payment of any amount due to MBO Cinemas in connection with your acquisition of our services and/or products;\n"));
        questionsList.add(new Question("Your obligations","It is obligatory for you to supply MBO Cinemas with your personal data and your failure to do so will result in MBO Cinemas being unable to process your personal data for any of the Purposes. You will take reasonable steps to ensure that your personal data is accurate, complete, not misleading and kept up-to-date."));
        questionsList.add(new Question("Security of your personal data","MBO Cinemas, when processing your personal data, takes practical steps to protect your personal data from any loss, misuse, modification, unauthorized or accidental access or disclosure, alteration or destruction including but not limited to the use of procedural and technical safeguards such as encryption, \"firewalls\" and secure socket layers."));
        questionsList.add(new Question("Amendment to this Privacy Policy","MBO Cinemas reserves the right to amend this Privacy Policy and Personal Data Notice at any time by posting an amended Privacy Policy and Personal Data Notice containing such amendments on MBO Cinemas website/MBO Cinemas Mobile App or by any other mode MBO Cinemas deems suitable."));
        questionsList.add(new Question("Links to third party websites","When you use a link from MBO Cinemas website or MBO Cinemas Mobile App to another third party website, this Privacy Policy is no longer in effect. Once you have used such link, MBO Cinemas does not have any control over that other third party website and MBO Cinemas cannot and shall not be liable or responsible for the protection and privacy of any personal data which you provided whilst visiting such website(s). Your browsing of and interaction on any other third party website(s) will be subject to that websites’ own rules and policies."));

        mRecyclerView = findViewById(R.id.rvPrivacyPolicy);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new QuestionAdapter(questionsList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
