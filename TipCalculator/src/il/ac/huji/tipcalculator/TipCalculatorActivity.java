package il.ac.huji.tipcalculator;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculatorActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calculator);
		final Button b = (Button) findViewById(R.id.btnCalculate);
		b.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				EditText t=(EditText) findViewById(R.id.edtBillAmount);
				TextView tip=(TextView) findViewById(R.id.txtTipResult);



				Editable d=  t.getText();

				String s=d.toString();
				double y=Double.parseDouble(s);
				y=y*0.12;
				CheckBox round=(CheckBox) findViewById(R.id.chkRound);

				if(round.isChecked()){
					y=Math.round(y);
					int newY=(int) y;
					tip.setText("Tip: $"+newY);
				}
				else{
					String result = String.format("%.2f", y);
					tip.setText("Tip: $"+result);

				}





			}
		});

	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_calculator, menu);
		return true;
	}

}