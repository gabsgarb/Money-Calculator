package UI;

import Model.Money;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.JTextField;
import moneycalculator.CurrencyDialog;
import moneycalculator.CurrencyDialogPanel;

public class MoneyDialogPanel extends JPanel implements MoneyDialog{
    private String amount = "0";
    private CurrencyDialog currencyDialog;

    public MoneyDialogPanel() {
        super(new FlowLayout(FlowLayout.LEFT));
        this.createComponents();
    }
    
    @Override
    public Money getMoney() {
        return new Money(Double.parseDouble(amount), currencyDialog.getCurrency());
    }

    private void createComponents() {
        this.add(createAmountWidget());
        this.add(createCurrencyDialogPanel());
    }

    private JTextField createAmountWidget() {
        final JTextField inputAmount = new JTextField(amount, 10);
        inputAmount.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                amount = inputAmount.getText();
            }
        });
        return inputAmount;
    }

    private JPanel createCurrencyDialogPanel() {
        CurrencyDialogPanel panel = new CurrencyDialogPanel();
        this.currencyDialog = panel;
        return panel;
    }

}
