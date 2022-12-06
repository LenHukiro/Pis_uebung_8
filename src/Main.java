import controlP5.*;
import processing.core.PApplet;

public class Main extends PApplet {
    ControlP5 p5;
    int sliderVal = 0, btnVal = 0;
    public static void main(String[] args) {
        PApplet.main(new String[]{"Main"});
    }

    @Override
    public void setup() {
        p5 = new ControlP5(this);
        Button btn = p5.addButton("TestButton");
        Slider slider = p5.addSlider("TestSlider");

        slider.setValue(sliderVal);
        btn.setLabel(String.valueOf(btnVal));

        ControlListener controlListener = controlEvent -> sliderVal  = (int) slider.getValue();
        CallbackListener callbackListener = callbackEvent -> btnVal = (int) btn.getValue()+1;
        slider.addListener(controlListener);
        btn.addCallback(callbackListener);

        new ReadOnlySlider(slider,controlListener);
        new ReadOnlyBtn(btn,callbackListener);
    }

    @Override
    public void settings() {
        size( 200,400);
    }

    @Override
    public void draw() {
        super.draw();
    }
}