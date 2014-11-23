/**
 * Created by Livia on 11/23/2014.
 */
import clase.CalcController;
import clase.CalcModel;
import clase.CalcView;
public class main {
    public static void main(String[]args){
        CalcModel m=new CalcModel();
        CalcView v=new CalcView();
        CalcController c=new CalcController();

        m.addModeList(v);
        v.addModel(m);
        v.add_controller(c);
        c.addModel(m);
        c.addView(v);
        v.setVisible(true);
    }

}
