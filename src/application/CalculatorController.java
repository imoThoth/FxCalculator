package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalculatorController {
	
	
	@FXML
	private Label output;
	private long num1 = 0;
	private String operator = "";
	private boolean start = true;
	private Model model = new Model();
	
	@FXML
	public void Numbers(ActionEvent event) {
		
		if(start) {
			output.setText("");
			start = false;
		}
		
		String value = ((Button)event.getSource()).getText();
		output.setText(output.getText() + value);
	}
	
	@FXML
	public void Operator(ActionEvent event) {
	
		String value = ((Button)event.getSource()).getText();
		//output.setText(output.getText());
		
		if(!value.equals("=")) {
			if(!operator.isEmpty())
				return;
			operator = value;
			num1 = Long.parseLong(output.getText());
			output.setText("");
		}
		else {
			if(operator.isEmpty())
				return;
			Long num2 = Long.parseLong(output.getText());
			float result = model.calculator(num1, num2, operator);
			output.setText(String.valueOf(result));
			operator = "";
			start = true;
			
		}
	}

}
