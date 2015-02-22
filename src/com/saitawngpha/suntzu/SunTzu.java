package com.saitawngpha.suntzu;


import com.saitawngpha.suntzu.R;

import dalvik.annotation.TestTargetClass;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ImageButton;
import android.widget.Toast;


public class SunTzu extends Activity{
	
TextView tex;
ImageButton imageButton;
private boolean exit;

    public void onCreate(Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);
           setContentView(R.layout.suntzu_main);
           
           addListenerOnButton();
           
           
           tex= (TextView)findViewById(R.id.text_title1);
           ChangeFont(tex);
           // sun intro
           
           final Button butt=(Button)findViewById(R.id.sun_intro);
           ChangeFont(butt);
           butt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                    
             Intent intent = new Intent(getBaseContext(), SunTzuIntro.class);
                        startActivity(intent);
                    }
                  });
           
           // sun 1 
           final Button butt1=(Button)findViewById(R.id.sun_1);
           ChangeFont(butt1);
           butt1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                    	
                    	Intent intent = new Intent(getBaseContext(), SunTzu1.class);
                        startActivity(intent);
                    
                    
                    }
                  });
           
           //sun 2 
           
           final Button butt2=(Button)findViewById(R.id.sun_2);
           ChangeFont(butt2);
           butt2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                    
                   
                    	Intent intent = new Intent(getBaseContext(), SunTzu2.class);
                        startActivity(intent);
                    }
                  });
           
           // sun 3 
           final Button butt3=(Button)findViewById(R.id.sun_3);
           ChangeFont(butt3);
           butt3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
              
                    	
                    	Intent intent = new Intent(getBaseContext(), SunTzu3.class);
                        startActivity(intent);
                    
                    }
                  });
           
           // sun 4 
           
           final Button butt4=(Button)findViewById(R.id.sun_4);
           ChangeFont(butt4);
           butt4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                    
                    	Intent intent = new Intent(getBaseContext(), SunTzu4.class);
                        startActivity(intent); 
                    }
                  });
           
           // sun 5
           final Button butt5=(Button)findViewById(R.id.sun_5);
           ChangeFont(butt5);
           butt5.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                    
                    	Intent intent = new Intent(getBaseContext(), SunTzu5.class);
                        startActivity(intent);
                    
                    }
                  });
           
           //sun 6 
           final Button butt6=(Button)findViewById(R.id.sun_6);
           ChangeFont(butt6);
           butt6.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                    
                    	Intent intent = new Intent(getBaseContext(), SunTzu6.class);
                        startActivity(intent);
                    
                    }
                  });
           
           //sun 7
           final Button butt7=(Button)findViewById(R.id.sun_7);
           ChangeFont(butt7);
           butt7.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                    
                    	Intent intent = new Intent(getBaseContext(), SunTzu7.class);
                        startActivity(intent); 
                    }
                  });
           
           // sun 8
           final Button butt8=(Button)findViewById(R.id.sun_8);
           ChangeFont(butt8);
           butt8.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                   
                    	Intent intent = new Intent(getBaseContext(), SunTzu8.class);
                        startActivity(intent);
                    
                    }
                  });
           
           //sun 9
           
           final Button butt9=(Button)findViewById(R.id.sun_9);
           ChangeFont(butt9);
           butt9.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                 
                    	Intent intent = new Intent(getBaseContext(), SunTzu9.class);
                        startActivity(intent);
                    
                    }
                  });
           
           //sun 10
           final Button butt10=(Button)findViewById(R.id.sun_10);
           ChangeFont(butt10);
           butt10.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                    
                    	Intent intent = new Intent(getBaseContext(), SunTzu10.class);
                        startActivity(intent);  
                    }
                  });
           
           //sun 11
           final Button butt11=(Button)findViewById(R.id.sun_11);
           ChangeFont(butt11);
           butt11.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                    
                    	Intent intent = new Intent(getBaseContext(), SunTzu11.class);
                        startActivity(intent);  
                    }
                  });
           
           //sun 12
           final Button butt12=(Button)findViewById(R.id.sun_12);
           ChangeFont(butt12);
           butt12.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                    
                    	Intent intent = new Intent(getBaseContext(), SunTzu12.class);
                        startActivity(intent);
                    }
                  });
           
           // sun 13
           
           final Button butt13=(Button)findViewById(R.id.sun_13);
           ChangeFont(butt13);
           butt13.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                  
                    	Intent intent = new Intent(getBaseContext(), SunTzu13.class);
                        startActivity(intent);
                    
                    }
                  });
           
       
    }

    public void ChangeFont(TextView t) {
   		if (Build.VERSION.SDK_INT > 18) {
   			Typeface face = Typeface.createFromAsset(getAssets(), "fonts/PangLong1.ttf"); 
   			t.setTypeface(face);
   		}
   		else {
   			Typeface face = Typeface.createFromAsset(getAssets(), "fonts/PangLong.ttf"); 
   			t.setTypeface(face);
   		}
   	}
    
    
    public void addListenerOnButton() {

    	imageButton = (ImageButton) findViewById(R.id.imgBut1);

    	imageButton.setOnClickListener(new OnClickListener() {

    		@Override
    		public void onClick(View arg0) {

    			//Toast toast = Toast.makeText(SunTzu.this, "ၸိူင်းသိုၵ်း သုၼ်းၸိုဝ်ႇ", Toast.LENGTH_SHORT);
    			//TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
    			//v.setTextColor(Color.RED);
    			//ChangeFont(v);
    			//toast.show();
    			Dialog dialog = new Dialog(SunTzu.this);
    			dialog.setContentView(R.layout.suntzu_dialog);
    			dialog.setTitle("The Art Of War By SunTzu");
    			dialog.setCancelable(true);
    			TextView v = (TextView) dialog.findViewById(R.id.text_suntzu);
    			ChangeFont(v);
    			
    			ImageView image = (ImageView) dialog.findViewById(R.id.image);
    			image.setImageResource(R.drawable.ic_launcher);
    			ImageView image1 = (ImageView) dialog.findViewById(R.id.image1);
    			image1.setImageResource(R.drawable.ic_launcher_sai);
    			dialog.show();
    			
    			
				
    		}
        
    	});
    }
    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        if (exit) 
        {
            finish(); // finish activity
        } else 
        {
            Toast.makeText(this, "Press Back again to Exit.",
                    Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() 
            {
                @Override
                public void run()
                {
                    exit = false;
                }
            }, 3 * 1000);
}
        }
    }