package oop.inheritance.data.terminals;

import oop.inheritance.data.SupportedTerminal;
import oop.inheritance.data.interfaces.*;
import oop.inheritance.data.terminals.Ingenico.Ingenico;
import oop.inheritance.data.terminals.Verifone.v240m.Verifone240;
import oop.inheritance.data.terminals.Verifone.v520.Verifone520;
import oop.inheritance.data.terminals.Verifone.v690.Verifone690;

abstract public class TerminalFactory implements Terminal {
    static private Terminal terminal;

    static public Terminal getInstance(SupportedTerminal supportedTerminal)
    {
        if (terminal == null){
            switch (supportedTerminal) {
                case INGENICO -> terminal = new Ingenico();
                case VERIFONE240 -> terminal = new Verifone240();
                case VERIFONE520 -> terminal = new Verifone520();
                case VERIFONE690 -> terminal = new Verifone690();
            }
        }
        return terminal;
    }
}
