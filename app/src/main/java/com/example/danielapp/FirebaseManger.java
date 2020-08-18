package com.example.danielapp;



import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.database.FirebaseDatabase;


public class FirebaseManger {
    public static final String USERS = "Users";
    public static final String DATES = "Dates";
    public static final String TIME = "Time";

    //singleton: share a single object across the entire app:

    public FirebaseManger() {
    }

    public static FirebaseManger shared = new FirebaseManger();

    public void saveUser(User user){
        String mAuth = FirebaseAuth.getInstance().getUid();
        FirebaseDatabase.getInstance().getReference(USERS).child(mAuth).setValue(user);

    }

    public void saveDate(Date date){
        String mAuth = FirebaseAuth.getInstance().getUid();
        FirebaseDatabase.getInstance().getReference(DATES).child(mAuth).setValue(date);
    }

    public void saveQueue(Queue queue){
        FirebaseDatabase.getInstance().getReference("Queue").setValue(queue);
    }



}
