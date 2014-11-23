package clase;

import exceptii.Ex;
import interfete.Model;
import interfete.ModelList;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * Created by Livia on 11/23/2014.
 */
public class CalcModel {


    public static final String INITIAL_VALUE="2";
    private BigInteger t;
    private List<ModelList> l;


    public CalcModel()
    {

        Random r3=new Random();
        int nr3=r3.nextInt(80);
        String ss3=Integer.toString(nr3);
        t=new BigInteger(ss3);
    }

    public void setValue(String v) throws Ex{
        try {
            t = new BigInteger(v);
            notifyList();
        }catch (NumberFormatException e){
            throw new Ex(v,e.getMessage());
        }
    }
    public String getValue(){
        return t.toString();
    }

    public void addModeList(ModelList list){
        if(l==null)
            l=new ArrayList<ModelList>();
        l.add(list);
    }

    private void notifyList()
    {
        if(l!=null && l.isEmpty())
            for (ModelList listener:l)
                listener.update();
    }
}
