package labs.lab9;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.util.ArrayList;
import java.util.Collections;

public class StudentRosterUI {

	public static void main(String[] args) {
		
		ArrayList<StudentRoster> list = new ArrayList<StudentRoster>();
		
		// whole frame
		JFrame frame = new JFrame();
		// create a whole panel
		JPanel totalPanel = new JPanel();
		
		//first panel
		JLabel label_name = new JLabel("Name: ");
		JTextField text_name = new JTextField(20);
		JPanel panel = new JPanel();
		panel.add(label_name);
		panel.add(text_name);
		
		// second panel
		JLabel label_breed = new JLabel("Breed: ");
		JComboBox breedCombo = new JComboBox();
		breedCombo.addItem("Bulldog");
		breedCombo.addItem("Chihuahua");
		breedCombo.addItem("French Bulldog");
		breedCombo.addItem("German Shepherd");
		breedCombo.addItem("Golden Retriever");
		breedCombo.addItem("Labrador Retriever");
		breedCombo.addItem("Pomeranian");
		breedCombo.addItem("Poodle");
		breedCombo.addItem("Pug");
		breedCombo.addItem("Siberian Husky");
		breedCombo.addItem("Other");
		
		JPanel panel2 = new JPanel();
		panel2.add(label_breed);
		panel2.add(breedCombo);
		
		//third panel
		JLabel label_Phone = new JLabel("Phone: ");
		JTextField text_phone = new JTextField(20);
		JPanel panel3 = new JPanel();
		panel3.add(label_Phone);
		panel3.add(text_phone);
		
		//student panel
		JPanel studentPanel = new JPanel();
		JRadioButton newStudent = new JRadioButton("New Student");
		JRadioButton returnStudent = new JRadioButton("Returning Student");
		ButtonGroup group = new ButtonGroup();
		group.add(newStudent);
		group.add(returnStudent);
		studentPanel.add(newStudent);
		studentPanel.add(returnStudent);
		
		//courses panel
		JPanel coursesPanel = new JPanel();
		JLabel course_name = new JLabel("Courses: ");
		JCheckBox agility = new JCheckBox("Agility Training");
		JCheckBox Obedience1 = new JCheckBox("Obedience 1");
		JCheckBox Obedience2 = new JCheckBox("Obedience 2");
		JCheckBox puppy = new JCheckBox("Puppy Etiquette");
		JCheckBox tricks = new JCheckBox("Tricks");
		ArrayList<JCheckBox> box = new ArrayList<JCheckBox>();
		box.add(agility);
		box.add(Obedience1);
		box.add(Obedience2);
		box.add(puppy);
		box.add(tricks);
		coursesPanel.add(course_name);
		coursesPanel.add(agility); 
		coursesPanel.add(Obedience1);
		coursesPanel.add(Obedience2);
		coursesPanel.add(puppy);
		coursesPanel.add(tricks);
		
		
		//tuition panel
		JPanel tuitionPanel = new JPanel();
		JLabel tuition = new JLabel("Tuition: ");
		final JLabel money = new JLabel("$ " + "0.0");
		tuitionPanel.add(tuition);
		tuitionPanel.add(money);

		//display tution on the label 
		class addTuitionListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				double tuition_fee;
				int count=0;
				for(JCheckBox item: box) {
					if(item.isSelected()) {
						count++;
					}
				}
				tuition_fee = count*100;
				money.setText("$ " + tuition_fee);
			}
		}
		ActionListener listener = new addTuitionListener();
		agility.addActionListener(listener);
		Obedience1.addActionListener(listener);
		Obedience2.addActionListener(listener);
		puppy.addActionListener(listener);
		tricks.addActionListener(listener);
		
		//note panel
		JPanel notePanel = new JPanel();
