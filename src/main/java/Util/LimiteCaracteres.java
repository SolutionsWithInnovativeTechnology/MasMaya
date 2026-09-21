package Util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class LimiteCaracteres {
    private static class Filtro extends DocumentFilter {

        int limite;

        public Filtro(int limite) {
            this.limite = limite;
        }

        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            if ((fb.getDocument().getLength() + string.length()) <= limite) {
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            int currentLength = fb.getDocument().getLength();
            int newLength = currentLength - length + text.length();

            if (newLength <= limite) {
                super.replace(fb, offset, length, text, attrs);
            }
        }
    }

    public static void limitar(javax.swing.JTextField campo, int limite) {
        ((javax.swing.text.PlainDocument) campo.getDocument()).setDocumentFilter(new Filtro(limite));
    }


}
