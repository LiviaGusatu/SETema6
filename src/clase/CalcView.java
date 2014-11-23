package clase;

import interfete.ModelList;
import interfete.View;
import interfete.Controller;
import interfete.ModelList;
import clase.CalcModel;
import clase.CalcAct;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
/**
 * Created by Livia on 11/23/2014.
 */
public class CalcView extends JFrame implements ModelList, View {
    private static final long serialVersionUID=-5758555454500685115L;

    private JTextField temp=new JTextField(6);
    private JTextField vant=new JTextField(6);
    private JButton rand=new JButton("Random");
    private JButton cl=new JButton("Clear");

    private Controller calc;
    private CalcModel model;

    public CalcView()
    {
        //vant.setEditable(false);
        vant.getDocument().addDocumentListener(new DocumentListener() {
            public void update(DocumentEvent e) {
                vit_v();
            }
            @Override
            public void insertUpdate(DocumentEvent e) {
                vit_v();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                vit_v();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                vit_v();
            }

            public void vit_v()
            {

            }
        });
        temp.getDocument().addDocumentListener(new DocumentListener() {
            public void update(DocumentEvent e) {
                warn();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                warn();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                warn();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                warn();
            }
            public void warn() {

                rand.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Random r=new Random();
                        int nr=r.nextInt(50);
                        String ss=Integer.toString(nr);
                        temp.setText(ss);

                        Random r2=new Random();
                        int nr2=r2.nextInt(80);
                        String ss2=Integer.toString(nr2);
                        vant.setText(ss2);
                    }
                });


            }
        });

        JPanel content=new JPanel();
        content.setLayout(new FlowLayout());
        content.add(new JLabel("Temperatura"));
        content.add(temp);
        Random r=new Random();
        int nr=r.nextInt(50);
        String ss=Integer.toString(nr);
        temp.setText(ss);
        content.add(new JLabel("Viteza_vant"));
        content.add(vant);
        Random r2=new Random();
        int nr2=r2.nextInt(80);
        String ss2=Integer.toString(nr2);
        vant.setText(ss2);

        content.add(rand);

        this.setContentPane(content);
        this.pack();
        this.setTitle("Meteo");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

   public void addModel(CalcModel mm){
        model=mm;
        vant.setText(mm.getValue());
    }

    @Override
    public void update() {
        vant.setText(model.getValue());
      //  temp.setText(model.getValue());
    }

    @Override
    public void mesaj(boolean err, String m) {
        if(err)
            JOptionPane.showMessageDialog(this,m,"Eroare",JOptionPane.ERROR_MESSAGE);
        else
            JOptionPane.showMessageDialog(this,m,"Meteo",JOptionPane.INFORMATION_MESSAGE);
    }

    public void add_controller(Controller list)
    {
        rand.setActionCommand(Controller.ACTION_CALCULATE);
        rand.addActionListener(list);
        cl.setActionCommand(Controller.ACTION_RESET);
        cl.addActionListener(list);
    }
}
