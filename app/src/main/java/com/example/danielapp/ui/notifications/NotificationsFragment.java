package com.example.danielapp.ui.notifications;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.danielapp.LoginActivity;
import com.example.danielapp.MainActivity;
import com.example.danielapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private Button logout;
    
    private ImageView btnCall , btnWaze , btnInstegram , btnWhatsApp;





    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);


        logout = root.findViewById(R.id.btn_logout);
        logout.setOnClickListener(v -> {
            logout(v);
        });
        
        btnCall = root.findViewById(R.id.call);
        btnCall.setOnClickListener(v -> {
            call();
        });

        btnWaze = root.findViewById(R.id.waze);
        btnWaze.setOnClickListener(v -> {
            try{
                // Launch Waze to look for Hawaii:
                String url = "https://waze.com/ul?q=Hawaii";
                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse( url ) );
                startActivity( intent );
            }
            catch ( ActivityNotFoundException ex  )
            {
                // If Waze is not installed, open it in Google Play:
                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse( "market://details?id=com.waze" ) );
                startActivity(intent);
            }
        });

        btnWhatsApp = root.findViewById(R.id.facebook);
        btnWhatsApp.setOnClickListener(v -> {
            try{
                // Launch Waze to look for Hawaii:
                String url = "https://www.facebook.com/inbalcosmtics/";
                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse( url ) );
                startActivity( intent );
            }
            catch ( ActivityNotFoundException ex  )
            {
                // If Waze is not installed, open it in Google Play:
                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse( "https://www.facebook.com/" ) );
                startActivity(intent);
            }
        });

        btnInstegram = root.findViewById(R.id.instegram);
        btnInstegram.setOnClickListener(v -> {
            try{

                String url = "https://www.instagram.com/inbal__cosmetics/";
                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse( url ) );
                startActivity( intent );
            }
            catch ( ActivityNotFoundException ex  )
            {

                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse( "https://www.instagram.com/" ) );
                startActivity(intent);
            }
        });
        

        return root;
    }

    private void logout(View v){
        FirebaseAuth.getInstance().signOut();
    }


    private void call() {
        //step 2: check for permission:
        String callPhonePermission = Manifest.permission.CALL_PHONE;//"android.permission.CALL_PHONE"

        String[] array = {callPhonePermission};

        if (ActivityCompat.checkSelfPermission(getContext(), callPhonePermission) != PackageManager.PERMISSION_GRANTED) {
            //request permission:
            ActivityCompat.requestPermissions(getActivity(), array, 0);

            //get out of the method
            return; //don't continue to the dangerous code if we d'ont have a permission yet.
        }

        //call is dangerous: hence -> 1) manifest, 2) we need to request a run time permission:
        Uri telUri = Uri.parse("tel:0502445559");
        Intent dialIntent = new Intent(Intent.ACTION_DIAL, telUri);

        startActivity(dialIntent);
    }

    //add this method: to get notified when the permission is granted / not

    //callback for the dialog
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //if we got a permission -> call()

        if (requestCode == 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            //we have permission:
            call();
        }

        else {
            //No Permission:
            Toast.makeText(getContext(), "No Permission", Toast.LENGTH_SHORT).show();
        }
    }

}