//		notePanel.setLayout(new GridLayout(2,1));
		JLabel noteLabel = new JLabel("Notes: ");
		final int ROWS = 5; // Lines of text
		final int COLUMNS = 10; // Characters in each row  
		JTextArea textArea = new JTextArea(ROWS, COLUMNS);
		JScrollPane scrollPane = new JScrollPane(textArea);
		notePanel.add(noteLabel);
		notePanel.add(scrollPane);

		// new save delete panel
		JPanel nsdPanel = new JPanel();
		JButton newAction = new JButton("New");
		JButton saveAction = new JButton("Save");
		JButton deleteAction = new JButton("Delete");
		nsdPanel.add(newAction);
		nsdPanel.add(saveAction);
		nsdPanel.add(deleteAction);
		
		// previous and next
		JPanel preNextPanel = new JPanel();
		JButton preAction = new JButton("<< Previous");
		JButton nextAction = new JButton("Next >>");
		preAction.setEnabled(false);
		nextAction.setEnabled(false);
		preNextPanel.add(preAction);
		preNextPanel.add(nextAction);
		
		//save, new , delete action 
		class saveListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				if(text_name.getText().length() == 0 || text_phone.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				String phone_str = text_phone.getText();
				int i = 0;
				while(i<phone_str.length()) {
					if(phone_str.charAt(i) <'0' || phone_str.charAt(i) > '9') {
						JOptionPane.showMessageDialog(null, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
					i++;
				}
				for(int j=0; j<list.size(); j++) {
					if(list.get(j).getName().equals(text_name.getText())) {
						JOptionPane.showMessageDialog(null, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				if(text_name.getText().length()>0) {
					//store the info into student object 
					StudentRoster student = new StudentRoster();
					student.setName(text_name.getText());
					student.setBreed(breedCombo.getSelectedIndex());
					student.setNumber(text_phone.getText());
					student.setTuition(money.getText());
					String type = newStudent.isSelected() ? "new" : "return";
					student.setType(type);
					student.setNotes(textArea.getText());
					student.setAgility(agility.isSelected());
					student.setObedience1(Obedience1.isSelected());
					student.setObedience2(Obedience2.isSelected());
					student.setPuppy(puppy.isSelected());
					student.setTricks(tricks.isSelected());
					
					list.add(student);
					list.sort((object1, object2) -> object1.getName().compareTo(object2.getName()));
					
					
					int size = list.size();
					int index = 0;
					for(int j=0; j<size; j++) {
						if(list.get(j).getName().equals(text_name.getText())) {
							index = j;
						}
					}
					if(index>0) preAction.setEnabled(true);
					if(index == size-1) {
						nextAction.setEnabled(false);
					}else {
						nextAction.setEnabled(true);
					}
					
					JOptionPane.showMessageDialog(null, "Student Saved!", "Success", JOptionPane.PLAIN_MESSAGE);
				}
			}
		}
		
		ActionListener savelistener = new saveListener();
		saveAction.addActionListener(savelistener);
		
		class newListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				text_name.setText(null);
				breedCombo.setSelectedIndex(0);
				text_phone.setText(null);
				newStudent.setSelected(false);
				returnStudent.setSelected(false);
				money.setText("$ 0.0");
				textArea.setText(null);
				agility.setSelected(false); 
				Obedience1.setSelected(false); 
				Obedience2.setSelected(false); 
				puppy.setSelected(false); 
				tricks.setSelected(false);
			}
		}
		ActionListener newlistener = new newListener();
		newAction.addActionListener(newlistener);
		
		class deleteListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				
				if(list.size()>=1) {
					JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the student", "Confirm Delete", JOptionPane.YES_NO_OPTION);
					String name = text_name.getText();
					for(int i=0; i<list.size(); i++) {
						if(name.equals(list.get(i).getName()))
							list.remove(i);
					
						if(list.size()>0) {
							text_name.setText(list.get(0).getName());
							text_phone.setText(list.get(0).getNumber());
							if(list.get(0).getType().equals("new")) {
								newStudent.setSelected(true);
							}else {
								returnStudent.setSelected(true);
							}
							breedCombo.setSelectedIndex(list.get(0).getBreed());
							money.setText(list.get(0).getTuition());
							textArea.setText(list.get(0).getNotes());
							
							agility.setSelected(list.get(0).getAgility());
							Obedience1.setSelected(list.get(0).getObedience1());
							Obedience2.setSelected(list.get(0).getObedience2());
							puppy.setSelected(list.get(0).getPuppy());
							tricks.setSelected(list.get(0).getTricks());
							
							preAction.setEnabled(false);
							if(list.size()>1) {
								nextAction.setEnabled(true);
							}else {
								nextAction.setEnabled(false);
							}
							
						}
						if(list.size() == 0) {
							text_name.setText(null);
							text_phone.setText(null);
							newStudent.setSelected(false);
							returnStudent.setSelected(false);
							breedCombo.setSelectedIndex(0);
							money.setText("0.0");
							textArea.setText(null);
							agility.setSelected(false); 
							Obedience1.setSelected(false); 
							Obedience2.setSelected(false); 
							puppy.setSelected(false); 
							tricks.setSelected(false);
							preAction.setEnabled(false);
							nextAction.setEnabled(false);
						}
					}
				}
				
			}
		}
		ActionListener deletelistener = new deleteListener();
		deleteAction.addActionListener(deletelistener);
		

		// pre and next
		class preListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				int size = list.size();
				int index = 0;
				for(int j=0; j<size; j++) {
					if(list.get(j).getName().equals(text_name.getText())) {
						index = j;
					}
				}
				if(index>0) {
					text_name.setText(list.get(index-1).getName());
					text_phone.setText(list.get(index-1).getNumber());
					if(list.get(index-1).getType().equals("new")) {
						newStudent.setSelected(true);
					}else {
						returnStudent.setSelected(true);
					}
					breedCombo.setSelectedIndex(list.get(index-1).getBreed());
					money.setText(list.get(index-1).getTuition());
					textArea.setText(list.get(index-1).getNotes());
					
					agility.setSelected(list.get(index-1).getAgility());
					Obedience1.setSelected(list.get(index-1).getObedience1());
					Obedience2.setSelected(list.get(index-1).getObedience2());
					puppy.setSelected(list.get(index-1).getPuppy());
					tricks.setSelected(list.get(index-1).getTricks());
				}
				if((index-1)==0) {
					preAction.setEnabled(false);
				}else {
					preAction.setEnabled(true);
				}
				index--;
				if(index == (size-1)) {
					nextAction.setEnabled(false);
				}else {
					nextAction.setEnabled(true);
				}
			}
		}
		ActionListener prelistener = new preListener();
		preAction.addActionListener(prelistener);
		
		
		class nextListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				int size = list.size();
				int index = 0;
				for(int j=0; j<size; j++) {
					if(list.get(j).getName().equals(text_name.getText())) {
						index = j;
					}
				}
				if(index+1 < size) {
					text_name.setText(list.get(index+1).getName());
					text_phone.setText(list.get(index+1).getNumber());
					if(list.get(index+1).getType().equals("new")) {
						newStudent.setSelected(true);
					}else {
						returnStudent.setSelected(true);
					}
					breedCombo.setSelectedIndex(list.get(index+1).getBreed());
					money.setText(list.get(index+1).getTuition());
					textArea.setText(list.get(index+1).getNotes());
					
					agility.setSelected(list.get(index+1).getAgility());
					Obedience1.setSelected(list.get(index+1).getObedience1());
					Obedience2.setSelected(list.get(index+1).getObedience2());
					puppy.setSelected(list.get(index+1).getPuppy());
					tricks.setSelected(list.get(index+1).getTricks());
				}
				index++;
				if(index == (size-1)) {
					nextAction.setEnabled(false);
				}else {
					nextAction.setEnabled(true);
				}
				if(index > 0) {
					preAction.setEnabled(true);
				}else {
					preAction.setEnabled(true);
				}
			}
		}
		ActionListener nextlistener = new nextListener();
		nextAction.addActionListener(nextlistener);
		
		// add all panel to the whole panel 
		totalPanel.setLayout(new GridLayout(9,1 ));
		totalPanel.add(panel);
		totalPanel.add(panel2);
		totalPanel.add(panel3);
		totalPanel.add(studentPanel);
		totalPanel.add(coursesPanel);
		totalPanel.add(tuitionPanel);
		totalPanel.add(notePanel);
		totalPanel.add(nsdPanel);
		totalPanel.add(preNextPanel);
		// display the frame 
		frame.add(totalPanel);


		
		frame.setSize(400, 500);
		frame.setTitle("Zhicheng Ding - 42587819");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
	
}
