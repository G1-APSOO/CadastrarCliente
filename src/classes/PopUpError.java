package classes;

import javax.swing.JOptionPane;

public class PopUpError{
	
	public PopUpError(String text)
    {
		JOptionPane.showMessageDialog(null, text, "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
