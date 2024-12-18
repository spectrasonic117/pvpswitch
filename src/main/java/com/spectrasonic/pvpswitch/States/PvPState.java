package com.spectrasonic.pvpswitch.States;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PvPState {
    private boolean isPvPEnabled = false; // por defecto PvP está desactivado

    public PvPState() {
    this.isPvPEnabled = false;
    }

    public void toggle() {
        this.isPvPEnabled = !this.isPvPEnabled;
    }

    public void setPvP(boolean enabled) {
        this.isPvPEnabled = enabled;
    }
}