package moneycalculator;

import Model.Money;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MoneyViewerPanel extends JPanel implements MoneyViewer{
    private JLabel jLabel;

    public MoneyViewerPanel() {
        super(new FlowLayout(FlowLayout.LEFT));
        this.createComponents();
    }
    
    @Override
    public void show(Money money) {
        jLabel.setText(money.toString());
    }

    private void createComponents() {
        this.add(createMoneyDisplay());
    }

    private JLabel createMoneyDisplay() {
        jLabel = new JLabel();
        return jLabel;
    }

}
