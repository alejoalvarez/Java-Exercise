import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Car  implements ActionListener {

    public void drive(){
        System.out.println("Car: drive");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
