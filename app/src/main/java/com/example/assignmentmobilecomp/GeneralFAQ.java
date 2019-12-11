package com.example.assignmentmobilecomp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class GeneralFAQ extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_faq);

        ArrayList<Question> questionsList = new ArrayList<>();
        questionsList.add(new Question("During the seat selection (online purchase), why can't I leave an empty seat in between?","Following MBO Cinemas' online booking policies, leaving 1 empty seat in between reserved seats is not allowed. You may however leave 2 seats empty between reserved seats."));
        questionsList.add(new Question("What do I do if I didn't receive my booking confirmation?","Our booking confirmation email may take 20 minutes to deliver. Kindly check your email inbox again including junk/ spam mailbox.\n" +
                "\n" +
                "Booking confirmation for Mobile App will be displayed after tickets purchased. You can view it again at Purchases tab under ‘Booking’ in the app itself.\n" +
                "\n" +
                "If you did not receive the confirmation, kindly email us at customercare@mbocinemas.com with your full name, contact number, email address, cinema location, show time and amount charged. "));
        questionsList.add(new Question("What are the methods by which I can make an online booking?","You can purchase your tickets online at www.mbocinemas.com or simply download our mobile app from Google Play Store or Apple App Store.\n"));
        questionsList.add(new Question("What are the essentials for collecting my ticket at the box office?","From 1 January 2018 – QR Code Ticket was made available for website www.mbocinemas.com purchases.\n" +
                "You may bring QR Code Ticket to the usher counter at MBO Cinemas for entry to the movie hall.\n" +
                "\n" +
                "QR Code Ticket for website purchases are displayed at the confirmation page and inside your Starclub dashboard when logged in under ‘Booking’\n" +
                "\n" +
                "For ticket purchase using MBO Mobile App (iOS or Android) – proceed to the usher counter to scan your QR Code ticket for entry to the movie hall.\n" +
                "\n" +
                "*Usher counters equipped with QR code/Barcode scanners are available at all MBO Cinemas "));
        questionsList.add(new Question("What are the charges for booking tickets online or using mobile app?","Online ticketing at www.mbocinemas.com and MBO Mobile App are subject to an RM1 booking fee effective 2 January 2018.\n" +
                "Tickets prices displayed in www.mbocinemas.com and MBO Mobile App are GST 0%*\n" +
                "\n" +
                "* Kadar Cukai Barang & Perkhidmatan 6% dipinda menjadi 0% berkuatkuasa 1 Jun 2018. Oleh yang demikian, peniaga masih tertakluk kepada perundangan Cukai Barang & Perkhidmatan semasa. Perintah CBP (Kadar Cukai) (Pindaan )2018/ P.U. (A) 118/2018 "));
        questionsList.add(new Question("If i wish to purchase a couple seat for 2 persons, what quantity should i select during the booking process?","1.  Kindly select the couple seat during the Seat Selection process\n" +
                "2.  Select ‘1’ as the quantity in the next step\n" +
                "3.  If you purchase 2 couple seats (for 4 person) – kindly select 2 couple seat in seat selection process and select ‘2’ for the quantity"));
        questionsList.add(new Question("What is Happy Wednesday?","1.  ALLSTAR members get to purchase movie tickets at RM9 each (0% GST) on every Wednesday either online www.mbocinemas.com, box office counters, or MBO Mobile App.\n" +
                "2.  ALLSTAR members get to enjoy 2x (double) points with every purchase of movie tickets or concession items on Wednesday.\n" +
                "3.  Happy Wednesday promotion is valid for Standard 2D, Standard 3D only. Happy Wednesday is not valid for Premier Actuator Halls, Premier Halls, Premier Auro Halls, BIG SCREEN, MX4D & KECIL\n" +
                "4.  Happy Wednesday is not valid for any Sneak Movies, and on any State, National, Public or Special Holidays (including Chinese New Year & Hari Raya week).\n" +
                "5.  ALLSTAR members are however still entitled to earn 2x (double) points on every Wednesday regardless of point No.4\n" +
                "6.  2x Points only applicable for purchases made on Wednesday for Wednesday only. It’s not applicable for Wednesday sessions purchased on a Non-Wednesday.\n" +
                "7.  Happy Wednesday are not applicable with any ongoing promotion or discount that are available.\n" +
                "8.  ALLSTAR members are required to show or produce their ALLSTAR card the counter, or log in at www.mbocinemas.com to purchase movie session on Wednesday in order to entitled the 2x points. "));
        questionsList.add(new Question("Student Price Terms & Conditions:","1.  Student price is applicable on weekdays for all movies that has showtimes before 6PM only at a price of RM9 (0% GST).\n" +
                "2.  Student are required to purchase the movies tickets over-the-counter at the cinema to get the student price.\n" +
                "3.  All University and College students are required to present a valid student ID/Card with MyKad for verification before purchasing movie tickets with student price.\n" +
                "4.  High School students are required to present MyKad for verification before purchasing movie tickets with student price.\n" +
                "5.  The cinema management reserves the right to refuse sale of student price if above verification is not met or deem invalid.\n" +
                "6.  Student price is not applicable on any State, National, Public or Special Holidays (including Chinese New Year & Hari Raya week) "));
        questionsList.add(new Question("Terms and Conditions for KECIL at MBO the Starling","KECIL is the 1st dedicated movie hall for children. It is a concept of fun and entertainment for children created by MBO Cinemas. In here, their imagination may run free!\n" +
                "\n" +
                "KECIL consists of movies that are suitable for minors with the rating U or PG-13 as per LPF Malaysia guidelines.\n" +
                "\n" +
                "1.  KECIL tickets can be purchased via walk-in, MBO Cinemas mobile app and MBO Cinemas website for the all available locations. Show times for KECIL in website/mobile web are labelled besides the time e.g 8:00 AM [KECIL]\n" +
                "2.  KECIL Family Bed is for maximum of 2 adults and 1 child (with the maximum height of 100cm). Additional children below 1m may be seated at the Family Bed as well. Children with more than 1m height will require a child ticket.\n" +
                "3.  KECIL Bean is for 1 child (with the maximum height of 1m) or 1 child up to 12 years old.\n" +
                "4.  Children may play at the playground during the movie. However, adult supervision is encouraged.\n" +
                "5.  Adult that are accompanying children in KECIL are not allowed to use the playground as they are built for the children only.\n" +
                "6.  Undisciplined, harmful and offensive conduct is prohibited. It is recommended not to use high-sounding words, inappropriate language or signals.\n" +
                "7.  KECIL sessions only valid only for selected titles and selected show time with the rating of U or P13 as per LPF Malaysia guidelines.\n" +
                "8.  The Management & Staff of MBO Cinemas reserve the right to refuse admission to any person failing to comply with the terms and conditions.\n" +
                "9.  MBO Cinemas is not responsible for any accident or injury to the patrons & damage or loss of their belongings.\n" +
                "10.  MBO Cinemas reserves the right to change the terms & conditions for the KECIL sessions without prior notice. "));
        questionsList.add(new Question("Terms and Conditions for MX4D at MBO the Starling","Welcome to the MX4D® Motion EFX Experience, where you will be immersed into the on-screen action like never before. Please be advised of the following regarding this experiences that you are about to enjoy:\n" +
                "\n" +
                "1.  Throughout the movie your seat will move with the action on screen\n" +
                "2.  Please remain seated with your feet on top of the footrest during the entire movie\n" +
                "3.  If you need to get in or out of your seat, please exercise caution and care as your seat and the seats around you may be moving\n" +
                "4.  You must be at least 40” tall and be able to sit and support yourself to enjoy this experience\n" +
                "5.  Please only 1 person per seat, no lap sitting allowed\n" +
                "6.  This experience may not be appropriate for people who may be pregnant, have heart, back, head, leg or neck conditions, or other physical limitations, or those that may have reactions to scents, fog, or strobe lightning effects.\n" +
                "\n" +
                "If you have any questions or concerns about this MX4D® Motion EFX Theatre, please contact theater management staff before the movie begins."));

        mRecyclerView = findViewById(R.id.rvFAQ);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new QuestionAdapter(questionsList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
