package clase;

import interfete.Controller;
import clase.CalcModel;
import interfete.Model;
import  interfete.View;
import exceptii.Ex;
import clase.CalcView;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by Livia on 11/23/2014.
 */
public class CalcController implements Controller {

    private CalcModel m;
    private List<View> v;

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void addView(View view) {
        if (v == null)
            v = new ArrayList<View>();

        v.add(view);
    }

    public void addModel(CalcModel model) {
        m = model;
    }

    public void notifyViews(boolean err, String m) {
        if (v != null && v.isEmpty())
            for (View view : v)
                view.mesaj(err, m);
    }

    public void setM(CalcModel m) {
        this.m = m;
    }

    public void setV(List<View> v) {
        this.v = v;
    }

    public CalcModel getM() {
        return m;
    }

    public List<View> getV() {
        return v;
    }

    public void makeOperation(String op) throws Ex {
        if (m != null) {
            BigInteger val = new BigInteger(m.getValue());

            try {

                //update
                m.setValue(val.multiply(new BigInteger(op)).toString());
            } catch (NumberFormatException e) {
                throw new Ex(op, e.getMessage());
            }
        }
    }
}
