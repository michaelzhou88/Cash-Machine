package com.company;

//Importing constructors to be used by the program
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class ATM extends JFrame{

    //Declarations of variables/constants that will be used throughout the program
    private double balance = 10;
    private int action = 0;
    private int attempts = 3;
    private int PIN = 1234;

    //Text to prompt the user to take action
    private String instantText = "Please enter your PIN (" + attempts + " attempts remaining)";
    private String displayText = "";

    //Setting up JButton constructors from Java Swing, buttons are to be shown on the program
    //'00A3' is the Unicode character for a pound sterling sign (£)
    private JButton withdrawFiver = new JButton("Withdraw \u00A35");
    private JButton withdrawTenner = new JButton("Withdraw \u00A310");
    private JButton withdrawTwenty = new JButton("Withdraw \u00A320");
    private JButton numberZero = new JButton("0");
    private JButton numberOne = new JButton("1");
    private JButton numberTwo = new JButton("2");
    private JButton numberThree = new JButton("3");
    private JButton numberFour = new JButton("4");
    private JButton numberFive = new JButton("5");
    private JButton numberSix = new JButton("6");
    private JButton numberSeven = new JButton("7");
    private JButton numberEight = new JButton("8");
    private JButton numberNine = new JButton("9");
    private JButton deposit = new JButton("Deposit");
    private JButton clear = new JButton("Clear");
    private JButton enter = new JButton("Enter");
    private JButton quit = new JButton("Quit");

    //Declaring JTextFields, which will display text on the program
    private JTextField instructions;
    private JTextField display;
    private JTextField displayBalance;

    public static void main(String[] args){

        //Setting up the ATM constructor
        ATM atm = new ATM();

        //Properties of the program, can't be resized, closes properly, is of a fixed size, and is visible
        atm.setResizable(false);
        atm.setDefaultCloseOperation(EXIT_ON_CLOSE);
        atm.setSize(620,335);
        atm.setVisible(true);
    }

    public ATM(){

        //Title of the window
        super("Cash Machine");

        //Setting up JPanels which will contain more Java Swing elements
        JPanel input = new JPanel();
        JPanel displayContainer = new JPanel();

        //Initialisation of text fields
        instructions = new JTextField(instantText);
        display = new JTextField(displayText);
        displayBalance = new JTextField("");

        //Making the 'instructions' text field greyed out and uneditable, also aligning text to centre and giving it a border
        instructions.setEditable(false);
        instructions.setHorizontalAlignment(SwingConstants.CENTER);
        instructions.setBorder(new TitledBorder(new EtchedBorder(), "Instructions"));

        //Making the 'display' text field greyed out and uneditable, also aligning the text to centre and giving it a border
        display.setEditable(false);
        display.setHorizontalAlignment(SwingConstants.CENTER);
        display.setBorder(new TitledBorder(new EtchedBorder(), "Display"));

        //Making the 'displayBalance' text field greyed out and uneditable, also aligning the text to centre and giving it a border
        displayBalance.setEditable(false);
        displayBalance.setHorizontalAlignment(SwingConstants.CENTER);
        displayBalance.setBorder(new TitledBorder(new EtchedBorder(), "Balance"));

        //Making the 'displayWrapper' JPanel in a grid layout with 2 elements
        displayContainer.setLayout(new GridLayout(2,1));

        //Adding the 2 elements to the JPanel 'displayContainer'
        displayContainer.add(display);
        displayContainer.add(displayBalance);

        //Adding a border to the 'input' JPanel
        input.setBorder(new TitledBorder(new EtchedBorder(), "Input"));

        //Making the 'input' JPanel in a grid layout with 20 elements (though not all of these will be used)
        input.setLayout(new GridLayout(5,4));

        //Adding elements to the JPanel 'input'
        input.add(withdrawFiver);
        input.add(numberOne);
        input.add(numberTwo);
        input.add(numberThree);
        input.add(withdrawTenner);
        input.add(numberFour);
        input.add(numberFive);
        input.add(numberSix);
        input.add(withdrawTwenty);
        input.add(numberSeven);
        input.add(numberEight);
        input.add(numberNine);
        input.add(deposit);
        input.add(numberZero);
        input.add(clear);
        input.add(enter);
        input.add(quit);

        //Adding the JPanels and the instructions text field to the whole program
        add(instructions, BorderLayout.NORTH);
        add(displayContainer, BorderLayout.CENTER);
        add(input, BorderLayout.SOUTH);

        //Implementing ActionListeners to all the buttons
        quit.addActionListener(new QuitButton());
        numberZero.addActionListener(new Num0Button());
        numberOne.addActionListener(new Num1Button());
        numberTwo.addActionListener(new Num2Button());
        numberThree.addActionListener(new Num3Button());
        numberFour.addActionListener(new Num4Button());
        numberFive.addActionListener(new Num5Button());
        numberSix.addActionListener(new Num6Button());
        numberSeven.addActionListener(new Num7Button());
        numberEight.addActionListener(new Num8Button());
        numberNine.addActionListener(new Num9Button());
        clear.addActionListener(new ClearButton());
        enter.addActionListener(new EnterButton());
        withdrawFiver.addActionListener(new Withdraw1());
        withdrawTenner.addActionListener(new Withdraw2());
        withdrawTwenty.addActionListener(new Withdraw3());
        deposit.addActionListener(new DepositButton());
    }

    class QuitButton implements ActionListener{
        public void actionPerformed(ActionEvent e){

            //If the quit button is pressed, reset everything back to default
            attempts = 3;
            action = 0;
            instantText = "Please enter your PIN (" + attempts + " attempts remaining)";
            instructions.setText(instantText);
            balance = 10;
            displayBalance.setText("");
            displayText = "";
            display.setText(displayText);
            PIN = 1234;
        }
    }

    class Num0Button implements ActionListener{
        public void actionPerformed(ActionEvent e){

            //If the 0 button is pressed, add a number 0 to the 'display' text field
            displayText = display.getText();
            display.setText(displayText + "0");
        }
    }

    class Num1Button implements ActionListener{
        public void actionPerformed(ActionEvent e){

            //If the 1 button is pressed, add a number 1 to the 'display' text field
            displayText = display.getText();
            display.setText(displayText + "1");
        }
    }

    class Num2Button implements ActionListener{
        public void actionPerformed(ActionEvent e){

            //If the 2 button is pressed, add a number 2 to the 'display' text field
            displayText = display.getText();
            display.setText(displayText + "2");
        }
    }

    class Num3Button implements ActionListener{
        public void actionPerformed(ActionEvent e){

            //If the 3 button is pressed, add a number 3 to the 'display' text field
            displayText = display.getText();
            display.setText(displayText + "3");
        }
    }

    class Num4Button implements ActionListener{
        public void actionPerformed(ActionEvent e){

            //If the 4 button is pressed, add a number 4 to the 'display' text field
            displayText = display.getText();
            display.setText(displayText + "4");
        }
    }

    class Num5Button implements ActionListener{
        public void actionPerformed(ActionEvent e){

            //If the 5 button is pressed, add a number 5 to the 'display' text field
            displayText = display.getText();
            display.setText(displayText + "5");
        }
    }

    class Num6Button implements ActionListener{
        public void actionPerformed(ActionEvent e){

            //If the 6 button is pressed, add a number 6 to the 'display' text field
            displayText = display.getText();
            display.setText(displayText + "6");
        }
    }

    class Num7Button implements ActionListener{
        public void actionPerformed(ActionEvent e){

            //If the 7 button is pressed, add a number 7 to the 'display' text field
            displayText = display.getText();
            display.setText(displayText + "7");
        }
    }

    class Num8Button implements ActionListener{
        public void actionPerformed(ActionEvent e){

            //If the 8 button is pressed, add a number 8 to the 'display' text field
            displayText = display.getText();
            display.setText(displayText + "8");
        }
    }

    class Num9Button implements ActionListener{
        public void actionPerformed(ActionEvent e){

            //If the 9 button is pressed, add a number 9 to the 'display' text field
            displayText = display.getText();
            display.setText(displayText + "9");
        }
    }

    class ClearButton implements ActionListener{
        public void actionPerformed(ActionEvent e){

            //If the clear button is pressed, set the value of the text field to nothing
            display.setText("");
        }
    }

    class Withdraw1 implements ActionListener{
        public void actionPerformed(ActionEvent e){

            //Checks to see if the user is logged in or not (by seeing if they still need to enter their PIN)
            if(action != 0){

                //Makes sure the user has at least £5 to withdraw from their account
                if(balance >= 5){

                    //Take away £5 from the user's balance
                    balance = balance - 5;

                    //Update the balance on the interface
                    displayBalance.setText("\u00A3" + String.format("%.2f", balance));

                    //Updates the log of transactions in the terminal/command line
                    System.out.println("Transaction: -\u00A35\nBalance: " + displayBalance.getText());

                    //Inform the user of the transaction
                    instantText = "\u00A35 withdrawn from account";
                    instructions.setText(instantText);
                } else {

                    //If the user does not have £5 to withdraw, produce an error message
                    instantText = "Insufficient balance to withdraw \u00A35, please select another option";
                    instructions.setText(instantText);
                }
            } else {

                //If the user is not logged in, ask them to do so (and list the number of PIN attempts they have left)
                instantText = "You must be signed in to use this function, please enter your PIN (" + attempts + " attempts remaining)";
                instructions.setText(instantText);
            }
        }
    }

    class Withdraw2 implements ActionListener{
        public void actionPerformed(ActionEvent e){

            //Checks to see if the user is logged in or not (by seeing if they still need to enter their PIN)
            if(action != 0){

                //Makes sure the user has at least £10 to withdraw from their account
                if(balance >= 10){

                    //Take away £10 from the user's current balance
                    balance = balance - 10;

                    //Update the balance on the screen
                    displayBalance.setText("\u00A3" + String.format("%.2f", balance));

                    //Update the log of transactions in the command window
                    System.out.println("Transaction: -\u00A310\nBalance: " + displayBalance.getText());

                    //Inform the user of the transaction
                    instantText = "\u00A310 withdrawn from account";
                    instructions.setText(instantText);
                } else {

                    //If the user does not have £10 to withdraw, produce an error message
                    instantText = "Insufficient balance to withdraw \u00A310, please select another option";
                    instructions.setText(instantText);
                }
            } else {

                //If the user is not logged in, ask them to do so (and list the number of PIN attempts they have left)
                instantText = "You must be signed in to use this function, please enter your PIN (" + attempts + " attempts remaining)";
                instructions.setText(instantText);
            }
        }
    }

    class Withdraw3 implements ActionListener{
        public void actionPerformed(ActionEvent e){

            //Checks to see if the user is logged in or not (by seeing if they still need to enter their PIN)
            if(action != 0){

                //Makes sure the user has at least £20 to withdraw from their account
                if(balance >= 20){

                    //Take away £20 from the user's balance
                    balance = balance - 20;

                    //Update the balance on the screen
                    displayBalance.setText("\u00A3" + String.format("%.2f", balance));

                    //Update the log of transactions in the command window
                    System.out.println("Transaction: -\u00A320\nBalance: " + displayBalance.getText());

                    //Inform the user of the transaction
                    instantText = "\u00A320 withdrawn from account";
                    instructions.setText(instantText);
                } else {

                    //If the user does not have £20 to withdraw, produce an error message
                    instantText = "Insufficient balance to withdraw \u00A320, please select another option";
                    instructions.setText(instantText);
                }
            } else {

                //If the user is not logged in, ask them to do so (and list the number of PIN attempts they have left)
                instantText = "You must be signed in to use this function, please enter your PIN (" + attempts + " attempts remaining)";
                instructions.setText(instantText);
            }
        }
    }

    class DepositButton implements ActionListener{
        public void actionPerformed(ActionEvent e){

            //Makes sure user is logged into their account
            if(action != 0){

                //Set the 'action' integer to 1
                action = 1;

                //Ask the user how much they would like to deposit to their account
                instantText = "Enter the amount you would like to deposit (\u00A31000 limit)";
                instructions.setText(instantText);
            } else {

                //If the user is not logged in, ask them to do so (and list the number of PIN attempts they have left)
                instantText = "You must be signed in to use this function, please enter your PIN (" + attempts + " attempts remaining)";
                instructions.setText(instantText);
            }
        }
    }

    class EnterButton implements ActionListener{
        public void actionPerformed(ActionEvent e){

            //Retrieve the current text in 'displayText'
            displayText = display.getText();

            //Using a switch statement to decide what happens during each action
            switch(action){

                //Checking to see if the text field is empty or not
                case 0: if(displayText.isEmpty()){

                    //If it is empty, ask to enter the PIN again but don't decrease the number of attempts the user has left
                    instantText = "No characters were entered, please try again (" + attempts + " attempts remaining)";
                    instructions.setText(instantText);
                } else{

                    //Checks to see if the value entered is '1234' (the PIN)
                    if(Integer.parseInt(displayText) == PIN){

                        //Display the balance, and move on to the next action, with a corresponding change in instruction
                        displayBalance.setText("\u00A3" + String.format("%.2f", balance));
                        action = 2;
                        instantText = "Please choose an option";
                        instructions.setText(instantText);
                        display.setText("");
                    } else if(displayText.isEmpty() == false){

                        //If user enters a value that is not equal to '1234', check how many attempts they have left
                        if(attempts < 2){

                            //If the user runs out of attempts, exit the program
                            System.exit(0);
                        }

                        //Decrease the number of attempts by 1
                        attempts--;

                        //Inform the user that the PIN entered was wrong, and show how many attempts they have left at it
                        instantText = "Invalid PIN entered, please try again (" + attempts + " attempts remaining)";
                        instructions.setText(instantText);
                        display.setText("");
                    } else {

                        //An extra check in case something goes wrong
                        instantText = "No characters were entered, please try again (" + attempts + " attempts remaining)";
                        instructions.setText(instantText);
                    }
                }
                    break;
                case 1: if(Integer.parseInt(displayText) <= 1000){

                    //If amount entered to deposit is less than or equal to 1000, add 1000 to the balance
                    balance = balance + Integer.parseInt(displayText);
                    displayBalance.setText("\u00A3" + String.format("%.2f", balance));

                    //Update the log of transactions in the command window
                    System.out.println("Transaction: +\u00A3" + Integer.parseInt(displayText) + "\nBalance: " + displayBalance.getText());

                    //Inform the user of the transaction
                    instantText = "\u00A3" + Integer.parseInt(displayText) + " deposited into account";
                    instructions.setText(instantText);
                    displayText = "";
                    display.setText(displayText);
                } else {

                    //If amount entered to deposit is over 1000, produce an error
                    instantText = "Amount to deposit is too large (\u00A31000 limit)";
                    instructions.setText(instantText);
                    displayText = "";
                    display.setText(displayText);
                }

                    //Update the action back to 2 (logged in)
                    action = 2;
                    break;
                case 3: if(displayText.isEmpty()){

                    //If it is empty, inform the user that they have not entered anything
                    instantText = "No characters were entered, please select another action";
                    instructions.setText(instantText);
                    action = 2;
                } else {

                    //If new PIN isn't 4 digits long, produce an error and return to the previous action
                    if(displayText.length() != 4){
                        instantText = "PIN must be 4 digits long, please select another action";
                        instructions.setText(instantText);
                        displayText = "";
                        display.setText(displayText);
                        action = 2;
                    } else {

                        //Set the PIN to whatever the user entered and return to the previous action
                        PIN = Integer.parseInt(displayText);
                        instantText = "PIN successfully updated, please select another action";
                        instructions.setText(instantText);
                        displayText = "";
                        display.setText(displayText);
                        action = 2;
                    }
                }
                    break;
            }
        }
    }
}

