import controlP5.Button;
import controlP5.CColor;
import controlP5.CallbackListener;

import java.awt.*;

import static controlP5.ControlP5Constants.ACTION_RELEASE;

public class ReadOnlyBtn {
    CColor originalColor;
    Button btn;
    CallbackListener listener;
    private boolean readOnly;

    ReadOnlyBtn(Button btn, CallbackListener listener) {
        this.btn = btn;
        this.listener = listener;
        readOnly = false;
        originalColor = btn.getColor();
    }

    public boolean isEnabled() {
        return readOnly;
    }

    public void setDisabled(boolean state) {
        readOnly = state;
        if (state) {
            btn.setColorBackground(Color.gray.getRGB());
            btn.removeListenerFor(ACTION_RELEASE, this.listener);
        } else {
            btn.setColorBackground(Color.blue.getRGB());
            btn.addListenerFor(ACTION_RELEASE, (this.listener));
        }
    }
}
