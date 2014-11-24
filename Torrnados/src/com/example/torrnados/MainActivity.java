package com.example.torrnados;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	boolean answer;

	public boolean isAnswer() {
		return answer;
	}

	public void setAnswer(boolean answer) {
		this.answer = answer;
	}



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final Button buttonIncrement = (Button) findViewById(R.id.incrementButton);
		buttonIncrement.setOnClickListener(incrementScore);

		final Button buttonWicket = (Button) findViewById(R.id.wicketButton);
		buttonWicket.setOnClickListener(incrementWicket);

		final Button buttonDeccrement = (Button) findViewById(R.id.decrementButton);
		buttonDeccrement.setOnClickListener(deccrementScore);

		final Button buttonDecrementWicket = (Button) findViewById(R.id.decrementWicketButton);
		buttonDecrementWicket.setOnClickListener(deccrementWicket);

		final Button clearWicket = (Button) findViewById(R.id.clearButton);
		clearWicket.setOnClickListener(clear);

		final Button captureButton = (Button) findViewById(R.id.captureButton);
		captureButton.setOnClickListener(capture);


	}
	View.OnClickListener incrementScore = new View.OnClickListener() {
		public void onClick(View v) {

			TextView scoreView = (TextView) findViewById(R.id.scoreTextView);
			String score = scoreView.getText().toString();
			int scorerAbsoluteValue = Integer.parseInt(score);
			scorerAbsoluteValue = scorerAbsoluteValue+1;
			scoreView.setText(""+ scorerAbsoluteValue);
		}
	};

	View.OnClickListener incrementWicket = new View.OnClickListener() {
		public void onClick(View v) {

			TextView wicketView = (TextView) findViewById(R.id.wicketTextView);
			String wicket = wicketView.getText().toString();
			int wicketAbsoluteValue = Integer.parseInt(wicket);
			wicketAbsoluteValue = wicketAbsoluteValue+1;
			wicketView.setText(""+ wicketAbsoluteValue);
		}
	};

	View.OnClickListener deccrementScore = new View.OnClickListener() {
		public void onClick(View v) {

			TextView scoreView = (TextView) findViewById(R.id.scoreTextView);
			String score = scoreView.getText().toString();
			int scorerAbsoluteValue = Integer.parseInt(score);
			if(scorerAbsoluteValue > 0)
			{
				scorerAbsoluteValue = scorerAbsoluteValue-1;
			}
			scoreView.setText(""+ scorerAbsoluteValue);
		}
	};

	View.OnClickListener deccrementWicket = new View.OnClickListener() {
		public void onClick(View v) {

			TextView wicketView = (TextView) findViewById(R.id.wicketTextView);
			String wicket = wicketView.getText().toString();
			int wicketAbsoluteValue = Integer.parseInt(wicket);
			if(wicketAbsoluteValue > 0)
			{
				wicketAbsoluteValue = wicketAbsoluteValue-1;
			}wicketView.setText(""+ wicketAbsoluteValue);
		}
	};

	View.OnClickListener clear = new View.OnClickListener() {
		public void onClick(View v) {
			Confirm();
		}
	};

	View.OnClickListener capture = new View.OnClickListener() {
		public void onClick(View v) {
			capture();
		}
	};

	public boolean capture()
	{
		AlertDialog dialog = new AlertDialog.Builder(new ContextThemeWrapper(this,R.style.AppTheme)).create();
		dialog.setTitle("ALERT");
		dialog.setMessage("You are not qualified to handle this button. FUCK OFF!");
		
		dialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int buttonId) {
				//nothing
			}
		});
		
		dialog.setIcon(android.R.drawable.ic_dialog_alert);
		dialog.show();
		return true;
	}


	public boolean Confirm()
	{
		AlertDialog dialog = new AlertDialog.Builder(new ContextThemeWrapper(this,R.style.AppTheme)).create();
		dialog.setTitle("Confirmation");
		dialog.setMessage("Are you sure you want to Clear?");
		dialog.setCancelable(false);
		dialog.setButton(DialogInterface.BUTTON_POSITIVE, "Clear", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int buttonId)
			{
				TextView wicketView = (TextView) findViewById(R.id.wicketTextView);
				TextView scoreView = (TextView) findViewById(R.id.scoreTextView);
				wicketView.setText("0");
				scoreView.setText("0");
			}
		});
		dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int buttonId) {
				//nothing
			}
		});
		dialog.setIcon(android.R.drawable.ic_dialog_alert);
		dialog.show();
		return answer;
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	/* public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }*/

}
