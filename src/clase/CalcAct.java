package clase;

import javax.swing.*;
import java.awt.*;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Livia on 11/23/2014.
 */
public class CalcAct implements Action {
    private boolean en=true;
    private HashMap<String, Object> v=new HashMap<String, Object>();
    private ArrayList<PropertyChangeListener> ch_l;

    @Override
    public Object getValue(String key) {
        return null;
    }

    @Override
    public void putValue(String key, Object value) {
        v.put(key,value);
    }

    @Override
    public void setEnabled(boolean b) {
        en=b;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        if(ch_l==null)
            ch_l=new ArrayList<PropertyChangeListener>();
        ch_l.add(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        if(ch_l!=null && ch_l.contains((Point) listener))
            ch_l.remove((MenuComponent) listener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
