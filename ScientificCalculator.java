import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

// JFrame is a top-level container that provides a window on the screen.
// A frame is actually a base window on which other components rely,
// namely the menu bar, panels, labels, text fields, buttons, etc.

/**
 * The ScientificCalculator Class inherits from the JFrame Class
 * The ScientificCalculator Class implements the ActionListener Interface
 */
public class ScientificCalculator extends JFrame implements ActionListener {
    JTextField tfield; // JTextField is a component that allows editing of a single line of text.
    double temp, temp1, result, a;
    static double m1;
    int k = 1, x = 0, y = 0, z = 0;
    char ch;

    // Declaring the different buttons
    JButton One, Two, Three, Four, Five, Six, Seven, Eight, Nine, ba, bb, zero, double_zero, clr, pow2, pow3, xpowy, exp, tenpowx,
            fac, plus, min, div, mod, log, nlog, rec, mul, eq, addSub, dot, mr, mc, mp,
            mm, sqrt, sin, cos, tan, sinh, cosh, tanh, Rand, Rad, scd, cbrt, Yrt, EE, Pi, Ex;

    Container cont; // A container class is a class that is used to hold objects in memory or external storage.
    JPanel buttonpanel; //  To organize components, various layouts can be set in JPanel which provide better organisation of components

    ScientificCalculator() {
        cont = getContentPane();
        cont.setLayout(new BorderLayout());
        JPanel textpanel = new JPanel();
        tfield = new JTextField(40);
        tfield.setHorizontalAlignment(SwingConstants.RIGHT);
        tfield.addKeyListener(new KeyAdapter() {

            // KeyAdapter is an abstract adapter class for receiving keyboard events.
            // We override the KeyTyped() method in the KeyAdapter class
            public void keyTyped(KeyEvent keyevent) {
                char c = keyevent.getKeyChar();
                if (c < '0' || c > '9') {
                    // public void consume()
                    //Consumes this event so that it will not be processed
                    // in the default manner by the source which originated it.
                    keyevent.consume();
                }
            }
        });
        textpanel.add(tfield);
        buttonpanel = new JPanel();
        // The GridLayout class in Java is used to design layouts that have a specified number of rows and columns in a rectangular grid.
        buttonpanel.setLayout(new GridLayout(5, 10, 2, 2));

        // Implements the first Bracket
        ba = new JButton("(" );
        buttonpanel.add(ba);
        ba.addActionListener(this);

        // Implements the second Bracket
        bb = new JButton(")" );
        buttonpanel.add(bb);
        bb.addActionListener(this);

        // Memory Clear Button
        mc = new JButton("mc");
        buttonpanel.add(mc);
        mc.addActionListener(this);

        // Adding to Memory
        mp = new JButton("m+");
        buttonpanel.add(mp);
        mp.addActionListener(this);

        // Deleting an Item from the Memory
        mm = new JButton("m-");
        buttonpanel.add(mm);
        mm.addActionListener(this);

        mr = new JButton("mr");
        buttonpanel.add(mr);
        mr.addActionListener(this);

        // Clear screen button
        clr = new JButton("C");
        buttonpanel.add(clr);
        clr.addActionListener(this);

        addSub = new JButton("+/-");
        buttonpanel.add(addSub);
        addSub.addActionListener(this);

        mod = new JButton("%");
        mod.addActionListener(this);
        buttonpanel.add(mod);

        div = new JButton("/");
        div.addActionListener(this);
        buttonpanel.add(div);

        scd = new JButton("2nd");
        scd.addActionListener(this);
        buttonpanel.add(scd);

        pow2 = new JButton("x^2");
        buttonpanel.add(pow2);
        pow2.addActionListener(this);

        pow3 = new JButton("x^3");
        buttonpanel.add(pow3);
        pow3.addActionListener(this);

        xpowy = new JButton("x^y");
        buttonpanel.add(xpowy);
        xpowy.addActionListener(this);

        Ex = new JButton("e^x");
        buttonpanel.add(Ex);
        Ex.addActionListener(this);

        // 10 raised to the power x button
        tenpowx = new JButton("10^x");
        buttonpanel.add(tenpowx);
        tenpowx.addActionListener(this);

        Seven = new JButton("7");
        buttonpanel.add(Seven);
        Seven.addActionListener(this);

        Eight = new JButton("8");
        buttonpanel.add(Eight);
        Eight.addActionListener(this);

        Nine = new JButton("9");
        buttonpanel.add(Nine);
        Nine.addActionListener(this);

        // Multiplication Button
        mul = new JButton("*");
        buttonpanel.add(mul);
        mul.addActionListener(this);

        // Reciprocal Button; in other words one divided by a given number say x
        rec = new JButton("1/x");
        buttonpanel.add(rec);
        rec.addActionListener(this);

        // Square Root Button
        sqrt = new JButton("Sqrt");
        buttonpanel.add(sqrt);
        sqrt.addActionListener(this);

        // Cube Root Button
        cbrt = new JButton("Cbrt");
        buttonpanel.add(cbrt);
        cbrt.addActionListener(this);

        Yrt = new JButton("Yrt");
        buttonpanel.add(Yrt);
        Yrt.addActionListener(this);

        nlog = new JButton("ln");
        buttonpanel.add(nlog);
        nlog.addActionListener(this);

        log = new JButton("log");
        buttonpanel.add(log);
        log.addActionListener(this);

        Four = new JButton("4");
        buttonpanel.add(Four);
        Four.addActionListener(this);

        Five = new JButton("5");
        buttonpanel.add(Five);
        Five.addActionListener(this);

        Six = new JButton("6");
        buttonpanel.add(Six);
        Six.addActionListener(this);

        min = new JButton("-");
        buttonpanel.add(min);
        min.addActionListener(this);

        fac = new JButton("n!");
        fac.addActionListener(this);
        buttonpanel.add(fac);

        sin = new JButton("sin");
        buttonpanel.add(sin);
        sin.addActionListener(this);

        cos = new JButton("cos");
        buttonpanel.add(cos);
        cos.addActionListener(this);

        tan = new JButton("tan");
        buttonpanel.add(tan);
        tan.addActionListener(this);

        exp = new JButton("e");
        buttonpanel.add(exp);
        exp.addActionListener(this);

        EE = new JButton("EE");
        buttonpanel.add(EE);
        EE.addActionListener(this);

        One = new JButton("1");
        buttonpanel.add(One);
        One.addActionListener(this);

        Two = new JButton("2");
        buttonpanel.add(Two);
        Two.addActionListener(this);

        Three = new JButton("3");
        buttonpanel.add(Three);
        Three.addActionListener(this);

        plus = new JButton("+");
        buttonpanel.add(plus);
        plus.addActionListener(this);

        Rad = new JButton("Rad");
        Rad.addActionListener(this);
        buttonpanel.add(Rad);

        sinh = new JButton("sinh");
        sinh.addActionListener( this );
        buttonpanel.add(sinh);

        cosh = new JButton("cosh");
        cosh.addActionListener( this );
        buttonpanel.add(cosh);

        tanh = new JButton("tanh");
        tanh.addActionListener( this );
        buttonpanel.add(tanh);

        Pi = new JButton("Pi");
        buttonpanel.add(Pi);
        Pi.addActionListener(this);

        Rand = new JButton("Rand");
        Rand.addActionListener(this);
        buttonpanel.add(Rand);

        zero = new JButton("0");
        buttonpanel.add(zero);
        zero.addActionListener(this);

        double_zero = new JButton("00");
        buttonpanel.add(double_zero);
        double_zero.addActionListener(this);

        dot = new JButton(".");
        buttonpanel.add(dot);
        dot.addActionListener(this);

        eq = new JButton("=");
        buttonpanel.add(eq);
        eq.addActionListener(this);

        cont.add("Center", buttonpanel);
        cont.add("North", textpanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * We override the actionPerformed method in the ActionListener Interface
     */
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("1")) {
            if (z == 0) {
                // The setText() method is used to set the current text that is to be read by this StringCharacterIterator.
                // This method takes the text to be set as a parameter
                // and sets the text of this StringCharacterIterator at that text.
                // public final void setText(String value)
                tfield.setText(tfield.getText() + "1");
            } else {
                tfield.setText("");
                // The getText() method returns the text from the single-line text field.
                // public final String getText()
                tfield.setText(tfield.getText() + "1");
                z = 0;
            }
        }
        if (s.equals("2")) {
            if (z == 0) {
                tfield.setText(tfield.getText() + "2");
            } else {
                tfield.setText("");
                tfield.setText(tfield.getText() + "2");
                z = 0;
            }
        }
        if (s.equals("3")) {
            if (z == 0) {
                tfield.setText(tfield.getText() + "3");
            } else {
                tfield.setText("");
                tfield.setText(tfield.getText() + "3");
                z = 0;
            }
        }
        if (s.equals("4")) {
            if (z == 0) {
                tfield.setText(tfield.getText() + "4");
            } else {
                tfield.setText("");
                tfield.setText(tfield.getText() + "4");
                z = 0;
            }
        }
        if (s.equals("5")) {
            if (z == 0) {
                tfield.setText(tfield.getText() + "5");
            } else {
                tfield.setText("");
                tfield.setText(tfield.getText() + "5");
                z = 0;
            }
        }
        if (s.equals("6")) {
            if (z == 0) {
                tfield.setText(tfield.getText() + "6");
            } else {
                tfield.setText("");
                tfield.setText(tfield.getText() + "6");
                z = 0;
            }
        }
        if (s.equals("7")) {
            if (z == 0) {
                tfield.setText(tfield.getText() + "7");
            } else {
                tfield.setText("");
                tfield.setText(tfield.getText() + "7");
                z = 0;
            }
        }
        if (s.equals("8")) {
            if (z == 0) {
                tfield.setText(tfield.getText() + "8");
            } else {
                tfield.setText("");
                tfield.setText(tfield.getText() + "8");
                z = 0;
            }
        }
        if (s.equals("9")) {
            if (z == 0) {
                tfield.setText(tfield.getText() + "9");
            } else {
                tfield.setText("");
                tfield.setText(tfield.getText() + "9");
                z = 0;
            }
        }
        if (s.equals("0")) {
            if (z == 0) {
                tfield.setText(tfield.getText() + "0");
            } else {
                tfield.setText("");
                tfield.setText(tfield.getText() + "0");
                z = 0;
            }
        }

        if (s.equals("00")) {
            if (z == 0) {
                tfield.setText(tfield.getText() + "00");
            } else {
                tfield.setText("");
                tfield.setText(tfield.getText() + "00");
                z = 00;
            }
        }

        if (s.equals("C")) {
            tfield.setText("");
            x = 0;
            y = 0;
            z = 0;
        }

        if (s.equals("log")) {
            if (tfield.getText().equals("")) {
                tfield.setText("");
            } else {
                a = Math.log10(Double.parseDouble(tfield.getText()));
                tfield.setText("");
                tfield.setText(tfield.getText() + a);
            }
        }

        if (s.equals("ln")) {
            if (tfield.getText().equals("")) {
                tfield.setText("");
            } else {
                a = Math.log(Double.parseDouble(tfield.getText()));
                tfield.setText("");
                tfield.setText(tfield.getText() + a);
            }
        }

        if (s.equals("Rad")) {
            if (tfield.getText().equals("")) {
                tfield.setText("");
            } else {
                a = Math.toRadians(Double.parseDouble(tfield.getText()));
                tfield.setText("");
                tfield.setText(tfield.getText() + a);
            }
        }

        if (s.equals("Rand")) {
            // Select a randomly generated number
            a = Math.random();
            tfield.setText("");
            tfield.setText(tfield.getText() + a);
        }

        if (s.equals("Pi")) {
            a = Math.PI;
            tfield.setText("");
            tfield.setText(tfield.getText() + a);
        }

        if (s.equals("1/x")) {
            if (tfield.getText().equals("")) {
                tfield.setText("");
            } else {
                a = 1 / Double.parseDouble(tfield.getText());
                tfield.setText("");
                tfield.setText(tfield.getText() + a);
            }
        }
        if (s.equals("e")) {
            if (tfield.getText().equals("")) {
                tfield.setText("");
            } else {
                a = Math.exp(Double.parseDouble(tfield.getText()));
                tfield.setText("");
                tfield.setText(tfield.getText() + a);
            }
        }

        if (s.equals("x^2")) {
            if (tfield.getText().equals("")) {
                tfield.setText("");
            } else {
                a = Math.pow(Double.parseDouble(tfield.getText()), 2);
                tfield.setText("");
                tfield.setText(tfield.getText() + a);
            }
        }

        if (s.equals("x^3")) {
            if (tfield.getText().equals("")) {
                tfield.setText("");
            } else {
                a = Math.pow(Double.parseDouble(tfield.getText()), 3);
                tfield.setText("");
                tfield.setText(tfield.getText() + a);
            }
        }

        if (s.equals("x^y")) {
            if (tfield.getText().equals("")) {
                tfield.setText("");
            } else {
                a = Math.pow(Double.parseDouble(tfield.getText()), y);
                tfield.setText("");
                tfield.setText(tfield.getText() + a);
            }
        }

        if (s.equals("+/-")) {
            if (x == 0) {
                tfield.setText("-" + tfield.getText());
                x = 1;
            } else {
                tfield.setText(tfield.getText());
            }
        }
        if (s.equals(".")) {
            if (y == 0) {
                tfield.setText(tfield.getText() + ".");
                y = 1;
            } else {
                tfield.setText(tfield.getText());
            }
        }
        if (s.equals("+")) {
            if (tfield.getText().equals("")) {
                tfield.setText("");
                temp = 0;
                ch = '+';
            } else {
                temp = Double.parseDouble(tfield.getText());
                tfield.setText("");
                ch = '+';
                y = 0;
                x = 0;
            }
            // tfield.requestFocus();
        }
        if (s.equals("-")) {
            if (tfield.getText().equals("")) {
                tfield.setText("");
                temp = 0;
            } else {
                x = 0;
                y = 0;
                temp = Double.parseDouble(tfield.getText());
                tfield.setText("");
            }
            ch = '-';
            // tfield.requestFocus();
        }
        if (s.equals("/")) {
            if (tfield.getText().equals("")) {
                tfield.setText("");
                temp = 1;
                ch = '/';
            } else {
                x = 0;
                y = 0;
                temp = Double.parseDouble(tfield.getText());
                ch = '/';
                tfield.setText("");
            }
            // tfield.requestFocus();
        }
        if (s.equals("*")) {
            if (tfield.getText().equals("")) {
                tfield.setText("");
                temp = 1;
                ch = '*';
            } else {
                x = 0;
                y = 0;
                temp = Double.parseDouble(tfield.getText());
                ch = '*';
                tfield.setText("");
            }
            // tfield.requestFocus();
        }
        if (s.equals("mc")) {
            m1 = 0;
            tfield.setText("");
        }
        if (s.equals("mr")) {
            tfield.setText("");
            tfield.setText(tfield.getText() + m1);
        }
        if (s.equals("m+")) {
            if (k == 1) {
                m1 = Double.parseDouble(tfield.getText());
                k++;
            } else {
                m1 += Double.parseDouble(tfield.getText());
                tfield.setText("" + m1);
            }
        }
        if (s.equals("m-")) {
            if (k == 1) {
                m1 = Double.parseDouble(tfield.getText());
                k++;
            } else {
                m1 -= Double.parseDouble(tfield.getText());
                tfield.setText("" + m1);
            }
        }
        if (s.equals("Sqrt")) {
            if (tfield.getText().equals("")) {
                tfield.setText("");
            } else {
                a = Math.sqrt(Double.parseDouble(tfield.getText()));
                tfield.setText("");
                tfield.setText(tfield.getText() + a);
            }
        }

        if (s.equals("cbrt")) {
            if (tfield.getText().equals("")) {
                tfield.setText("");
            } else {
                a = Math.cbrt(Double.parseDouble(tfield.getText()));
                tfield.setText("");
                tfield.setText(tfield.getText() + a);
            }
        }

        if (s.equals("sin")) {
            if (tfield.getText().equals("")) {
                tfield.setText("");
            } else {
                a = Math.sin(Double.parseDouble(tfield.getText()));
                tfield.setText("");
                tfield.setText(tfield.getText() + a);
            }
        }
        if (s.equals("cos")) {
            if (tfield.getText().equals("")) {
                tfield.setText("");
            } else {
                a = Math.cos(Double.parseDouble(tfield.getText()));
                tfield.setText("");
                tfield.setText(tfield.getText() + a);
            }
        }
        if (s.equals("tan")) {
            if (tfield.getText().equals("")) {
                tfield.setText("");
            } else {
                a = Math.tan(Double.parseDouble(tfield.getText()));
                tfield.setText("");
                tfield.setText(tfield.getText() + a);
            }
        }

        if (s.equals("sinh")) {
            if (tfield.getText().equals("")) {
                tfield.setText("");
            } else {
                a = Math.sinh(Double.parseDouble(tfield.getText()));
                tfield.setText("");
                tfield.setText(tfield.getText() + a);
            }
        }

        if (s.equals("cosh")) {
            if (tfield.getText().equals("")) {
                tfield.setText("");
            } else {
                a = Math.cosh(Double.parseDouble(tfield.getText()));
                tfield.setText("");
                tfield.setText(tfield.getText() + a);
            }
        }

        if (s.equals("tanh")) {
            if (tfield.getText().equals("")) {
                tfield.setText("");
            } else {
                a = Math.tanh(Double.parseDouble(tfield.getText()));
                tfield.setText("");
                tfield.setText(tfield.getText() + a);
            }
        }

        if (s.equals("=")) {
            if (tfield.getText().equals("")) {
                tfield.setText("");
            } else {
                temp1 = Double.parseDouble(tfield.getText());
                switch (ch) {
                    case '+' -> result = temp + temp1;
                    case '-' -> result = temp - temp1;
                    case '/' -> result = temp / temp1;
                    case '*' -> result = temp * temp1;
                }
                tfield.setText("");
                tfield.setText(tfield.getText() + result);
                z = 1;
            }
        }
        if (s.equals("n!")) {
            if (tfield.getText().equals("")) {
                tfield.setText("");
            } else {
                a = fact(Double.parseDouble(tfield.getText()));
                tfield.setText("");
                tfield.setText(tfield.getText() + a);
            }
        }
        tfield.requestFocus();
    }

    double fact(double x) {
        if (x < 0) {
            return 0;
        }
        double i, s = 1;
        for (i = 2; i <= x; i += 1.0)
            s *= i;
        return s;
    }

    public static void main(String[] args) {
        // To programmatically specify a L&F, use the UIManager.setLookAndFeel() method
        // with the fully qualified name of the appropriate subclass of LookAndFeel as its argument.
        try {
            UIManager
                    .setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ignored) {
        }
        ScientificCalculator f = new ScientificCalculator();
        f.setTitle("Scientific Calculator");
        f.pack();
        f.setVisible(true);
    }
}