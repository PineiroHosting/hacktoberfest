import javax.swing.*;

/**
 * A simple class which allows opening blocking confirm Guis.
 */
public class ConfirmGui {
  /**
   * This method shows a simple Gui in order to allow retrieving a user`s consent.
   * @param message The message to use within the gui.
   * @param title The title to set when initiating the gui.
   * @return True if the user confirmed - otherwise false.
   */
  public static boolean openConfirmGui(final String message, final String title) {
    final int result = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.OK_CANCEL_OPTION);
    return result == JOptionPane.OK_OPTION;
  }
}
