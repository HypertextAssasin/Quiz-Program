import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class quiz1 implements ActionListener{
String[] questions = {
"What is the capital of Chile?",
"What is the highest mountain in Britain?",
"What is the smallest country in the world",
"Alberta is a province of which country? ",
"How many countries still have the shilling as currency? ",
"Which is the only vowel not used as the first letter in a US State? ",
"Which is the largest country in the world??",
"Where would you find the River Thames?",
"What is the hottest continent on Earth?",
"What is the longest river?",
"Which of these albums came out first?",
"Hayley Williams released her debut solo single in January. What was it called?",
"How many Grammys did Ariana Grande win in 2020?",
" When did Lady Gaga put out 'Stupid Love’?",
"Which of these things does Beyoncé NOT mention in the ‘Savage' remix?",
" One Direction celebrated their 10 year anniversary in June.",
" What’s the first track on Taylor Swift’s folklore album?",
"Who does NOT appear in the WAP music video?",
" How many times does Harry Styles sing 'watermelon sugar' in ‘Watermelon Sugar’?",
"Which music video won Video of the Year at the MTV VMAs?"
};
String[][] options = {
{"San diego","Nevada","Florida","SanTiago"},
{"Mt everst","Mt fuji","Mt Hope","Mt allah"},
{"Vatican city","India","China","Russia"},
{"Canada","Albania","Angola","India"},
{"4","5","6","12"},
{"a","e","i","o"},
{"Russia","China","Canada","India"},
{"Britan","USA","Brazil","Argentina"},
{"Asia","Africa","Europe","North America"},
{"Nile","Ganga","Kaveri","Yamuna"},
{" Dua Lipa - Future Nostalgia","Halsey - Manic","Justin Bieber - Changes","(Selena Gomez - Rare)"},
{"Cinnamon","Dead horse","Pure love","Simmer"},
{"4","2","1","0"},
{"February","March","April","May"},
{"Ivy park","only fans","Red lobster","Tik Tok"},
{"TRUE","FALSE","Not sure","They didn't"},
{"cardigan","exile","the1","The last great american dynasty"},
{"Chloe X Halle","Kylie Jenner","Normani","Rosalia"},
{"18","25","32","40"},
{"Billie Eilish - 'everything i wanted'","Future & Drake - 'Life Is Good'","Lady Gaga & Ariana Grande - 'Rain On Me'","The Weekend - 'Blinding Lights'"},
};
char[] answers= {
'D',
'C',
'A',
'A',
'B',
'B',
'A',
'A',
'B',
'B',
'D',
'D',
'D',
'A',
'C',
'B',
'C',
'B',
'B',
'D'
};
char guess;
char answer;
int index;
int correct_guesses =0;
int total_questions = questions.length;
int result;
int seconds=10;
JFrame frame = new JFrame();
JTextField textfield = new JTextField();
JTextArea textarea = new JTextArea();
JButton buttonA = new JButton();
JButton buttonB = new JButton();
JButton buttonC = new JButton();
JButton buttonD = new JButton();
JLabel answer_labelA = new JLabel();
JLabel answer_labelB = new JLabel();
JLabel answer_labelC = new JLabel();
JLabel answer_labelD = new JLabel();
JLabel time_label = new JLabel();
JLabel seconds_left = new JLabel();
JTextField number_right = new JTextField();
JTextField percentage = new JTextField();
Timer timer = new Timer(1000, new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
seconds--;
seconds_left.setText(String.valueOf(seconds));
if(seconds<=0) {
displayAnswer();
}
}
});
public quiz1() {
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(750,750);
frame.getContentPane().setBackground(new Color(50,50,50));
frame.setLayout(null);
frame.setResizable(false);
textfield.setBounds(0,0,750,50);
textfield.setBackground(new Color(25,25,25));
textfield.setForeground(new Color(25,255,0));
textfield.setFont(new Font("Ink Free",Font.BOLD,30));
textfield.setBorder(BorderFactory.createBevelBorder(1));
textfield.setHorizontalAlignment(JTextField.CENTER);
textfield.setEditable(false);
textarea.setBounds(0,50,750,50);
textarea.setLineWrap(true);
textarea.setWrapStyleWord(true);
textarea.setBackground(new Color(25,25,25));
textarea.setForeground(new Color(25,255,0));
textarea.setFont(new Font("MV Boli",Font.BOLD,25));
textarea.setBorder(BorderFactory.createBevelBorder(1));
textarea.setEditable(false);
buttonA.setBounds(0,100,100,100);
buttonA.setFont(new Font("MV Boli",Font.BOLD,35));
buttonA.setFocusable(false);
buttonA.addActionListener(this);
buttonA.setText("A");
buttonB.setBounds(0,200,100,100);
buttonB.setFont(new Font("MV Boli",Font.BOLD,35));
buttonB.setFocusable(false);
buttonB.addActionListener(this);
buttonB.setText("B");
buttonC.setBounds(0,300,100,100);
buttonC.setFont(new Font("MV Boli",Font.BOLD,35));
buttonC.setFocusable(false);
buttonC.addActionListener(this);
buttonC.setText("C");
buttonD.setBounds(0,400,100,100);
buttonD.setFont(new Font("MV Boli",Font.BOLD,35));
buttonD.setFocusable(false);
buttonD.addActionListener(this);
buttonD.setText("D");
answer_labelA.setBounds(125,100,500,100);
answer_labelA.setBackground(new Color(50,50,50));
answer_labelA.setForeground(new Color(25,255,0));
answer_labelA.setFont(new Font("MV Boli",Font.PLAIN,35));
answer_labelB.setBounds(125,200,500,100);
answer_labelB.setBackground(new Color(50,50,50));
answer_labelB.setForeground(new Color(25,255,0));
answer_labelB.setFont(new Font("MV Boli",Font.PLAIN,35));
answer_labelC.setBounds(125,300,500,100);
answer_labelC.setBackground(new Color(50,50,50));
answer_labelC.setForeground(new Color(25,255,0));
answer_labelC.setFont(new Font("MV Boli",Font.PLAIN,35));
answer_labelD.setBounds(125,400,500,100);
answer_labelD.setBackground(new Color(50,50,50));
answer_labelD.setForeground(new Color(25,255,0));
answer_labelD.setFont(new Font("MV Boli",Font.PLAIN,35));
seconds_left.setBounds(535,510,100,100);
seconds_left.setBackground(new Color(25,25,25));
seconds_left.setForeground(new Color(255,0,0));
seconds_left.setFont(new Font("Ink Free",Font.BOLD,60));
seconds_left.setBorder(BorderFactory.createBevelBorder(1));
seconds_left.setOpaque(true);
seconds_left.setHorizontalAlignment(JTextField.CENTER);
seconds_left.setText(String.valueOf(seconds));
time_label.setBounds(535,475,100,25);
time_label.setBackground(new Color(50,50,50));
time_label.setForeground(new Color(255,0,0));
time_label.setFont(new Font("MV Boli",Font.PLAIN,16));
time_label.setHorizontalAlignment(JTextField.CENTER);
time_label.setText("timer >:D");
number_right.setBounds(225,225,200,100);
number_right.setBackground(new Color(25,25,25));
number_right.setForeground(new Color(25,255,0));
number_right.setFont(new Font("Ink Free",Font.BOLD,50));
number_right.setBorder(BorderFactory.createBevelBorder(1));
number_right.setHorizontalAlignment(JTextField.CENTER);
number_right.setEditable(false);
percentage.setBounds(225,325,200,100);
percentage.setBackground(new Color(25,25,25));
percentage.setForeground(new Color(25,255,0));
percentage.setFont(new Font("Ink Free",Font.BOLD,50));
percentage.setBorder(BorderFactory.createBevelBorder(1));
percentage.setHorizontalAlignment(JTextField.CENTER);
percentage.setEditable(false);
frame.add(time_label);
frame.add(seconds_left);
frame.add(answer_labelA);
frame.add(answer_labelB);
frame.add(answer_labelC);
frame.add(answer_labelD);
frame.add(buttonA);
frame.add(buttonB);
frame.add(buttonC);
frame.add(buttonD);
frame.add(textarea);
frame.add(textfield);
frame.setVisible(true);
nextQuestion();
}
public void nextQuestion() {
if(index>=total_questions) {
results();
}
else {
textfield.setText("Question "+(index+1));
textarea.setText(questions[index]);
answer_labelA.setText(options[index][0]);
answer_labelB.setText(options[index][1]);
answer_labelC.setText(options[index][2]);
answer_labelD.setText(options[index][3]);
timer.start();
}
}
@Override
public void actionPerformed(ActionEvent e) {
buttonA.setEnabled(false);
buttonB.setEnabled(false);
buttonC.setEnabled(false);
buttonD.setEnabled(false);
if(e.getSource()==buttonA) {
answer= 'A';
if(answer == answers[index]) { 
    correct_guesses++;
}
}
if(e.getSource()==buttonB) {
answer= 'B';
if(answer == answers[index]) {
correct_guesses++;
}
}
if(e.getSource()==buttonC) {
answer= 'C';
if(answer == answers[index]) {
correct_guesses++;
}
}
if(e.getSource()==buttonD) {
answer= 'D';
if(answer == answers[index]) {
correct_guesses++;
}
}
displayAnswer();
}
public void displayAnswer() {
timer.stop();
buttonA.setEnabled(false);
buttonB.setEnabled(false);
buttonC.setEnabled(false);
buttonD.setEnabled(false);
if(answers[index] != 'A')
answer_labelA.setForeground(new Color(255,0,0));
if(answers[index] != 'B')
answer_labelB.setForeground(new Color(255,0,0));
if(answers[index] != 'C')
answer_labelC.setForeground(new Color(255,0,0));
if(answers[index] != 'D')
answer_labelD.setForeground(new Color(255,0,0));
Timer pause = new Timer(2000, new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
    answer_labelA.setForeground(new Color(25,255,0));
answer_labelB.setForeground(new Color(25,255,0));
answer_labelC.setForeground(new Color(25,255,0));
answer_labelD.setForeground(new Color(25,255,0));
answer = ' ';
seconds=10;
seconds_left.setText(String.valueOf(seconds));
buttonA.setEnabled(true);
buttonB.setEnabled(true);
buttonC.setEnabled(true);
buttonD.setEnabled(true);
index++;
nextQuestion();
}
});
pause.setRepeats(false);
pause.start();
}
public void results(){
buttonA.setEnabled(false);
buttonB.setEnabled(false);
buttonC.setEnabled(false);
buttonD.setEnabled(false);
result = (int)((correct_guesses/(double)total_questions)*100);
textfield.setText("RESULTS!");
textarea.setText("");
answer_labelA.setText("");
answer_labelB.setText("");
answer_labelC.setText("");
answer_labelD.setText("");
number_right.setText("("+correct_guesses+"/"+total_questions+")");
percentage.setText(result+"%");
frame.add(number_right);
frame.add(percentage);
}
}
    
    

