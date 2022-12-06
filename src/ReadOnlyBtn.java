import controlP5.Button;
import controlP5.CColor;
import controlP5.CallbackEvent;
import controlP5.CallbackListener;

import javax.security.auth.callback.Callback;

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
            CColor gray = new CColor().setBackground(Color.gray.getRGB());
            btn.setColor(gray);
            btn.removeListenerFor(ACTION_RELEASE,this.listener);
        }else {
            btn.setColor(originalColor);
            btn.addListenerFor(ACTION_RELEASE,(this.listener));
        }
    }
}
